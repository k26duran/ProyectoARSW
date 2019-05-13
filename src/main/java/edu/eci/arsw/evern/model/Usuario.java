package edu.eci.arsw.evern.model;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.validation.constraints.*;

import com.fasterxml.jackson.annotation.JsonFormat;


public class Usuario {

	private String correo;
	private String clave;
	private String nombres;
	private String apellidos;
	private String celular;
	private int calificacion = 0;
	private List<CuentaBancaria> cuentasBancarias = new ArrayList<CuentaBancaria>();
	private List<Viaje> viajes = new ArrayList<Viaje>();
	
	public Usuario() {
	}

	public Usuario(String correo, String nombres, String apellidos, String celular, String clave) {
		this.correo = correo;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.celular=celular;
		this.clave = clave;
	}

	public List<CuentaBancaria> getCuentasBancarias() {
		return cuentasBancarias;
	}

	public List<Viaje> getViajes() {
		return viajes;
	}

	public void setViajes(List<Viaje> viajes) {
		this.viajes = viajes;
	}
	
	public void setCuentasBancarias(List<CuentaBancaria> cuentasBancarias) {
		this.cuentasBancarias = cuentasBancarias;
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

	public int getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(int calificacion) {
		this.calificacion = calificacion;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getTipoUsuario() {
		return "usuario";
	}
	
	@Override
	public String toString() {
		return "Usuario [correo=" + correo + ", clave=" + clave + ", nombres=" + nombres + ", apellidos=" + apellidos
				+ ", celular=" + celular + ", calificacion=" + calificacion + ", cuentasBancarias=" + cuentasBancarias
				+ ", viajes=" + viajes + "]";
	}

}
