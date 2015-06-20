<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>

<%
	String key1 = (String)request.getAttribute("KEY1");
	String key2 = (String)request.getAttribute("KEY2");
	String key3 = (String)request.getAttribute("KEY3");
	
	String str1 = (String)session.getAttribute("SESSION_KEY1");
	String app1 = (String)application.getAttribute("APPLICATION_KEY1");
%>


<body>
	<form method="post" action="RegistrationServlet">
		Student Id<input type="text" name="id"><br/>
		First Name<input type="text" name="fname"><br/>	
		Last Name<input type="text" name="lname"><br/>
		Contact Number<input type="number" name="mobile"><br/>
		<input type="submit" value="Send">
		<input type="reset" value="Clear">
	</form>
	
	
	<br />
	
	<a href="login.jsp">LOGIN</a>
	
</body>
</html>