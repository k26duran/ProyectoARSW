package edu.eci.arsw.enerv.model;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

//@Service("PasajeroBean")
public class Pasajero implements Usuario{

	private String nombres;
	private String apellidos;
	private Date fechaDeNacimiento;
	private List<TarjetaDeCredito> tarjetas;
	private List<Comentario> comentarios;
	private List<Viaje> viajes;
	

	public Pasajero(){}

	public Pasajero(String nombres, String apellidos, Date fechaDeNacimiento, List<TarjetaDeCredito> tarjetas,
			List<Comentario> comentarios, List<Viaje> viajes) {
		super();
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.fechaDeNacimiento = fechaDeNacimiento;
		this.tarjetas = tarjetas;
		this.comentarios = comentarios;
		this.viajes = viajes;
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

	public Date getFechaDeNacimiento() {
		return fechaDeNacimiento;
	}

	public void setFechaDeNacimiento(Date fechaDeNacimiento) {
		this.fechaDeNacimiento = fechaDeNacimiento;
	}

	public List<TarjetaDeCredito> getTarjetas() {
		return tarjetas;
	}

	public void setTarjetas(List<TarjetaDeCredito> tarjetas) {
		this.tarjetas = tarjetas;
	}

	public List<Comentario> getComentarios() {
		return comentarios;
	}

	public void setComentarios(List<Comentario> comentarios) {
		this.comentarios = comentarios;
	}
	public List<Viaje> getViajes() {
		return viajes;
	}

	public void setViajes(List<Viaje> viajes) {
		this.viajes = viajes;
	}
	
	@Override
	public String toString() {
		return "Pasajero [nombres=" + nombres + ", apellidos=" + apellidos + ", fechaDeNacimiento=" + fechaDeNacimiento
				+ ", tarjetas=" + tarjetas + ", comentarios=" + comentarios + ", viajes=" + viajes + "]";
	}

	@Override
	public void registrarTarjetas(int id, String Banco) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void deleteTarjetas(int id, String Banco) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void updateFoto() {
		// TODO Auto-generated method stub
		
	}
	

}
