package edu.eci.arsw.evern.repository;

import edu.eci.arsw.evern.model.Automovil;
import edu.eci.arsw.evern.model.Pasajero;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PasajeroRepository  extends JpaRepository<Pasajero, Long> {
}
