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
<title>Mascoticas Roles</title>
</head>
<body style="background-color: #F7931E">
	<nav class="navbar">
		<div
			style="font-family: Luckiest Guy; color: black; margin-left: 50px; font-size: 2rem; text-align: center"
			class="col-9">
			Bienvenido a:&nbsp &nbsp <img src="img/titulo.png" height="50%"
				width="50%" />
		</div>
		<div class="dropdown col-2">
			<button class="btn_login dropdown-toggle" data-bs-toggle="dropdown">
				Regresar</button>
			<div class="dropdown-menu text-center" style="background-color:#0172C2; border:2px solid #262D94; font-family:Righteous; border-radius: 10px">
				<a>User</a>
				<div class="dropdown-divider"></div>
				<a href="menu_ppal.jsp" class="dropdown-item"> Menú </a>
			</div>
		</div>
	</nav>
	<span class="badge_titulo">Gestión de Roles</span>
	<div align="center">
		<form class="form-pagina" method="post" action="./Servlet" style="display:block">
			<br> <br>
			<table>
				<tr>
					<td><label>Id:</label></td>
					<td><input type="number" name="id_rol"></td>
				</tr>
				<tr>
					<td><label>Nombre Rol:</label></td>
					<td><input type="text" name="nombre_rol"></td>
				</tr>
				</table>
				<br> <br>
				<table>
				<tr>
					<td>
						<button class="btn_pagina btn-block" type="submit" name="AgregarRol" style="background-color:#2ECC71">Agregar</button>
						<button class="btn_pagina btn-block" type="submit" name="ListarRoles" style="background-color:#0172C2">Listar</button>
						<button class="btn_pagina btn-block" type="submit" name="ActualizarRol" style="background-color:#F39C12">Actualizar</button>
						<button class="btn_pagina btn-block" type="submit" name="EliminarRol" style="background-color:#E74C3C">Eliminar</button>
						<a href="usuarios.jsp" >
							<input class="btn_pagina btn-block" value="Volver" style="width:100px; background-color:#A569BD">
						</a>
					</td>
				</tr>
			</table>
		</form>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ"
		crossorigin="anonymous"></script>
</body>
</html>