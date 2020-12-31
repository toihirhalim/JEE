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
</style>
</head>
<body>
<%
	ArrayList<LigneCommande> lignecommande = new ArrayList();
	String idClient = "";
	Client client = (Client)request.getAttribute("client");
	if(client != null) idClient = "&idClient=" + client.getId();
	
	String idCommande = "0";
	String prixTotal = "0";
	Commande commande = (Commande)request.getAttribute("commande");
	if(commande != null) {
		idCommande = "" + commande.getId();
		prixTotal = "" + commande.getPrixTotal();
		lignecommande = (ArrayList<LigneCommande>) commande.getLigneCommandes();
	}
	
%>
	<div>
		<form action="ajouterProduit"  method="POST">
			<div class="center">
				<table>
					<tr>
						<td>client Id </td>
						<td>
							<input type="number" name="idCommande" id="idCommande" value="<%= idCommande %>" readonly/>
						</td>
						<td>client Id </td>
						<td>
							<input type="number" name="idClient" id="idClient" required/>
						</td>
					</tr>
					
				</table>
			</div>
			<div class="center">
				<button type="submit">Ok</button>
			</div>
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