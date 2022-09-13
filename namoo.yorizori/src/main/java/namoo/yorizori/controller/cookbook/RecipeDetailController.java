package namoo.yorizori.controller.cookbook;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import namoo.yorizori.common.factory.ServiceFactoryImpl;

/**
 * Servlet implementation class RecipeDetailController
 */
@WebServlet("/recipe/detail.do")
public class RecipeDetailController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("local", request.getHeader("referer"));
		String recipe_id = request.getParameter("recipeid");
		ServiceFactoryImpl.getInstance().getCookbookService().recipeview(recipe_id);
		request.setAttribute("recipe", ServiceFactoryImpl.getInstance().getCookbookService().findRecipeById(Integer.parseInt(recipe_id)));
		request.setAttribute("proc_list", ServiceFactoryImpl.getInstance().getCookbookService().findProcedureByrecipeid(Integer.parseInt(recipe_id)));
		request.getRequestDispatcher("/WEB-INF/views/recipe/recipedetail.jsp").forward(request, response);
	
	}

}
