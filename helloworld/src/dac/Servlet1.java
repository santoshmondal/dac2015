package dac;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Servlet1")
public class Servlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	@Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
    	doPost(request, response);
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String email = request.getParameter("email");
		
		out.println("hello");
		out.println(fname);
		out.println(lname);
		out.println(email);
		
		out.println("<br/>");
		
		Map<String, String[]> map = request.getParameterMap();
		for(Map.Entry<String, String[]> entry : map.entrySet()){
			String key = entry.getKey();
			String[] value = entry.getValue();
			
			out.println("KEY :: " + key + "VALUES :: " + value[0]);
		}
		
		
		
		// Printing the HEADER INFORMATION
		Enumeration<String> headers = request.getHeaderNames();
		while(headers.hasMoreElements()){
			String nextElement = headers.nextElement();
			String headerValue = request.getHeader(nextElement);
			
			out.println(nextElement+ " :: " + headerValue +  "<br />" );
		}
		
		
		String remoteHost = request.getRemoteHost();
		out.println("REMOTE HOST ::" + remoteHost);
		
	}

	@Override
	public void destroy() {
		super.destroy();
		System.out.println("DESTROY METHOD CALLED!!!!");
	}

	@Override
	public void init() throws ServletException {
		super.init();
		System.out.println("INIT METHOD CALLED!!!!");
	}
	
}
