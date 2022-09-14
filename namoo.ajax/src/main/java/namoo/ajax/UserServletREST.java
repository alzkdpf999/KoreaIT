package namoo.ajax;

import java.awt.image.RescaleOp;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PrimitiveIterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

/**
 * REST 기반 API설계
 */
@WebServlet("/users")

public class UserServletREST extends HttpServlet {
	//회원 목록
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/json; charset=utf-8");
		Gson gson = new Gson();
		List<User> userList = new ArrayList<User>();
		userList.add(new User("1","2","3"));
		userList.add(new User("4","5","6"));
		userList.add(new User("7","8","9"));
		Map result = new HashMap();
		result.put("size",userList.size());
		result.put("userList", userList);
		String objectString = gson.toJson(result);
		System.out.println(objectString);
		PrintWriter out =response.getWriter();
		
		out.print(objectString);
		out.close();
	}

//회원가입 처리(REST)
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		// 역직렬화
		BufferedReader in = request.getReader();
		Gson gson = new Gson();
		User user = gson.fromJson(in, User.class);
		System.out.println(user);
	
		
		String message = gson.toJson(user);
		out.print(message);
		out.close();
	}

}
