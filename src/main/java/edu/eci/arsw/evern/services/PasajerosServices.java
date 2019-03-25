package edu.eci.arsw.evern.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import edu.eci.arsw.evern.model.Pasajero;
import edu.eci.arsw.evern.persistence.repositories.IPasajeroRepository;
import edu.eci.arsw.evern.persistence.repositories.IViajeRepository;
import edu.eci.arsw.evern.services.contracts.IPasajerosServices;


@Component
public class PasajerosServices  implements  IPasajerosServices {
	
	
	@Autowired
	@Qualifier("PasajeroRepository")
	private IPasajeroRepository pasajeroRepository;


	@Override
	public Long createPasajero(Pasajero pasajero) {
		return pasajeroRepository.save(pasajero);
	}

	@Override
	public void delete(Pasajero pasajero) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pasajeroCalificaAlConductorByViaje(long idViaje, int calificacion) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actualizarNombres(String correoUsuario, String nuevosNombres) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actualizarApellidos(String correoUsuario, String nuevosApellidos) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Pasajero> list() {
		return  pasajeroRepository.findAll();
	}

	@Override
	public Pasajero getPasajeroCorreo(String correo) {
		return pasajeroRepository.getPasajero(correo);
	}


}
