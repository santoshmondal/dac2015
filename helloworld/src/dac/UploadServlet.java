package dac;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;



@WebServlet("/UploadServlet")
@MultipartConfig
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		String realPath = request.getServletContext().getRealPath("/");
		File writePath = new File(realPath + "/default/");
		if(!writePath.exists()) {
			writePath.mkdirs();
		}
		
		Part part = request.getPart("file1");
		
		if(part != null) {
			String fileName = part.getSubmittedFileName();
			part.write(writePath + "/"+ fileName);
			
			
			Set<String> iList = (Set<String>)session.getAttribute("IMAGE_LIST");
			if(iList == null) {
				iList = new HashSet<String>();
			}
			
			iList.add(fileName);
			
			session.setAttribute("IMAGE_LIST", iList);
			
			response.sendRedirect("profile.jsp");
		}
	}

}
