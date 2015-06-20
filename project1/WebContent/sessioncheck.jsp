<%
Boolean auth = (Boolean) session.getAttribute("AUTH");

if(auth==null || auth==false ){
	response.sendRedirect("signin.jsp");
	return;
}
%>