package edu.eci.arsw.evern.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import edu.eci.arsw.evern.model.Conductor;
import edu.eci.arsw.evern.model.Pasajero;
import edu.eci.arsw.evern.model.Usuario;
import edu.eci.arsw.evern.persistence.EvernPersistence;
import edu.eci.arsw.evern.persistence.EvernPersistenceException;

@Service
public class EvernServices {

	@Autowired
	@Qualifier("inMemoryPersistence")
	EvernPersistence eps;
	
	public void registrarPasajero(Pasajero pasajero) throws EvernPersistenceException {
		eps.registrarPasajero(pasajero);
	}

	public void registrarConductor(Conductor conductor) throws EvernPersistenceException{
		eps.registrarConductor(conductor);
	}
	
}
