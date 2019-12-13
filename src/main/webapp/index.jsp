<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import= "forfile.*" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
    index
    <br/>
    <a href="/IP-13/sss">To Sss</a>
    <%
    	String d = (String) getServletContext().getInitParameter("doc-dir");
    	ChoiseXXX ch = new ChoiseXXX(d, "doc");
    	String ll = null;
    	for (int i = 0; i < ch.listxxx.length; i++) {
    	   ll = ch.listxxx[i];
    %>
    <br />
    <a href="sss?file=<%=ll%>"> <%=ll%> </a>
    <%}%>

</body>
</html>
