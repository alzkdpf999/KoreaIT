package namoo.tutorial.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletConfigServlet
 */
public class ServletConfigServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    	public void init(ServletConfig config) throws ServletException {
    		String user = config.getInitParameter("user");
    		String passwd = config.getInitParameter("passwd");
    		System.out.println(user);
    		System.out.println(passwd);
    	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("초기 파라미터 테스트");
	}

}
