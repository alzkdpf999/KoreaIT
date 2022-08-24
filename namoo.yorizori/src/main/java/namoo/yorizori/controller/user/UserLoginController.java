package namoo.yorizori.controller.user;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import namoo.yorizori.common.factory.jdbcDaoFactory;
import namoo.yorizori.dto.user.User;

/**
 * Servlet implementation class UserLoginController
 */
@WebServlet("/user/login.do")
public class UserLoginController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getSession().invalidate();
		response.sendRedirect(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		String saveCheck = request.getParameter("yes");
		
		try {
			User loginUser = jdbcDaoFactory.getInstance().getUserDao().login(id, passwd);
			if (loginUser != null) {
				HttpSession loginSession = request.getSession();
				loginSession.setAttribute("loginUser", loginUser);
				if (saveCheck != null) {
					Cookie idCookie = new Cookie("id", loginUser.getId());
					idCookie.setPath("/");
					idCookie.setMaxAge(60 * 60 * 24 * 30);
					response.addCookie(idCookie);
				} 
				response.sendRedirect(request.getContextPath());
			} 
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
