<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page errorPage="error.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>logout page</title>
</head>
<body>

<%
 
   session.invalidate();
   response.sendRedirect("login.html");


%>


</body>
</html>