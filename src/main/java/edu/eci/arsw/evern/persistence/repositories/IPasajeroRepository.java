package edu.eci.arsw.evern.persistence.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;

import edu.eci.arsw.evern.model.*;


@Repository
public interface IPasajeroRepository  extends DAO<Pasajero, Long> {
	
	public Pasajero getPasajero(String correo);
	public Long save(Pasajero entity);
	public List<Viaje> getViajesPasajeroByCorreo(String correoPasajero);
}
