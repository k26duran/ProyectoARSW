package edu.eci.arsw.evern.persistence.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;

import edu.eci.arsw.evern.model.*;


@Repository
public interface IPasajeroRepository  extends DAO<Pasajero, String> {
		
	List<Viaje> getViajesPasajeroByCorreo(String correoPasajero);
	
	void pasajeroCalificaAlConductorByViaje(Long idViaje, int calificacion);
	void updateNombres(String correoUsuario, String nuevosNombres);
	void updateApellidos(String correoUsuario, String nuevosApellidos);
	void updateCelular(String correoUsuario,String celular);
	void updateClave(String correoUsuario, String nuevaClave);
	
}
