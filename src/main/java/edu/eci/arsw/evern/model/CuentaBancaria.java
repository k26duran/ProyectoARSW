package edu.eci.arsw.evern.model;

import javax.persistence.*;

@Entity
@Table(name = "CuentaBancaria")
public class CuentaBancaria {
	
	@Id
	private Long numero;
	
	private boolean activa;

	@ManyToOne
	private Usuario usr;

	public void setNumero(Long numero) {
		this.numero = numero;
	}

	public Usuario getUsr() {
		return usr;
	}

	public void setUsr(Usuario usr) {
		this.usr = usr;
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
