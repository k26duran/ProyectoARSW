package edu.eci.arsw.evern.model;

import java.util.ArrayList;
import java.util.List;

public class Viaje {
	
	
	private long id;
	private String lugarOrigen;
	private String lugarDestino;
	private String fecha;
	private int calificacion;
	private int costo;
	private int tiempo;
	private String correoConductor;
	private String correoPasajero;
	
	private List<Comentario> comentarios = new ArrayList<Comentario>();
	
	public Viaje(){}
	
	public Viaje(String lugarOrigen, String lugarDestino, int costo, String correoConductor, String correoPasajero) {
		this.lugarOrigen = lugarOrigen;
		this.lugarDestino = lugarDestino;
		this.costo = costo;
		this.correoConductor = correoConductor;
		this.correoConductor = correoPasajero;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
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

	public int getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(int calificacion) {
		this.calificacion = calificacion;
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



}
