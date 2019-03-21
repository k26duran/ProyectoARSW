package edu.eci.arsw.evern.repository;

import edu.eci.arsw.evern.model.Automovil;
import edu.eci.arsw.evern.model.Pasajero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PasajeroRepository  extends JpaRepository<Pasajero, Long> {
	
	@Query(value = "select * from pasajero p where p.correo = :correo" , nativeQuery = true)
	Pasajero getPasajero( @Param("correo") String correo);
	

}
