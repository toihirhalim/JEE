<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="metier.Connexion"%>
<%@page import="java.util.Random"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inscription</title>
<style>
	table, td {
	  	border: 1px solid black;
	}
	table {
		width: 100%;
	}
	.container {
		width: 50%;
		margin: auto;
	}
	.btn-container {
		margin: 10px;
		display: flex;
		justify-content: center;
	}
	header {
		display: flex;
		justify-content: space-between;
		padding: 5px 10px 40px 10px;
	}
	h1 {
		padding: 0;
		margin: 0;
	}
</style>
</head>
<body>
	<% 
		session.invalidate();
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String adresse = request.getParameter("adresse");
		String password = request.getParameter("password");
		
		if(nom != null && prenom != null && adresse != null && password != null){
			Random rd = new Random();
			int id = rd.nextInt(10000);
			Connexion cnx= new Connexion();
			System.out.println(cnx.addEtudiant(id, nom, prenom, adresse, password));
			
			request.setAttribute("nom", null);
			request.setAttribute("prenopm", null);
			request.setAttribute("adresse", null);
			request.setAttribute("password", null);
			response.sendRedirect("index.html");
		}
	%>
	<header>
		<h1>Inscription page</h1>
		<a href="index.html">Acceuil</a>
	</header>
	<form action="inscription.jsp" method="POST">
		<div class="container">
			<table>
				<tr>
					<td>Nom</td>
					<td><input type="text" name="nom" id="nom" required></td>
				</tr>
				<tr>
					<td>Prenom</td>
					<td><input type="text" name="prenom" id="prenom" required></td>
				</tr>
				<tr>
					<td>Adresse</td>
					<td><input type="text" name="adresse" id="adresse" required></td>
				</tr>
				<tr>
					<td>Mot de passe</td>
					<td><input type="password" name="password" id="password" required></td>
				</tr>
			</table>
			<div class="btn-container">
				<button type="submit">Nouvel Utilisateur</button>
			</div>
		</div>
	</form>
</body>
</html>