package edu.eci.arsw.evern.services.contracts;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.eci.arsw.evern.controller.EvernException;
import edu.eci.arsw.evern.model.*;

@Service
public interface IConductorServices {
	

	String createConductor(Conductor conductor) throws EvernException ;
	void updateConductor(Conductor conductor) throws EvernException ;
	void deleteConductor(Conductor conductor) throws EvernException ;
	
	List<Conductor> getConductores() throws EvernException ;
	Conductor getConductorByCorreo(String correo) throws EvernException ;
	List<Viaje> getViajesConductorByCorreo(String correoConductor) throws EvernException ;
	
	void conductorCalificaAlPasajeroByViaje(Long idViaje, int calificacion) throws EvernException ;
	void updateNombres(String correoUsuario, String nuevosNombres) throws EvernException ;
	void updateApellidos(String correoUsuario, String nuevosApellidos) throws EvernException ;
	void updateCelular(String correoUsuario,String celular) throws EvernException ;
	void updateClave(String correoUsuario, String nuevaClave) throws EvernException ;
	void updateFechaNacimiento(String correoUsuario, String nuevaClave) throws EvernException ;
	void updateCasa(String correoUsuario, String nuevaCasa) throws EvernException;
	
	void aceptarViajeConductor(Conductor conductor, Long idViaje) throws EvernException ;
	Conductor getConductorByCorreoYClave(String correoConductor, String clave) throws EvernException;

}
