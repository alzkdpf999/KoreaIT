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
import namoo.yorizori.dao.cookbook.CookbookDao;

/**
 * Servlet implementation class CookBookListController
 */
@WebServlet("/cookbook/list.do")
public class CookBookListController extends HttpServlet {
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("local", request.getHeader("referer"));
		request.setAttribute("book_list",ServiceFactoryImpl.getInstance().getCookbookService().findCookbookByAll());  
		request.getRequestDispatcher("/WEB-INF/views/cookbook/cookbookList.jsp").forward(request, response);// 포워드
	}


}
