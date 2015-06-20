<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<s:form action="createUser.action"  theme="simple">

	USERNAME : <s:textfield name="user.username" ></s:textfield> <br />
	PASSWORD : <s:textfield name="user.password" ></s:textfield> <br />
	EMAIL : <s:textfield name="user.email" ></s:textfield> <br />
	CONTACT : <s:textfield name="user.contactno" ></s:textfield> <br />
	
	<s:if test="user.username != null">
		<s:hidden name="user.opr" value="UPDATE"></s:hidden>
	</s:if>
	<s:else>
		<s:hidden name="user.opr" value="INSERT"></s:hidden>
	</s:else>
	
	<s:submit></s:submit>
	
</s:form>


</body>
</html>