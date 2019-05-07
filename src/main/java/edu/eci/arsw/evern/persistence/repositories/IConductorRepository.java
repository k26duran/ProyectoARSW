package edu.eci.arsw.evern.persistence.repositories;

import org.springframework.stereotype.Repository;

import edu.eci.arsw.evern.model.*;
import java.util.*;


@Repository
public interface IConductorRepository  extends DAO<Conductor, String> {
	
	public void aceptarViajeConductor(Conductor conductor , int idViaje);

	
	void conductorCalificaAlPasajeroByViaje(Long idViaje, int calificacion);
	void updateNombres(String correoUsuario, String nuevosNombres);
	void updateApellidos(String correoUsuario, String nuevosApellidos);
	void updateCelular(String correoUsuario,String celular);
	void updateClave(String correoUsuario, String nuevaClave);
	void updateCalificacion(String correoUsuario, int nuevaCalificacion);
	List<Viaje> getViajesConductorByCorreo(String correo); 
	Conductor getConductorByCorreoYClave(String correoConductor, String clave);
}
