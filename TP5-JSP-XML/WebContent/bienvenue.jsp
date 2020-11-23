<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="metier.Connexion"%>
<%@page import="metier.Etudiant"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bienvenue</title>
</head>
<body>
<% 
		Etudiant etudiant = (Etudiant)session.getAttribute("etudiant");
		
		if(etudiant == null){
			String nom = request.getParameter("nom");
			String prenom = request.getParameter("prenom");
			String password = request.getParameter("password");
			
			if(nom != null && prenom != null && password != null){
				
				Connexion cnx= new Connexion();
				etudiant = cnx.getEtudiant(nom, prenom, password);
				session.setAttribute("etudiant", etudiant);
				
			}else {
				response.sendRedirect("utilisateur.html");
			}
			
		}
		
	%>
	
	<% if(etudiant != null) { %>
	<p>
		bonjour <% etudiant.getNom(); %> <% etudiant.getPrenom(); %>
		votre identifiant est <% etudiant.getId(); %> 
		votre mot de passe est <% etudiant.getPassword(); %>
	</p>
	<% } %>
</body>
</html>