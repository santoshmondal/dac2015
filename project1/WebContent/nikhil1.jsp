<%@page import="in.dac.Employee"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<%
	List<Employee> emplist = (List<Employee>)request.getAttribute("EMPLIST");
%>
<body>
	Hello Subodh.....!<br/>
	Employes Details are:<br/><hr>
	
<%
	if(emplist!=null){
		for(int i=0;i<emplist.size();i++){
			Employee emp=emplist.get(i);
%>		
	EmpID: <%= emp.getEmpid() %>
	Name: <%= emp.getName() %>
	Company: <%= emp.getCompanyname() %>
	City: <%= emp.getCity() %>
	<br/>
<%
		}
	}
	else{
%>
	Sorry, No records found>>

<%
	}
%>
</body>
</html>