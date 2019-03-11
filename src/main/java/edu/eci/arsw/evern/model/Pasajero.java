package edu.eci.arsw.evern.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

public class Pasajero extends Usuario{

	private List<Cupon> cupones = new ArrayList<Cupon>();
	
	public Pasajero(String correo, String nombres, String apellidos, String fechaNacimiento, String clave){
		super(correo, nombres, apellidos, fechaNacimiento, clave);
	}

	public List<Cupon> getCupones() {
		return cupones;
	}

	public void setCupones(List<Cupon> cupones) {
		this.cupones = cupones;
	}
	
	public String userType() {
		return "pasajero";
	}
	
}
