package edu.eci.arsw.evern.persistence.repositories;

import org.springframework.stereotype.Repository;

import edu.eci.arsw.evern.model.*;


@Repository
public interface IConductorRepository  extends DAO<Conductor, Long> {
	
	public Conductor getCondutor(String correo);
	
	public void aceptarViajeConductor(Conductor conductor , int idViaje);

	
}
