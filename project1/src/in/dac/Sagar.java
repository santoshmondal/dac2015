package in.dac;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Sagar")
public class Sagar extends HttpServlet {
	private static final long serialVersionUID = 1L;
     

     
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost( request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<String,String> map=new HashMap<String,String>();
		map.put("01","Sagar");
		map.put("02","Sachin");
		map.put("03","Sanket");
		
		request.setAttribute("MAP", map);
		RequestDispatcher rd=request.getRequestDispatcher("/sagar.jsp");
		rd.forward(request, response);
	}

}
