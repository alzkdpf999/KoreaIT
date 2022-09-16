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
@WebServlet(urlPatterns={"/recipe/detail.do","/recipe/my/detail.do","/recipe/main/detail.do","/recipe/all/detail.do","/recipe/myrecipe/detail.do"})

public class RecipeDetailController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getRequestURI().contains("my")) {
			if(request.getRequestURI().contains("myrecipe")) {
				request.setAttribute("page", request.getContextPath()+"/myrecipe.do");
				request.setAttribute("move", "myrecipe/");
			}else {
			request.setAttribute("page", request.getContextPath()+"/recipe/my/list.do");
			request.setAttribute("move", "my/");
			}
		}else if(request.getRequestURI().contains("main")) {
			request.setAttribute("page", request.getContextPath()+"/recipe/main/list.do");
			request.setAttribute("move", "main/");
		}else if(request.getRequestURI().contains("all")){
			request.setAttribute("page", request.getContextPath()+"/recipe/all.do");
			request.setAttribute("move", "all/");
		}else {
			request.setAttribute("page", request.getContextPath()+"/recipe/list.do");
		}
		System.out.println(request.getRequestURL());
		String recipe_id = request.getParameter("recipeid");
		ServiceFactoryImpl.getInstance().getCookbookService().recipeview(recipe_id);
		request.setAttribute("recipe", ServiceFactoryImpl.getInstance().getCookbookService().findRecipeById(Integer.parseInt(recipe_id)));
		request.setAttribute("proc_list", ServiceFactoryImpl.getInstance().getCookbookService().findProcedureByrecipeid(Integer.parseInt(recipe_id)));
		request.getRequestDispatcher("/WEB-INF/views/recipe/recipedetail.jsp").forward(request, response);
	
	}

}
