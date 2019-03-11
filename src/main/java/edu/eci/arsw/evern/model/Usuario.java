package edu.eci.arsw.evern.model;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;

public class Usuario {
	
	@Column(name  = "correo")
	private String correo;
	
	@Column(name  = "nombres")
	private String nombres;
	
	@Column(name  = "apellidos")
	private String apellidos;
	
	private BufferedImage foto=null;
	
	@Column(name  = "calificacion")
	private int calificacion=0;
	
	@Column(name  = "fechaNacimiento")
	private String fechaNacimiento; // dd-mm-yy
	
	String celular;
	
	String clave;
	
	private List<CuentaBancaria> cuentasBancarias = new ArrayList<CuentaBancaria>();
	
	private List<Viaje> viajes = new ArrayList<Viaje>();
	
	public Usuario () {}

	public Usuario(String correo, String nombres, String apellidos, String fechaNacimiento, String clave) {
		this.correo = correo;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public BufferedImage getFoto() {
		return foto;
	}

	public void setFoto(BufferedImage foto) {
		this.foto = foto;
	}

	public int getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(int calificacion) {
		this.calificacion = calificacion;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	
}
