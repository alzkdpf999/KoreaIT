package namoo.yorizori.controller.cookbook;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import namoo.yorizori.common.factory.ServiceFactoryImpl;
import namoo.yorizori.dto.user.User;

/**
 * Servlet implementation class CookbookMyController
 */
@WebServlet("/mybook.do")
public class CookbookMyController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		System.out.println(request.getHeader("referer"));
		HttpSession session = request.getSession();
		User user =  (User)session.getAttribute("loginUser");
		request.setAttribute("book_list",ServiceFactoryImpl.getInstance().getCookbookService().myCookbook(user.getId()));  
		request.getRequestDispatcher("/WEB-INF/views/cookbook/cookbookMyList.jsp").forward(request, response);// 포워드
	}

}
