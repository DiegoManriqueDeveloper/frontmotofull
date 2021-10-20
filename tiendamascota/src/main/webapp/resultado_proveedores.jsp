<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ page import='java.util.Date'%>
<%@ page import='co.edu.unbosque.motofull.Proveedores'%>
<%@ page import='java.util.ArrayList'%>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="STYLESHEET" type="text/css" href="css/Principal.css">
<link rel="STYLESHEET" type="text/css" href="css/resultados.css">
<title>Resultado Proveedores</title>
</head>
<body style="background-color: #0000">
	<div class="titulo">
		<h1>tienda motofull</h1>
	</div>
	<ul class="menu">
		<li><a href="usuarios.jsp">usuarios</a>
		<li><a href="clientes.jsp">clientes </a>
		<li><a style="background-color: purple"href="proveedores.jsp">proveedores</a>
		<li><a href="productos.jsp">producto</a>
		<li><a href="ventas.jsp">ventas</a>
		<li><a href="detalles_Ventas.jsp">Detalles Ventas</a>
		<li><a href="inicio.jsp" class="dropdown-item">salir</a></li>
	</ul>


<body>
	<div id="page">

		<table width="100%" border="0">
			<caption>clientes</caption>
			<tr class= "titulos">
				<td><label>Nit</label></td>
				<td><label>Nombre</label></td>
				<td><label>Direccion</label></td>
				<td><label>Ciudad</label></td>
				<td><label>Teléfono</label></td>
			</tr>

			<%
			ArrayList<Proveedores> lista = (ArrayList<Proveedores>) request.getAttribute("listaProveedores");
			for (Proveedores proveedor : lista) {
			%>
			<tr>
				<td><%=proveedor.getNit_proveedor()%></td>
				<td><%=proveedor.getNombre_proveedor()%></td>
				<td><%=proveedor.getDireccion_proveedor()%></td>
				<td><%=proveedor.getCiudad_proveedor()%></td>
				<td><%=proveedor.getTelefono_proveedor()%></td>
			</tr>
			<%
			}
			%>
		</table>
		<div class ="login-box" Style= border-radius:20px>
					
				<ul class="return">
			<li><a href="clientes.jsp">regresar</a>
			</li>
			</ul>
			</div>	

	</div>
</body>
</html>
