<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
	<form action="" method="post">
		<label>Mot Cle: <input type="text" name="mot" id="mot" required></label>
		<button type="submit">Ok</button>
	</form>
	<table style="width:100%">
		<tr>
			<th>Id</th>
			<th>Nom</th>
			<th>Prix</th>
		</tr>
		<%
			String [][] produits = {{"1","hello", "40.0"},{"2","yep", "50.0"},{"3","hi", "23.0"}};
			
			for(String [] produit : produits){
				out.println("<tr>");
				out.println("<td>"+produit[0]+"</td>");;
				out.println("<td>"+produit[1]+"</td>");;
				out.println("<td>"+produit[2]+"</td>");
				out.println("</tr>");
			}
		%>
	</table>
</body>
</html>