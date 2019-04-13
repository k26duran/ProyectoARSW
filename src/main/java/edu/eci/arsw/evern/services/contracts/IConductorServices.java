package edu.eci.arsw.evern.services.contracts;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.eci.arsw.evern.model.*;

@Service
public interface IConductorServices {
	

	String createConductor(Conductor conductor);
	void updateConductor(Conductor conductor);
	void deleteConductor(Conductor conductor);
	
	List<Conductor> getConductores();
	Conductor getConductorByCorreo(String correo);
	List<Viaje> getViajesConductorByCorreo(String correoConductor);
	
	void conductorCalificaAlPasajeroByViaje(Long idViaje, int calificacion);
	void updateNombres(String correoUsuario, String nuevosNombres);
	void updateApellidos(String correoUsuario, String nuevosApellidos);
	void updateCelular(String correoUsuario,String celular);
	void updateClave(String correoUsuario, String nuevaClave);
	
	void aceptarViajeConductor(Conductor conductor, Long idViaje);	

}
