package namoo.yorizori.common.web;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpFilter;

/**
 * Servlet Filter implementation class CharacterEncodingfilter
 */
@WebFilter(
		description = "문자인코딩 필터", 
		urlPatterns = { "*.do" }, 
		initParams = { 
				@WebInitParam(name = "encoding", value = "utf-8")
		})
public class CharacterEncodingfilter extends HttpFilter implements Filter {
	private String encoding;
	
	public void destroy() {
	}
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//post 요청에 대한 문자 인코딩 설정
		request.setCharacterEncoding(encoding);
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		encoding = fConfig.getInitParameter("encoding");
	}

}
