<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Tienda Fullmotos Proveedores</title>
		<link rel="STYLESHEET" type="text/css" href="css/Principal.css">
	
</head>
<body style="background-color: white">
<div class ="titulo">
	    	<h1>Tienda FullMotos Proveedores</h1>
	    </div>
		<ul class="menu">
			<li><a href="usuarios.jsp">Usuarios</a>
			<li><a href="clientes.jsp">Clientes </a>
			<li><a style="background-color: purple" href="proveedores.jsp">Proveedores</a>
			<li><a href="productos.jsp">Producto</a>
			<li><a href="ventas.jsp">Ventas</a>
			<li><a href="detalles_Ventas.jsp">Detalles de Ventas</a>
			<li><a href="inicio.jsp"class="dropdown-item">Salir</a>
		</ul>	

<body style="background-color: #0000">
	

	<div align="center">
		<form id="formulario_ur" class="form-pagina" method="post" action="./Servlet" style="display:block">
			<br>
			<table class="formulario_datos">
				<tr>
					<td><label>Nit:</label></td>
					<td><input type="number" name="nit_proveedor"></td>
				</tr>
				<tr>
					<td><label>Nombre :</label></td>
					<td><input type="text" name="nombre_proveedor"></td>
				</tr>
				<tr>
					<td><label>Dirección:</label></td>
					<td><input type="text" name="direccion_proveedor"></td>
				</tr>
				<tr>
					<td><label>Ciudad:</label></td>
					<td><input type="text" name="ciudad_proveedor"></td>
				</tr>
				<tr>
					<td><label>Teléfono:</label></td>
					<td><input type="number" name="telefono_proveedor"></td>
				</tr>
				</table>
				<br> 
				<table>
				<tr>
					<td>
						<button class="btn_pagina btn-block" type="submit" name="AgregarProveedores" style="background-color:gray">Agregar</button>
						<button class="btn_pagina btn-block" type="submit" name="ListarProveedores" style="background-color:gray">Listar</button>
						<button class="btn_pagina btn-block" type="submit" name="ActualizarProveedores" style="background-color:gray">Actualizar</button>
						<button class="btn_pagina btn-block" type="submit" name="EliminarProveedores" style="background-color:gray">Eliminar</button>
					</td>
				</tr>
			</table>
		</form>
	</div>
	
</body>
</html>