package edu.eci.arsw.evern.model;

import java.util.Date;

public class Comentario {
	
	private long id;
	private String contenido;
	private String date; //dd-mm-yy
	private String correoAutor;
	
	public Comentario(){}
	
	public Comentario(long id, String contenido, String date, String correoAutor) {
		this.id = id;
		this.contenido = contenido;
		this.date = date;
		this.correoAutor = correoAutor;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getCorreoAutor() {
		return correoAutor;
	}

	public void setCorreoAutor(String correoAutor) {
		this.correoAutor = correoAutor;
	}

	@Override
	public String toString() {
		return "Comentario [id=" + id + ", contenido=" + contenido + ", date=" + date + ", autor=" + correoAutor + "]";
	}

}
