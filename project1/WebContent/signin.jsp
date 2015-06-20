<%@include file="static_header.jsp"%>
<jsp:include page="header.jsp"></jsp:include>

<%
	String message  = request.getParameter("message");
	if(message == null) {
		message = "";
	}
%>

<body>

<%=message %>

<form action="LoginServlet" method="post">
Username : <input type="text" name="uname" > <br>
Password : <input type="password" name="pwd"> <br>
<input type="submit" value="LOG IN">
</form>
</body>
</html>