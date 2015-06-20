<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>

<%
	String username = request.getParameter("username");
	String password = request.getParameter("password");
	String email = request.getParameter("email");
	
	if(username == null) {
		username = "";
	}
	if(password == null) {
		password = "";
	}
	
	if(email == null) {
		email = "";
	}
%>


<body>
	<%
		String buttonvalue = "";
		if(!username.isEmpty()) {
			buttonvalue = "UPDATE";
	%>	
		<h1>Update Form:</h1><br>
				
				
	<%	}
		else {
			buttonvalue = "REGISTER";	
	%>
		<h1>Registration Form:</h1><br>
	<%
		}
	%>
	
	
	<form action="RegistrationServlet" method="get">
	User Name: <input type="text" name="username" value="<%=username%>"><br>
	Password: <input type="password" name="password" value="<%=password%>"><br>
	Email: <input type="text" name="email" value="<%=email%>"><br>
	
	<%
		if(!username.isEmpty()){
	%>		
		<input type="hidden" name="opr" value="UPDATE">
	<% } else {%>
		<input type="hidden" name="opr" value="REGISTER">
	<%}%>
	 
	
	<input type="submit" value="<%=buttonvalue%>">
	</form>
	
	<br/><br/><br/>
	
	<%
		if(!username.isEmpty()){
	%>		
		<a href="home.jsp">HOME</a>
	<% } else {%>
		<a href="signin.jsp">SIGN IN</a>
	<%}%>
	
	<br/>
	
</body>
</html>