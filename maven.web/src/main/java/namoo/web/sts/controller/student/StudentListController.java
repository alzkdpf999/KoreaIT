package namoo.web.sts.controller.student;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.google.gson.Gson;

import namoo.student.common.web.Params;
import namoo.student.common.web.myPageBuilder;
import namoo.web.sts.dto.Student;
import namoo.web.sts.mapper.StudentMapper;

/**
 * Servlet implementation class StudentListController
 */
@WebServlet("/students")
public class StudentListController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		SqlSession sqlSession = null;
		String resource = "mybatis-config.xml";
		Reader reader = null;
		try {
			reader = Resources.getResourceAsReader(resource);
		} catch (IOException e) {
			e.printStackTrace();
		}
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		sqlSession = sqlSessionFactory.openSession();// Auto commit 아님

		StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
		Params params = new Params(1, 10, 3, "ssn", "all", "");
		List<Student> list = mapper.listByPage(params);
		int cnt = mapper.countByPage(params);
		myPageBuilder pageBuilder = new myPageBuilder(params, cnt);
		pageBuilder.build();
		request.setAttribute("list", list);
		request.setAttribute("page", pageBuilder);
		request.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		SqlSession sqlSession = null;
		String resource = "mybatis-config.xml";
		Reader reader = null;
		try {
			reader = Resources.getResourceAsReader(resource);
		} catch (IOException e) {
			e.printStackTrace();
		}
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		sqlSession = sqlSessionFactory.openSession();// Auto commit 아님

		// 역직렬화
		PrintWriter out = response.getWriter();
		BufferedReader in = request.getReader();
		Gson gson = new Gson();
		Student student = gson.fromJson(in, Student.class);
		System.out.println(student);
		StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
		mapper.create(student);
		sqlSession.commit();
		Params params = new Params(1, 10, 3, "ssn", "all", "");
		List<Student> list = mapper.listByPage(params);
		String resultJson = gson.toJson(list);
		out.print(resultJson);
		in.close();
		out.close();

	}
}
