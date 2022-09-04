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
import namoo.yorizori.dao.cookbook.CookbookDao;
import namoo.yorizori.dao.user.UserDao;
import namoo.yorizori.dto.cookbook.Cookbook;
import namoo.yorizori.dto.user.User;
import namoo.yorizori.service.cookbook.CookbookServiceImpl;

/**
 * Servlet implementation class CookBookRegistController
 */
@WebServlet("/cookbook/regist.do")
public class CookBookRegistController extends HttpServlet {
// 조회
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 로그인 안하면 오류 페이지로 보내주고
		//일단 보류
		// 아니면 디스페처로 창 뛰워주기
		request.getRequestDispatcher("/WEB-INF/views/cookbook/cookbookForm.jsp").forward(request, response);
	}
// 등록, 삭제 ,수정 처리
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// request.setCharacterEncoding("utf-8");
		String book_name = request.getParameter("book_name");
		String Username = request.getParameter("Username");
		String book_desc = request.getParameter("book_desc");
		Cookbook cookbook = new Cookbook();
		cookbook.setAuthor_id(Username);
		cookbook.setBook_desc(book_desc);
		cookbook.setBook_name(book_name);
		ServiceFactoryImpl.getInstance().getCookbookService().registerCookbook(cookbook);
		request.setAttribute("cookbook", cookbook);
		response.sendRedirect(request.getContextPath()+"/cookbook/list.do");
		System.out.println(request.getHeader("referer"));
	}

}
