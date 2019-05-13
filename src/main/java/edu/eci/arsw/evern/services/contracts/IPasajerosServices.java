package edu.eci.arsw.evern.services.contracts;


import java.util.List;
import org.springframework.stereotype.Service;
import edu.eci.arsw.evern.model.Pasajero;
import edu.eci.arsw.evern.model.Viaje;


@Service
public interface IPasajerosServices {

	
	String createPasajero(Pasajero pasajero);
	void updatePasajero(Pasajero pasajero);
	void deletePasajero(Pasajero pasajero);
	
	List<Pasajero> getPasajeros();
	Pasajero getPasajeroByCorreo(String correo);
	List<Viaje> getViajesPasajeroByCorreo(String correoPasajero);
	
	void pasajeroCalificaAlConductorByViaje(Long idViaje, int calificacion);
	void updateNombres(String correoUsuario, String nuevosNombres);
	void updateApellidos(String correoUsuario, String nuevosApellidos);
	void updateCelular(String correoUsuario,String celular);
	void updateClave(String correoUsuario, String nuevaClave);
	
	Pasajero getPasajeroByCorreoYClave(String correoPasajero, String clave);
	
}
