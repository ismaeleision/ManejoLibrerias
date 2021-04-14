package ejercicio3;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

public class Pedido{

	private static int codigoPedido=0;
	private ArrayList<LineaPedido> lineaPedido;
	LocalDateTime fecha;
	private double total;
	private Cliente cliente;
	
	public Pedido() {
		this.codigoPedido = codigoPedido++;
		this.fecha = LocalDateTime.now();
		this.lineaPedido = new ArrayList<>();
		this.total = 0;
	}
	
	public double total() {
		double cuantia=0;
		
		for(LineaPedido p : lineaPedido) {
			cuantia += p.subtotal();
		}
		
		return (cuantia)*this.cliente.descuento();
	}
	
	public void nuevaLinea(LineaPedido Ip) {
		this.lineaPedido.add(Ip);
		this.total += Ip.subtotal();
	}

	public void toPDF() throws Exception{
		try (PDDocument document = new PDDocument()) {
            PDPage page = new PDPage(PDRectangle.A6);
            document.addPage(page);

            PDPageContentStream contentStream = new PDPageContentStream(document, page);

            // Text
            contentStream.beginText();
            contentStream.setFont(PDType1Font.TIMES_BOLD, 20);
            contentStream.newLineAtOffset(20, page.getMediaBox().getHeight() -55);
            contentStream.setLeading(15);
            contentStream.newLine();
            contentStream.showText(cliente.getNombre()+" "+cliente.getApellidos()+" "+cliente.getDni());
            contentStream.endText();
            
            contentStream.beginText();
            contentStream.setFont(PDType1Font.TIMES_BOLD, 10);
            contentStream.newLineAtOffset(20, page.getMediaBox().getHeight() -75);
            contentStream.setLeading(15);
            
            for(int i=0; i<lineaPedido.size(); i++) {
            	contentStream.newLine();
            	contentStream.showText(lineaPedido.get(i).imprimirTicket());//
            }
            
            contentStream.endText();
            
            contentStream.close();

            document.save("document.pdf");
        }catch(Exception e) {
        	System.out.println("Fail occurried "+e);
        }
	}
	
	/**
	 * @return the codigoPedido
	 */
	public static int getCodigoPedido() {
		return codigoPedido;
	}

	/**
	 * @param codigoPedido the codigoPedido to set
	 */
	public static void setCodigoPedido(int codigoPedido) {
		Pedido.codigoPedido = codigoPedido;
	}

	/**
	 * @return the lineaPedido
	 */
	public ArrayList<LineaPedido> getLineaPedido() {
		return lineaPedido;
	}

	/**
	 * @param lineaPedido the lineaPedido to set
	 */
	public void setLineaPedido(ArrayList<LineaPedido> lineaPedido) {
		this.lineaPedido = lineaPedido;
	}

	/**
	 * @return the total
	 */
	public double getTotal() {
		return total;
	}

	/**
	 * @param total the total to set
	 */
	public void setTotal(double total) {
		this.total = total;
	}

	/**
	 * @return the cliente
	 */
	public Cliente getCliente() {
		return cliente;
	}

	/**
	 * @param cliente the cliente to set
	 */
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	/**
	 * @return the fecha
	 */
	public LocalDateTime getFecha() {
		return fecha;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Pedido [lineaPedido=");
		builder.append(lineaPedido + "\n");
		builder.append(", fecha=");
		builder.append(fecha);
		builder.append(", total=");
		builder.append(total);
		builder.append(", cliente=");
		builder.append(cliente);
		builder.append("]");
		return builder.toString();
	}
}
