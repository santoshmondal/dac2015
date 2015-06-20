<%@page import="java.util.Map"%>
<%@ include file="static_header.jsp" %>

<jsp:include page="header.jsp"></jsp:include>

<%
Map<String,String> map=(Map<String,String>) request.getAttribute("MAP");
%>
<body>
<%
int i=5/0;
if(map!=null){
for(Map.Entry<String, String> entry: map.entrySet()){
	String key = entry.getKey();
	String value = entry.getValue();
%>
<%=key %>
<%=value %>
<%
}
}else{
%>
DATA NOT FOUND.
<%
}
%>
</body>
</html>