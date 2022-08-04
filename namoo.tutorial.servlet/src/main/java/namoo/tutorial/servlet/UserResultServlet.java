package namoo.tutorial.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import namoo.user.dto.User;

/**
 * 서블릿에서 DB 연동하기
 * 디스패치로
 */
public class UserResultServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = (User) request.getAttribute("user");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='utf-8'>");
		out.println("<title>오늘부터 서블릿 프로그래밍프로그램입니다.</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h2>회원가입 결과</h2>");
		out.println("<ul>");
		out.println("<li>"+user.getId()+"</li>");
		out.println("<li>"+user.getName()+"</li>");
		out.println("<li>"+user.getEmail()+"</li>");
		out.println("</ul>");
		out.println("<a href='index.html'>홈으로</a>");
		RequestDispatcher rd = request.getRequestDispatcher("gugudan");
		rd.include(request, response);
		out.println("</body>");
		out.println("</html>");
	}

}
