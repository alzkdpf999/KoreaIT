package namoo.tutorial.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import namoo.common.factory.jdbcDaoFactory;
import namoo.user.dao.UserDao;
import namoo.user.dto.User;

/**
 * 서블릿에서 DB 연동하기
 */
public class DBServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		UserDao userDao = jdbcDaoFactory.getInstance().getUserDao();
		try {
			List<User> list = userDao.list();
			
			out.print("<!DOCTYPE HTML>");
			out.print("<html>");
			out.print("<head>");
			out.print("<meta charset=\"utf-8\">");
			out.print("<title>무료 다운로드 받은 table 관련 CSS 파일</title>");
			out.print("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/table.css\">");
			out.print("</head>");
			out.print("<body>");
			out.print("<br>");

			out.print("<table>");
			out.print("<caption>Flight Schedule</caption>");
			out.print("<thead>");
			out.print("<tr>");
			out.print("<th id=\"fn\" scope=\"col\">아이디</th>");
			out.print("<th id=\"fr\" scope=\"col\">이름</th>");
			out.print("<th id=\"to\" scope=\"col\">이메일</th>");
			out.print("<th id=\"dp\" scope=\"col\">가입일자</th>");
			out.print("</tr>");
			out.print("</thead>");
			out.print("<tfoot>");
			out.print("<tr>");
			out.print("<td colspan=\"4\">Total: ? 명</td>");
			out.print("</tr>");
			out.print("</tfoot>");
			out.print("<tbody>");
			for (User user : list) {
				out.print("<tr>");
				out.print("<td>"+user.getId()+"</td>");
				out.print("<td>"+user.getName()+"</td>");
				out.print("<td>"+user.getEmail()+"</td>");
				out.print("<td>"+user.getRegdate()+"</td>");
				out.print("</tr>");
			}
			out.print("</tbody>");
			out.print("</table>");
			out.print("</body>");
			out.print("</html>");
						}catch(SQLException e) {
			e.printStackTrace();
		}

	}

}
