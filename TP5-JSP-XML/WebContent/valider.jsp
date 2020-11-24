<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="bdd.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
	div {
		display: flex;
		width: 80%;
		justify-content: space-between;
		padding: 20px;
		margin: auto;
	}
</style>
</head>
<body>
<div>
	<a href="index.html">Acceuil</a>
	<a href="utilisateur.jsp">Authentification</a>
	<a href="inscription.jsp">Inscription</a>
</div>
	<jsp:useBean id="utilisateur" class="bdd.Personne" scope="session">
		<jsp:setProperty name="utilisateur" property="*"/>
			<table>
				<tr>
					<td width="180">Nom</td>
					<td><jsp:getProperty name="utilisateur" property="nom"/></td>
				</tr>
				<tr>
					<td width="180">Prenom</td>
					<td><jsp:getProperty name="utilisateur" property="prenom"/></td>
				</tr>
				<tr>
					<td width="180">Adresse</td>
					<td><jsp:getProperty name="utilisateur" property="adresse"/></td>
				</tr>
				<tr>
					<td width="180">Mot de passe</td>
					<td><jsp:getProperty name="utilisateur" property="password"/></td>
				</tr>
			</table>
	</jsp:useBean>
	
	<%
		if(!utilisateur.enregistrer()){
	%>
		<script>
			alert("utilisateur deja existant");
			windows.location.href="inscription.jsp";
		</script>
	<%
		}else {
	%>
		<script>
			alert("nouvau utilisateur enregistré");
			windows.location.href="inscription.jsp";
		</script>
	<%
		}
	%>
	
</body>
</html>