package namoo.tutorial.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BoardListServlet
 */
public class BoardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   		//DB에서 게시판 리스트 조회
   		response.setContentType("text/html; charset=utf-8");//출력하고자 하는 데이터를 알려줌
		PrintWriter out=response.getWriter();
//		response.sendError(HttpServletResponse.SC_FORBIDDEN);//403 금지됨 
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='utf-8'>");
		out.println("<title>게시판 리스트</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h2>게시판 리스트입니다.</h2>");
		out.println("</body>");
		out.println("</html>");
   	}
}
