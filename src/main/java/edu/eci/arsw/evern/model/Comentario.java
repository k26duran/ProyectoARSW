	package edu.eci.arsw.evern.model;

import java.io.Serializable;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.validation.constraints.NotBlank;
import java.util.Date;


public class Comentario implements Serializable {
	
	private Long id;
	
	private String contenido;
	
	
	private Date date = new Date(); //dd-mm-yy

    private Viaje viaje;
	
    public Comentario() {
    	
    }

	public Comentario(long id, String contenido, Date date, String correoAutor) {
		this.id = id;
		this.contenido = contenido;
		this.date = date;
	}
    
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	public String getContenido() {
		return contenido;
	}
	public void setContenido(String contenido) {
		this.contenido = contenido;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}


	

}
