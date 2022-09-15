package namoo.yorizori.controller.cookbook;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import namoo.yorizori.common.factory.ServiceFactoryImpl;

/**
 * Servlet implementation class CookbookDeleteController
 */
@WebServlet("/cookbook/delete.do")
public class CookbookDeleteController extends HttpServlet {
@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String book_id=request.getParameter("cbid");
	System.out.println(request.getHeader("referer"));
	
	ServiceFactoryImpl.getInstance().getCookbookService().delcookbook(book_id);
	
	
	if(request.getHeader("referer").contains("my")) {
		if(request.getHeader("referer").contains("myrecipe")) {
			response.sendRedirect(request.getContextPath()+"/myrecipe.do");
		}else {
			response.sendRedirect(request.getContextPath()+"/mybook.do");
			
		}
	}else if(request.getHeader("referer").contains("main")) {
		response.sendRedirect((request.getContextPath()+"/index.do"));
	}else {
		response.sendRedirect(request.getContextPath()+"/cookbook/list.do");
	}
	
	
	
//	response.sendRedirect(request.getContextPath()+"/cookbook/list.do");
	}

}
