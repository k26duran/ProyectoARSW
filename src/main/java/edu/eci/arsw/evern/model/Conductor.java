package edu.eci.arsw.evern.model;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

import org.springframework.stereotype.Service;

@Entity
public class Conductor extends Usuario {


	@OneToOne(mappedBy = "conductor", cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
	private Automovil auto;

	public Conductor() {

	}

	public Conductor(String correo, String nombres, String apellidos, Date fechaNacimiento, String clave,
			Automovil auto) {
		super(correo, nombres, apellidos, fechaNacimiento, clave);
		this.auto = auto;
	}

	public Automovil getAuto() {
		return auto;
	}

	public void setAuto(Automovil auto) {
		this.auto = auto;
	}

//	@Override
//	public String toString() {
//		return "Conductor [auto=" + auto + super.toString() + "]";
//	}
//

}
