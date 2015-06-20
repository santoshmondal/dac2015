package in.dac;

import in.dac.database.DacDatabaseController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String email=request.getParameter("email");
		String opr=request.getParameter("opr");
		
		Employee emp = new Employee(email,username,password);
		
		if("REGISTER".equalsIgnoreCase(opr)) {
			boolean success = DacDatabaseController.insertEmployee(emp);	
		} else if("UPDATE".equalsIgnoreCase(opr)) {
			boolean success = DacDatabaseController.updateEmployee(emp);
		}
		
		
		List<Employee> emp_list = DacDatabaseController.readAllEmployee();
		
		request.setAttribute("EMPLIST", emp_list);
		
		RequestDispatcher rd=request.getRequestDispatcher("/success.jsp");
		rd.forward(request, response);
		return;
	
		
	}

}
