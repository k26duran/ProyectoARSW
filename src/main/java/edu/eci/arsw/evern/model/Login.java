package edu.eci.arsw.evern.model;

public class Login {

	String correo;
	String clave;
	
	public Login(String correo, String clave) {
		this.correo = correo;
		this.clave = clave;
	}

	public Login() {}
	
	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	@Override
	public String toString() {
		return "Login [correo=" + correo + ", clave=" + clave + "]";
	}
	
}