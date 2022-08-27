package namoo.yorizori.controller.user;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.net.ApplicationBufferHandler;

import namoo.yorizori.common.factory.jdbcDaoFactory;
import namoo.yorizori.dao.user.UserDao;
import namoo.yorizori.dto.user.User;

/**
 * 회원가입 처리 서블릿
 */
@WebServlet("/user/regist.do")
public class UserRegistController extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		System.out.println(id);
		System.out.println(passwd);
		User user = new User(id,passwd,name,email);
		
		//서비스(비즈니스) 객체를 이용한 DB처리
		UserDao userDao = jdbcDaoFactory.getInstance().getUserDao();
		
		try {
			
			userDao.create(user);
			request.setAttribute("user", user);
			request.getRequestDispatcher("/WEB-INF/views/user/userResult.jsp").forward(request, response);//포워드
		} catch (SQLException e) {
		}
	}

}
