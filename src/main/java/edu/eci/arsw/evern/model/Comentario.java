package edu.eci.arsw.evern.model;

import java.util.Date;

public class Comentario {
	
	private long id;
	private String contenido;
	private String date; //dd-mm-yy
	private Usuario autor;
	
	public Comentario(){}
	
	public Comentario(long id, String contenido, String date, Usuario autor) {
		this.id = id;
		this.contenido = contenido;
		this.date = date;
		this.autor = autor;
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

	public Usuario getAutor() {
		return autor;
	}

	public void setAutor(Usuario autor) {
		this.autor = autor;
	}

	@Override
	public String toString() {
		return "Comentario [id=" + id + ", contenido=" + contenido + ", date=" + date + ", autor=" + autor + "]";
	}
	
	

}
