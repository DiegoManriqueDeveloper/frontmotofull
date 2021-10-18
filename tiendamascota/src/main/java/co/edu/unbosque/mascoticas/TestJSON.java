package co.edu.unbosque.mascoticas;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class TestJSON 
{
	private static URL url;
	private static String sitio = "http://localhost:5000/";
	private static String usuarioAPI = "usuarioAPI:123";
	
	
	//LQ: Agregado 17/10/2021
	public static ArrayList<Productos> parsingProductos(String json) throws ParseException 
	{
		System.out.println("Llegó al parsingProductos");
		JSONParser jsonParser = new JSONParser();
		JSONArray productos = (JSONArray) jsonParser.parse(json);
		
		ArrayList<Productos> lista = new ArrayList<Productos>();
		Iterator i = productos.iterator();
		while (i.hasNext()) 
		{
			JSONObject innerObj = (JSONObject) i.next();
			Productos producto = new Productos();
			Proveedores proveedor = new Proveedores();
			
			producto.setCodigo_producto(Long.parseLong(innerObj.get("codigo_producto").toString()));
			producto.setNombre_producto(innerObj.get("nombre_producto").toString());
			producto.setPrecio_compra(Double.parseDouble(innerObj.get("precio_compra").toString()));
			producto.setPrecio_venta(Double.parseDouble(innerObj.get("precio_venta").toString()));
			producto.setExistencia(Double.parseDouble(innerObj.get("existencia").toString()));
			producto.setIvacompra(Double.parseDouble(innerObj.get("ivacompra").toString()));
			
			//Para sacar los proveedores del Json de Productos
			String JsonProveedor = "[" +innerObj.get("proveedores") + "]";
			System.out.println("El Json de Proveedor: " + JsonProveedor);
			
			JSONParser jsonParserProveedores = new JSONParser();
			JSONArray Aproveedor = (JSONArray) jsonParserProveedores.parse(JsonProveedor);
			JSONObject innerObjPro = (JSONObject) Aproveedor.get(0);
			proveedor.setNit_proveedor(Long.parseLong(innerObjPro.get("nit_proveedor").toString()));
			System.out.println("El Nit Proveedor: " + proveedor.getNit_proveedor());
			
			producto.setProveedores(proveedor);
			
			System.out.println("proveedor Data: " + producto.getNombre_producto());
			lista.add(producto);
		}
		return lista;
	}
	
	
	//LQ: Agregado 17/10/2021
	public static ArrayList<Proveedores> parsingProveedores(String json) throws ParseException 
	{
		System.out.println("Llegó al parsingProveedores");
		JSONParser jsonParser = new JSONParser();
		ArrayList<Proveedores> lista = new ArrayList<Proveedores>();
		JSONArray proveedores = (JSONArray) jsonParser.parse(json);
		Iterator i = proveedores.iterator();
		while (i.hasNext()) 
		{
			JSONObject innerObj = (JSONObject) i.next();
			Proveedores proveedor = new Proveedores();
			proveedor.setNit_proveedor(Long.parseLong(innerObj.get("nit_proveedor").toString()));
			proveedor.setNombre_proveedor(innerObj.get("nombre_proveedor").toString());
			proveedor.setCiudad_proveedor(innerObj.get("ciudad_proveedor").toString());
			proveedor.setTelefono_proveedor(innerObj.get("telefono_proveedor").toString());
			proveedor.setDireccion_proveedor(innerObj.get("direccion_proveedor").toString());
			System.out.println("proveedor Data: " + proveedor.getNombre_proveedor());
			lista.add(proveedor);
		}
		return lista;
	}
	
	
	//TODO Metodos de Usuarios
	public static ArrayList<Usuarios> parsingUsuarios(String json) throws ParseException 
	{
		System.out.println("Llegó al ParsingUsuarios");
		JSONParser jsonParser = new JSONParser();
		ArrayList<Usuarios> lista = new ArrayList<Usuarios>();
		JSONArray usuarios = (JSONArray) jsonParser.parse(json);
		Iterator i = usuarios.iterator();
		while (i.hasNext()) 
		{
			JSONObject innerObj = (JSONObject) i.next();
			Usuarios usuario = new Usuarios();
			usuario.setCedula_usuario(Long.parseLong(innerObj.get("cedula_usuario").toString()));
			usuario.setNombre_usuario(innerObj.get("nombre_usuario").toString());
			usuario.setEmail_usuario(innerObj.get("email_usuario").toString());
			usuario.setUsuario(innerObj.get("usuario").toString());
			usuario.setPassword(innerObj.get("password").toString());
			System.out.println("usuario Pass: " + usuario.getPassword());
			lista.add(usuario);
		}
		return lista;
	}
	
	//LQ: Agregado 16/10/2021
	public static ArrayList<Clientes> parsingClientes(String json) throws ParseException 
	{
		System.out.println("Llegó al ParsingClientes");
		JSONParser jsonParser = new JSONParser();
		ArrayList<Clientes> lista = new ArrayList<Clientes>();
		JSONArray clientes = (JSONArray) jsonParser.parse(json);
		Iterator i = clientes.iterator();
		while (i.hasNext()) 
		{
			JSONObject innerObj = (JSONObject) i.next();
			Clientes cliente = new Clientes();
			cliente.setCedula_cliente(Long.parseLong(innerObj.get("cedula_cliente").toString()));
			cliente.setNombre_cliente(innerObj.get("nombre_cliente").toString());
			cliente.setEmail_cliente(innerObj.get("email_cliente").toString());
			cliente.setTelefono_cliente(innerObj.get("telefono_cliente").toString());
			cliente.setDireccion_cliente(innerObj.get("direccion_cliente").toString());
			System.out.println("Cliente Data: " + cliente.getNombre_cliente());
			lista.add(cliente);
		}
		return lista;
	}
	
	
	//LQ Agregado 17/10/2021
	public static ArrayList<Productos> getJSONProductos() throws IOException, ParseException
	{
		System.out.println("Ingresó a getJSONProductos");
		url = new URL(sitio+"productos/listar");
		String authStr = Base64.getEncoder().encodeToString(usuarioAPI.getBytes());
		HttpURLConnection http = (HttpURLConnection)url.openConnection();
		http.setRequestMethod("GET");
		http.setRequestProperty("Accept", "application/json");
		http.setRequestProperty("Authorization", "Basic " + authStr); 
		InputStream respuesta = http.getInputStream();
		System.out.println("Respuesta: "+ respuesta);
		byte[] inp = respuesta.readAllBytes();
		
		String json = "";
		for (int i = 0; i<inp.length ; i++) 
		{
			json += (char)inp[i];
		
		}
		System.out.print("Json: " + json);
		
		ArrayList<Productos> lista = new ArrayList<Productos>();
		lista = parsingProductos(json);
		System.out.println("Salió del Parsing Productos");
		
		
		http.disconnect();
		return lista;
	}
	
	//LQ Agregado 17/10/2021
	public static ArrayList<Proveedores> getJSONProveedores() throws IOException, ParseException
	{
		System.out.println("Ingresó a getJSONProveedores");
		url = new URL(sitio+"proveedores/listar");
		String authStr = Base64.getEncoder().encodeToString(usuarioAPI.getBytes());
		HttpURLConnection http = (HttpURLConnection)url.openConnection();
		http.setRequestMethod("GET");
		http.setRequestProperty("Accept", "application/json");
		http.setRequestProperty("Authorization", "Basic " + authStr); 
		InputStream respuesta = http.getInputStream();
		System.out.print("Respuesta: "+ respuesta);
		byte[] inp = respuesta.readAllBytes();
		
		String json = "";
		for (int i = 0; i<inp.length ; i++) 
		{
			json += (char)inp[i];
		
		}
		System.out.print("Json: " + json);
		
		ArrayList<Proveedores> lista = new ArrayList<Proveedores>();
		lista = parsingProveedores(json);
		System.out.print("Salió del Parsing Proveedores");
		http.disconnect();
		return lista;
		}
	
	
	public static ArrayList<Usuarios> getJSONUsuarios() throws IOException, ParseException
	{
		System.out.println("Ingresó a getJSONUsuarios");
		url = new URL(sitio+"usuarios/listar");
		String authStr = Base64.getEncoder().encodeToString(usuarioAPI.getBytes());
		HttpURLConnection http = (HttpURLConnection)url.openConnection();
		http.setRequestMethod("GET");
		http.setRequestProperty("Accept", "application/json");
		http.setRequestProperty("Authorization", "Basic " + authStr); 
		InputStream respuesta = http.getInputStream();
		System.out.print("Respuesta: "+ respuesta);
		byte[] inp = respuesta.readAllBytes();
		
		String json = "";
		for (int i = 0; i<inp.length ; i++) 
		{
			json += (char)inp[i];
		
		}
		System.out.print("Json: " + json);
		
		ArrayList<Usuarios> lista = new ArrayList<Usuarios>();
		lista = parsingUsuarios(json);
		System.out.print("Salió del Parsing");
		http.disconnect();
		return lista;
		}
	
	//LQ: Agregado 16/10/2021
	public static ArrayList<Clientes> getJSONClientes() throws IOException, ParseException
	{
		System.out.println("Ingresó a getJSONClientes");
		url = new URL(sitio+"clientes/listar");
		String authStr = Base64.getEncoder().encodeToString(usuarioAPI.getBytes());
		HttpURLConnection http = (HttpURLConnection)url.openConnection();
		http.setRequestMethod("GET");
		http.setRequestProperty("Accept", "application/json");
		http.setRequestProperty("Authorization", "Basic " + authStr); 
		InputStream respuesta = http.getInputStream();
		System.out.print("Respuesta: "+ respuesta);
		byte[] inp = respuesta.readAllBytes();
		
		String json = "";
		for (int i = 0; i<inp.length ; i++) 
		{
			json += (char)inp[i];
		
		}
		System.out.print("Json: " + json);
		
		ArrayList<Clientes> lista = new ArrayList<Clientes>();
		lista = parsingClientes(json);
		System.out.print("Salió del Parsing");
		http.disconnect();
		return lista;
	}

	
	//LQ: Agregado 17/10/2021
	public static int postJSONProductos(Productos producto) throws IOException 
	{
		System.out.println("Ingresó a TestJSON.postJSONProductos");
		
		url = new URL(sitio+"productos/guardar");
		HttpURLConnection http;
		http = (HttpURLConnection)url.openConnection();
		String authStr = Base64.getEncoder().encodeToString(usuarioAPI.getBytes());
		try {
		http.setRequestMethod("POST");
		} catch (ProtocolException e) {
		e.printStackTrace();
		}
		http.setDoOutput(true);
		http.setRequestProperty("Accept", "application/json");
		http.setRequestProperty("Authorization", "Basic " + authStr); 
		http.setRequestProperty("Content-Type", "application/json");
		
		System.out.println("Antes de Nit del Proveedor: ");
		Long NitProveedor = producto.getProveedores().getNit_proveedor();
		System.out.println("Nit del Proveedor: " + NitProveedor);
		
		String data = "{"
		+ "\"codigo_producto\":\""+ producto.getCodigo_producto()
		+"\",\"nombre_producto\":\""+ producto.getNombre_producto()
		+"\",\"precio_venta\":\""+ producto.getPrecio_venta()
		+"\",\"precio_compra\":\""+ producto.getPrecio_compra()
		+"\",\"existencia\":\""+ producto.getExistencia()
		+"\",\"ivacompra\":\""+ producto.getIvacompra() 
		//Agregamos el proveedor
		+"\",\"proveedores\":{\"nit_proveedor\":\""+ producto.getProveedores().getNit_proveedor() + "\""
		+ "}}";
		System.out.println("data a enviar de producto: " + data);
		
		byte[] out = data.getBytes(StandardCharsets.UTF_8);
		OutputStream stream = http.getOutputStream();
		stream.write(out);
		int respuesta = http.getResponseCode();
		http.disconnect();
		System.out.print("Respuesta de TestJson.postJSONProducto: " + respuesta);
		return respuesta;
	}
	
	//LQ: Agregado 17/10/2021
	public static int postJSONProveedores(Proveedores proveedor) throws IOException 
	{
		System.out.println("Ingresó a TestJSON.postJSONProveedores");
		
		url = new URL(sitio+"proveedores/guardar");
		HttpURLConnection http;
		http = (HttpURLConnection)url.openConnection();
		String authStr = Base64.getEncoder().encodeToString(usuarioAPI.getBytes());
		try {
		http.setRequestMethod("POST");
		} catch (ProtocolException e) {
		e.printStackTrace();
		}
		http.setDoOutput(true);
		http.setRequestProperty("Accept", "application/json");
		http.setRequestProperty("Authorization", "Basic " + authStr); 
		http.setRequestProperty("Content-Type", "application/json");
		String data = "{"
		+ "\"nit_proveedor\":\""+ proveedor.getNit_proveedor()
		+"\",\"nombre_proveedor\":\""+ proveedor.getNombre_proveedor()
		+"\",\"ciudad_proveedor\":\""+ proveedor.getCiudad_proveedor()
		+"\",\"direccion_proveedor\":\""+ proveedor.getDireccion_proveedor()
		+"\",\"telefono_proveedor\":\""+ proveedor.getTelefono_proveedor() + "\""                      
		+ "}";
		System.out.println("data a enviar de proveedor: " + data);
		
		byte[] out = data.getBytes(StandardCharsets.UTF_8);
		OutputStream stream = http.getOutputStream();
		stream.write(out);
		int respuesta = http.getResponseCode();
		http.disconnect();
		System.out.print("Respuesta de TestJson.postJSONproveedores: " + respuesta);
		return respuesta;
	}
	
	//LQ: Agregado 16/10/2021
	public static int postJSONClientes(Clientes cliente) throws IOException 
	{
		System.out.println("Ingresó a TestJSON.postJSONClientes");
		
		url = new URL(sitio+"clientes/guardar");
		HttpURLConnection http;
		http = (HttpURLConnection)url.openConnection();
		String authStr = Base64.getEncoder().encodeToString(usuarioAPI.getBytes());
		try {
		http.setRequestMethod("POST");
		} catch (ProtocolException e) {
		e.printStackTrace();
		}
		http.setDoOutput(true);
		http.setRequestProperty("Accept", "application/json");
		http.setRequestProperty("Authorization", "Basic " + authStr); 
		http.setRequestProperty("Content-Type", "application/json");
		String data = "{"
		+ "\"cedula_cliente\":\""+ cliente.getCedula_cliente()
		+"\",\"nombre_cliente\":\""+ cliente.getNombre_cliente()
		+"\",\"email_cliente\":\""+ cliente.getEmail_cliente()
		+"\",\"direccion_cliente\":\""+ cliente.getDireccion_cliente()
		+"\",\"telefono_cliente\":\""+cliente.getTelefono_cliente() + "\""                      
		+ "}";
		System.out.println("data a enviar de Cliente: " + data);
		
		byte[] out = data.getBytes(StandardCharsets.UTF_8);
		OutputStream stream = http.getOutputStream();
		stream.write(out);
		int respuesta = http.getResponseCode();
		http.disconnect();
		System.out.print("Respuesta de TestJson.postJSONClientes: " + respuesta);
		return respuesta;
	}

	//LQ: Agregado 17/10/2021
	public static int putJSONProductos(Productos producto) throws IOException 
	{
		System.out.println("Ingresó a TestJson.putJSONProductos");
		url = new URL(sitio+"productos/actualizar");
		HttpURLConnection http;
		http = (HttpURLConnection)url.openConnection();
		String authStr = Base64.getEncoder().encodeToString(usuarioAPI.getBytes());
		try {
		http.setRequestMethod("PUT");
		} catch (ProtocolException e) {
		e.printStackTrace();
		}
		http.setDoOutput(true);
		http.setRequestProperty("Accept", "application/json");
		http.setRequestProperty("Authorization", "Basic " + authStr); 
		http.setRequestProperty("Content-Type", "application/json");
		
		String data = "{"
				+ "\"codigo_producto\":\""+ producto.getCodigo_producto()
				+"\",\"nombre_producto\":\""+ producto.getNombre_producto()
				+"\",\"precio_venta\":\""+ producto.getPrecio_venta()
				+"\",\"precio_compra\":\""+ producto.getPrecio_compra()
				+"\",\"existencia\":\""+ producto.getExistencia()
				+"\",\"ivacompra\":\""+ producto.getIvacompra() 
				//Agregamos el proveedor
				+"\",\"proveedores\":{\"nit_proveedor\":\""+ producto.getProveedores().getNit_proveedor() + "\""
				+ "}}";
		System.out.println("data a enviar de producto: " + data);
		
		byte[] out = data.getBytes(StandardCharsets.UTF_8);
		OutputStream stream = http.getOutputStream();
		stream.write(out);
		int respuesta = http.getResponseCode();
		http.disconnect();
		return respuesta;
	}

	
	//LQ: Agregado 17/10/2021
	public static int putJSONProveedores(Proveedores proveedor) throws IOException 
	{
		System.out.println("Ingresó a TestJson.putJSONProveedores");
		url = new URL(sitio+"proveedores/actualizar");
		HttpURLConnection http;
		http = (HttpURLConnection)url.openConnection();
		String authStr = Base64.getEncoder().encodeToString(usuarioAPI.getBytes());
		try {
		http.setRequestMethod("PUT");
		} catch (ProtocolException e) {
		e.printStackTrace();
		}
		http.setDoOutput(true);
		http.setRequestProperty("Accept", "application/json");
		http.setRequestProperty("Authorization", "Basic " + authStr); 
		http.setRequestProperty("Content-Type", "application/json");
		
		String data = "{"
				+ "\"nit_proveedor\":\""+ proveedor.getNit_proveedor()
				+"\",\"nombre_proveedor\":\""+ proveedor.getNombre_proveedor()
				+"\",\"ciudad_proveedor\":\""+ proveedor.getCiudad_proveedor()
				+"\",\"direccion_proveedor\":\""+ proveedor.getDireccion_proveedor()
				+"\",\"telefono_proveedor\":\""+ proveedor.getTelefono_proveedor() + "\""                      
				+ "}";
		System.out.println("data a enviar de proveedor: " + data);
		
		byte[] out = data.getBytes(StandardCharsets.UTF_8);
		OutputStream stream = http.getOutputStream();
		stream.write(out);
		int respuesta = http.getResponseCode();
		http.disconnect();
		return respuesta;
	}
	
	//LQ: Agregado 16/10/2021
	public static int putJSONClientes(Clientes cliente) throws IOException 
	{
		System.out.println("Ingresó a TestJson.putJSONClientes");
		url = new URL(sitio+"clientes/actualizar");
		HttpURLConnection http;
		http = (HttpURLConnection)url.openConnection();
		String authStr = Base64.getEncoder().encodeToString(usuarioAPI.getBytes());
		try {
		http.setRequestMethod("PUT");
		} catch (ProtocolException e) {
		e.printStackTrace();
		}
		http.setDoOutput(true);
		http.setRequestProperty("Accept", "application/json");
		http.setRequestProperty("Authorization", "Basic " + authStr); 
		http.setRequestProperty("Content-Type", "application/json");
		System.out.print("Pasé por aquí1");
		
		String data = "{"
				+ "\"cedula_cliente\":\""+ cliente.getCedula_cliente()
				+"\",\"nombre_cliente\":\""+ cliente.getNombre_cliente()
				+"\",\"email_cliente\":\""+ cliente.getEmail_cliente()
				+"\",\"direccion_cliente\":\""+ cliente.getDireccion_cliente()
				+"\",\"telefono_cliente\":\""+cliente.getTelefono_cliente() + "\""                      
				+ "}";
		
		System.out.print(data);
		
		byte[] out = data.getBytes(StandardCharsets.UTF_8);
		OutputStream stream = http.getOutputStream();
		stream.write(out);
		int respuesta = http.getResponseCode();
		http.disconnect();
		return respuesta;
	}

	//LQ: Agregado 17/10/2021
	public static int deleteJSONProductos(int id) throws IOException 
	{
		url = new URL(sitio+"productos/eliminar/" + id);
		HttpURLConnection http;
		http = (HttpURLConnection)url.openConnection();
		String authStr = Base64.getEncoder().encodeToString(usuarioAPI.getBytes());
		try 
		{
			http.setRequestMethod("DELETE");
		} catch (ProtocolException e) 
		{
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		http.setDoOutput(true);
		http.setRequestProperty("Accept", "application/json");
		http.setRequestProperty("Authorization", "Basic " + authStr); 
		http.setRequestProperty("Content-Type", "application/json");
		http.connect();
		int respuesta = http.getResponseCode();
		http.disconnect();
		return respuesta;
	}
	
	//LQ: Agregado 10/16/2021
	public static int deleteJSONProveedores(int id) throws IOException 
	{
		url = new URL(sitio+"provedores/eliminar/" + id);
		HttpURLConnection http;
		http = (HttpURLConnection)url.openConnection();
		String authStr = Base64.getEncoder().encodeToString(usuarioAPI.getBytes());
		try 
		{
			http.setRequestMethod("DELETE");
		} catch (ProtocolException e) 
		{
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		http.setDoOutput(true);
		http.setRequestProperty("Accept", "application/json");
		http.setRequestProperty("Authorization", "Basic " + authStr); 
		http.setRequestProperty("Content-Type", "application/json");
		http.connect();
		int respuesta = http.getResponseCode();
		http.disconnect();
		return respuesta;
	}
	
	//LQ: Agregado 10/16/2021
	public static int deleteJSONClientes(int id) throws IOException 
	{
		url = new URL(sitio+"clientes/eliminar/" + id);
		HttpURLConnection http;
		http = (HttpURLConnection)url.openConnection();
		String authStr = Base64.getEncoder().encodeToString(usuarioAPI.getBytes());
		try 
		{
			http.setRequestMethod("DELETE");
		} catch (ProtocolException e) 
		{
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		http.setDoOutput(true);
		http.setRequestProperty("Accept", "application/json");
		http.setRequestProperty("Authorization", "Basic " + authStr); 
		http.setRequestProperty("Content-Type", "application/json");
		http.connect();
		int respuesta = http.getResponseCode();
		http.disconnect();
		return respuesta;
	}
	
	
	
	
	
	public static int postJSONUsuarios(Usuarios usuario) throws IOException {
		System.out.println("Ingresó a TestJSON.PostJSONUsuarios");
		url = new URL(sitio+"usuarios/guardar");
		HttpURLConnection http;
		http = (HttpURLConnection)url.openConnection();
		String authStr = Base64.getEncoder().encodeToString(usuarioAPI.getBytes());
		try {
		http.setRequestMethod("POST");
		} catch (ProtocolException e) {
		e.printStackTrace();
		}
		http.setDoOutput(true);
		http.setRequestProperty("Accept", "application/json");
		http.setRequestProperty("Authorization", "Basic " + authStr); 
		http.setRequestProperty("Content-Type", "application/json");
		String data = "{"
		+ "\"cedula_usuario\":\""+ usuario.getCedula_usuario()
		+"\",\"nombre_usuario\":\""+usuario.getNombre_usuario()
		+"\",\"email_usuario\":\""+usuario.getEmail_usuario()
		+"\",\"usuario\":\""+usuario.getUsuario()
		+"\",\"password\":\""+usuario.getPassword()                       
		+ "\"}";
		System.out.println("Usuario a Guardar: " + data);
		byte[] out = data.getBytes(StandardCharsets.UTF_8);
		OutputStream stream = http.getOutputStream();
		stream.write(out);
		int respuesta = http.getResponseCode();
		http.disconnect();
		System.out.print(respuesta);
		return respuesta;
		}
	
	public static int putJSONUsuarios(Usuarios usuario) throws IOException {
		url = new URL(sitio+"usuarios/actualizar");
		HttpURLConnection http;
		http = (HttpURLConnection)url.openConnection();
		String authStr = Base64.getEncoder().encodeToString(usuarioAPI.getBytes());
		try {
		http.setRequestMethod("PUT");
		} catch (ProtocolException e) {
		e.printStackTrace();
		}
		http.setDoOutput(true);
		http.setRequestProperty("Accept", "application/json");
		http.setRequestProperty("Authorization", "Basic " + authStr); 
		http.setRequestProperty("Content-Type", "application/json");
		System.out.print("Pasé por aquí1");
		String data = "{"
				+ "\"cedula_usuario\":\""+ usuario.getCedula_usuario()
				+"\",\"nombre_usuario\":\""+usuario.getNombre_usuario()
				+"\",\"email_usuario\":\""+usuario.getEmail_usuario()
				+"\",\"usuario\":\""+usuario.getUsuario()
				+"\",\"password\":\""+usuario.getPassword()                       
				+ "\"}";
		System.out.print(data);
		byte[] out = data.getBytes(StandardCharsets.UTF_8);
		OutputStream stream = http.getOutputStream();
		stream.write(out);
		int respuesta = http.getResponseCode();
		http.disconnect();
		System.out.print("Pasé por aquí3");
		return respuesta;
		}
	
	public static int deleteJSONUsuarios(Long id) throws IOException 
	{
		System.out.println("Ingreso a TestJSON.deleteJSONUsuarios");
		url = new URL(sitio+"usuarios/eliminar/"+id);
		HttpURLConnection http;
		http = (HttpURLConnection)url.openConnection();
		String authStr = Base64.getEncoder().encodeToString(usuarioAPI.getBytes());
		try {
		http.setRequestMethod("DELETE");
		} catch (ProtocolException e) {
		e.printStackTrace();
		}
		http.setDoOutput(true);
		http.setRequestProperty("Accept", "application/json");
		http.setRequestProperty("Authorization", "Basic " + authStr); 
		http.setRequestProperty("Content-Type", "application/json");
		http.connect();
		int respuesta = http.getResponseCode();
		System.out.println("respuesta: " + respuesta);
		http.disconnect();
		return respuesta;
		}
	
	//TODO Metodos de Roles
	public static ArrayList<Roles> parsingRoles(String json) throws ParseException {
		JSONParser jsonParser = new JSONParser();
		ArrayList<Roles> lista = new ArrayList<Roles>();
		JSONArray roles = (JSONArray) jsonParser.parse(json);
		Iterator i = roles.iterator();
		while (i.hasNext()) {
		JSONObject innerObj = (JSONObject) i.next();
		Roles rol = new Roles();
		rol.setId_rol(Long.parseLong(innerObj.get("id_rol").toString()));
		rol.setDescripcion(innerObj.get("descripcion").toString());
		lista.add(rol);
		}
		return lista;
		}
	
	public static ArrayList<Roles> getJSONRoles() throws IOException, ParseException{
		url = new URL(sitio+"roles/listar");
		String authStr = Base64.getEncoder().encodeToString(usuarioAPI.getBytes());
		HttpURLConnection http = (HttpURLConnection)url.openConnection();
		http.setRequestMethod("GET");
		http.setRequestProperty("Accept", "application/json");
		http.setRequestProperty("Authorization", "Basic " + authStr); 
		InputStream respuesta = http.getInputStream();
		byte[] inp = respuesta.readAllBytes();
		String json = "";
		for (int i = 0; i<inp.length ; i++) {
		json += (char)inp[i];
		}
		ArrayList<Roles> lista = new ArrayList<Roles>();
		lista = parsingRoles(json);
		http.disconnect();
		return lista;
		}
	
	public static int postJSONRoles(Roles rol) throws IOException {
		url = new URL(sitio+"roles/guardar");
		HttpURLConnection http;
		http = (HttpURLConnection)url.openConnection();
		String authStr = Base64.getEncoder().encodeToString(usuarioAPI.getBytes());
		try {
		http.setRequestMethod("POST");
		} catch (ProtocolException e) {
		e.printStackTrace();
		}
		http.setDoOutput(true);
		http.setRequestProperty("Accept", "application/json");
		http.setRequestProperty("Authorization", "Basic " + authStr); 
		http.setRequestProperty("Content-Type", "application/json");
		String data = "{"
		+ "\"id_rol\":\""+ rol.getId_rol()
		+"\",\"descripcion\": \""+rol.getDescripcion()
		+ "\"}";
		byte[] out = data.getBytes(StandardCharsets.UTF_8);
		OutputStream stream = http.getOutputStream();
		stream.write(out);
		int respuesta = http.getResponseCode();
		http.disconnect();
		return respuesta;
		}
	public static int putJSONRoles(Roles rol) throws IOException {
		url = new URL(sitio+"roles/actualizar");
		HttpURLConnection http;
		http = (HttpURLConnection)url.openConnection();
		String authStr = Base64.getEncoder().encodeToString(usuarioAPI.getBytes());
		try {
		http.setRequestMethod("PUT");
		} catch (ProtocolException e) {
		e.printStackTrace();
		}
		http.setDoOutput(true);
		http.setRequestProperty("Accept", "application/json");
		http.setRequestProperty("Authorization", "Basic " + authStr); 
		http.setRequestProperty("Content-Type", "application/json");
		String data = "{"
				+ "\"id_rol\":\""+ rol.getId_rol()
				+"\",\"descripcion\": \""+rol.getDescripcion()
				+ "\"}";
		byte[] out = data.getBytes(StandardCharsets.UTF_8);
		OutputStream stream = http.getOutputStream();
		stream.write(out);
		int respuesta = http.getResponseCode();
		http.disconnect();
		return respuesta;
		}
	
	public static int deleteJSONRoles(Long id) throws IOException {
		url = new URL(sitio+"roles/eliminar/"+id);
		HttpURLConnection http;
		http = (HttpURLConnection)url.openConnection();
		String authStr = Base64.getEncoder().encodeToString(usuarioAPI.getBytes());
		try {
		http.setRequestMethod("DELETE");
		} catch (ProtocolException e) {
		e.printStackTrace();
		}
		http.setDoOutput(true);
		http.setRequestProperty("Accept", "application/json");
		http.setRequestProperty("Authorization", "Basic " + authStr); 
		http.setRequestProperty("Content-Type", "application/json");
		http.connect();
		int respuesta = http.getResponseCode();
		http.disconnect();
		return respuesta;
		}
	
}
