package reg;

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
import javax.servlet.http.HttpSession;


@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private List<Student> studentList = new ArrayList<Student>();
    public RegistrationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		ServletContext application = request.getServletContext();
		
		String id = request.getParameter("id");
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String contact = request.getParameter("mobile");
		
		Student student = new Student();
		student.setFname(fname);
		student.setLname(lname);
		student.setMobile(contact);
		student.setStdId(id);
		
		studentList.add(student);
		
		application.setAttribute("STUDENTLIST",studentList);
		RequestDispatcher rd = request.getRequestDispatcher("/success.jsp");
		rd.forward(request,response);
		
	}

}
