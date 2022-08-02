package namoo.tutorial.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LifecycleServlet
 */
public class LifecycleServlet extends HttpServlet {
	private int count;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     * 제일 먼저 호출됨 한번만 호출
     */
    public LifecycleServlet() {
    	System.out.println("생성자 LifecycleServlet() 호출 됨");
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 * 한번만 호출
	 */
	public void init(ServletConfig config) throws ServletException {
		count = 0;
		System.out.println("init() 호출됨. ..");
	}

	/**
	 * @see Servlet#destroy()
	 * 사용해지할 떄 사용
	 */
	public void destroy() {
		System.out.println("destroy() 호출됨. ..");	
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 * 서비스 매소드를 오버라이딩 하면서 기존에 있는 서비스 메소드를 사용
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.service(request, response);
		System.out.println("service()호출됨...."+count++);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * 빠른 이용
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doget() 호출됨...");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out=response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='utf-8'>");
		out.println("<title>오늘부터 서블릿 프로그래밍프로그램입니다.</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h2>당신은"+count+"번 째 방문자입니다.</h>");
		out.println("</body>");
		out.println("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 * 보안에 좋음
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("dopost() 호출됨...");
	}

}
