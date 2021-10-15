<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="ISO-8859-1">
<head>
		<meta charset="UTF-8 ">
		<title>tienda fullmotos Usuarios </title>
		<link rel="STYLESHEET" type="text/css" href="css/Principal.css">
	</head>
	
	<body class=>
	<!-- menu -->
	    <div class ="titulo">
	    	<h1>tienda fullmotos Usuarios</h1>
	    </div>
		<ul class="menu">
			<li><a style="background-color: purple" href="usuarios.jsp">usuarios</a>
			<li><a href="clientes.jsp">clientes </a>
			<li><a href="proveedores.jsp">proveedores</a>
			<li><a href="productos.jsp">producto</a>
			<li><a href="ventas.jsp">ventas</a>
			<li><a href="operacion_no.jsp">reporte</a>
			<li><a href="inicio.jsp"class="dropdown-item">salir</a>
		</ul>	

	<!-- formulario de usuarios -->
	<div  style="background-color: #15175b" align="center">
		<form id="formulario_ur" class="form-pagina" method="post" action="./Servlet" style="display:block">
			<br>
			<table class="formulario_datos">
				<tr>
					<td><label>Cedula:</label></td>
					<td><input type="number" name="cedula"></td>
				</tr>
				<tr>
					<td><label>Nombre Completo:</label></td>
					<td><input type="text" name="nombre"></td>
				</tr>
				<tr>
					<td><label>Correo Electronico:</label></td>
					<td><input type="email" name="email"></td>
				</tr>
				<tr>
					<td><label>Celular:</label></td>
					<td><input type="number" name="celular"></td>
				</tr>
				<tr>
					<td><label>Password:</label></td>
					<td><input type="password" name="password"></td>
				</tr>
				<tr>
					<td><label>Id Rol:</label></td>
					<td><input type="number" name="rol_usuario"></td>
				</tr>
				</table>
				<br> 
				<table>
				<tr>
					<td>
						<button class="btn_pagina btn-block" type="submit" name="AgregarUsuario" style="background-color:gray">Agregar</button>
						<button class="btn_pagina btn-block" type="submit" name="ListarUsuarios" style="background-color:gray">Listar</button>
						<button class="btn_pagina btn-block" type="submit" name="ActualizarUsuario" style="background-color:gray">Actualizar</button>
						<button class="btn_pagina btn-block" type="submit" name="EliminarUsuario" style="background-color:gray">Eliminar</button>
						<a href="roles.jsp" >
							<input class="btn_pagina btn-block" value="Roles" style="width:100px; background-color:gray">
						</a>
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>