package namoo.tutorial.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DetailServlet
 */
public class DetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(request);
		System.out.println(response);
		//요청 메시지의 요청라인 정보 출력
		System.out.println("브라우저 요청 방식"+request.getMethod()); 
		System.out.println("브라우저 요청 방식"+request.getRequestURI()); 
		System.out.println("브라우저 사용 프로토콜"+request.getProtocol()); 
		
	}

}
