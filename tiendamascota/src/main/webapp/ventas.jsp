<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="STYLESHEET" type="text/css" href="css/Principal.css">

	
<title>Tienda MotoFull Ventas</title>
</head>
<body style="background-color: white">
<!-- menu -->
	    <div class ="titulo">
	    	<h1>Tienda Motofull</h1>
	    </div>
		<ul class="menu">
			<li><a href="usuarios.jsp">Usuarios</a>
			<li><a href="clientes.jsp">Clientes </a>
			<li><a href="proveedores.jsp">Proveedores</a>
			<li><a href="productos.jsp">Producto</a>
			<li><a style="background-color: purple" href="ventas.jsp">Ventas</a>
			<li><a href="detalles_Ventas.jsp">Detalles de Ventas</a>
			<li><a href="inicio.jsp"class="dropdown-item">Salir</a>
		</ul>	

<body style="background-color: ">
	<div align="center">
	<span class="badge_titulo">INGRESAR VENTA</span>
	<form class="form-control" method="post" action="./Servlet">
		<table Class =cliente>
			<tr>
				<td><label>Cedula del Cliente:</label></td>
				<td><input type="text" name="cedula_cliente"></td>
				<td><button type="submit" name="ConsultarCliente">Consultar</td>
				<td><label>Nombre del Cliente</label></td>
				<td><input type="text" name="nombre_cliente"></td>
				<td><label>Consecutivo</label></td>
				<td><input type="text" name="codigo_venta"></td>
			</tr>
			<br>
		</table>
		<table>
			<tr>
				<td><label>Cód. del Producto</label></td>
				<td><label>Nombre del Producto</label></td>
				<td><label>Cant.</label></td>
				<td><label>Vr. Unit</label></td>
				<td><label>Vr. Total</label></td>
			</tr>
			<tr>
				<td><input type="text" name="codigo_producto1"><button type="submit" name="Consultar_Producto">Consultar</td>
				<td><input type="text" name="nombre_producto1"></td>
				<td><input type="text" name="cantidad1"></td>
				<td><input type="text" name="valor_venta1"></td>
				<td><input type="text" name="valor_total1"></td>
			</tr>
			<tr>
				<td><input type="text" name="codigo_producto2"><button type="submit" name="Consultar_Producto">Consultar</td>
				<td><input type="text" name="nombre_producto2"></td>
				<td><input type="text" name="cantidad2"></td>
				<td><input type="text" name="valor_venta2"></td>
				<td><input type="text" name="valor_total2"></td>
			</tr>
			<tr>
				<td><input type="text" name="codigo_producto3"><button type="submit" name="Consultar_Producto">Consultar</td>
				<td><input type="text" name="nombre_producto3"></td>
				<td><input type="text" name="cantidad3"></td>
				<td><input type="text" name="valor_venta3"></td>
				<td><input type="text" name="valor_total3"></td>
			</tr>
			<tr>
				<td><input type="text" name="codigo_producto4"><button type="submit" name="Consultar_Producto">Consultar</td>
				<td><input type="text" name="nombre_producto4"></td>
				<td><input type="text" name="cantidad4"></td>
				<td><input type="text" name="valor_venta4"></td>
				<td><input type="text" name="valor_total4"></td>
			</tr>
			
			<tr>
				<td><button type="submit" name="CrearVenta">Guardar Venta</td>
			</tr>
		</table>
	</form>
	</div>	

</body>
</html>