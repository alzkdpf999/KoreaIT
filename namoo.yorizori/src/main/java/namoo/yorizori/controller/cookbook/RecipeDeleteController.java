package namoo.yorizori.controller.cookbook;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import namoo.yorizori.common.factory.ServiceFactoryImpl;

/**
 * Servlet implementation class RecipeDeleteController
 */
@WebServlet("/recipe/delete.do")
public class RecipeDeleteController extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String recipe_id = request.getParameter("recipeid");
		String book_id = request.getParameter("book_id");
		ServiceFactoryImpl.getInstance().getCookbookService().delrecipe(recipe_id);
		response.sendRedirect(request.getContextPath()+"/recipe/list.do?cbid="+book_id);
	}

}
