package edu.eci.arsw.evern.repository;

import edu.eci.arsw.evern.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.stereotype.Repository;


@Repository
public interface ConductorRepository extends JpaRepository<Conductor, String> {

}
