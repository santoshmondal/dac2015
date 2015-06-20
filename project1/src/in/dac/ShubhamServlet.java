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


@WebServlet("/ShubhamServlet")
public class ShubhamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<String> list=new ArrayList<String>();
		list.add("sachin");
		list.add("pavan");
		list.add("sagar");
		list.add("Deepak");
		list.add("Daya");
		list.add("zombie");
		
		request.setAttribute("LIST", list);
		
		
		RequestDispatcher rd=request.getRequestDispatcher("/first1.jsp");
		rd.forward(request,response);
		return;																																											
	}

}
