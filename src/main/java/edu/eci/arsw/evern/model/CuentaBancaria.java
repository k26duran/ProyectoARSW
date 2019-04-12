package edu.eci.arsw.evern.model;

import java.io.Serializable;

public class CuentaBancaria implements Serializable{
	
	private Long numero;
	private boolean activa;

	public void setNumero(Long numero) {
		this.numero = numero;
	}

	public long getNumero() {
		return numero;
	}

	public CuentaBancaria(){}
	
	public CuentaBancaria(Long numero, boolean activa) {
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
