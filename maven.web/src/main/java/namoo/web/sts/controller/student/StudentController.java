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
import org.apache.ibatis.type.IntegerTypeHandler;

import com.google.gson.Gson;

import namoo.student.common.web.Params;
import namoo.student.common.web.myPageBuilder;
import namoo.web.sts.dto.Student;
import namoo.web.sts.mapper.StudentMapper;
import namoo.web.sts.service.StudentServiceImpl;

/**
 * Servlet implementation class StudentListController
 */
@WebServlet("/students")
public class StudentController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println(request.getRequestURI() + "::" + request.getParameter("page"));
		String[] path = request.getRequestURI().split("/");
		String type = path[path.length - 2];
		String value = path[path.length - 1];
		String sortType = request.getParameter("sort");
		String page = request.getParameter("page");
		String seq = request.getParameter("seq");
		if(seq == null || seq.equals("")) seq = "order";
		if(page == null || page.equals("")) page ="1";
		if(sortType == null || sortType.equals("")) sortType = "ssn";
		Map<String, Object> resultMap = new HashMap<String, Object>();
		SqlSession sqlSession = StudentServiceImpl.getInstance().setUp();
		
		Gson gson = new Gson();
		StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
		Params params = null;
		if(path.length > 3) {
			params = new Params(Integer.parseInt(page),10,3,sortType,type,value,seq);
			resultMap.put("exist",true);
		}else {
			params = new Params(Integer.parseInt(page), 10, 3, sortType, "all", "",seq);
			resultMap.put("exist",false);
		}
		List<Student> list = mapper.listByPage(params);
		int cnt = mapper.countByPage(params);
		myPageBuilder pageBuilder = new myPageBuilder(params, cnt);
		pageBuilder.build();

		PrintWriter out = response.getWriter();
		
		resultMap.put("page", pageBuilder);
		resultMap.put("student", list);
		
		
		String resultJson = gson.toJson(resultMap);

		out.print(resultJson);
		out.close();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		SqlSession sqlSession = StudentServiceImpl.getInstance().setUp();

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

		Params params = new Params(1, 10, 3, "ssn", "all", "","order");
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
		String[] path = request.getRequestURI().split("/");
		SqlSession sqlSession = StudentServiceImpl.getInstance().setUp();
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
			if (list.size() == 0) {
				resultMap.put("check", false);
			} else {
				resultMap.put("check", true);
				mapper.deleteAll();
			}
		}
		sqlSession.commit();
		Params params = new Params(1, 10, 3, "ssn", "all", "","order");
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
