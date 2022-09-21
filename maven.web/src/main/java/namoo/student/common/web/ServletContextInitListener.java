package namoo.student.common.web;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ServletContextInitListener implements ServletContextListener {
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("서블릿 컨테이너 초기화 됨...");
		String appName = sce.getServletContext().getContextPath();
		sce.getServletContext().setAttribute("ctx", appName);
		//지금 상황에서는 /yorizori를 받아와서 sce에 저장
	}
}
