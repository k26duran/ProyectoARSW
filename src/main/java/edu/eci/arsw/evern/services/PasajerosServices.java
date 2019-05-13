package edu.eci.arsw.evern.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import edu.eci.arsw.evern.controller.EvernException;
import edu.eci.arsw.evern.model.Pasajero;
import edu.eci.arsw.evern.model.Viaje;
import edu.eci.arsw.evern.persistence.repositories.IPasajeroRepository;
import edu.eci.arsw.evern.services.contracts.IPasajerosServices;


@Component
public class PasajerosServices  implements  IPasajerosServices {
	
	
	@Autowired
	@Qualifier("PasajeroRepository")
	private IPasajeroRepository pasajeroRepository;

	@Override
	public List<Pasajero> getPasajeros() throws EvernException {
		return pasajeroRepository.findAll();
	}
	
	@Override
	public Pasajero getPasajeroByCorreo(String correo) throws EvernException {
		return pasajeroRepository.find(correo);
	}

	@Override
	public String createPasajero(Pasajero pasajero) throws EvernException {
		return pasajeroRepository.save(pasajero);
	}

	@Override
	public void updatePasajero(Pasajero pasajero) throws EvernException {
		pasajeroRepository.update(pasajero);
	}

	@Override
	public void deletePasajero(Pasajero pasajero) throws EvernException {
		pasajeroRepository.delete(pasajero);
	}

	@Override
	public List<Viaje> getViajesPasajeroByCorreo(String correoPasajero) throws EvernException {
		return pasajeroRepository.getViajesPasajeroByCorreo(correoPasajero);
	}

	@Override
	public void pasajeroCalificaAlConductorByViaje(Long idViaje, int calificacion) throws EvernException {
		pasajeroRepository.pasajeroCalificaAlConductorByViaje(idViaje, calificacion);
	}

	@Override
	public void updateNombres(String correoUsuario, String nuevosNombres) throws EvernException {
		pasajeroRepository.updateNombres(correoUsuario, nuevosNombres);
	}

	@Override
	public void updateApellidos(String correoUsuario, String nuevosApellidos) throws EvernException {
		pasajeroRepository.updateApellidos(correoUsuario, nuevosApellidos);
	}

	@Override
	public void updateCelular(String correoUsuario, String celular) throws EvernException {
		pasajeroRepository.updateCelular(correoUsuario, celular);
	}

	@Override
	public void updateClave(String correoUsuario, String nuevaClave) throws EvernException {
		pasajeroRepository.updateClave(correoUsuario, nuevaClave);
	}

	@Override
	public Pasajero getPasajeroByCorreoYClave(String correoPasajero, String clave) throws EvernException {
		return pasajeroRepository.getPasajeroByCorreoYClave(correoPasajero, clave);
	}

	@Override
	public void updateFechaNacimiento(String correoUsuario, String nuevaClave) throws EvernException {
		pasajeroRepository.updateFechaNacimiento(correoUsuario, nuevaClave);
	}
	
}
