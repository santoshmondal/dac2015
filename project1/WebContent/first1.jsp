<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE htmld PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<%
List<String> list= (List<String>)request.getAttribute("LIST");
%>
<body>

<%
if(list!=null){
	for(int i=0;i<list.size();i++) 
	{
			String value=list.get(i);
	%>
	<%= value %><br/>
	
	<%
	}
}else{
%>
No Data In The list
<% 
}
%>



</body>
</html>