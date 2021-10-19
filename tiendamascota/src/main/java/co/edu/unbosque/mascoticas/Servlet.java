package co.edu.unbosque.mascoticas;

import java.io.File;
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

import com.opencsv.exceptions.CsvValidationException;


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
		//LQ: Agregado 17/10/2021
		String listarProveedores = request.getParameter("ListarProveedores");
		String agregarProveedores = request.getParameter("AgregarProveedores");
		String actualizarProveedores = request.getParameter("ActualizarProveedores");
		String eliminarProveedores = request.getParameter("EliminarProveedores");
		
		String listarProductos = request.getParameter("ListarProductos");
		String agregarProductos = request.getParameter("AgregarProductos");
		String actualizarProductos = request.getParameter("ActualizarProductos");
		String eliminarProductos = request.getParameter("EliminarProductos");
		
		String crearVenta = request.getParameter("CrearVenta");
		
		
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
		
		//Agregado 17/10/2021
		if (agregarProveedores != null)
		{
			agregarProveedores(request, response);
		}
		if (actualizarProveedores != null) 
		{
			actualizarProveedores(request, response);
		}
		
		if (eliminarProveedores != null) 
		{
			eliminarProveedores(request, response);
		}
		if (listarProveedores != null)
		{
			try 
			{
				listarProveedores(request, response);
			} 
			catch (ParseException | ServletException e) 
			{
				e.printStackTrace();
				System.out.println(e.getMessage());
			}
		}
		
		
		if (agregarProductos != null)
		{
			agregarProductos(request, response);
		}
		if (actualizarProductos != null) 
		{
			actualizarProductos(request, response);
		}
		
		if (eliminarProductos != null) 
		{
			eliminarProductos(request, response);
		}
		if (listarProductos != null)
		{
			try 
			{
				listarProductos(request, response);
			} 
			catch (ParseException | ServletException e) 
			{
				e.printStackTrace();
				System.out.println(e.getMessage());
			}
		}
		
		if(crearVenta != null)
		{
			crearVenta(request, response);
		}
		
		
	}
	
	//LQ: Agregado 18/10/2021
	public void crearVenta(HttpServletRequest request, HttpServletResponse response) throws ServletException 
	{
		
		System.out.println("Ingreso a Servlet.crearVenta");
		Ventas ventas = new Ventas();
		DetalleVentas detalleVentas1 = new DetalleVentas();
		DetalleVentas detalleVentas2 = new DetalleVentas();
		DetalleVentas detalleVentas3 = new DetalleVentas();
		DetalleVentas detalleVentas4 = new DetalleVentas();
		
		Clientes cliente = new Clientes();
		Usuarios usuario = new Usuarios();
		
		//Solo es necesario cargar la llavel del Cliente
		cliente.setCedula_cliente(Long.parseLong(request.getParameter("cedula_cliente")));
		ventas.setCliente(cliente);
		//END CLIENTE
		//Solo es necesario cargar la llave del Usuario, TODO: Hay que traerla de ???
		usuario.setCedula_usuario(74752863);// TODO: Esta quemada la llave
		ventas.setUsuarios(usuario);
		
		
		ventas.setCodigo_venta(Long.parseLong(request.getParameter("codigo_venta")));
		ventas.setFecha_creacion("18/10/2021");
		ventas.setIvaventa(19);
		
		ventas.setTotal_venta(100100);
		ventas.setValor_venta(100101);
				
		System.out.println("Datos de Venta: " + ventas.getCodigo_venta());
		  
		
		//Cargamos el producto 1
		detalleVentas1.setCantidad_producto(Integer.parseInt(request.getParameter("cantidad1")));
		//detalleVentas1.setCodigo_detalle_venta(serialVersionUID); //TODO: no cargar volver autoincremental
		Productos producto1 = new Productos();
		producto1.setCodigo_producto(Integer.parseInt(request.getParameter("codigo_producto1")));
		detalleVentas1.setProductos(producto1);
		detalleVentas1.setValor_total(Double.parseDouble(request.getParameter("valor_total1")));
		detalleVentas1.setValor_venta(Double.parseDouble(request.getParameter("valor_venta1")));
		detalleVentas1.setValoriva(19);
		detalleVentas1.setVentas(ventas);
		
		//Cargamos el producto 2
		detalleVentas2.setCantidad_producto(Integer.parseInt(request.getParameter("cantidad2")));
		//detalleVentas2.setCodigo_detalle_venta(serialVersionUID); //TODO: no cargar volver autoincremental
		Productos producto2 = new Productos();
		producto2.setCodigo_producto(Integer.parseInt(request.getParameter("codigo_producto2")));
		detalleVentas2.setProductos(producto2);
		detalleVentas2.setValor_total(Double.parseDouble(request.getParameter("valor_total2")));
		detalleVentas2.setValor_venta(Double.parseDouble(request.getParameter("valor_venta2")));
		detalleVentas2.setValoriva(19);
		detalleVentas2.setVentas(ventas);
		
		//Cargamos el producto 3
		detalleVentas3.setCantidad_producto(Integer.parseInt(request.getParameter("cantidad3")));
		//detalleVentas3.setCodigo_detalle_venta(serialVersionUID); //TODO: no cargar volver autoincremental
		Productos producto3 = new Productos();
		producto3.setCodigo_producto(Integer.parseInt(request.getParameter("codigo_producto3")));
		detalleVentas3.setProductos(producto2);
		detalleVentas3.setValor_total(Double.parseDouble(request.getParameter("valor_total3")));
		detalleVentas3.setValor_venta(Double.parseDouble(request.getParameter("valor_venta3")));
		detalleVentas3.setValoriva(19);
		detalleVentas3.setVentas(ventas);


		//Cargamos el producto 3
		detalleVentas4.setCantidad_producto(Integer.parseInt(request.getParameter("cantidad4")));
		//detalleVentas4.setCodigo_detalle_venta(serialVersionUID); //TODO: no cargar volver autoincremental
		Productos producto4 = new Productos();
		producto4.setCodigo_producto(Integer.parseInt(request.getParameter("codigo_producto4")));
		detalleVentas4.setProductos(producto2);
		detalleVentas4.setValor_total(Double.parseDouble(request.getParameter("valor_total4")));
		detalleVentas4.setValor_venta(Double.parseDouble(request.getParameter("valor_venta4")));
		detalleVentas4.setValoriva(19);
		detalleVentas4.setVentas(ventas);

		System.out.println("Se cargaron al objeto los detalles de las ventas");
		
		
		int respuesta = 0;
		try{
			//Mandamos a guardar las ventas, si todo sale bien se debe mandar a guardar el detalle de la venta
			respuesta=TestJSON.postJSONVentas(ventas);
			System.out.println("respuesta de testJson.postJSONClientes: " + respuesta);
			PrintWriter writer = response.getWriter();
			if (respuesta == 200) {
				
				//Si llegó hasta aquí la venta se debe enviar los detalles:
				int respuestaDetalle =0;
				respuestaDetalle = TestJSON.postJSONDetalleVentas(detalleVentas1);
				System.out.println("Guardar Detalle1");
				respuestaDetalle = TestJSON.postJSONDetalleVentas(detalleVentas2);
				System.out.println("Guardar Detalle2");
				respuestaDetalle = TestJSON.postJSONDetalleVentas(detalleVentas3);
				System.out.println("Guardar Detalle3");
				respuestaDetalle = TestJSON.postJSONDetalleVentas(detalleVentas4);
				System.out.println("Guardar Detalle4");
				
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
	
	
	
	
	//LQ: Agregado 17/10/2021
	public void agregarProveedores(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		
		System.out.println("Ingreso a Servlet.agregarProveedores");
		Proveedores proveedor = new Proveedores();
		
		proveedor.setNit_proveedor(Long.parseLong(request.getParameter("nit_proveedor")));
		proveedor.setNombre_proveedor(request.getParameter("nombre_proveedor"));
		proveedor.setCiudad_proveedor(request.getParameter("ciudad_proveedor"));
		proveedor.setDireccion_proveedor(request.getParameter("direccion_proveedor"));
		proveedor.setTelefono_proveedor(request.getParameter("telefono_proveedor"));
		System.out.println("Datos del proveedor: " + proveedor.getNombre_proveedor());
		int respuesta = 0;
		try{
			respuesta=TestJSON.postJSONProveedores(proveedor);
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
	
	public void agregarProductos(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		
		System.out.println("Ingreso a Servlet.agregarProductos");
		Productos producto = new Productos();
		Proveedores proveedor = new Proveedores();
		
		producto.setCodigo_producto(Long.parseLong(request.getParameter("codigo_producto")));
		producto.setNombre_producto(request.getParameter("nombre_producto"));
		producto.setPrecio_venta(Double.parseDouble(request.getParameter("precio_venta")));
		producto.setPrecio_compra(Double.parseDouble(request.getParameter("precio_compra")));
		producto.setExistencia(Double.parseDouble(request.getParameter("existencia")));
		producto.setIvacompra(Double.parseDouble(request.getParameter("ivacompra")));
		
		//Agregamos el proveedor
		proveedor.setNit_proveedor(Long.parseLong(request.getParameter("nit_proveedor")));
		producto.setProveedores(proveedor);
		System.out.println("Datos del producto: " + producto.getNombre_producto());
		int respuesta = 0;
		try{
			respuesta=TestJSON.postJSONProductos(producto);
			System.out.println("respuesta de testJson.postJSONProductos: " + respuesta);
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
	
		
		
	//LQ: Agregado 17/10/2021
	public void actualizarProveedores(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		Proveedores proveedor = new Proveedores();
		System.out.println("Ingresó a Servlet.ActualizarProveedor:");
		//Los parametros son de los txt del html
		proveedor.setNit_proveedor(Long.parseLong(request.getParameter("nit_proveedor")));
		proveedor.setNombre_proveedor(request.getParameter("nombre_proveedor"));
		proveedor.setCiudad_proveedor(request.getParameter("ciudad_proveedor"));
		proveedor.setDireccion_proveedor(request.getParameter("direccion_proveedor"));
		proveedor.setTelefono_proveedor(request.getParameter("telefono_proveedor"));
		System.out.println("Datos del proveedor: " + proveedor.getNombre_proveedor());
		int respuesta = 0;
		try{
			respuesta=TestJSON.putJSONProveedores(proveedor);
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
	
	//LQ: Agregado 17/10/2021
	public void actualizarProductos(HttpServletRequest request, HttpServletResponse response) throws ServletException 
	{
		Productos producto = new Productos();
		System.out.println("Ingresó a Servlet.ActualizarProveedor:");
		//Los parametros son de los txt del html
		producto.setCodigo_producto(Long.parseLong(request.getParameter("codigo_producto")));
		producto.setNombre_producto(request.getParameter("nombre_producto"));
		producto.setPrecio_venta(Double.parseDouble(request.getParameter("precio_venta")));
		producto.setPrecio_compra(Double.parseDouble(request.getParameter("precio_compra")));
		producto.setExistencia(Double.parseDouble(request.getParameter("existencia")));
		producto.setIvacompra(Double.parseDouble(request.getParameter("ivacompra")));
		System.out.println("Datos del producto: " + producto.getNombre_producto());
		int respuesta = 0;
		try{
			respuesta=TestJSON.putJSONProductos(producto);
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
	
	
	//LQ: Agregado 17/10/2021
		public void eliminarProductos(HttpServletRequest request, HttpServletResponse response) throws ServletException 
		{
			System.out.println("Ingresó a Servlet.eliminarProductos");
			int respuesta = 0;
			try{
				int Id = 0;
				Id = Integer.parseInt(request.getParameter("codigo_producto").toString()) ;
				respuesta=TestJSON.deleteJSONProductos ((Id));
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
	
	//LQ: Agregado 17/10/2021
	public void eliminarProveedores(HttpServletRequest request, HttpServletResponse response) throws ServletException 
	{
		System.out.println("Ingresó a Servlet.eliminarProveedor");
		int respuesta = 0;
		try{
			int Id = 0;
			Id = Integer.parseInt(request.getParameter("nit_proveedor").toString()) ;
			respuesta=TestJSON.deleteJSONProveedores ((Id));
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
		
	
	//LQ: Agregado 17/10/2021
	public void listarProductos(HttpServletRequest request, HttpServletResponse response) throws ParseException, ServletException 
	{
		try 
		{
			System.out.println("Ingresó a Servlet.listarProductos");
			ArrayList<Productos> lista = TestJSON.getJSONProductos();
			String pagina = "/resultado_productos.jsp";
			request.setAttribute("listaProductos", lista);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
			dispatcher.forward(request, response);
		}catch(IOException e){
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
	
	//LQ: Agregado 17/10/2021
	public void listarProveedores(HttpServletRequest request, HttpServletResponse response) throws ParseException, ServletException 
	{
		try 
		{
			System.out.println("Ingresó a Servlet.listarProveedores");
			ArrayList<Proveedores> lista = TestJSON.getJSONProveedores();
			String pagina = "/resultado_proveedores.jsp";
			request.setAttribute("listaProveedores", lista);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
			dispatcher.forward(request, response);
		}catch(IOException e){
			e.printStackTrace();
			System.out.println(e.getMessage());
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
		System.out.println("Ingresó a Servlet.agregarUsuario");
		Usuarios usuario = new Usuarios();
		
		usuario.setCedula_usuario(Long.parseLong(request.getParameter("cedula")));
		usuario.setNombre_usuario(request.getParameter("nombre"));
		usuario.setEmail_usuario(request.getParameter("email"));
		usuario.setUsuario(request.getParameter("usuario"));
		usuario.setPassword(request.getParameter("password"));
		System.out.println("Nombre Usuario a Guardar: " + usuario.getUsuario());
		int respuesta = 0;
		try{
			respuesta=TestJSON.postJSONUsuarios(usuario);
			PrintWriter writer = response.getWriter();
			System.out.println("Respuesta: " + respuesta);
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
		usuario.setUsuario(request.getParameter("usuario"));
		usuario.setPassword(request.getParameter("password"));
		
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
