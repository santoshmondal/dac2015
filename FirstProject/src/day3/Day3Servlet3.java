package day3;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Day3Servlet3
 */
@WebServlet("/Day3Servlet3")
public class Day3Servlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		ServletContext application = request.getServletContext();
		
		// request
		String key1 = (String)request.getAttribute("KEY1");
		String key2 = (String)request.getAttribute("KEY2");
		System.out.println("AT SERVLET 3 " + key1 + ":: " + key2);
		
		// session
		String str1 = (String)session.getAttribute("SESSION_KEY1");
		System.out.println("SESION KEY1" + str1);
		
		
		// application
		String strApp1 = "I AM FROM APPLICATION SCOEPE";
		application.setAttribute("APPLICATION_KEY1", strApp1);
		
		
		String str = "I_AM_FROM_SERVLET3";
		request.setAttribute("KEY3", str);
		
		
		RequestDispatcher rd = request.getRequestDispatcher("/registration.jsp");
		rd.forward(request, response);
	}

}
