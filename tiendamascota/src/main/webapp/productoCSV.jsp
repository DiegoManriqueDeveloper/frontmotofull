<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="ISO-8859-1">
<head>
		<meta charset="UTF-8 ">
		<title>tienda fullmotos Usuarios </title>
		<link rel="STYLESHEET" type="text/css" href="css/Principal.css">
		<link rel="STYLESHEET" type="text/css" href="css/estiloUsuario.css">
	</head>
	
	<body >
	<!-- menu -->
	    <div class ="titulo">
	    	<h1>tienda fullmotos Usuarios</h1>
	    </div>
		<ul class="menu">
			<li><a style="background-color: purple" href="usuarios.jsp">usuarios</a>
			<li><a href="clientes.jsp">clientes </a>
			<li><a href="proveedores.jsp">proveedores</a>
			<li><a href="productos.jsp">producto</a>
			<li><a href="ventas.jsp">ventas</a>
			<li><a href="detalles_Ventas.jsp">Detalles ventas</a>
			<li><a href="inicio.jsp"class="dropdown-item">salir</a>
		</ul>	

	<!-- formulario de usuarios -->
	<div class=container  style="background-color: #15175b" align="center">
		<form id="formulario_ur" class="form-pagina" method="post" action="./Servlet" style="display:block">
			<br>
			<table class="formulario_datos">
				<tr>
					<div>
						<h1>Adición de productos por CSV</h1>
					</div>
					<div id="dvImportSegments" class="fileupload ">
						<fieldset>
							<legend>Upload your CSV File</legend>
							<input type="file" name="archivo" id="txtFileUpload" accept=".csv" onchange="handleFiles(this.files)" />
						</fieldset>
					</div>
				</tr>
			</table>
			<br> 
			<table>
				<tr>
					<td class=botons>
					<ul class="return">
						<li><button class="btn_pagina btn-block" type="submit" name="AgregarCsv" style="background-color:gray, center:true;">Cargar CSV</button>
						</ul>
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>