<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
	Boolean auth = (Boolean)session.getAttribute("AUTH");
	if(auth == null || auth == false) {
		response.sendRedirect("login.jsp");
		return;
	}
%>

Upload Image!! <br /><br />
<form action="UploadImageServlet" method="post" enctype="multipart/form-data">
	Location : <input type="text" name="location"> <br />
	Image : <input type="file" name="image_file"> <br />
	<input type="submit" value="Upload" />
</form>



</body>
</html>