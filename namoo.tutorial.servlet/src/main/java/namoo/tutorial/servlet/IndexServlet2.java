package namoo.tutorial.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//쿠기 사용
public class IndexServlet2 extends HttpServlet {  
	private static final long serialVersionUID = 1L;



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//		HttpSession session =request.getSession();
//		User user =(User) session.getAttribute("user");
		String loginId=null;
		String regdate=null;
		Cookie[] cookies = request.getCookies();
		if(cookies != null) {
			for(Cookie cookie : cookies) {
				if(cookie.getName().equals("id")) loginId = cookie.getValue();
				if(cookie.getName().equals("date")) regdate = cookie.getValue();
			}
		}
		response.setContentType("text/html; charset=utf-8");
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
		if(loginId != null) {
			out.println("<h4>"+loginId+"("+regdate+")님 로그인 중</h4>");
			out.println("<a href ='login.do'>로그아웃</a>"); //링크는 무조건 get방식임
		}else {
			out.println("<form method=\"post\" action=\"login2.do\">");
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
