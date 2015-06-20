<%@page import="java.util.List"%>
<%@page import="in.dac.Employee"%>
<%@include file="static_header.jsp" %>
<jsp:include page="header.jsp"></jsp:include>
<% 
	Employee e1=(Employee)request.getAttribute("KEY1");

	List<Employee> list=(List<Employee>)request.getAttribute("EMPLIST");
%>
<body>



<!-- Printing all list of element -->
<%
	if(list!=null){
		for(int i=0;i<list.size();i++){
	
			Employee emp=list.get(i);
%>
		Id:<%= emp.getId()%>
	User Name:<%=emp.getUsername() %>
	Password:<%=emp.getPassword()%>
	Email:<%=emp.getEmail() %>
	<a href="registration.jsp?username=<%=emp.getUsername()%>&password=<%=emp.getPassword()%>&email=<%=emp.getEmail() %>">EDIT</a><br />
<%
		}
	
	}		
%>
<a href="home.jsp">HOME</a>
</body>
</html>