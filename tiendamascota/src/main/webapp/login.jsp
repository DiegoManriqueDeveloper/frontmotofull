<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
			<meta charset="ISO-8859-1">
			<title>la tienda.com</title>
			<link rel="STYLESHEET" type="text/css" href="css/estilo_login.css"> 
	</head>

	<body style=background-image:url(img/moto2.jpg);>
			<div class ="login-box" Style= border-radius:20px>
				
				<h1>MECHANIC SERVICES</h1>
				<form method = "get" action ="Servlet">
					<label for="ussername">Usuario </label>
					<input name="txtUsuario" type= "text"placeholder ="Ingrese Usuario"><br>
			
					<label for="password">Contrase�a </label>
					<input name="txtPassword" type= "password" placeholder ="Ingrese contrase�a">
			
					<input type="submit" value ="Ingresar" name="validacionLogin">
			

					<a href ="#">�Olvid� su contrase�a?</a>
					<a href ="#">�No tiene una cuenta?</a>


				</form>
			</div>	
	</body>
</html>


