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
 * Servlet implementation class CookbookModifyController
 */
@WebServlet("/cookbook/modify.do")
public class CookbookModifyController extends HttpServlet {
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String book_id = request.getParameter("cbid");
		request.setAttribute("local", request.getHeader("referer"));
		request.setAttribute("book",ServiceFactoryImpl.getInstance().getCookbookService().findCookbookById(book_id));
		request.getRequestDispatcher("/WEB-INF/views/cookbook/cookbookModify.jsp").forward(request, response);
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String book_name =request.getParameter("book_name");
		String local = request.getParameter("local");
		String book_desc =request.getParameter("book_desc");
		String book_id= request.getParameter("book_id");
		Cookbook cookbook = new Cookbook();
		cookbook.setBook_name(book_name);
		cookbook.setBook_desc(book_desc);
		cookbook.setBook_id(book_id);
		ServiceFactoryImpl.getInstance().getCookbookService().modifyCookbook(cookbook);
		response.sendRedirect(local);
	}

}
