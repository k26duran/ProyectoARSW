package edu.eci.arsw.enerv.model;

import java.util.Date;

public class Comentario {
	private Usuario creador;
	private Usuario destinatario;
	private String comentario;
	private Date fechaDeCreacion;
	
	public Comentario(){}
	
	public Comentario(Usuario creador, Usuario destinatario, String comentario, Date fechaDeCreacion) {
		this.creador = creador;
		this.destinatario = destinatario;
		this.comentario = comentario;
		this.fechaDeCreacion = fechaDeCreacion;
	}
	
	public Usuario getCreador() {
		return creador;
	}
	public void setCreador(Usuario creador) {
		this.creador = creador;
	}
	public Usuario getDestinatario() {
		return destinatario;
	}
	public void setDestinatario(Usuario destinatario) {
		this.destinatario = destinatario;
	}
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	public Date getFechaDeCreacion() {
		return fechaDeCreacion;
	}
	public void setFechaDeCreacion(Date fechaDeCreacion) {
		this.fechaDeCreacion = fechaDeCreacion;
	}

	@Override
	public String toString() {
		return "Comentario [creador=" + creador + ", destinatario=" + destinatario + ", comentario=" + comentario
				+ ", fechaDeCreacion=" + fechaDeCreacion + "]";
	}
	
	

}
