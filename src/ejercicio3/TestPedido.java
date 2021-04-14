package ejercicio3;

import java.time.LocalDateTime;

public class TestPedido {

	public static void main(String[] args) throws Exception {
		
		Categoria carne = new Categoria("carne");
		Categoria pescado = new Categoria("pescado");
		Categoria panaderia = new Categoria("panaderia");
		
		//precio*kilo
		Producto filete = new Producto("filete", "ternera", carne, 15.99, 1.21);
		Producto salmon = new Producto("salmon", "crianza", pescado, 8, 1.16);
		Producto sardina = new Producto("sardina", "salvaje", pescado, 7.5, 1.21);
		Producto lomo = new Producto("lomo", "cerdo", carne, 8.30, 1.15);
		Producto higado = new Producto("higado", "cerdo", carne, 3.80, 1.10);
		Producto panPueblo = new Producto("Pan de Pueblo", "leña", panaderia, 2.5, 1.2);
		Producto ensaimada = new Producto("ensaimada", "dulce", panaderia, 0.8, 1.3);//precio/unidad
		
		Pedido pedido = new Pedido();
		
		pedido.nuevaLinea(new LineaPedido(filete, 6));
		pedido.nuevaLinea(new LineaPedido(sardina, 10));
		pedido.nuevaLinea(new LineaPedido(panPueblo, 8));
		pedido.nuevaLinea(new LineaPedido(higado, 9));
		pedido.nuevaLinea(new LineaPedido(ensaimada, 25));
		
		ClienteRegistrado cliente = new ClienteRegistrado("Pablo", "Muñoz", "32165487T", "almeria", "c/Muñoz Mendez", 
				"Pablo_Muñoz@yahoo.us", "1234", LocalDateTime.parse("2021-04-04T11:53:11.418257200"));
		
		pedido.setCliente(cliente);
		
		pedido.toPDF();
		
		System.out.println(pedido);
	}
}
