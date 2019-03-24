package edu.eci.arsw.evern.model;

import java.io.Serializable;

public class CuentaBancaria implements Serializable{
	
	private Long numero;
	private boolean activa;
	private Conductor conductor;
	private Pasajero pasajero;

	public Conductor getConductor() {
		return conductor;
	}

	public void setConductor(Conductor conductor) {
		this.conductor = conductor;
	}

	public Pasajero getPasajero() {
		return pasajero;
	}

	public void setPasajero(Pasajero pasajero) {
		this.pasajero = pasajero;
	}

	public void setNumero(Long numero) {
		this.numero = numero;
	}


	public Long getNumero() {
		return numero;
	}



	public CuentaBancaria(){}
	
	public CuentaBancaria(long numero, boolean activa) {
		this.numero = numero;
		this.activa = activa;
	}

	public boolean isActiva() {
		return activa;
	}

	public void setActiva(boolean activa) {
		this.activa = activa;
	}

	@Override
	public String toString() {
		return "CuentaBancaria [numero=" + numero + ", activa=" + activa + "]";
	}
	
}
