package edu.eci.arsw.evern.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Viaje implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Long id;
	private String lugarOrigen;
	private String lugarDestino;
	private String fecha = (new Date()).toString();
	private int calificacionAlPasajero; //[0..5]
	private int calificacionAlConductor; //[0..5]
	private int costo;
	private int tiempo;
	private String correoConductor;
	private String correoPasajero;

	public Automovil getAutomovil() {
		return automovil;
	}

	public void setAutomovil(Automovil automovil) {
		this.automovil = automovil;
	}

	private boolean aceptado=false;
	private Automovil automovil;
	
	private List<Comentario> comentarios = new ArrayList<Comentario>();

	public Viaje(){}
	
	public Viaje(String lugarOrigen, String lugarDestino, int costo, int tiempo,
		String correoConductor, String correoPasajero, Automovil automovil) {
		this.lugarOrigen = lugarOrigen;
		this.lugarDestino = lugarDestino;
		this.costo = costo;
		this.tiempo = tiempo;
		this.correoConductor = correoConductor;
		this.correoPasajero = correoPasajero;
		this.automovil = automovil;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getLugarOrigen() {
		return lugarOrigen;
	}

	public void setLugarOrigen(String lugarOrigen) {
		this.lugarOrigen = lugarOrigen;
	}

	public String getLugarDestino() {
		return lugarDestino;
	}

	public void setLugarDestino(String lugarDestino) {
		this.lugarDestino = lugarDestino;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public int getCalificacionAlPasajero() {
		return calificacionAlPasajero;
	}

	public void setCalificacionAlPasajero(int calificacion) {
		this.calificacionAlPasajero = calificacion;
	}
	
	public int getCalificacionAlConductor() {
		return calificacionAlConductor;
	}
	
	public void setCalificacionAlConductor(int calificacion) {
		this.calificacionAlConductor = calificacion;
	}
	
	public int getCosto() {
		return costo;
	}

	public void setCosto(int costo) {
		this.costo = costo;
	}

	public int getTiempo() {
		return tiempo;
	}

	public void setTiempo(int tiempo) {
		this.tiempo = tiempo;
	}

	public boolean isAceptado() {
		return aceptado;
	}

	public void setAceptado(boolean aceptado) {
		this.aceptado = aceptado;
	}

	public List<Comentario> getComentarios() {
		return comentarios;
	}

	public void setComentarios(List<Comentario> comentarios) {
		this.comentarios = comentarios;
	}
	
	public String getCorreoConductor() {
		return correoConductor;
	}

	public void setCorreoConductor(String correoConductor) {
		this.correoConductor = correoConductor;
	}

	public String getCorreoPasajero() {
		return correoPasajero;
	}

	public void setCorreoPasajero(String correoPasajero) {
		this.correoPasajero = correoPasajero;
	}
	
	@Override
	public String toString() {
		return "Viaje [id=" + id + ", lugarOrigen=" + lugarOrigen + ", lugarDestino=" + lugarDestino + ", fecha="
				+ fecha + ", calificacionAlPasajero=" + calificacionAlPasajero + ", calificacionAlConductor="
				+ calificacionAlConductor + ", costo=" + costo + ", tiempo=" + tiempo + ", correoConductor="
				+ correoConductor + ", correoPasajero=" + correoPasajero + ", aceptado=" + aceptado + ", automovil="
				+ automovil + ", comentarios=" + comentarios + "]";
	}

}
