package namoo.yorizori.controller.cookbook;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import namoo.yorizori.common.factory.jdbcDaoFactory;
import namoo.yorizori.dao.cookbook.ProcedureDao;
import namoo.yorizori.dao.cookbook.RecipeDao;
import namoo.yorizori.dto.cookbook.Procedure;
import namoo.yorizori.dto.cookbook.Recipe;

/**
 * Servlet implementation class RecipeDetailController
 */
@WebServlet("/recipe/detail.do")
public class RecipeDetailController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RecipeDao recipeDao = jdbcDaoFactory.getInstance().getRecipeDao();
		ProcedureDao procDao =jdbcDaoFactory.getInstance().getProcedureDao();
		String recipe_id = request.getParameter("recipeid");
		try {
			List<Procedure> list = procDao.show(Integer.parseInt(recipe_id));
			Recipe recipe = recipeDao.detail(Integer.parseInt(recipe_id));
			request.setAttribute("recipe", recipe);
			request.setAttribute("proc_list", list);
			request.getRequestDispatcher("/WEB-INF/views/recipe/recipedetail.jsp").forward(request, response);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
