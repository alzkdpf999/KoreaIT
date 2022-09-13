package namoo.yorizori.controller.cookbook;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import namoo.yorizori.common.factory.ServiceFactoryImpl;

/**
 * Servlet implementation class MainviewController
 */
@WebServlet("/index.do")
public class MainviewController extends HttpServlet {
	@Override
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("cooktop", ServiceFactoryImpl.getInstance().getCookbookService().top4Cookbook());
		request.setAttribute("recipetop",ServiceFactoryImpl.getInstance().getCookbookService().top4Recipe());
		request.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(request, response);
		}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("cooktop", ServiceFactoryImpl.getInstance().getCookbookService().top4Cookbook());
		request.setAttribute("recipetop",ServiceFactoryImpl.getInstance().getCookbookService().top4Recipe());
		request.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(request, response);
	}

}
