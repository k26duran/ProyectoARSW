package edu.eci.arsw.evern.model;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;


@Entity
@Table(name = "comentario")
public class Comentario {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@NotBlank
	private String contenido;
	
	
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
    private Date date = new Date(); //dd-mm-yy

    private String correoAutor;

    @ManyToOne()
	private Viaje viaje;
	
    public Comentario() {
    	
    }

	public Comentario(long id, String contenido, Date date, String correoAutor) {
		this.id = id;
		this.contenido = contenido;
		this.date = date;
		this.correoAutor = correoAutor;
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
	public String getCorreoAutor() {
		return correoAutor;
	}
	public void setCorreoAutor(String correoAutor) {
		this.correoAutor = correoAutor;
	}
	

	

}
