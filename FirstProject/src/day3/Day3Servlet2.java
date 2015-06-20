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
 * Servlet implementation class Day3Servlet2
 */
@WebServlet("/Day3Servlet2")
public class Day3Servlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		String key1 = (String)request.getAttribute("KEY1");
		System.out.println("AT SERVLET 2 " + key1);
		
		String str1 = (String)session.getAttribute("SESSION_KEY1");
		System.out.println("SESION KEY1" + str1);
		
		String str = "I_AM_FROM_SERVLET2";
		request.setAttribute("KEY2", str);
		
		
		RequestDispatcher rd = request.getRequestDispatcher("/Day3Servlet3");
		rd.forward(request, response);
	}

}
