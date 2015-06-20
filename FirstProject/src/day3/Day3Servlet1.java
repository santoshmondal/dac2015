package day3;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Day3Servlet1
 */
@WebServlet("/Day3Servlet1")
public class Day3Servlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		String str = "I_AM_FROM_SERVLET1";
		request.setAttribute("KEY1", str);
		
		String str1 = "I_AM_FROM_SESSION_SERVLET1";
		session.setAttribute("SESSION_KEY1", str1);
		
		
		RequestDispatcher rd = request.getRequestDispatcher("/Day3Servlet2");
		rd.forward(request, response);
		
	}

}
