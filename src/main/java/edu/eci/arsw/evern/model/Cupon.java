package edu.eci.arsw.evern.model;

public class Cupon {

	private String cupon;
	private boolean activo;

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
