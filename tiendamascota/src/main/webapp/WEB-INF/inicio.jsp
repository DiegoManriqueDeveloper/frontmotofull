<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="css/estilos.css" rel="stylesheet" type="text/css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU"
	crossorigin="anonymous">
<title>Mascoticas Inicio</title>
</head>
<body style="background-color: #F7931E">
	<img class="img_center" src="img/titulo.png" height="50%" width="50%" />
	<div class="container col-lg-6">
		<div class="row">
			<div class="col-4">
				<img class="img_center" src="img/perro.png" height="90%" width="100%" />
			</div>
			<div class="col-8">
				<div>
					<img class="img_center" src="img/bienvenidos.png" />
				</div>
				<br>
				<form method="post" action="./Servlet">
					<div class="form-group">
						<label>Cédula:</label> <input class="form-control" type="number"
							name="txtUsuario" placeholder="Ingrese su cédula">
					</div>
					<div class="form-group">
						<label>Password:</label> <input class="form-control" type="password" name="txtPassword"
							placeholder="Ingrese su contraseña">
						<br>
					</div>
					<div align="center">
						<input class="btn_login btn-block" type="submit" name="ValidacionLogin" value="Ingresar">
					</div>
				</form>
			</div>

		</div>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ"
		crossorigin="anonymous"></script>
</body>
</html>