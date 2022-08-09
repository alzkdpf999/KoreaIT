package namoo.servlet3;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 서브릿 3.0버전부터는 아래 @부분에 하고싶은대로 선언하면 됌 web.xml에 따로
 * 설정을 안해도 가능 
 */
@WebServlet("/hello3")
public class HelloServlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("호출");
	}

	

}
