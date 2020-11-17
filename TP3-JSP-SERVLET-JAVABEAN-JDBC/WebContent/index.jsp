<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Acceuil</title>
</head>
<body>
	<h2>Acceuil</h2>
	<form action="/TP3-JSP-SERVLET-JAVABEAN-JDBC/TraiterLoginServlet" method="POST">
		<div>
			<label>Login: 
				<input type="text" id="login" name="login" required>
			</label>
		</div>
		<div style="margin-top: 20px;">
			<label>password: 
				<input type="password" id="password" name="password" required>
			</label>
		</div>
		
		<input type="hidden" id="formName" name="formName" value="loginForm">
		
		<div style="margin-top: 20px;">
		<button type="submit">Ok</button>
		</div>
	</form>
</body>
</html>