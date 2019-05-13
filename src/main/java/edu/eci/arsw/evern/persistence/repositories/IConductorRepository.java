package edu.eci.arsw.evern.persistence.repositories;

import org.springframework.stereotype.Repository;

import edu.eci.arsw.evern.controller.EvernException;
import edu.eci.arsw.evern.model.*;
import java.util.*;


@Repository
public interface IConductorRepository  extends DAO<Conductor, String> {
	
	public void aceptarViajeConductor(Conductor conductor , int idViaje) throws EvernException;
	void conductorCalificaAlPasajeroByViaje(Long idViaje, int calificacion) throws EvernException;
	void updateNombres(String correoUsuario, String nuevosNombres) throws EvernException;
	void updateApellidos(String correoUsuario, String nuevosApellidos) throws EvernException;
	void updateCelular(String correoUsuario,String celular) throws EvernException;
	void updateClave(String correoUsuario, String nuevaClave) throws EvernException;
	void updateCalificacion(String correoUsuario, int nuevaCalificacion) throws EvernException;
	void updateFechaNacimiento(String correoUsuario, String nuevaClave) throws EvernException;	
	void updateCasa(String correoUsuario, String nuevaCasa) throws EvernException;
	
	List<Viaje> getViajesConductorByCorreo(String correo) throws EvernException; 
	Conductor getConductorByCorreoYClave(String correoConductor, String clave) throws EvernException;
}
