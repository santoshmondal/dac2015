package in.dac;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Sunnyservlet
 */
@WebServlet("/Sunnyservlet")
public class Sunnyservlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.print("hello world");
		
		ServletConfig config = getServletConfig();
		String connection = config.getInitParameter("CONNECTION_SERVER");
		out.println(connection);
		

		ServletContext application = getServletContext();
		String value = application.getInitParameter("HELLO");
		out.println("<br>");
		out.println(value);
		
	}
}
