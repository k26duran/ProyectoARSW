package edu.eci.arsw.evern.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import org.springframework.stereotype.Service;

@Entity
public class Pasajero extends Usuario{

	@OneToMany(mappedBy = "pasajero" , fetch = FetchType.EAGER , cascade =  CascadeType.ALL)
	private List<Cupon> cupones = new ArrayList<Cupon>();

	@OneToMany(mappedBy = "pasajero" , fetch = FetchType.LAZY , cascade =  CascadeType.ALL)
	private List<CuentaBancaria> cuentasBancarias = new ArrayList<CuentaBancaria>();

	@OneToMany(mappedBy = "pasajero" , fetch = FetchType.LAZY , cascade =  CascadeType.ALL)
	private List<Viaje> viajes = new ArrayList<Viaje>();


	public Pasajero(){

	}

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


	public void setViajes(List<Viaje> viajes) {
		this.viajes = viajes;
	}

	public void agregarViaje(Viaje viaje) {
		this.viajes.add(viaje);
	}


	public List<Viaje> getViajes() {
		return viajes;
	}


}
