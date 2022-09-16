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
@WebServlet(urlPatterns={"/recipe/delete.do","/recipe/my/delete.do","/recipe/main/delete.do","/recipe/all/delete.do","/recipe/myrecipe/delete.do"})
public class RecipeDeleteController extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String recipe_id = request.getParameter("recipeid");
		System.out.println(request.getHeader("referer"));
		String book_id = request.getParameter("book_id");
		ServiceFactoryImpl.getInstance().getCookbookService().delrecipe(recipe_id);
		if(request.getHeader("referer").contains("my")) {
			if(request.getHeader("referer").contains("myrecipe")) {
				response.sendRedirect(request.getContextPath()+"/myrecipe.do");
			}else {
				response.sendRedirect(request.getContextPath()+"/recipe/my/list.do?cbid="+book_id);
				
			}
		}else if(request.getHeader("referer").contains("main")) {
			response.sendRedirect((request.getContextPath()+"/recipe/main/list.do?cbid="+book_id));
		}else if(request.getHeader("referer").contains("all")){
			response.sendRedirect(request.getContextPath()+"/recipe/all.do");
		}else {
			response.sendRedirect(request.getContextPath()+"/recipe/list.do?cbid="+book_id);
		}
	}

}
