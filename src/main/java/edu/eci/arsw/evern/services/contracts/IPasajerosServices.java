package edu.eci.arsw.evern.services.contracts;


import java.util.List;
import org.springframework.stereotype.Service;

import edu.eci.arsw.evern.controller.EvernException;
import edu.eci.arsw.evern.model.Pasajero;
import edu.eci.arsw.evern.model.Viaje;


@Service
public interface IPasajerosServices {

	
	String createPasajero(Pasajero pasajero) throws EvernException ;
	void updatePasajero(Pasajero pasajero) throws EvernException ;
	void deletePasajero(Pasajero pasajero) throws EvernException ;
	void removePasajero(String correopasajero) throws EvernException;

	List<Pasajero> getPasajeros() throws EvernException ;
	Pasajero getPasajeroByCorreo(String correo) throws EvernException ;
	List<Viaje> getViajesPasajeroByCorreo(String correoPasajero) throws EvernException ;
	
	void pasajeroCalificaAlConductorByViaje(Long idViaje, int calificacion) throws EvernException ;
	void updateNombres(String correoUsuario, String nuevosNombres) throws EvernException ;
	void updateApellidos(String correoUsuario, String nuevosApellidos) throws EvernException ;
	void updateCelular(String correoUsuario,String celular) throws EvernException ;
	void updateClave(String correoUsuario, String nuevaClave) throws EvernException ;
	void updateFechaNacimiento(String correoUsuario, String nuevaClave) throws EvernException ;
	void updateCasa(String correoUsuario, String nuevaCasa) throws EvernException;
	
	Pasajero getPasajeroByCorreoYClave(String correoPasajero, String clave) throws EvernException ;
	
}
