<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="metier.Produit"%> 
<%@page import="java.util.List"%> 
<%@page import="java.util.ArrayList"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Produits</title>
<style>
	table, th, td {
	  border: 1px solid black;
	}
</style>
</head>
<body>
	<form action="/TP4-JSP-SERVLET-MVC-JDBC/controlleur.do" method="post">
		<label>Mot Cle: <input type="text" name="nom" id="nom" required></label>
		<input type="hidden" id="formName" name="formName" value="ProduitResearch">
		<button type="submit">Ok</button>
	</form>
	<table style="width:100%">
		<tr>
			<th>Id</th>
			<th>Nom</th>
			<th>Prix</th>
		</tr>
		<%
			List<Produit> produits = (ArrayList<Produit>)request.getAttribute("produits");
			
			if(produits != null){
				for(Produit produit : produits){
					out.println("<tr>");
					out.println("<td>"+produit.getId()+"</td>");
					out.println("<td>"+produit.getNom()+"</td>");
					out.println("<td>"+produit.getPrix()+"</td>");
					out.println("</tr>");
				}
			}
			
		%>
	</table>
</body>
</html>