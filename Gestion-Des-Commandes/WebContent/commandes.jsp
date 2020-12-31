<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="ma.fstt.entities.Commande"%>
<%@page import="ma.fstt.entities.Client"%>
<%@page import="java.util.ListIterator"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Commandes</title>
<style>
  	.center {
  		display: flex;
  		justify-content: center;
  	}
  	.head {
  		background-color: rgb(0, 60, 179);
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
	<%  ArrayList<Commande> commandes =   (ArrayList<Commande>)request.getAttribute("commandes"); %>
	<% if(commandes == null) commandes = new ArrayList(); %>
	<% 
		String urlClientId = "";
		String nomClient = "";
		Client client = (Client)request.getAttribute("client");
		if(client != null){ 
			urlClientId = "?idClient=" + client.getId();
			nomClient = " Client id = " + client.getId() + ", nom = " + client.getNom();
		}
	%>
	
	<header>
		<a href="">Acceuil</a>
		<a href="produits">Produits</a>
		<a href="commandes">Commandes</a>
	</header>
	
	<div class="center">
		<h1>list Commandes <%= nomClient %></h1>
	</div>
	
	<div class="center">
	
		<table>
			<thead class="head">
				<th> Num </th>
				<th> Id Commande</th>
				<th> Client </th>
				<th> Date </th>
				<th> Prix Total </th>
				<th> Delete </th>
				<th> Update </th>
			</thead>
			<% for(int i=0 ; i < commandes.size() ; i++ ) { %>
			<tr>  
			
				<td><%= i %> </td>
				<td><%=commandes.get(i).getId() %> </td>
				<td> <a href="commandes?idClient=<%= commandes.get(i).getClient().getId() %>" > <%= commandes.get(i).getClient().getNom() %> </a> </td>
				<td> <%=commandes.get(i).getDate() %> </td>
				<td> <%=commandes.get(i).getPrixTotal() %> </td>
				<td> <a href="deleteCommande?id=<%=commandes.get(i).getId() %>" >  delete </a> </td>
				<td> <a href="ajouterCommande?idCommande=<%=commandes.get(i).getId() %>" >  update </a>  </td>
				
			</tr>
			<%} %>
		
		</table>
	
	</div>
	<br><br>
	<div class="center">
		<a href="ajouterCommande<%= urlClientId%>">
			<button>Ajouter Commande</button>
		</a>
	</div>
</body>
</html>