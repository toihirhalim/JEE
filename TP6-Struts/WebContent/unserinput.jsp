<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="h"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
	table, td {
	  	border: 1px solid black;
	}
</style>
<body>

	<h:form action="/userinput">
		<table>
			<tr>
				<td>Nom</td>
				<td>
					<input type="text" name="nom" id="nom" required>
					Saisir votre nom
				</td>
			</tr>
			<tr>
				<td>Prenom</td>
				<td>
					<input type="text" name="prenom" id="prenom" required>
					Saisie votre prenom
				</td>
			</tr>
			<tr>
				<td>Email</td>
				<td>
					<input type="email" name="email" id="email" required>
					Saisir votre email
				</td>
			</tr>
			<tr>
				<td></td>
				<td><h:reset value="Effacer"/><h:submit value="Ok"/></td>
			</tr>
		</table>
	</h:form>
	
	<script type="text/javascript">
		const myCollection = document.getElementsByTagName("input");
		
		function clear(){
			var i;
			for (i = 0; i < myCollection.length; i++) {
			  myCollection[i].value = "";
			}
		}
	</script>
</body>
</html>