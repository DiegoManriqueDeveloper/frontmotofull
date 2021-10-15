<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>tienda fullmotos Detalles ventas</title>
		<link rel="STYLESHEET" type="text/css" href="css/Principal.css">
	
</head>
<body style="background-color: black">
<div class ="titulo">
	    	<h1>tienda fullmotos Detalles ventas</h1>
	    </div>
		<ul class="menu">
			<li><a href="usuarios.jsp">usuarios</a>
			<li><a style="background-color: purple" href="clientes.jsp">clientes </a>
			<li><a href="proveedores.jsp">proveedores</a>
			<li><a href="productos.jsp">producto</a>
			<li><a href="ventas.jsp">ventas</a>
			<li><a href="operacion_no.jsp">detalles de ventas</a>
			<li><a href="inicio.jsp"class="dropdown-item">salir</a>
		</ul>	

<body style="background-color: #0000">
	

	<div align="center">
		<form id="formulario_ur" class="form-pagina" method="post" action="./Servlet" style="display:block">
			<br>
			<table class="formulario_datos">
				<tr>
					<td><label>codigo_detalle_venta:</label></td>
					<td><input type="number" name="codigo_detalle_venta"></td>
				</tr>
				<tr>
					<td><label>cantidad_producto:</label></td>
					<td><input type="text" name="cantidad_producto"></td>
				</tr>
				<tr>
					<td><label>valor_total:</label></td>
					<td><input type="text" name="valor_total"></td>
				</tr>
				<tr>
					<td><label>valor_venta:</label></td>
					<td><input type="email" name="valor_venta"></td>
				</tr>
				<tr>
					<td><label>valoriva:</label></td>
					<td><input type="number" name="valoriva"></td>
				</tr>
				</table>
				<br> 
				<table>
				<tr>
					<td>
						<button class="btn_pagina btn-block" type="submit" name="AgregarCliente" style="background-color:gray">Agregar</button>
						<button class="btn_pagina btn-block" type="submit" name="ListarClientes" style="background-color:gray">Listar</button>
						<button class="btn_pagina btn-block" type="submit" name="ActualizarCliente" style="background-color:gray">Actualizar</button>
						<button class="btn_pagina btn-block" type="submit" name="EliminarCliente" style="background-color:gray">Eliminar</button>
					</td>
				</tr>
			</table>
		</form>
	</div>
	
</body>
</html>