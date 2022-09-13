package namoo.yorizori.controller.cookbook;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import namoo.yorizori.common.factory.ServiceFactoryImpl;
import namoo.yorizori.common.factory.jdbcDaoFactory;
import namoo.yorizori.common.web.YZRuntimeException;
import namoo.yorizori.dao.cookbook.RecipeDao;

/**
 * Servlet implementation class RecipeListController
 */
@WebServlet(urlPatterns={"/recipe/list.do","/recipe/my/list.do","/recipe/main/list.do"})
public class RecipeListController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		if(request.getRequestURI().contains("my")) {
			request.setAttribute("page", request.getContextPath()+"/mybook.do");
		}else if(request.getRequestURI().contains("main")) {
			request.setAttribute("page", request.getContextPath()+"/index.do");
		}else {
			request.setAttribute("page", request.getContextPath()+"/cookbook/list.do");
		}
		
		//request.setAttribute("local", request.getRequestURL());
		String book_id = request.getParameter("cbid");
		ServiceFactoryImpl.getInstance().getCookbookService().cookbookview(book_id);
		request.setAttribute("book", ServiceFactoryImpl.getInstance().getCookbookService().findCookbookById(book_id));
		request.setAttribute("recipe_list",
				ServiceFactoryImpl.getInstance().getCookbookService().findRecipeBybookId(Integer.parseInt(book_id)));
		request.getRequestDispatcher("/WEB-INF/views/recipe/recipeList.jsp").forward(request, response);

	}

}
