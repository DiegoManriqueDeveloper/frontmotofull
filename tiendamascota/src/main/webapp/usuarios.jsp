<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="ISO-8859-1">
<head>
		<meta charset="UTF-8 ">
		<title>Tienda Fullmotos Usuarios </title>
		<link rel="STYLESHEET" type="text/css" href="css/Principal.css">
	</head>
	
	<body >
	
	<!-- menu -->
	<body style="background-color: white">
	
	    <div class ="titulo">
	    	<h1>Tienda Fullmotos</h1>
	    </div>
		<ul class="menu">
			<li><a style="background-color: purple" href="usuarios.jsp">Usuarios</a>
			<li><a href="clientes.jsp">Clientes </a>
			<li><a href="proveedores.jsp">Proveedores</a>
			<li><a href="productos.jsp">Producto</a>
			<li><a href="ventas.jsp">Ventas</a>
			<li><a href="detalles_Ventas.jsp">Detalles ventas</a>
			<li><a href="inicio.jsp"class="dropdown-item">Salir</a>
		</ul>	

	<!-- formulario de usuarios -->
	<div class=container  style="background-color: white" align="left">
		<form id="formulario_ur" class="form-pagina" method="post" action="./Servlet" style="display:block">
			<br>
			<table class="formulario_datos">
				<tr>
					<td><label>Cédula:</label></td>
					<td><input type="number" name="cedula"></td>
				</tr>
				<tr>
					<td><label>Nombre Completo:</label></td>
					<td><input type="text" name="nombre"></td>
				</tr>
				<tr>
					<td><label>Correo Electrónico:</label></td>
					<td><input type="email" name="email"></td>
				</tr>
				<tr>
					<td><label>Usuario:</label></td>
					<td><input type="text" name="usuario"></td>
				</tr>
				<tr>
				
					<td><label>Contraseña:</label></td>
					<td><input type="password" name="password"></td>
				</tr>
	
				</table>
				<br> 
				<table>
				<tr>

					<td button>
						<button class="btn_pagina btn-block" type="submit" name="AgregarUsuario" style="background-color:gray">Agregar</button>
						<button class="btn_pagina btn-block" type="submit" name="ListarUsuarios" style="background-color:gray">Listar</button>
						<button class="btn_pagina btn-block" type="submit" name="ActualizarUsuario" style="background-color:gray">Actualizar</button>
						<button class="btn_pagina btn-block" type="submit" name="EliminarUsuario" style="background-color:gray">Eliminar</button>
					<td>

				</tr>
			</table>
		</form>
	</div>
</body>
</html>