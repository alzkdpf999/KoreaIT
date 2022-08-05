package namoo.tutorial.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class IncludeServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("서블릿컨테이너에 의해 doGET()호출됨 ");//디버그용
		response.setContentType("text/html; charset=utf-8");//출력하고자 하는 데이터를 알려줌
		String message = "서블릿은 동적 HTML 작성을 위한 웹 컴포넌트 입니다.";
		PrintWriter out=response.getWriter();
		RequestDispatcher rd = request.getRequestDispatcher("gugudan");
		 
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='utf-8'>");
		out.println("<title>오늘부터 서블릿 프로그래밍프로그램입니다.</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h2>"+message+"</h2>");
		rd.include(request, response);
		out.println("</body>");
		out.println("</html>");
	}
}
