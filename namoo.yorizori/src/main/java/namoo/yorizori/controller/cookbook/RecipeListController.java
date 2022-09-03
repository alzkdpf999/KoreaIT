package namoo.yorizori.controller.cookbook;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import namoo.yorizori.common.factory.jdbcDaoFactory;
import namoo.yorizori.common.web.YZRuntimeException;
import namoo.yorizori.dao.cookbook.CookbookDao;
import namoo.yorizori.dao.cookbook.RecipeDao;

/**
 * Servlet implementation class RecipeListController
 */
@WebServlet("/recipe/list.do")
public class RecipeListController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RecipeDao recipeDao = jdbcDaoFactory.getInstance().getRecipeDao();
		CookbookDao cookbookDao = jdbcDaoFactory.getInstance().getCookbookDao();
		String book_id = request.getParameter("cbid");
	try {
			request.setAttribute("book",cookbookDao.view_All(book_id));
			request.setAttribute("recipe_list", recipeDao.view_All(Integer.parseInt(book_id)));
			request.getRequestDispatcher("/WEB-INF/views/recipe/recipeList.jsp").forward(request, response);
	}catch (SQLException e) {
		throw new YZRuntimeException(e.getMessage());
	}
		
	}

}
