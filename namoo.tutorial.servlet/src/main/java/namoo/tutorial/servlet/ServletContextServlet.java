package namoo.tutorial.servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ServletContextServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String message = "1모든 서블릿이 공유하는 데이터";//포워드를 안함
		ServletContext context = request.getServletContext();
		// 저장하는 용도
		context.setAttribute("message", message); 
		//삭제  키를 넣어주면 지우기
//		context.removeAttribute("message");
		String driver = context.getInitParameter("jdbc.driver");
		System.out.println(driver);
		
	}

}
