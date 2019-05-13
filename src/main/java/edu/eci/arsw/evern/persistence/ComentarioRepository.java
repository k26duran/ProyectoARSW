package edu.eci.arsw.evern.persistence;

import edu.eci.arsw.evern.model.*;
import edu.eci.arsw.evern.persistence.repositories.IComentarioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


@Component
@Qualifier("ComentarioRepository")
public class ComentarioRepository implements IComentarioRepository {


	@Override
	public List<Comentario> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Comentario find(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long save(Comentario entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Comentario entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Comentario o) {
		// TODO Auto-generated method stub

	}

	@Override
	public void remove(Long pkEntity) {
		// TODO Auto-generated method stub
		
	}

}
