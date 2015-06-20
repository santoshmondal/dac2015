<%@page import="in.dac.Employee"%>
<%@include file="static_header.jsp"%>
<%@include file="sessioncheck.jsp"%>
<jsp:include page="header.jsp"></jsp:include>

<% 
Employee e = (Employee) session.getAttribute("USER_SESSION");
%>

<body>
WELCOME...!!!!
<%=e.getFname() %>

<a href="Signout">SIGN OUT</a>

<br />
<a href="displayUsersServlet">Display Users</a>

</body>
</html>