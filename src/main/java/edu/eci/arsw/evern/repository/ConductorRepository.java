package edu.eci.arsw.evern.repository;

import edu.eci.arsw.evern.model.Automovil;
import edu.eci.arsw.evern.model.Conductor;
import edu.eci.arsw.evern.model.Pasajero;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ConductorRepository  extends JpaRepository<Conductor, Long> {
	@Query(value = "select * from conductor p where p.correo = :correo" , nativeQuery = true)
	Conductor getConductor( @Param("correo") String correo);
	

}
