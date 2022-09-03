package namoo.yorizori.common.web;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ServletContextInitListener implements ServletContextListener {
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		String appName = sce.getServletContext().getContextPath();
		sce.getServletContext().setAttribute("ctx", appName);
		//지금 상황에서는 /yorizori를 받아와서 sce에 저장
	}
}
