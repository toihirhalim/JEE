<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="ma.fstt.entities.Commande"%>
    <%@page import="ma.fstt.entities.Client"%>
<%@page import="java.util.ArrayList"%>
<%@page import="ma.fstt.entities.LigneCommande"%>
<%@page import="ma.fstt.entities.Client"%>
<%@page import="java.util.ListIterator"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ajouter Commande</title>
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
<%
	ArrayList<LigneCommande> lignecommande = new ArrayList();
	String idClient = "";
	
	String commandLink = "";
	String idCommande = "0";
	String prixTotal = "0";
	Commande commande = (Commande)request.getAttribute("commande");
	if(commande != null) {
		idCommande = "" + commande.getId();
		prixTotal = "" + commande.getPrixTotal();
		idClient = "" + commande.getClient().getId();
		commandLink = "?idClient=" + commande.getClient().getId();
		lignecommande = (ArrayList<LigneCommande>) commande.getLigneCommandes();
		
	}
	
	if(idClient.equals("")){
		
		Client client = (Client)request.getAttribute("client");
		if(client != null) {
			idClient = "" + client.getId();
			commandLink = "?idClient=" + client.getId();
		}
	}
	
%>
	<header>
		<a href="">Acceuil</a>
		<a href="produits">Produits</a>
		<a href="clients">Clients</a>
		<a href="commandes">Commandes</a>
	</header>
	
	<div class="center">
		<h1>Ajouter / Update Commande</h1>
	</div>
	<div>
		<form action="ajouterCommande"  method="POST">
			<div class="center">
				<table>
					<tr>
						<td>Commande Id </td>
						<td>
							<input type="number" name="idCommande" id="idCommande" value="<%= idCommande %>" readonly/>
						</td>
						<td>client Id </td>
						<td>
							<input type="number" name="idClient" id="idClient" value="<%= idClient %>" required/>
						</td>
					</tr>
					
					<tr>
						<td>ID Produit </td>
						<td>
							<input type="number" name="idProduit" id="idProduit" required/>
						</td>
						
					</tr>
					
					<tr>
						<td>Quantite </td>
						<td>
							<input type="number" name="qtte" id="qtte" value="1" required/>
						</td>
						
					</tr>
					
				</table>
			</div>
			<br><br>
			<div class="center">
				<button type="submit">Add Produit</button>
				<a href="commandes<%= commandLink %>" style="padding-left: 10px;">
					<button type="button">Finish All</button>
				</a>
			</div>
			<br><br>
			<div class="center">
				<table>
					<thead class="head">
						<th> Id Produit </th>
						<th> Libele</th>
						<th> Prix Unitaire</th>
						<th> Quantite </th>
						<th> Prix</th>
					</thead>
					<% for(int i=0 ; i < lignecommande.size() ; i++ ) { %>
					<tr>  
					
						<td><%=lignecommande.get(i).getProduit().getId() %> </td>
						<td> <%= lignecommande.get(i).getProduit().getLibele() %> </td>
						<td> <%=lignecommande.get(i).getProduit().getPrix() %> </td>
						<td> <%=lignecommande.get(i).getQtte() %> </td>
						<td> <%=lignecommande.get(i).getQtte() * lignecommande.get(i).getProduit().getPrix() %> </td>
						
					</tr>
					<%} %>
					<tr>  
					
						<td>Prix Total</td>
						<td></td>
						<td></td>
						<td></td>
						<td><%= prixTotal %></td>
						
					</tr>
				</table>
			</div>
		</form>
	</div>
</body>
</html>