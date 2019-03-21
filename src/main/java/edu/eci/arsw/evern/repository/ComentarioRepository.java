package edu.eci.arsw.evern.repository;

import edu.eci.arsw.evern.model.*;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ComentarioRepository extends JpaRepository<Comentario , Long>{

	@Query(value = "select * from comentario c where c.viaje_id = :idViaje" , nativeQuery = true)
	List<Comentario> getComentariosDeViajes( @Param("idViaje") Integer idViaje);
	

	
	
}
