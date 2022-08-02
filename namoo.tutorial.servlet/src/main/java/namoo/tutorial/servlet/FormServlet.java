package namoo.tutorial.servlet;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class FormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//파싱해서 가져오기 떄문에 읽기만 하면 됌
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}
	//한글이 깨져서 나옴
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}
	protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//GET방식을 전송한 FORM 데이터 읽기
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String passwd = request.getParameter("passwd");
		//체크박스는 getParameter가 아닌 getParameterValues로 받는다
		String[] languages = request.getParameterValues("language");
		//select가 만약 mutiple이면 getParameterValues 아니면 getParameter
		String car = request.getParameter("cars");
		System.out.println("======수신한 데이터 =====");
		System.out.println(id);
		System.out.println(name);
		System.out.println(passwd);
		//체크를 안하면 오류가 발생함 500 그래서 if를 해야 알맞은 코드
		if(languages !=null) {
			for(String lang : languages) {
				System.out.print(lang+",");	
			}
		}
		System.out.println();
		System.out.println(car);
		//파라미터 이름을 모르는 경우(동적 생성)
		Enumeration<String> paramNames = request.getParameterNames();
		while(paramNames.hasMoreElements()) {
			String parameterName = paramNames.nextElement();
			if(parameterName.equals("language")) {
				String[] values = request.getParameterValues(parameterName);
				System.out.println(values);
			}
			String parameterValue = request.getParameter(parameterName);
			System.out.println(parameterValue);
		}
	}
}
