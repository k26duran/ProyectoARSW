package edu.eci.arsw.evern.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cupon")
public class Cupon {

	@Id
	@Column(name = "cupon")
	private String cupon;
	

	@Column(name = "activo")
	private boolean activo;
	
	public Cupon() {
		
	}
	
	public Cupon(String cupon, boolean activo) {
		super();
		this.cupon = cupon;
		this.activo = activo;
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
