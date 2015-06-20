package day4;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import reg.Student;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 
		HttpSession session = request.getSession();
		ServletContext application = request.getServletContext();
		
		// user login details
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		// database
		List<Student> studentList = (List<Student>)application.getAttribute("STUDENTLIST");
		
		
		// now authenticate the user
		boolean login = false;
		if(studentList != null) {
			for(int i= 0; i<studentList.size(); i++) {
				Student student = studentList.get(i);
				
				String fname = student.getFname();
				
				if(fname.equalsIgnoreCase(username)) {
					// session key for authentication
					session.setAttribute("AUTH", true);
					
					session.setAttribute("STUDENT", student);
					login = true;
					break;
				} else {
					
				}
				
			}
		}
		
		
		if(login) {
			
			response.sendRedirect("home.jsp");
			
		} else {
			session.setAttribute("FAILURE", "LOGIN FAILURE!!");
			response.sendRedirect("login.jsp");
		}
		
	}

}
