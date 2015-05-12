<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	<link href="style.css" type="text/css" rel="stylesheet">
</head>
<body>
	
	<div id='maindiv'>
		<form action="RegistrationServlet" method="get">
			FNAME - <input type='text' name="fname"> <br />
			LNAME - <input type='text' name="lname"> <br />
			EMAIL - <input type='text' name="email"> <br />
			<input type="submit" value="register">
		</form>
	</div>
	
</body>
</html>