package namoo.web.sts.controller.student;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.executor.result.ResultMapException;
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
public class StudentController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/// grade/students/name/a::1
		System.out.println(request.getRequestURI() + "::" + request.getParameter("page"));
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
		Gson gson = new Gson();
		StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
		Params params = new Params(1, 10, 3, "ssn", "all", "");
		List<Student> list = mapper.listByPage(params);

		int cnt = mapper.countByPage(params);
		myPageBuilder pageBuilder = new myPageBuilder(params, cnt);
		pageBuilder.build();
		PrintWriter out = response.getWriter();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("page", pageBuilder);
		resultMap.put("student", list);

		String resultJson = gson.toJson(resultMap);

		out.print(resultJson);
		out.close();

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
		StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
		Map<String, Object> resultMap = new HashMap<String, Object>();
		Student check = mapper.check(student.getSsn());
		if (check == null) {
			mapper.create(student);
			sqlSession.commit();
			resultMap.put("check", true);
		} else {
			resultMap.put("check", false);
		}

		Params params = new Params(1, 10, 3, "ssn", "all", "");
		int cnt = mapper.countByPage(params);
		myPageBuilder pageBuilder = new myPageBuilder(params, cnt);
		pageBuilder.build();

		List<Student> list = mapper.listByPage(params);

		resultMap.put("page", pageBuilder);
		resultMap.put("student", list);
		String resultJson = gson.toJson(resultMap);
		out.print(resultJson);
		in.close();
		out.close();
	}

	@Override
	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println(request.getRequestURI() + "::" + request.getParameter("page"));
		String[] path = request.getRequestURI().split("/");
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
		PrintWriter out = response.getWriter();
		BufferedReader in = request.getReader();
		Gson gson = new Gson();
		Student student = gson.fromJson(in, Student.class);
		StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
		Map<String, Object> delMap = new HashMap<String, Object>();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		if (path.length > 3) {

			delMap.put("ssn", student.getSsn());
			delMap.put("name", student.getName());

			Student st = mapper.search(delMap);

			if (st == null) {
				resultMap.put("check", false);
			} else {
				mapper.delete(delMap);
				resultMap.put("check", true);
				
			}
		} else {
			List<Student> list = mapper.findAll();
			if(list.size() == 0) {
				resultMap.put("check", false);
			}else {
				resultMap.put("check", true);
				mapper.deleteAll();
			}
		}
		sqlSession.commit();
		Params params = new Params(1, 10, 3, "ssn", "all", "");
		int cnt = mapper.countByPage(params);
		myPageBuilder pageBuilder = new myPageBuilder(params, cnt);
		pageBuilder.build();

		List<Student> list = mapper.listByPage(params);
		resultMap.put("page", pageBuilder);
		resultMap.put("student", list);
		String resultJson = gson.toJson(resultMap);
		out.print(resultJson);
		in.close();
		out.close();

	}
}
