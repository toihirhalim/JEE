<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="ma.fstt.entities.Produit"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Produit</title>
<style>
  	.center {
  		display: flex;
  		justify-content: center;
  	}
	table, th, td {
	  border: 1px solid black;
	}
</style>
</head>
<body>
<% 
	Produit produit = (Produit) request.getAttribute("produit");
	if(produit == null) response.sendRedirect("produits");
%>
	<div>
		<form action="updateProduit"  method="POST">
			<div class="center">
				<table>
					<thead class="head">
						<th> indications </th>
						<th> valeurs </th>
						<th> nouvelles valeurs </th>
					</thead>
					<tr>
						<td>Id</td>
						<td><%= produit.getId() %></td>
						<td>
							<input type="number" name="id" id="id" value="<%= produit.getId() %>" readonly/>
						</td>
					</tr>
					<tr>
						<td>Libele</td>
						<td><%= produit.getLibele() %></td>
						<td>
							<input type="text" name="libele" id="libele" value="<%= produit.getLibele() %>" required/>
						</td>
					</tr>
					<tr>
						<td>Prix</td>
						<td><%= produit.getPrix() %></td>
						<td>
							<input type="number" name="prix" id="prix" value="<%= produit.getPrix() %>" required/>
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