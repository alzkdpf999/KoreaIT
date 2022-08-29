package namoo.yorizori.controller.cookbook;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import namoo.yorizori.common.factory.jdbcDaoFactory;
import namoo.yorizori.dao.cookbook.CookbookDao;
import namoo.yorizori.dao.user.UserDao;
import namoo.yorizori.dto.cookbook.Cookbook;
import namoo.yorizori.dto.user.User;

/**
 * Servlet implementation class CookBookRegistController
 */
@WebServlet("/cookbook/regist.do")
public class CookBookRegistController extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request.setCharacterEncoding("utf-8");
				String book_id = "cookbook_seq.NEXTVAL"; 
				String book_name = request.getParameter("book_name");
				String book_author = request.getParameter("book_author");
				String book_desc = request.getParameter("book_desc");
				Cookbook cookbook = new Cookbook(book_id,book_name,book_author,book_desc);
				CookbookDao cookbookDao = jdbcDaoFactory.getInstance().getCookbookDao();
				
				
				try {
					cookbookDao.regist(cookbook);
					request.setAttribute("cookbook", cookbook);
					request.getRequestDispatcher("/WEB-INF/cookbook/cookbookList.jsp").forward(request, response);
				} catch (SQLException e) {
				}
			}

	}

