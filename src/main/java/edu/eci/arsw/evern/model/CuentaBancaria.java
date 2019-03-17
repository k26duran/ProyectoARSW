package edu.eci.arsw.evern.model;

import javax.persistence.*;

@Entity
@Table(name = "CuentaBancaria")
public class CuentaBancaria {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long numero;
	
	private boolean activa;

	@ManyToOne(targetEntity = edu.eci.arsw.evern.model.Conductor.class )
	private Conductor conductor;


	@ManyToOne(targetEntity = edu.eci.arsw.evern.model.Pasajero.class)
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
