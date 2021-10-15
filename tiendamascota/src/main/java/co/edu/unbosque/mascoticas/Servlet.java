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
		String listar_rol = request.getParameter("ListarRoles");
		String agregar_rol = request.getParameter("AgregarRol");
		String actualizar_rol = request.getParameter("ActualizarRol");
		String eliminar_rol = request.getParameter("EliminarRol");
		String listar_usu = request.getParameter("ListarUsuarios");
		String agregar_usu = request.getParameter("AgregarUsuario");
		String actualizar_usu = request.getParameter("ActualizarUsuario");
		String eliminar_usu = request.getParameter("EliminarUsuario");
		//Login
		if (login != null) {
			try {
				System.out.println("Ingresó a la acción");
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
		if (agregar_usu != null) {
			agregarUsuario(request, response);
		}
		if (actualizar_usu != null) {
			actualizarUsuario(request, response);
		}
		if (eliminar_usu != null) {
			eliminarUsuario(request, response);
		}
		//Roles	
		if (listar_rol != null) {
			try {
				listarRoles(request, response);
			} catch (ParseException | ServletException e) {
				e.printStackTrace();
			}
		}
		if (agregar_rol != null) {
			agregarRol(request, response);
		}
		if (actualizar_rol != null) {
			actualizarRol(request, response);
		}
		if (eliminar_rol != null) {
			eliminarRol(request, response);
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
			String pagina = "/menu_ppal.jsp";
			String login="/inicio.jsp";
			for (Usuarios usuario : lista) {
				Long usuariologin = usuario.getCedula_usuario() ;
				String passwordlogin = usuario.getPassword();
				if (usuariologin==(Long.parseLong(request.getParameter("txtUsuario")))&& passwordlogin.equals(request.getParameter("txtPassword"))) {
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
		usuario.setCelular_usuario(request.getParameter("celular"));
		usuario.setPassword(request.getParameter("password"));
		rol.setId_rol(Long.parseLong(request.getParameter("rol_usuario")));
		usuario.setRol(rol);
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
		usuario.setCelular_usuario(request.getParameter("celular"));
		usuario.setPassword(request.getParameter("password"));
		rol.setId_rol(Long.parseLong(request.getParameter("rol_usuario")));
		usuario.setRol(rol);
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
