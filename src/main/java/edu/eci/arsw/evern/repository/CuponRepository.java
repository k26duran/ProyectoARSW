package edu.eci.arsw.evern.repository;

import edu.eci.arsw.evern.model.Automovil;
import edu.eci.arsw.evern.model.Cupon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CuponRepository  extends JpaRepository<Cupon, Long> {
}
