package namoo.tutorial.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BoardwriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String writer=request.getParameter("writer");
//  	DB테이블에 Insert 완료 가정
//		response.setStatus(HttpServletResponse.SC_MOVED_PERMANENTLY);//301 오류
//		response.setHeader("Location", "list.do");
		response.sendRedirect("list.do"); // 위에 두줄을 한줄로 사용
	}

}
