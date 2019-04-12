package edu.eci.arsw.evern.services.contracts;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.eci.arsw.evern.model.*;

@Service
public interface IConductorServices {
	

	List<Conductor> list();
	
	Conductor getConductorCorreo(String correo);

	Long createConductor(Conductor conductor);
	
	void delete(Conductor pasajero);

	void conductorCalificaAlPasajeroByViaje(long idViaje, int calificacion);

	void actualizarNombres(String correoUsuario, String nuevosNombres);

	void actualizarApellidos(String correoUsuario, String nuevosApellidos);
	
	void aceptarViajeConductor(Conductor conductor , int idViaje);


}
