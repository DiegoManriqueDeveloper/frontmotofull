package co.edu.unbosque.mascoticas;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.parser.ParseException;


/**
 * Servlet implementation class Servlet
 */
@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		//Los parametros son de los nombres de los botones del html
		System.out.println("Llegó a doGet");
		String login = request.getParameter("validacionLogin");
		System.out.println("variable : "+ login);
		String listar_usu = request.getParameter("ListarUsuarios");
		String agregar_usu = request.getParameter("AgregarUsuario");
		String actualizar_usu = request.getParameter("ActualizarUsuario");
		String eliminar_usu = request.getParameter("EliminarUsuario");
		//LQ: Agregado 16/10/2021
		String listarClientes = request.getParameter("ListarClientes");
		String agregarCliente = request.getParameter("AgregarCliente");
		String actualizarCliente = request.getParameter("ActualizarCliente");
		String eliminarCliente = request.getParameter("EliminarCliente");
		
		//LQ
		
		System.out.println("Request Seleccionado: " + listarClientes);
		//Login
		if (login != null) {
			try {
				//System.out.println("Ingresó a la acción");
				validacionLogin(request, response);
			} catch (ParseException | ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//Usuarios
		if (listar_usu != null) {
			try {
				listarUsuarios(request, response);
			} catch (ParseException | ServletException e) {
				e.printStackTrace();
			}
		}
		
		if (agregar_usu != null) 
		{
			agregarUsuario(request, response);
		}
		
		if (actualizar_usu != null) {
			actualizarUsuario(request, response);
		}
		
		if (eliminar_usu != null) {
			eliminarUsuario(request, response);
		}
		// eliminacion de roles4
		
		if (listarClientes != null)
		{
			try 
			{
				listarClientes(request, response);
			} 
			catch (ParseException | ServletException e) 
			{
				e.printStackTrace();
				System.out.println(e.getMessage());
			}
		}
		
		if (agregarCliente != null)
		{
			agregarCliente(request, response);
		}
		
		if (actualizarCliente != null) 
		{
			actualizarCliente(request, response);
		}
		
		if (eliminarCliente != null) 
		{
			eliminarCliente(request, response);
		}
	}
	
	
	public void eliminarCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		System.out.println("Ingresó a Servlet.eliminarCliente");
		int respuesta = 0;
		try{
			int Id = 0;
			Id = Integer.parseInt(request.getParameter("cedula_cliente").toString()) ;
			respuesta=TestJSON.deleteJSONClientes ((Id));
			PrintWriter writer = response.getWriter();
			if (respuesta == 200) {
				String pagina = "/operacion_ok.jsp";
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
				dispatcher.forward(request, response);
			}else {
				String pagina = "/operacion_no.jsp";
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
				dispatcher.forward(request, response);
			}
			writer.close();
		}catch (IOException e){
			e.printStackTrace();
		}
	}

	//LQ: Agregado 16/10/2021
	public void actualizarCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		Clientes cliente = new Clientes();
		System.out.println("Ingresó a Servlet.ActualizarCliente:");
		//Los parametros son de los txt del html
		cliente.setCedula_cliente(Long.parseLong(request.getParameter("cedula_cliente")));
		cliente.setNombre_cliente(request.getParameter("nombre_cliente"));
		cliente.setEmail_cliente(request.getParameter("email_cliente"));
		cliente.setDireccion_cliente(request.getParameter("direccion_cliente"));
		cliente.setTelefono_cliente(request.getParameter("telefono_cliente"));
		
		int respuesta = 0;
		try{
			respuesta=TestJSON.putJSONClientes(cliente);
			PrintWriter writer = response.getWriter();
			if (respuesta == 200) {
				String pagina = "/operacion_ok.jsp";
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
				dispatcher.forward(request, response);
			}else {
				String pagina = "/operacion_no.jsp";
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
				dispatcher.forward(request, response);
			}
		}catch (IOException e){
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
	
	//LQ: Agregado 16/10/2021
	public void agregarCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		
		System.out.println("Ingreso a Servlet.agregarCliente");
		Clientes cliente = new Clientes();
		
		cliente.setCedula_cliente(Long.parseLong(request.getParameter("cedula_cliente")));
		cliente.setNombre_cliente(request.getParameter("nombre_cliente"));
		cliente.setEmail_cliente(request.getParameter("email_cliente"));
		cliente.setDireccion_cliente(request.getParameter("direccion_cliente"));
		cliente.setTelefono_cliente(request.getParameter("telefono_cliente"));
		System.out.println("Datos del cliente: " + cliente.getNombre_cliente());
		int respuesta = 0;
		try{
			respuesta=TestJSON.postJSONClientes(cliente);
			System.out.println("respuesta de testJson.postJSONClientes: " + respuesta);
			PrintWriter writer = response.getWriter();
			if (respuesta == 200) {
				String pagina = "/operacion_ok.jsp";
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
				dispatcher.forward(request, response);
			}else {
				String pagina = "/operacion_no.jsp";
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
				dispatcher.forward(request, response);
			}
			writer.close();
		}catch (IOException e)
		{
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
	
	
	public void listarClientes(HttpServletRequest request, HttpServletResponse response) throws ParseException, ServletException 
	{
		try 
		{
			System.out.println("Ingresó a Servlet.listarClientes");
			ArrayList<Clientes> lista = TestJSON.getJSONClientes();
			String pagina = "/resultado_clientes.jsp";
			request.setAttribute("listaClientes", lista);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
			dispatcher.forward(request, response);
		}catch(IOException e){
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
	
	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	public void validacionLogin(HttpServletRequest request, HttpServletResponse response) throws ParseException, ServletException {
		try {
			ArrayList<Usuarios> lista = TestJSON.getJSONUsuarios();
			System.out.println("Trajó datos del API");
			String pagina = "/principal.jsp";
			String login="/inicio.jsp";
			for (Usuarios usuario : lista) 
			{
				String usuariologin = usuario.getUsuario() ;
				String passwordlogin = usuario.getPassword();
				
				String Usuario = request.getParameter("txtUsuario");
				String Pass = request.getParameter("txtPassword");
				
				System.out.println("Datos API: Usuario: "+ usuariologin + " Pass: " + passwordlogin);
				
				System.out.println("Datos Form: Usuario: "+ Usuario + " Pass: " + Pass);
				
				System.out.println(usuariologin.equals(Usuario.trim()) );
				System.out.println(passwordlogin.equals(Pass.trim()) );
				
				if (usuariologin.equals(Usuario.trim()) && passwordlogin.equals(Pass.trim())) 
				{
					System.out.println("Encontró usuario");
					RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
					dispatcher.forward(request, response);
				}
			}
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(login);
			dispatcher.forward(request, response);	
			}catch(IOException e){
				e.printStackTrace();
				}
		}

	
	//TODO Metodos de Usuarios
	public void listarUsuarios(HttpServletRequest request, HttpServletResponse response) throws ParseException, ServletException {
		try {
			ArrayList<Usuarios> lista = TestJSON.getJSONUsuarios();
			String pagina = "/resultado_usuarios.jsp";
			request.setAttribute("lista", lista);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
			dispatcher.forward(request, response);
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public void agregarUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		Usuarios usuario = new Usuarios();
		Roles rol = new Roles();
		usuario.setCedula_usuario(Long.parseLong(request.getParameter("cedula")));
		usuario.setNombre_usuario(request.getParameter("nombre"));
		usuario.setEmail_usuario(request.getParameter("email"));
		usuario.setUsuario(request.getParameter("Usuario"));
		usuario.setPassword(request.getParameter("password"));
		//rol.setId_rol(Long.parseLong(request.getParameter("rol_usuario")));
		//usuario.setRol(rol);
		int respuesta = 0;
		try{
			respuesta=TestJSON.postJSONUsuarios(usuario);
			PrintWriter writer = response.getWriter();
			if (respuesta == 200) {
				String pagina = "/operacion_ok.jsp";
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
				dispatcher.forward(request, response);
			}else {
				String pagina = "/operacion_no.jsp";
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
				dispatcher.forward(request, response);
			}
			writer.close();
		}catch (IOException e){
			e.printStackTrace();
		}
	}
	
	public void actualizarUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		Usuarios usuario = new Usuarios();
		Roles rol = new Roles();
		//Los parametros son de los txt del html
		usuario.setCedula_usuario(Long.parseLong(request.getParameter("cedula")));
		usuario.setNombre_usuario(request.getParameter("nombre"));
		usuario.setEmail_usuario(request.getParameter("email"));
		usuario.setUsuario(request.getParameter("Usuario"));
		usuario.setPassword(request.getParameter("password"));
		//rol.setId_rol(Long.parseLong(request.getParameter("rol_usuario")));
		//usuario.setRol(rol);
		int respuesta = 0;
		try{
			respuesta=TestJSON.putJSONUsuarios(usuario);
			PrintWriter writer = response.getWriter();
			if (respuesta == 200) {
				String pagina = "/operacion_ok.jsp";
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
				dispatcher.forward(request, response);
			}else {
				String pagina = "/operacion_no.jsp";
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
				dispatcher.forward(request, response);
			}
		}catch (IOException e){
			e.printStackTrace();
		}
	}
	
	public void eliminarUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		int respuesta = 0;
		try{
			respuesta=TestJSON.deleteJSONUsuarios(Long.parseLong(request.getParameter("cedula")));
			PrintWriter writer = response.getWriter();
			if (respuesta == 200) {
				String pagina = "/operacion_ok.jsp";
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
				dispatcher.forward(request, response);
			}else {
				String pagina = "/operacion_no.jsp";
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
				dispatcher.forward(request, response);
			}
			writer.close();
		}catch (IOException e){
			e.printStackTrace();
		}
	}
	
	//TODO Metodos de Roles
	public void listarRoles(HttpServletRequest request, HttpServletResponse response) throws ParseException, ServletException {
		try {
			ArrayList<Roles> lista = TestJSON.getJSONRoles();
			String pagina = "/resultado_roles.jsp";
			request.setAttribute("lista", lista);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
			dispatcher.forward(request, response);
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	public void agregarRol(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		Roles rol = new Roles();
		rol.setId_rol(Long.parseLong(request.getParameter("id_rol")));
		rol.setDescripcion(request.getParameter("nombre_rol"));
		int respuesta = 0;
		try{
			respuesta=TestJSON.postJSONRoles(rol);
			PrintWriter writer = response.getWriter();
			if (respuesta == 200) {
				String pagina = "/operacion_ok.jsp";
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
				dispatcher.forward(request, response);
			}else {
				String pagina = "/operacion_no.jsp";
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
				dispatcher.forward(request, response);
			}
			writer.close();
		}catch (IOException e){
			e.printStackTrace();
		}
	}
	public void actualizarRol(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		Roles rol = new Roles();
		//Los parametros son de los txt del html
		rol.setId_rol(Long.parseLong(request.getParameter("id_rol")));
		rol.setDescripcion(request.getParameter("nombre_rol"));
		int respuesta = 0;
		try{
			respuesta=TestJSON.putJSONRoles(rol);
			PrintWriter writer = response.getWriter();
			if (respuesta == 200) {
				
				String pagina = "/operacion_ok.jsp";
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
				dispatcher.forward(request, response);
			}else {
				String pagina = "/operacion_no.jsp";
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
				dispatcher.forward(request, response);
			}
			writer.close();
		}catch (IOException e){
			e.printStackTrace();
		}
	}
	public void eliminarRol(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		int respuesta = 0;
		try{
			//En parametro se envía el nombre del cuadro de texto del html
			respuesta=TestJSON.deleteJSONRoles(Long.parseLong(request.getParameter("id_rol")));
			PrintWriter writer = response.getWriter();
			if (respuesta == 200) {
				String pagina = "/operacion_ok.jsp";
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
				dispatcher.forward(request, response);
			}else {
				String pagina = "/operacion_no.jsp";
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
				dispatcher.forward(request, response);
			}
			writer.close();
		}catch (IOException e){
			e.printStackTrace();
		}
	}
	
}
