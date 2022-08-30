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

/**
 * Servlet implementation class CookBookListController
 */
@WebServlet("/cookbook/list.do")
public class CookBookListController extends HttpServlet {
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CookbookDao cookbookDao = jdbcDaoFactory.getInstance().getCookbookDao();
		try {
			request.setAttribute("book_list",cookbookDao.view_All());  
			request.getRequestDispatcher("/WEB-INF/cookbook/cookbookList.jsp").forward(request, response);// 포워드
		} catch (SQLException e) {
			throw new YZRuntimeException(e.getMessage());
		}
	}


}
