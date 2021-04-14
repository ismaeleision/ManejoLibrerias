package ejercicio3;

public class Producto {

	private String codigo;
	private String nombre;
	private String descripcion;
	private Categoria categoria;
	protected double precio;
	protected double iva;
	
	/**
	 * 
	 * @param codigo
	 * @param nombre
	 * @param descripcion
	 * @param categoria
	 * @param precio
	 * @param iva
	 */
	public Producto(String nombre, String descripcion, Categoria categoria, double precio, double iva) {
		super();
		this.nombre = nombre;
		this.codigo = generarCodigo();
		this.descripcion = descripcion;
		this.categoria = categoria;
		this.precio = precio;
		this.iva = iva;
	}
	
	public String generarCodigo() {
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<3; i++) {
			sb.append(this.nombre.charAt(i));
		}
		for(int i=0; i<4; i++) {
			sb.append((int)Math.random()*10);
		}
		
		return sb.toString();
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public Categoria getCategoria() {
		return categoria;
	}
	
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	public double getPrecio() {
		return precio;
	}
	
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	public double getIva() {
		return iva;
	}
	
	public void setIva(double iva) {
		this.iva = iva;
	}
	
	public String getCodigo() {
		return codigo;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Producto [codigo=");
		builder.append(codigo);
		builder.append(", nombre=");
		builder.append(nombre);
		builder.append(", descripcion=");
		builder.append(descripcion);
		builder.append(", categoria=");
		builder.append(categoria);
		builder.append(", precio=");
		builder.append(precio);
		builder.append(", iva=");
		builder.append(iva);
		builder.append("]");
		return builder.toString();
	}
	
	
}
