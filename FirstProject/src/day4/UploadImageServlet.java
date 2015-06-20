package day4;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import reg.Student;

@WebServlet("/UploadImageServlet")
@MultipartConfig
public class UploadImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		String location = request.getParameter("location");
		Part imagefile = request.getPart("image_file");
		
		if(imagefile != null) {
			// where to save the file
			Student student = (Student)session.getAttribute("STUDENT");
			
			String realPath = request.getServletContext().getRealPath("/");
			String username = student.getFname();
			
			String imageFileName = imagefile.getSubmittedFileName();
			
			realPath = realPath + "/" + username ;
			
			File file = new File(realPath);
			if(!file.exists()) {
				file.mkdirs();
			}
			// path is ready
			
			
			imagefile.write(realPath + "/" + imageFileName);
			
			
			// set the image list into session
			List<String> images = (List<String>)session.getAttribute("IMAGE_LIST");
			if(images == null) {
				images = new ArrayList<String>();
			}
			images.add(imageFileName);
			
			
			session.setAttribute("IMAGE_LIST", images);
			
			
			// go back to home page
			response.sendRedirect("home.jsp");
			return;
			
		}
		
	}

}
