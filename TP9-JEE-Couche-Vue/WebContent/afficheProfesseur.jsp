<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="beans.Professeur"%> 
<%@page import="java.util.List"%> 
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Professeurs</title>
<style>
	table, th, td {
	  border: 1px solid black;
	}
	.center{
		display: flex;
		flex-direction: column;
		width: 100%;
		justify-content: center;
		background-color: red;
	}
</style>
</head>
<body>
	<div class="center">
		<table>
			<tr>
				<th>Id</th>
				<th>Nom</th>
				<th>Prenom</th>
				<th>Adresse</th>
				<th>Select</th>
				<th>Supprimer</th>
				<th>Modifier</th>
			</tr>
			
			<%
				List<Professeur> profs = (ArrayList<Professeur>)request.getAttribute("professeurs");
				
				if(profs != null){
					for(Professeur prof : profs){
						out.println("<tr>");
						out.println("<td>"+prof.getId()+"</td>");
						out.println("<td>"+prof.getNom()+"</td>");
						out.println("<td>"+prof.getPrenom()+"</td>");
						out.println("<td>"+prof.getAdresse()+"</td>");
						out.println("<td>"+prof.getSelect()+"</td>");
						out.println("<td><a href=\"supprimerProfesseurs.do?id="+prof.getId()+"\">Supprimer</a></td>");
						out.println("<td><a href=\"editerProfesseurs.do?id="+prof.getId()+"\">Modifier</a></td>");
						out.println("</tr>");
					}
				}
				
			%>
		</table>
		<br>
		<a href="editerProfesseurs.do">
			<button>Ajouter Professeur dans la liste</button>
		</a>
	</div>
</body>
</html>