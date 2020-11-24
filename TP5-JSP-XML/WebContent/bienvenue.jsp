<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bienvenue</title>
</head>
<body>
<a href="index.html">acceuil</a>
<br>
	<jsp:useBean id="utilisateur" class="bdd.Personne" scope="session">
		<jsp:setProperty name="utilisateur" property="*"/>
			<% if(utilisateur.existe()) {  %>
			<p style="font-size: 24px;">
				bonjour <jsp:getProperty name="utilisateur" property="nom"/> <jsp:getProperty name="utilisateur" property="prenom"/>
				votre identifiant est <% out.print(utilisateur.identificateur()); %> 
				votre mot de passe est <jsp:getProperty name="utilisateur" property="password"/>
			</p>
			<% } %>
			
	</jsp:useBean>
	
</body>
</html>