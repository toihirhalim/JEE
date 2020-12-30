<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Produit</title>
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
		<form action="ajouterProduit"  method="POST">
			<div class="center">
				<table>
					<tr>
						<td>Libele</td>
						<td>
							<input type="text" name="libele" id="libele" required/>
						</td>
					</tr>
					<tr>
						<td>Prix</td>
						<td>
							<input type="number" name="prix" id="prix" required/>
						</td>
					</tr>
				</table>
			</div>
			<div class="center">
				<button type="submit">Ok</button>
			</div>
		</form>
	</div>
</body>
</html>