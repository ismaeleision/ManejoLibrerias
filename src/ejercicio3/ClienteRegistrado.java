package ejercicio3;

import java.time.LocalDateTime;

import org.apache.commons.codec.digest.DigestUtils;


//import org.apache.commons.codec.digest.DigestUtils;

public class ClienteRegistrado extends Cliente {

	private String email;
	private String password;
	LocalDateTime fechaNacimiento;
	LocalDateTime fechaRegistro;
	
	/**
	 * 
	 * @param nombre
	 * @param apellidos
	 * @param dni
	 * @param localidad
	 * @param direccion
	 * @param email
	 * @param password
	 * @param fechaNacimiento
	 */
	public ClienteRegistrado(String nombre, String apellidos, String dni, String localidad, String direccion,
			String email, String password, LocalDateTime fechaNacimiento) {
		super(nombre, apellidos, dni, localidad, direccion);
		this.email = email;
		this.password = DigestUtils.sha256(password).toString();
		this.fechaNacimiento = fechaNacimiento;
		this.fechaRegistro = LocalDateTime.now();
	}

	/**
	 *   
	 * @param pass
	 * @return
	 */
	public boolean checkPassword(String pass) {
		String contraseña = DigestUtils.sha256(pass).toString();
		if(this.password == contraseña) {
			return true;
		}else {
			return false;
		}
	}
	
	@Override
	public double descuento() {
		return -5;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setPassword2(String password) {
		this.password = DigestUtils.sha256(password).toString();
	}
	
	public LocalDateTime getFechaNacimiento() {
		return fechaNacimiento;
	}

	public LocalDateTime getFechaRegistro() {
		return fechaRegistro;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ClienteRegistrado [email=");
		builder.append(email);
		builder.append(", password=");
		builder.append(password);
		builder.append(", fechaNacimiento=");
		builder.append(fechaNacimiento);
		builder.append(", fechaRegistro=");
		builder.append(fechaRegistro);
		builder.append(", nombre=");
		builder.append(nombre);
		builder.append(", apellidos=");
		builder.append(apellidos);
		builder.append(", dni=");
		builder.append(dni);
		builder.append(", localidad=");
		builder.append(localidad);
		builder.append(", direccion=");
		builder.append(direccion);
		builder.append("]");
		return builder.toString();
	}
}
