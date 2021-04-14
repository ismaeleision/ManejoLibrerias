package ejercicio3;

public class ClienteNoRegistrado extends Cliente {

	public ClienteNoRegistrado(String nombre, String apellidos, String dni, String localidad, String direccion) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;
		this.localidad = localidad;
		this.direccion = direccion;
	}
	
	@Override
	public double descuento() {
		return 0;
	}
}
