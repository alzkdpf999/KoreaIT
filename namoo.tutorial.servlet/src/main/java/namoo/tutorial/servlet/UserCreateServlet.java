package namoo.tutorial.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import namoo.common.factory.jdbcDaoFactory;
import namoo.user.dao.UserDao;
import namoo.user.dto.User;

/**
 * 서블릿에서 DB 연동하기
 */
public class UserCreateServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		User users = new User(id,passwd,name,email);


		UserDao userDao = jdbcDaoFactory.getInstance().getUserDao();
		try {
			userDao.create(users);
			//회원목록 보여주는 서블릿으로 이동 redirect userDao가 사라진다 
//			response.sendRedirect("db.do");
			//회원가입 결과를 보여주는 서블릿으로 이동
			//request에다가 저장시켜놓는 메소드 인자는 키와 값(object);
			request.setAttribute("user", users);
			RequestDispatcher dispather=request.getRequestDispatcher("result.do");
			dispather.forward(request, response);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

}
