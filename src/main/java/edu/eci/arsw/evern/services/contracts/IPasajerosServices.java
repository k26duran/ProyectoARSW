package edu.eci.arsw.evern.services.contracts;


import java.util.List;

import org.springframework.stereotype.Service;

import edu.eci.arsw.evern.model.CuentaBancaria;
import edu.eci.arsw.evern.model.Pasajero;


@Service
public interface IPasajerosServices {

	
	List<Pasajero> list();

	Pasajero createPasajero(Pasajero pasajero);
	
	void delete(Pasajero pasajero);

	void pasajeroCalificaAlConductorByViaje(long idViaje, int calificacion);

	void actualizarNombres(String correoUsuario, String nuevosNombres);

	void actualizarApellidos(String correoUsuario, String nuevosApellidos);

}
