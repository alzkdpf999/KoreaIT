package namoo.tutorial.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import namoo.user.dto.User;


public class IndexServlet extends HttpServlet {  
	private static final long serialVersionUID = 1L;



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session =request.getSession();
		User user =(User) session.getAttribute("user");
		response.setContentType("text/html; charset=utf-8");
		String message = "서블릿은 동적 HTML 작성을 위한 웹 컴포넌트 입니다.";
		PrintWriter out=response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html lang=\"en\">");
		out.println("<head>");
		out.println("<meta charset=\"UTF-8\">");
		out.println("<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">");
		out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
		out.println("<title>Document</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h2 style=\"font-weight: bold;font-family: 'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;\">기본 정보 입력</h2>");
		if(user != null) {
			out.println("<h4>"+user.getId()+"("+user.getRegdate()+")님 로그인 중</h4>");
			out.println("<a href ='login.do'>로그아웃</a>");
		}else {
			out.println("<form method=\"post\" action=\"login.do\">");
			out.println("<table border=\"1\">");
			out.println(" <tr>");
			out.println("<th><label for=\"id\">아이디</label> </th>");
			out.println("<td>");
			out.println("<input type=\"text\" name=\"id\" id=\"id\">");
			out.println("<input type=\"button\" value=\"중복체크\">");
			out.println("</td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<th><label for=\"passwd\">비밀번호</label></th>");
			out.println("<td><input type=\"password\" id=\"passwd\" name=\"passwd\"></td>");
			out.println("</tr>");
			out.println("</table><br>");
			out.println("<input type=\"submit\" value=\"저장\">");
			out.println("</form>"); 
			out.println("</body>");
			out.println("</html>");

		}

	}

}
