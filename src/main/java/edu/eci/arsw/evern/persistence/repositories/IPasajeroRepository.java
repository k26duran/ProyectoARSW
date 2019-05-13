package edu.eci.arsw.evern.persistence.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;

import edu.eci.arsw.evern.controller.EvernException;
import edu.eci.arsw.evern.model.*;


@Repository
public interface IPasajeroRepository  extends DAO<Pasajero, String> {
		
	List<Viaje> getViajesPasajeroByCorreo(String correoPasajero) throws EvernException;
	void pasajeroCalificaAlConductorByViaje(Long idViaje, int calificacion) throws EvernException;
	void updateNombres(String correoUsuario, String nuevosNombres) throws EvernException;
	void updateApellidos(String correoUsuario, String nuevosApellidos) throws EvernException;
	void updateCelular(String correoUsuario,String celular) throws EvernException;
	void updateClave(String correoUsuario, String nuevaClave) throws EvernException;
	void updateCalificacion(String correoUsuario, int nuevaCalificacion) throws EvernException;
	void updateFechaNacimiento(String correoUsuario, String nuevaClave) throws EvernException;
	
	Pasajero getPasajeroByCorreoYClave(String correoPasajero, String clave) throws EvernException;
	
}
