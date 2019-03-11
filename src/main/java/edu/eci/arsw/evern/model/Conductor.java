package edu.eci.arsw.evern.model;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

import org.springframework.stereotype.Service;

//@Service("ConductorBean")
@Entity
@Table(name = "Coductores")
public class Conductor extends Usuario{
	
	Automovil auto;

	public Conductor() {
	}

	public Conductor(String correo, String nombres, String apellidos, String fechaNacimiento, String clave, Automovil auto) {
		super(correo, nombres, apellidos, fechaNacimiento, clave);
		this.auto = auto;
	}
	
	public Automovil getAuto() {
		return auto;
	}

	public void setAuto(Automovil auto) {
		this.auto = auto;
	}

	@Override
	public String toString() {
		return "Conductor [auto=" + auto + super.toString() + "]";
	}
}
