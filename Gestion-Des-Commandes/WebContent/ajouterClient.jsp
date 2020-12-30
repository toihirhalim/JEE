<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ajouter Client</title>
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
	<div>
		<form action="ajouterClient"  method="POST">
			<div class="center">
				<table>
					<tr>
						<td>nom</td>
						<td>
							<input type="text" name="nom" id="nom" required/>
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