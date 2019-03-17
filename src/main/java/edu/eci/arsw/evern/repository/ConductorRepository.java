package edu.eci.arsw.evern.repository;

import edu.eci.arsw.evern.model.Automovil;
import edu.eci.arsw.evern.model.Conductor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConductorRepository  extends JpaRepository<Conductor, Long> {


}
