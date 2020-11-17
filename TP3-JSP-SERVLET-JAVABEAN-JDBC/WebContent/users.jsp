<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>User</h2>
	<p>Votre Login est: <% out.println(request.getParameter("login")); %></p>
	<p>Votre Password est: <% out.println(request.getParameter("password")); %> </p>
	<a href="Modifier.jsp">Modifier</a>
</body>
</html>