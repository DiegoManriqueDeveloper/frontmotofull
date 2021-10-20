<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ page import='java.util.Date'%>
<%@ page import='co.edu.unbosque.motofull.Productos'%>
<%@ page import='co.edu.unbosque.motofull.Proveedores'%>
<%@ page import='java.util.ArrayList'%>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="STYLESHEET" type="text/css" href="css/Principal.css">
<link rel="STYLESHEET" type="text/css" href="css/resultados.css">
<title>Resultado Productos</title>
</head>
<body style="background-color: #0000">
	<div class="titulo">
		<h1>tienda motofull</h1>
	</div>
		<ul class="menu">
			<li><a href="usuarios.jsp">usuarios</a>
			<li><a href="clientes.jsp">clientes </a>
			<li><a href="proveedores.jsp">proveedores</a>
			<li><a style="background-color: purple" href="productos.jsp">producto</a>
			<li><a href="ventas.jsp">ventas</a>
			<li><a href="detalles_Ventas.jsp">Detalles Ventas</a>
			<li><a href="inicio.jsp"class="dropdown-item">salir</a>
		</ul>	
	<body>
	<div id="page">

		<table width="100%" border="0">
			<caption>Productos</caption>
			<tr class = "titulos">
				<td><label>Código Producto</label></td>
				<td><label>Nombre</label></td>
				<td><label>Precio Venta</label></td>
				<td><label>Precio Compra</label></td>
				<td><label>Iva Compra</label></td>
				<td><label>Existencias</label></td>
				<td><label>Nit Proveedor</label></td>
			</tr>
			<%
			ArrayList<Productos> lista = (ArrayList<Productos>) request.getAttribute("listaProductos");
			Proveedores proveedor = new Proveedores(); 
			for (Productos producto : lista){
			%>
			<tr>
				<td><%=producto.getCodigo_producto()%></td>
				<td><%=producto.getNombre_producto()%></td>
				<td><%=producto.getPrecio_venta()%></td>
				<td><%=producto.getPrecio_compra()%></td>
				<td><%=producto.getIvacompra()%></td>
				<td><%=producto.getExistencia()%></td>
				<%proveedor = producto.getProveedores(); %>
				<td><%=proveedor.getNit_proveedor()%></td>
			</tr>
			<%
			}
			%>
		</table>
		<div class ="login-box" Style= border-radius:20px>
					
				<ul class="return">
			<li><a href="productos.jsp">regresar</a>
			</li>
			</ul>
			</div>	

	</div>
</body>
</html>