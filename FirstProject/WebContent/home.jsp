<%@page import="java.util.List"%>
<%@page import="reg.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>

<%
	Boolean auth = (Boolean)session.getAttribute("AUTH");
	if(auth == null || auth == false) {
		response.sendRedirect("login.jsp");
		return;
	}
%>

<%
	Student student = (Student)session.getAttribute("STUDENT");
	List<String> images = (List<String>)session.getAttribute("IMAGE_LIST");
%>

<body>

Welcome!! <%=student.getFname() %>

<br /><br />
<a href="fileupload.jsp" >UPLOAD IMAGE</a>

<br />DISPLAY ALL IMAGES

<%
	if(images != null) {
		for(String image : images) {
%>			
	<img alt="NOTHING" height="100"
		src="${pageContext.request.contextPath}/<%=student.getFname()%>/<%=image %>" />
<%		}	
	}
%>



<br /><br />
<a href="Logout">LOGOUT</a>


</body>
</html>