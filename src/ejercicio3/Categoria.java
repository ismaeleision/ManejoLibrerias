package ejercicio3;

public class Categoria {

	private String nombre;

	public Categoria(String nombre) {
		super();
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Categoria [nombre=");
		builder.append(nombre);
		builder.append("]");
		return builder.toString();
	}
}
