package namoo.tutorial.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class HttpSessionServlet2 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name;
		HttpSession session = request.getSession();//인자 생략시 true로 떨어짐
		name = (String)session.getAttribute("name");// 오브젝트 타입이므로 형변환 필요
		System.out.println("세션에 저장된 이름 얻어오기 : "+name);
		//같은 url이여도 브라우저가 다르면 다른 정보를 읽어옴
		// request >> session >> context 순으로 공유크기
	}

}
