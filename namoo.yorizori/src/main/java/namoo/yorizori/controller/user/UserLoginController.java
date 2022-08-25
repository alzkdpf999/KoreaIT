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
			HttpSession loginSession = request.getSession();
			User loginUser = jdbcDaoFactory.getInstance().getUserDao().login(id, passwd);
			if (loginUser != null) {
				loginSession.setAttribute("loginUser", loginUser);
				if (saveCheck != null) { // 저장 체크 x
					Cookie idCookie = new Cookie("id", loginUser.getId());
					idCookie.setPath("/");
					idCookie.setMaxAge(60 * 60 * 24 * 30);
					response.addCookie(idCookie);
				} else { // 저장 체크 o
					Cookie[] cookies = request.getCookies();
					if (cookies != null) {
						for (Cookie cookie : cookies) {
							if (cookie.getName().equals("id")) {
								cookie.setMaxAge(0);
								cookie.setPath("/");
								response.addCookie(cookie);
							}
						}
					}
				}
				Cookie[] cookies = request.getCookies();
				if (cookies != null) { // 로그인했을 시 에러 쿠키 다 삭제
					for (Cookie cookie : cookies) {
						if (cookie.getName().equals("errPsw") || cookie.getName().equals("err")) {
							cookie.setMaxAge(0);
							cookie.setPath("/");
							response.addCookie(cookie);
						}
					}
				}
			} else { // 로그인 오류
				
				if (id.equals("") || id == null) {
					id="";
					Cookie errCookie = new Cookie("err", "-1"); //아이디 오류
					errCookie.setPath("/");
					errCookie.setMaxAge(60 * 60 * 24 * 30);
					response.addCookie(errCookie);
				} else if (!id.equals("") && id != null) {
					Cookie errCookie = new Cookie("err", "0"); //비밀번호 오류

					/*
					 * if (jdbcDaoFactory.getInstance().getUserDao().read(id) == null) { errCookie =
					 * new Cookie("err", "-2"); //아이디 비밀번호 오류
					 * 
					 * }else {
					 * 
					 * }
					 */
					Cookie errPsCookie = new Cookie("errPsw", id); //아이디 남기기
					errPsCookie.setPath("/");
					errPsCookie.setMaxAge(60 * 60 * 24 * 30);
					response.addCookie(errPsCookie);
					errCookie.setPath("/");
					errCookie.setMaxAge(60 * 60 * 24 * 30);
					response.addCookie(errCookie);
				}

				if (saveCheck == null) { // 저장 체크 x
					Cookie[] cookies = request.getCookies();
					if (cookies != null) {
						for (Cookie cookie : cookies) {
							if (cookie.getName().equals("id")) {
								cookie.setMaxAge(0);
								cookie.setPath("/");
								response.addCookie(cookie);
							}
						}
					}
				} else { // 아이디 저장 체크 o
					Cookie idCookie = null;
					idCookie = new Cookie("id", id);
					idCookie.setPath("/");
					idCookie.setMaxAge(60 * 60 * 24 * 30);
					response.addCookie(idCookie);
				}
			}
			response.sendRedirect(request.getContextPath());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
