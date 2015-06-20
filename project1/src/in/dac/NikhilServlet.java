package in.dac;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/NikhilServlet")
public class NikhilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Employee> emplist = new ArrayList<Employee>();
		
		Employee e1=new Employee("150240320096","CDAC","Mumbai");
		Employee e2=new Employee("150240320095","Cognizant","Pune");
		Employee e3=new Employee("150240320081","Rediff","Mumbai");
		
		emplist.add(e1);
		emplist.add(e2);
		emplist.add(e3);
		
		request.setAttribute("EMPLIST", emplist);
		
		
		RequestDispatcher rd= request.getRequestDispatcher("/nikhil1.jsp");
		rd.forward(request, response);
		return;
	}

}
