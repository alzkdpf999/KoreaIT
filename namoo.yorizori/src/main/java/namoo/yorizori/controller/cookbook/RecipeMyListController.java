package namoo.yorizori.controller.cookbook;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import namoo.yorizori.common.factory.ServiceFactoryImpl;
import namoo.yorizori.dto.cookbook.Cookbook;
import namoo.yorizori.dto.cookbook.Recipe;
import namoo.yorizori.dto.user.User;

/**
 * Servlet implementation class RecipeMyListController
 */
@WebServlet("/myrecipe.do")
public class RecipeMyListController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("loginUser");
		List<Cookbook> cookbooks = ServiceFactoryImpl.getInstance().getCookbookService().myCookbook(user.getId());
		HashMap<Cookbook, List<Recipe>> Hashlist = new HashMap<>();
		for (Cookbook cookbook : cookbooks) {
			int bookid =Integer.parseInt(cookbook.getBook_id());
			List<Recipe> recipes = ServiceFactoryImpl.getInstance().getCookbookService().findRecipeBybookId(bookid);
			Hashlist.put(cookbook, recipes);
			}
		request.setAttribute("Hashlist", Hashlist);
		request.getRequestDispatcher("/WEB-INF/views/recipe/recipeMyList.jsp").forward(request, response);// 포워드
	}

}
