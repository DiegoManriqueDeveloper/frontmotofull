<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>tienda fullmotos productos</title>
		<link rel="STYLESHEET" type="text/css" href="css/estiloUsuario.css">
		<link rel="STYLESHEET" type="text/css" href="css/Principal.css">
	
</head>
<body style="background-color: black">
<div class ="titulo">
	    	<h1>tienda fullmotos productos</h1>
	    </div>
		<ul class="menu">
			<li><a href="usuarios.jsp">usuarios</a>
			<li><a href="clientes.jsp">clientes </a>
			<li><a href="proveedores.jsp">proveedores</a>
			<li><a style="background-color: purple" href="productos.jsp">productos</a>
			<li><a href="ventas.jsp">ventas</a>
			<li><a href="detalles_Ventas.jsp">detalles de ventas</a>
			<li><a href="inicio.jsp"class="dropdown-item">salir</a>
		</ul>	

<body style="background-color: #0000">
	

	<div align="center">
		<form  class = container id="formulario_ur" class="form-pagina" method="post" action="./Servlet" style="display:block">
			<br>
			<table class="formulario_datos">
				<tr>
					<td><label>codigo_Producto:</label></td>
					<td><input type="number" name="codigo_producto"></td>
				</tr>
				<tr>
					<td><label>Nombre_producto :</label></td>
					<td><input type="text" name="nombre_producto"></td>
				</tr>
				<tr>
					<td><label>precio_compra:</label></td>
					<td><input type="text" name="precio_compra"></td>
				</tr>
				<tr>
					<td><label>precio_venta:</label></td>
					<td><input type="number" name="precio_venta"></td>
				</tr>
				<tr>
					<td><label>existencia:</label></td>
					<td><input type="number" name="existencia"></td>
				</tr>
				<tr>
					<td><label>Iva Compra:</label></td>
					<td><input type="number" name="ivacompra"></td>
				</tr>
				<tr>
					<td><label>Nit Proveedor:</label></td>
					<td><input type="number" name="nit_proveedor"></td>
				</tr>
				</table>
				<br> 
				<table>
				<tr>
					<td>
						<button class="btn_pagina btn-block" type="submit" name="AgregarProductos" style="background-color:gray">Agregar</button>
						<button class="btn_pagina btn-block" type="submit" name="ListarProductos" style="background-color:gray">Listar</button>
						<button class="btn_pagina btn-block" type="submit" name="ActualizarProductos" style="background-color:gray">Actualizar</button>
						<button class="btn_pagina btn-block" type="submit" name="EliminarProductos" style="background-color:gray">Eliminar</button>
					</td>
				</tr>
			</table>
		</form>
	</div>
	
</body>
</html>