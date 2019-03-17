package edu.eci.arsw.evern.model;

import javax.persistence.*;

@Entity
@Table(name = "cupon")
public class Cupon {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "cupon")
	private String cupon;
	

	@Column(name = "activo")
	private boolean activo;


	@ManyToOne
	private Pasajero pasajero;

	public Pasajero getPasajero() {
		return pasajero;
	}

	public void setPasajero(Pasajero pasajero) {
		this.pasajero = pasajero;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Cupon() {
		
	}
	
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
