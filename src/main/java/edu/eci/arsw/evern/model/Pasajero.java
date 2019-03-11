package edu.eci.arsw.evern.model;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

public class Pasajero extends Usuario{

	public Pasajero(String correo, String nombres, String apellidos, String fechaNacimiento, String clave){
		super(correo, nombres, apellidos, fechaNacimiento, clave);
	}
	
}
