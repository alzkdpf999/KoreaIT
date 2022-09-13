package namoo.yorizori.controller.cookbook;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import namoo.yorizori.common.factory.ServiceFactoryImpl;
import namoo.yorizori.dto.cookbook.Cookbook;

/**
 * Servlet implementation class CookBookRegistController
 */
@WebServlet("/cookbook/regist.do")
public class CookBookRegistController extends HttpServlet {
// 조회
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		request.setAttribute("local", request.getHeader("referer"));
		request.getRequestDispatcher("/WEB-INF/views/cookbook/cookbookForm.jsp").forward(request, response);
	}
// 등록, 삭제 ,수정 처리
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//request.setCharacterEncoding("utf-8");
		String book_name = request.getParameter("book_name");
		String Username = request.getParameter("Username");
		String book_desc = request.getParameter("book_desc");
		String UserId = request.getParameter("author_id");
		System.out.println(request.getAttribute("local"));
		Cookbook cookbook = new Cookbook();
		cookbook.setAuthor_name(Username);
		cookbook.setBook_desc(book_desc);
		cookbook.setBook_name(book_name);
		cookbook.setAuthor_id(UserId);
		ServiceFactoryImpl.getInstance().getCookbookService().registerCookbook(cookbook);
		request.setAttribute("cookbook", cookbook);
		response.sendRedirect(request.getContextPath()+"/cookbook/list.do");
		
	}

}
