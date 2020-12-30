<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="ma.fstt.entities.Client"%>
<%@page import="java.util.ListIterator"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Clients</title>
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
	<%  ArrayList<Client> clients =   (ArrayList<Client>)request.getAttribute("clients"); %>
	<% if(clients == null) clients = new ArrayList(); %>
	
	<div class="center">
	
		<table>
			<thead class="head">
				<th> Id </th>
				<th> Libele </th>
				<th> Commandes </th>
				<th> Delete </th>
				<th> Update </th>
			</thead>
			<% for(int i=0 ; i < clients.size() ; i++ ) { %>
			<tr>  
			
			<td><%=clients.get(i).getId() %> </td>
			<td> <%=clients.get(i).getNom() %> </td>
			<td> <a href="commandesClient?id=<%=clients.get(i).getId() %>" >  Commandes </a></td>
			<td> <a href="deleteClient?id=<%=clients.get(i).getId() %>" >  delete </a> </td>
			<td> <a href="updateClient?id=<%=clients.get(i).getId() %>" >  update </a>  </td>
			
			</tr>
			<%} %>
		
		</table>
	
	</div>
	<br><br>
	<div class="center">
		<a href="ajouterClient">
			<button>Ajouter Client</button>
		</a>
	</div>
</body>
</html>