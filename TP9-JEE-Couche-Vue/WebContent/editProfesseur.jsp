<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="beans.Professeur"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Professeur</title>
<style>
	*{
		padding: 0;
		margin: 0;
	}
	table, th, td {
	  border: 1px solid black;
	}
	.center{
		display: flex;
		justify-content: center;
	}
</style>
</head>
<body>
	<%
		String id = "", nom = "", prenom = "" , select = "SELECT1", adresse = "";
	
		Professeur prof = (Professeur)session.getAttribute("professeur");
		
		if(prof != null){
			id = "" + prof.getId();
			nom = prof.getNom();
			prenom = prof.getPrenom();
			adresse = prof.getAdresse();
			select = prof.getSelect();
		}
	%>
	<br>
	<div class="center">
		<h2>Editer / Ajouter Professeur</h2>
	</div>
	<br>
	<form action="EditProfesseur.do" method="POST" class="center">
		<table>
			<tr>
				<td>Id : </td>
				<td><%= id %></td>
			<tr>
			<tr>
				<td>Nom : </td>
				<td><input type="text" id="nom" name="nom" value="<%= nom %>" required/></td>
			<tr>
			<tr>
				<td>Prenom : </td>
				<td><input type="text" id="prenom" name="prenom" value="<%= prenom %>" required/></td>
			<tr>
			<tr>
				<td>Adresse : </td>
				<td><input type="email" id="adresse" name="adresse" value="<%= adresse %>" required/></td>
			<tr>
			<tr>
				<td>Select : </td>
				<td>
					<select id="select" name="select">
						<%
							for(int i = 1; i <= 4 ; i++){
								if(select.equals("SELECT" + i)){
									out.println("<option value=\"SELECT" + i +"\" selected>SELECT" + i +"</option>");
								}else{
									out.println("<option value=\"SELECT" + i +"\">SELECT" + i +"</option>");
								}
							}
						%>
					</select>
				</td>
			<tr>
			<tr>
				<td></td>
				<td>
					<button type="reset">Clear</button>
					<button type="submit">Save</button>
				</td>
			<tr>
		</table>
	</form>
	<br>
	<div class="center">
		<a href="afficherProfesseurs.do">
			<button>Afficher les Professeurs</button>
		</a>
	</div>
</body>
</html>