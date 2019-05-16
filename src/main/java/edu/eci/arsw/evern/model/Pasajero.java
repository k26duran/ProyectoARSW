package edu.eci.arsw.evern.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Pasajero extends Usuario implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private List<Cupon> cupones = new ArrayList<Cupon>();

	public Pasajero(){
	}

	public Pasajero(String correo, String nombres, String apellidos, String celular, String clave){
		super(correo, nombres, apellidos, celular, clave);
	}

	public List<Cupon> getCupones(){
		return cupones;
	}

	public void setCupones(List<Cupon> cupones) {
		this.cupones = cupones;
	}
	
	@Override
	public String getTipoUsuario() {
		return "pasajero";
	}

	@Override
	public String toString() {
		return "Pasajero [cupones=" + cupones + ", getCupones()=" + getCupones() + ", getTipoUsuario()="
				+ getTipoUsuario() + ", getCuentasBancarias()=" + getCuentasBancarias() + ", getViajes()=" + getViajes()
				+ ", getCorreo()=" + getCorreo() + ", getNombres()=" + getNombres() + ", getApellidos()="
				+ getApellidos() + ", getCalificacion()=" + getCalificacion() + ", getCelular()=" + getCelular()
				+ ", getClave()=" + getClave() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}


	
}
