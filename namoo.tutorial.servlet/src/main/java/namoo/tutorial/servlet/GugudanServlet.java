package namoo.tutorial.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GugudanServlet
 */
public class GugudanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");//출력하고자 하는 데이터를 알려줌
		//;하고 한 칸 뛰우고 인코딩 방식을 알려줌
		PrintWriter out=response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='utf-8'>");
		out.println("<title>동적 구구단 출력하기</title>");
		out.println("<style>");
		out.println("table{border:1px solid black}");
		out.println("</style>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h2>구구단</h2>");
		out.println("<table>");
		for(int i=2; i<10;i++) {
			out.println("<tr>");
			for(int j=1;j<10;j++) {
				out.println("<td>"+i+"*"+j+"="+(j*i)+"</td>");
			}
			out.println("</tr>");
		}
		out.println("</table>");
		out.println("</body>");
		out.println("</html>");
	}

}
