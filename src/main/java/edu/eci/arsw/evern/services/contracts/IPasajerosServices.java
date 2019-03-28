package edu.eci.arsw.evern.services.contracts;


import java.util.List;

import org.springframework.stereotype.Service;

import edu.eci.arsw.evern.model.CuentaBancaria;
import edu.eci.arsw.evern.model.Pasajero;
import edu.eci.arsw.evern.model.Viaje;


@Service
public interface IPasajerosServices {

	
	List<Pasajero> list();
	
	Pasajero getPasajeroByCorreo(String correo);

	Long createPasajero(Pasajero pasajero);
	
	void delete(Pasajero pasajero);

	void pasajeroCalificaAlConductorByViaje(long idViaje, int calificacion);

	void actualizarNombres(String correoUsuario, String nuevosNombres);

	void actualizarApellidos(String correoUsuario, String nuevosApellidos);

	List<Viaje> getViajesPasajeroByCorreo(String correoPasajero);
	
}
