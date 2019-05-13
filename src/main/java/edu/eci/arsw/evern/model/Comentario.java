	package edu.eci.arsw.evern.model;

import java.io.Serializable;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.validation.constraints.NotBlank;
import java.util.Date;


public class Comentario implements Serializable {
	
	private long id;
	private String contenido;
	private String fecha = (new Date()).toString(); //dd-mm-yy
    private String correoAutor;
	
    public Comentario() {}

	public Comentario(long id, String contenido, String fecha, String correoAutor) {
		this.id = id;
		this.contenido = contenido;
		this.fecha = fecha;
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

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getCorreoAutor() {
		return correoAutor;
	}

	public void setCorreoAutor(String correoAutor) {
		this.correoAutor = correoAutor;
	}

	@Override
	public String toString() {
		return "Comentario [id=" + id + ", contenido=" + contenido + ", fecha=" + fecha + ", correoAutor=" + correoAutor
				+ "]";
	}
	

    

}
