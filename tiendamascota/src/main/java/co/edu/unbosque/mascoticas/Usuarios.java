package co.edu.unbosque.mascoticas;

import co.edu.unbosque.mascoticas.Roles;

public class Usuarios {
	private long cedula_usuario;
	private String nombre_usuario;
	private String email_usuario;
	private String celular_usuario;
	private String password;
	private Roles rol;
	
	//getters y setters
	public long getCedula_usuario() {
		return cedula_usuario;
	}
	public void setCedula_usuario(long cedula_usuario) {
		this.cedula_usuario = cedula_usuario;
	}
	public String getNombre_usuario() {
		return nombre_usuario;
	}
	public void setNombre_usuario(String nombre_usuario) {
		this.nombre_usuario = nombre_usuario;
	}
	public String getEmail_usuario() {
		return email_usuario;
	}
	public void setEmail_usuario(String email_usuario) {
		this.email_usuario = email_usuario;
	}
	public String getCelular_usuario() {
		return celular_usuario;
	}
	public void setCelular_usuario(String celular_usuario) {
		this.celular_usuario = celular_usuario;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Roles getRol() {
		return rol;
	}

	public void setRol(Roles rol) {
		this.rol = rol;
	}
}