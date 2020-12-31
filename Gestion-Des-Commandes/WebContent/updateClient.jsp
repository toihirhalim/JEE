<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="ma.fstt.entities.Client"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Client</title>
<style>
  	.center {
  		display: flex;
  		justify-content: center;
  	}
	table, th, td {
	  border: 1px solid black;
	}
	header {
		display: flex;
		justify-content: space-around;
	}
</style>
</head>
<body>
<% 
	Client client = (Client) request.getAttribute("client");
	if(client == null) response.sendRedirect("clients");
%>
	<header>
		<a href="">Acceuil</a>
		<a href="produits">Produits</a>
		<a href="clients">Clients</a>
		<a href="commandes">Commandes</a>
	</header>
	
	<div class="center">
		<h1>Update Client</h1>
	</div>
	<div>
		<form action="updateClient"  method="POST">
			<div class="center">
				<table>
					<thead class="head">
						<th> indications </th>
						<th> valeurs </th>
						<th> nouvelles valeurs </th>
					</thead>
					<tr>
						<td>Id</td>
						<td><%= client.getId() %></td>
						<td>
							<input type="number" name="id" id="id" value="<%= client.getId() %>" readonly/>
						</td>
					</tr>
					<tr>
						<td>Nom</td>
						<td><%= client.getNom() %></td>
						<td>
							<input type="text" name="nom" id="nom" value="<%= client.getNom() %>" required/>
						</td>
					</tr>
				</table>
			</div>
			<br><br>
			<div class="center">
				<button type="submit">Ok</button>
			</div>
		</form>
	</div>
</body>
</html>