<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Gestión Usuarios</title>
</head>
<body>
	<p align="center"> GESTIÓN DE USUARIOS</p>
	<form method="post" action="./Servlet">
		<table>
			<tr>
				<td><label>Cedula:</label></td>
				<td><input type="text" name="cedula"></td>
			</tr>
			<tr>
				<td><label>Nombre:</label></td>
				<td><input type="text" name="nombre"></td>
			</tr>
			<tr>
				<td><label>Correo Electronico:</label></td>
				<td><input type="text" name="email"></td>
			</tr>
			<tr>
				<td><label>Celular:</label></td>
				<td><input type="text" name="celular"></td>
			</tr>
			<tr>
				<td><label>Password:</label></td>
				<td><input type="password" name="password"></td>
			</tr>
			<tr>
				<td><button type="submit" name="AgregarUsuario">Agregar Usuario</td>
			</tr>
			<tr>
				<td><button type="submit" name="ListarUsuario">Listar Usuarios</button></td>
			</tr>
			<tr>
				<td><button type="submit" name="ActualizarUsuario">Actualizar Usuario</button></td>
			</tr>
			<tr>
				<td><button type="submit" name="EliminarUsuario">Eliminar Usuario</button></td>
			</tr>
		</table>
	</form>
</body>
</html>