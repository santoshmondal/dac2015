package in.dac.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class TimeLogFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		long sTime = System.currentTimeMillis();
		
		HttpServletRequest httpRequest = (HttpServletRequest)request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		
		String uri = httpRequest.getRequestURI();
		StringBuffer url = httpRequest.getRequestURL();
		String path = httpRequest.getPathInfo();
		String pathT = httpRequest.getPathTranslated();
		
		String uname = request.getParameter("uname");
		
		if("abcd".equalsIgnoreCase(uname)) {
			httpResponse.sendRedirect("access_denied.jsp");
			return;
		}
		
		// before this method
		chain.doFilter(request, response);
		
		long eTime = System.currentTimeMillis();
		
		System.out.println("TT :: " + (eTime-sTime) + "ms" + " :: URL ::" + url);
		
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
	}
	
	
	public void destroy() {
	}

}
