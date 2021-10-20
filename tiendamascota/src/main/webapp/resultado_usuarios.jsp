<<<<<<< HEAD
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ page import='java.util.Date'%>
<%@ page import='co.edu.unbosque.mascoticas.Usuarios'%>
<%@ page import='java.util.ArrayList'%>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="STYLESHEET" type="text/css" href="css/Principal.css">
<link rel="STYLESHEET" type="text/css" href="css/resultados.css">
<title>Resultado Usuarios</title>
</head>
<body style="background-color: #0000">
	<div class="titulo">
		<h1>tienda motofull</h1>
		<img class= "avatar2" src="./img/moto50.jpg" alt="logo de fazt" Style="width: 50px"Style="height: 50px">
		
	</div>
		<ul class="menu">
			<li><a style="background-color: purple" href="usuarios.jsp">usuarios</a>
			<li><a href="clientes.jsp">clientes </a>
			<li><a href="proveedores.jsp">proveedores</a>
			<li><a href="productos.jsp">producto</a>
			<li><a href="ventas.jsp">ventas</a>
			<li><a href="detalles_Ventas.jsp">Detalles Ventas</a>
			<li><a href="inicio.jsp"class="dropdown-item">salir</a>
		</ul>	
	<body>
	<div id="page">

		<table>
			<caption>usuarios</caption>
			<tr class = "titulos">
				<td><label>Cédula</label></td>
				<td><label>Nombre</label></td>
				<td><label>Correo</label></td>
				<td><label>usuario</label></td>
				<td><label>Password</label></td>
			</tr>
			<%
			ArrayList<Usuarios> lista = (ArrayList<Usuarios>) request.getAttribute("lista");
			
			for (Usuarios usuario : lista){
				
			%>
			<tr>
				<td><%=usuario.getCedula_usuario()%></td>
				<td><%=usuario.getNombre_usuario()%></td>
				<td><%=usuario.getEmail_usuario()%></td>
				<td><%=usuario.getUsuario()%></td>
				<td><%=usuario.getPassword()%></td>
				
			</tr>
			<%
			}
			%>
		</table>
		<div class ="login-box" Style= border-radius:20px>
					
				<ul class="return">
			<li><a href="usuarios.jsp">regresar</a>
			</li>
			</ul>
			</div>	

	</div>
</body>
=======
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ page import='java.util.Date'%>
<%@ page import='co.edu.unbosque.mascoticas.Usuarios'%>
<%@ page import='java.util.ArrayList'%>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="STYLESHEET" type="text/css" href="css/Principal.css">
<link rel="STYLESHEET" type="text/css" href="css/resultados.css">
<title>Resultado Usuarios</title>
</head>
<body style="background-color: #0000">
	<div class="titulo">
		<h1>tienda motofull</h1>
		<img class= "avatar2" src="./img/moto50.jpg" alt="logo de fazt" Style="width: 50px"Style="height: 50px">
		
	</div>
		<ul class="menu">
			<li><a style="background-color: purple" href="usuarios.jsp">usuarios</a>
			<li><a href="clientes.jsp">clientes </a>
			<li><a href="proveedores.jsp">proveedores</a>
			<li><a href="productos.jsp">producto</a>
			<li><a href="ventas.jsp">ventas</a>
			<li><a href="detalles_Ventas.jsp">Detalles Ventas</a>
			<li><a href="inicio.jsp"class="dropdown-item">salir</a>
		</ul>	
	<body>
	<div id="page">

		<table>
			<caption>usuarios</caption>
			<tr class = "titulos">
				<td><label>Cédula</label></td>
				<td><label>Nombre</label></td>
				<td><label>Correo</label></td>
				<td><label>usuario</label></td>
				<td><label>Password</label></td>
			</tr>
			<%
			ArrayList<Usuarios> lista = (ArrayList<Usuarios>) request.getAttribute("lista");
			
			for (Usuarios usuario : lista){
				
			%>
			<tr>
				<td><%=usuario.getCedula_usuario()%></td>
				<td><%=usuario.getNombre_usuario()%></td>
				<td><%=usuario.getEmail_usuario()%></td>
				<td><%=usuario.getUsuario()%></td>
				<td><%=usuario.getPassword()%></td>
				
			</tr>
			<%
			}
			%>
		</table>
		<div class ="login-box" Style= border-radius:20px>
					
				<ul class="return">
			<li><a href="usuarios.jsp">regresar</a>
			</li>
			</ul>
			</div>	

	</div>
</body>
>>>>>>> refs/remotes/origin/master
</html>