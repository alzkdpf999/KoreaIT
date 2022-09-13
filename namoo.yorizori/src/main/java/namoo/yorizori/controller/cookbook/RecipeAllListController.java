package namoo.yorizori.controller.cookbook;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import namoo.yorizori.common.factory.ServiceFactoryImpl;

/**
 * Servlet implementation class RecipeAllListController
 */
@WebServlet("/recipe/all.do")
public class RecipeAllListController extends HttpServlet {
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			request.setAttribute("recipe_list", ServiceFactoryImpl.getInstance().getCookbookService().findRecipeByAll());
			request.getRequestDispatcher("/WEB-INF/views/recipe/recipeAllList.jsp").forward(request, response);
	}



}
