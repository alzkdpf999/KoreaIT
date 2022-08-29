package namoo.yorizori.controller.user;

import java.awt.Checkbox;
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
 * Servlet implementation class UserCheckIdController
 */
@WebServlet("/user/check.do")
public class UserCheckIdController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		User CheckIdUser = ServiceFactoryImpl.getInstance().getUserService().findById(id);
		if(CheckIdUser !=null) request.setAttribute("check",CheckIdUser);
		request.getRequestDispatcher("/WEB-INF/views/user/checkId.jsp").forward(request, response);//포워드
	}
}
