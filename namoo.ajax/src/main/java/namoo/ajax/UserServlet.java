package namoo.ajax;

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
 * 자바에서 json 파싱(object <-> JSOM)
 */
@WebServlet("/users1")
public class UserServlet extends HttpServlet {
	//디비 데이터를 현재 서블릿에서 json으로 필요한 데이터만 뽑는
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String requestJson = "{'id': 'bangry', 'name': 'jack', 'email': 'jack@naver.com'}";
		String requestArray = "[{'id': 'bangry', 'name': 'jack', 'email': 'jack@naver.com'},{'id': 'bangry2', 'name': 'jack2', 'email': 'jack2@naver.com'},{'id': 'bangry3', 'name': 'jack3', 'email': 'jack3@naver.com'}]";
		String requestComplex = "{'id': 'bangry', 'name': 'jack', 'languages': ['Java','CSS','JavaScript']}";
		//Gson생성
		Gson gson = new Gson();

		//수신한 JSON -> Map(역직렬화)
		Map map = gson.fromJson(requestJson, Map.class);
		System.out.println(map.toString());
		System.out.println(map.get("id"));

		// JSON -> Object(JavaBean)
		User user = gson.fromJson(requestJson, User.class);
		System.out.println("javaBean");
		System.out.println(user.toString());

		// JSON -> ArrayList
		List<User> list = gson.fromJson(requestArray, new TypeToken<ArrayList<User>>(){}.getType());
		System.out.println("arrayList");
		System.out.println(list.toString());

		//Json ->배열
		User[] array = gson.fromJson(requestArray, User[].class);
		System.out.println(array.toString());

		//JSON -> Map
		Map userInfo = gson.fromJson(requestComplex,Map.class);
		System.out.println(userInfo.toString());
		List<String> languages = (List<String>)userInfo.get("languages");
		for(String language : languages) {
			System.out.println(language);
		}
		//가독성 좋게 출력하기 위한 gson 생성
		Gson gson2 = new GsonBuilder().setPrettyPrinting().create();
		User userObj = new User("bangry1","jack1","jack@naver.com");
		String userJson =gson2.toJson(userObj);
		System.out.println(userJson);

		//Map -> Json
		Map<String,String> userMap = new HashMap<String,String>();
		userMap.put("id","ba");
		userMap.put("name","aa");
		userMap.put("email","cc");
		userJson = gson2.toJson(userMap);
		System.out.println("Map -> Json");
		System.out.println(userJson);

		//List<User> list =userService.listAll();
		List<User> userList = new ArrayList<User>();
		userList.add(new User("1","2","3"));
		userList.add(new User("4","5","6"));
		userList.add(new User("7","8","9"));
		String jsonUserList = gson2.toJson(userList);
		System.out.println("List<User> list =userService.listAll()");
		System.out.println(jsonUserList);

		//userList를 map으로 포장
		Map result = new HashMap();
		result.put("size", list.size());
		result.put("userList",userList);
		String jsonComplex  =gson2.toJson(result);
		System.out.println("userList를 map으로 포장");
		System.out.println(jsonComplex);
	}
//회원가입 예제
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		//역직렬화
		BufferedReader in = request.getReader();
		Gson gson = new Gson();
		User user = gson.fromJson(in, User.class);
		System.out.println(user);
		//직렬화
		List<User> userList = new ArrayList<User>();
		userList.add(new User("1","2","3"));
		userList.add(new User("4","5","6"));
		userList.add(new User("7","8","9"));
		Map result = new HashMap();
		result.put("size",userList.size());
		result.put("userList", userList);
		String objectString = gson.toJson(result);
		System.out.println(objectString);
		
		//JSON 응답
			out.print(objectString);
		out.close();
	}

}
