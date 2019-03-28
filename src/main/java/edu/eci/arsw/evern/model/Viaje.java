package edu.eci.arsw.evern.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Viaje implements Serializable {
	
	private int id;

	private String lugarOrigen;
	private String lugarDestino;
	private String fecha = (new Date()).toString();
	private int calificacionAlPasajero; //[0..5]
	private int calificacionAlConductor; //[0..5]
	private int costo;
	private int tiempo;
	private String correoConductor;
	private String correoPasajero;
	private boolean aceptado=false;

	private List<Comentario> comentarios = new ArrayList<Comentario>();

	public Viaje(){}
	
	public Viaje(String lugarOrigen, String lugarDestino, int costo, String correoConductor, String correoPasajero) {
		this.lugarOrigen = lugarOrigen;
		this.lugarDestino = lugarDestino;
		this.costo = costo;
		this.correoConductor = correoConductor;
		this.correoConductor = correoPasajero;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
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
	
	public void addComentario(Comentario comentario) {
		this.comentarios.add(comentario);
	}
	
	public void removeComentario(long idComentario) {
		List<Comentario> c = new ArrayList<Comentario>();
		for (Comentario comentario : this.comentarios) {
			if(comentario.getId() != idComentario) c.add(comentario);
		}
		comentarios = c;
	}


}
