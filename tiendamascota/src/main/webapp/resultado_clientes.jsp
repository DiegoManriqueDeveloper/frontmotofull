<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ page import='java.util.Date' %>
<%@ page import='co.edu.unbosque.mascoticas.Clientes'%>
<%@ page import='java.util.ArrayList' %>
<html>
<head>
<meta charset="ISO-8859-1">
	<link rel="STYLESHEET" type="text/css" href="css/Principal.css">
<title>Resultado Clientes</title>
<body style="background-color: #F7931E">
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
	<div align="center">
		<table class="tabla-resultados">
			<tr>
				<td><label>Cédula</label></td>
				<td><label>Nombre</label></td>
				<td><label>Direccion</label></td>
				<td><label>Correo</label></td>
				<td><label>Teléfono</label></td>
			</tr>
			<%
			ArrayList<Clientes> lista = (ArrayList<Clientes>) request.getAttribute("listaClientes");
			for (Clientes cliente : lista){
			%>
			<tr>
				<td><%=cliente.getCedula_cliente()%></td>
				<td><%=cliente.getNombre_cliente()%></td>
				<td><%=cliente.getDireccion_cliente()%></td>
				<td><%=cliente.getEmail_cliente()%></td>
				<td><%=cliente.getTelefono_cliente()%></td>
			</tr>
			<%
			}
			%>
		</table>
	</div>
	
</body>
</html>