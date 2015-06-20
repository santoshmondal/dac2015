package in.dac;

import in.dac.database.DacDatabaseController;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		String username = request.getParameter("uname");
		String password = request.getParameter("pwd");
		
		
		boolean login=false;
		
		Employee emp = DacDatabaseController.readEmployeeByUsername(username, password);
		
		if(emp!=null) {
			session.setAttribute("USER_SESSION", emp);
			session.setAttribute("AUTH", true);			
			login=true;
		}
	
		if(login) {
			RequestDispatcher rd = request.getRequestDispatcher("/home.jsp");
			rd.forward(request, response);
			return;
		}
		
		else {
			String message = "Wrong Username or Password!!";
			response.sendRedirect("signin.jsp?message=" + message);
		}
		 
		
	}

}
