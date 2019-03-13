package edu.eci.arsw.evern.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import org.springframework.stereotype.Service;

@Entity
@Table( name = "pasajeros")
public class Pasajero extends Usuario{

	@Transient
	private List<Cupon> cupones = new ArrayList<Cupon>();
	
	public Pasajero(String correo, String nombres, String apellidos, Date fechaNacimiento, String clave){
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
