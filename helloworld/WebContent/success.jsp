<%@page import="dac.Student"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>

<% // JAVA CODE TO FETCH DATA
	List<Student> list = (List<Student>)request.getAttribute("STUDENT_LIST");
	System.out.println(list);
%>


<body>
	<center>REGISTRATION SUCCESS!!</center>
	<%
		for(int i=0; i<list.size(); i++) {
			Student student = list.get(i);
	%>
		NAME :: <b><%=student.getFname()%></b>
		LNAME :: <b><%=student.getLname() %> </b>
		EMAIL :: <b><%=student.getEmail() %> </b> 
		<br />		
	<% 		
		}
	%>
	
	

</body>
</html>