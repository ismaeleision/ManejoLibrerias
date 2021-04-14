package ejercicio3;

public class LineaPedido {

	private Producto producto;
	private int cantidad;
	
	public LineaPedido(Producto producto, int cantidad) {
		super();
		this.producto = producto;
		this.cantidad = cantidad;
	}
	
	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double subtotal() {
		return (this.producto.precio*this.producto.iva)*this.cantidad;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("LineaPedido [producto=");
		builder.append(producto);
		builder.append(", cantidad=");
		builder.append(cantidad);
		builder.append("]");
		return builder.toString();
	}
	
	public String imprimirTicket() {
		StringBuilder builder = new StringBuilder();
		builder.append(producto.getNombre()+ " ");
		builder.append(producto.getDescripcion()+" ");
		builder.append(" IVA"+producto.getIva());
		builder.append(" Precio"+producto.getPrecio());
		builder.append(", cantidad=");
		builder.append(cantidad);
		return builder.toString();
	}
}
