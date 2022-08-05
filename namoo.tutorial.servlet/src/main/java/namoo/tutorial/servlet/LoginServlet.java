package namoo.tutorial.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import namoo.common.factory.jdbcDaoFactory;
import namoo.user.dao.UserDao;
import namoo.user.dto.User;


public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//로그인 처리
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id= request.getParameter("id");
		String passwd = request.getParameter("passwd");
		
		UserDao userdao=jdbcDaoFactory.getInstance().getUserDao();
		try {
			User user =userdao.login(id, passwd);
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			response.sendRedirect("index.do");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	//로그아웃처리
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.invalidate();
		
	}


}
