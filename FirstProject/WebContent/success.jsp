<%@page import="reg.Student"%>
<%@page import="java.util.List"%>
<%@page errorPage="my_exception.jsp" %>

<%@include file="style.css" %>
<%@include file="main.js" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>



</head>

<%
	List<Student>list =	(List<Student>)application.getAttribute("STUDENTLIST");
%>

<body>
	
	
	
	<%	
		if(list != null) { 
			for(int i=0;i<list.size();i++){
				Student stud = list.get(i);
	%>
				<%=stud.getFname()%>
				<%=stud.getLname()%>
				<%=stud.getMobile()%>
				<%=stud.getStdId()%>
				
				<a href="#">EDIT</a>
				<a href="#">DELETE</a>
				<br/>
	<%
			}
		} else {
	%>
		!!NO DATA AVAILABLE!!
	<% } %>
	<br />
	<a href="registration.jsp">Go back to home page</a>
</body>
</html>


