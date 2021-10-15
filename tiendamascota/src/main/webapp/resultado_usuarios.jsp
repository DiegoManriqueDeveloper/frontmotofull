<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ page import='java.util.Date' %>
<%@ page import='co.edu.unbosque.mascoticas.Usuarios'%>
<%@ page import='co.edu.unbosque.mascoticas.Roles'%>
<%@ page import='java.util.ArrayList' %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>PRINCIPAL tienda fullmotos </title>
		<link rel="STYLESHEET" type="text/css" href="css/Principal.css">
<link href="css/estilos.css" rel="stylesheet" type="text/css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU"
	crossorigin="anonymous">
<title>Resultado Usuarios</title>
<body style="background-color: black">
<!-- menu -->
	    <div class ="titulo">
	    	<h1>tienda motofull</h1>
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
	<nav class="navbar">
	</nav>
	<div align="center">
		<table class="tabla-resultados">
			<tr>
				<td><label>Cédula</label></td>
				<td><label>Nombre</label></td>
				<td><label>Correo</label></td>
				<td><label>Celular</label></td>
				<td><label>Password</label></td>
				<td><label>Rol</label></td>
			</tr>
			<%
			ArrayList<Usuarios> lista = (ArrayList<Usuarios>) request.getAttribute("lista");
			
			for (Usuarios usuario : lista){
				
			%>
			<tr>
				<td><%=usuario.getCedula_usuario()%></td>
				<td><%=usuario.getNombre_usuario()%></td>
				<td><%=usuario.getEmail_usuario()%></td>
				<td><%=usuario.getCelular_usuario()%></td>
				<td><%=usuario.getPassword()%></td>
				<td><%=usuario.getRol().getDescripcion()%></td>
			</tr>
			<%
			}
			%>
		</table>
	</div>
	
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ"
		crossorigin="anonymous"></script>
</body>
</html>