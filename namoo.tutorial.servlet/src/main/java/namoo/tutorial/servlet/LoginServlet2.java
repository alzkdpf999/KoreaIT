package namoo.tutorial.servlet;

import java.io.IOException;
import java.net.URLEncoder;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import namoo.common.factory.jdbcDaoFactory;
import namoo.user.dao.UserDao;
import namoo.user.dto.User;

//쿠기 사용 쿠기는 한글을 저장할 수 없음
public class LoginServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//로그인 처리
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id= request.getParameter("id");
		String passwd = request.getParameter("passwd");
		
		UserDao userdao=jdbcDaoFactory.getInstance().getUserDao();
		try {
			User user =userdao.login(id, passwd);
//			HttpSession session = request.getSession();
//			session.setAttribute("user", user);
			//쿠기는 텍스트이므로 문자열만 저장 가능
			//두개를 적용하고 싶으면 구분자를 넣어줘서 받는 쪽에서 파싱해야한다.(bangry|2001-02)
			Cookie idCookie = new Cookie("id",user.getId());
			Cookie dateCookie = new Cookie("date",URLEncoder.encode(user.getRegdate(),"utf-8"));
			
			response.addCookie(idCookie);
			response.addCookie(dateCookie);
			response.sendRedirect("index2.do");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	//로그아웃처리
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		HttpSession session = request.getSession();
//		session.invalidate(); 참고 ==> 기본 session들은 브라우저 요청없이 30분정도 지나면 자동으로 삭제  
//		response.sendRedirect("index2.do");
		//쿠키로 처리하기 위해
		Cookie[] cookies = request.getCookies();
		if(cookies != null) {
			for(Cookie cookie : cookies) {
				if(cookie.getName().equals("id") || cookie.getName().equals("date")) {
					cookie.setMaxAge(0);
					response.addCookie(cookie);
				}
			}
			response.sendRedirect("index2.do");
		}
	}


}
