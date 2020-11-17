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
	<p>votre login est: <% out.println(request.getParameter("login")); %></p>
	<p>votre password est: <% out.println(request.getParameter("password")); %> </p>
	<a href="#">Modifier</a>
</body>
</html>