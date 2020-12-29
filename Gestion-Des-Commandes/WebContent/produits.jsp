<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@page import="java.util.ArrayList"%>
<%@page import="ma.fstt.entities.Produit"%>
<%@page import="java.util.ListIterator"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%  ArrayList<Produit> produits =   (ArrayList<Produit>)request.getAttribute("produits"); %>
	<% if(produits == null) produits = new ArrayList(); %>
	
	<div>
	
	<table>
		<thead>
			<th> Id </th>
			<th> Libele </th>
			<th> Prix </th>
			<th> Delete </th>
			<th> Update </th>
		</thead>
		<% for(int i=0 ; i < produits.size() ; i++ ) { %>
		<tr>  
		
		<td><%=produits.get(i).getId() %> </td>
		<td> <%=produits.get(i).getLibele() %> </td>
		<td> <%=produits.get(i).getPrix() %> </td>
		<td> <a href="DeleteEudtaintServlet?id=<%=produits.get(i).getId() %>" >  delete </a> </td>
		<td> <a href="UpdateEudtaintServlet?id=<%=produits.get(i).getId() %>" >  update </a>  </td>
		
		</tr>
		<%} %>
		
		</table>
	
	</div>
	
</body>
</html>