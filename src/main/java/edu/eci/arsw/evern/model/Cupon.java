package edu.eci.arsw.evern.model;

import java.io.Serializable;

public class Cupon implements Serializable{

	private Long id;
	private String cupon;
	private boolean activo;

	public Cupon() {}
	
	public Cupon(String cupon, boolean activo) {
		super();
		this.cupon = cupon;
		this.activo = activo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getCupon() {
		return cupon;
	}

	public void setCupon(String cupon) {
		this.cupon = cupon;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	@Override
	public String toString() {
		return "Cupon [cupon=" + cupon + ", activo=" + activo + "]";
	}

}
