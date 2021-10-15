<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ page import='co.edu.unbosque.mascoticas.Roles'%>
<%@ page import='java.util.ArrayList' %>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="css/estilos.css" rel="stylesheet" type="text/css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU"
	crossorigin="anonymous">
<title>Resultado Roles</title>
<body style="background-color: #F7931E">
	<nav class="navbar">
		<div
			style="font-family: Luckiest Guy; color: black; margin-left: 50px; font-size: 2rem; text-align: center"
			class="col-9">
			Bienvenido a:&nbsp &nbsp <img src="img/titulo.png" height="50%"
				width="50%" />
		</div>
		<div class="dropdown col-2">
			<button class="btn_login dropdown-toggle" data-bs-toggle="dropdown">
				Regresar</button>
			<div class="dropdown-menu text-center" style="background-color:#0172C2; border:2px solid #262D94; font-family:Righteous; border-radius: 10px">
				<a>User</a>
				<div class="dropdown-divider"></div>
				<a href="menu_ppal.jsp" class="dropdown-item"> Menú Ppal </a>
			</div>
		</div>
	</nav>
	<span class="badge_titulo">Gestión de Roles</span>
	<div align="center">
		<table class="tabla-resultados">
			<tr>
				<td><label><strong>Id</strong></label></td>
				<td><label><strong>Descripción</strong></label></td>
			</tr>
			<%
			ArrayList<Roles> lista = (ArrayList<Roles>) request.getAttribute("lista");
			for (Roles rol : lista){
			%>
			<tr>
				<td><%=rol.getId_rol()%></td>
				<td><%=rol.getDescripcion()%></td>
			</tr>
			<%
			}
			%>
		</table>
	</div>
	<br>
	<div align="right" style="margin-right:50px">
		<a href="roles.jsp" >
			<input class="btn_volver btn-block" value="Volver a Roles">
		</a>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ"
		crossorigin="anonymous"></script>
</body>
</html>