package edu.eci.arsw.evern.model;

public class CuentaBancaria {
	private long numero;
	private boolean activa;
	
	public CuentaBancaria(){}
	
	public CuentaBancaria(long numero, boolean activa) {
		this.numero = numero;
		this.activa = activa;
	}

	public long getNumero() {
		return numero;
	}

	public void setNumero(long numero) {
		this.numero = numero;
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
