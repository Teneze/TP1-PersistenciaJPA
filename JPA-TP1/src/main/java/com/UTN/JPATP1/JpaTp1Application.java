package com.UTN.JPATP1;

import com.UTN.JPATP1.entidades.*;
import com.UTN.JPATP1.enumeraciones.EstadoPedido;
import com.UTN.JPATP1.enumeraciones.FormaPago;
import com.UTN.JPATP1.enumeraciones.TipoEnvio;
import com.UTN.JPATP1.enumeraciones.TipoProducto;
import com.UTN.JPATP1.repositorios.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootApplication
public class JpaTp1Application {
	@Autowired
	ClienteRepository clienteRepository;
	@Autowired
	RubroRepository rubroRepository;


	public static void main(String[] args) {
		SpringApplication.run(JpaTp1Application.class, args);

		System.out.println("Estoy funcionando bro");






	}
//----------------------------------------------------------------------------------------------------------------------
	@Bean
	CommandLineRunner init(ClienteRepository clienteRepo, RubroRepository rubroRepo) {
		return args -> {
			System.out.println("----------APARENTEMENTEEEEE--------");
			//Creamos objeto rubro
			Rubro rubro1 = Rubro.builder()
					.denominacion("Lomos")
					.build();
			//Creamos objetos de producto
			Producto producto1 = Producto.builder()
					.tipoProducto(TipoProducto.Insumo)
					.tiempoEstimadoCocina(40)
					.denominacion("lomo con champiñones")
					.precioVenta(2199)
					.precioCompra(1100)
					.stockActual(560)
					.stockMinimo(4)
					.unidadMedida("unidad1")
					.receta("receta1")
					.build();
			Producto producto2 = Producto.builder()
					.tipoProducto(TipoProducto.Insumo)
					.tiempoEstimadoCocina(60)
					.denominacion("Pizzalomo")
					.precioVenta(4999)
					.precioCompra(2000)
					.stockActual(60)
					.stockMinimo(4)
					.unidadMedida("unidad2")
					.receta("receta2")
					.build();

			//Agregamos productos al rubro
			rubro1.agregarProducto(producto1);
			rubro1.agregarProducto(producto2);

			//Guardamos el rubro
			rubroRepository.save(rubro1);

			//Creamos un objeto de Cliente
			Cliente cliente = Cliente.builder()
					.nombre("Pepe")
					.apellido("Hongo")
					.telefono("2615734823")
					.email("pepehonguito@gmail.com")
					.build();

			//Creamos objetos de Domicilio
			Domicilio domicilio1 = Domicilio.builder()
					.calle("Basaltar")
					.numero("308")
					.localidad("Lujan de Cuyo")
					.build();
			Domicilio domicilio2 = Domicilio.builder()
					.calle("San Martín")
					.numero("206")
					.localidad("Maipu")
					.build();

			//Agregamos los domicilios al cliente
			cliente.agregarDomicilio(domicilio1);
			cliente.agregarDomicilio(domicilio2);

			//Creamos objetos DetallePedido
			DetallePedido detallePedido1 = DetallePedido.builder()
					.cantidad(2)
					.subtotal(6200)
					.build();

			DetallePedido detallePedido2 = DetallePedido.builder()
					.cantidad(3)
					.subtotal(3200)
					.build();

			DetallePedido detallePedido3 = DetallePedido.builder()
					.cantidad(1)
					.subtotal(3000)
					.build();

			//Realizamos la configuración de la fecha a travez de SimpleDateFormat
			SimpleDateFormat formatoFecha = new SimpleDateFormat ("yyyy-MM-dd");
			String fechaString = "2023-02-15";

			// Parsear la cadena en un objeto Date
			Date fecha = formatoFecha.parse(fechaString);

			//Creamos objetos Pedido
			Pedido pedido1 = Pedido.builder()
					.estadoPedido(EstadoPedido.Entregado)
					.fecha(fecha)
					.tipoEnvio(TipoEnvio.Delivery)
					.total(4600)
					.build();

			Pedido pedido2 = Pedido.builder()
					.estadoPedido(EstadoPedido.Preparacion)
					.fecha(fecha)
					.tipoEnvio(TipoEnvio.Delivery)
					.total(3000)
					.build();

			//Creamos objetos de factura
			Factura factura1 = Factura.builder()
					.numero(1)
					.fecha(fecha)
					.descuento(0)
					.formaPago(FormaPago.Efectivo)
					.total(5800)
					.build();

			Factura factura2 = Factura.builder()
					.numero(2)
					.fecha(fecha)
					.descuento(400)
					.formaPago(FormaPago.Efectivo)
					.total(6000)
					.build();

			//Agregamos los detalles al pedido
			pedido1.agregarDetallePedido(detallePedido1);
			pedido1.agregarDetallePedido(detallePedido2);
			pedido2.agregarDetallePedido(detallePedido3);

			//Agregamos los pedidos al cliente
			cliente.agregarPedido(pedido1);
			cliente.agregarPedido(pedido2);

			//vinculamos el detallePedido con el producto
			detallePedido1.setProducto(producto1);
			detallePedido2.setProducto(producto2);
			detallePedido3.setProducto(producto1);

			//Vinculamos factura con el pedido
			pedido1.setFactura(factura1);
			pedido2.setFactura(factura2);

			//Guardamos al cliente
			clienteRepository.save(cliente);

			//Recuperamos el objeto rubro desde la base de datos
			Rubro rubroRecuperado = rubroRepository.findById(rubro1.getId()).orElse(null);
			if (rubroRecuperado != null){
				System.out.println("Denominacion: " + rubroRecuperado.getDenominacion());
				rubroRecuperado.mostrarProductos();
			}
			//Recuperamos al Cliente desde la base de Datos
			Cliente clienteRecuperado = clienteRepository.findById(cliente.getId()).orElse(null);
			if (clienteRecuperado != null){
				System.out.println("Nombre: " + clienteRecuperado.getNombre());
				System.out.println("Apellido: " + clienteRecuperado.getApellido());
				System.out.println("Email: " + clienteRecuperado.getEmail());
				System.out.println("Telefono: " + clienteRecuperado.getTelefono());
				clienteRecuperado.mostrarDomicilios();
				clienteRecuperado.mostrarPedidos();



		}
		};
	}

}




