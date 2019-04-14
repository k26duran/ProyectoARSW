package edu.eci.arsw.evern.persistence.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;

import edu.eci.arsw.evern.model.*;

@Repository
public interface IViajeRepository extends DAO<Viaje,Long>{

	
	List<Comentario> getComentariosByViaje(Long idViaje);
	
}
