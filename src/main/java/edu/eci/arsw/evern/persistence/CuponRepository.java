package edu.eci.arsw.evern.persistence;

import java.util.List;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import edu.eci.arsw.evern.model.*;
import edu.eci.arsw.evern.persistence.repositories.ICuponRepository;

@Component

@Qualifier("CuponRepository")
public class CuponRepository implements ICuponRepository {
	
	@Override
	public List<Cupon> findAll() {
		return null;
	}

	@Override
	public Cupon find(Long id) {
		return null;
	}

	@Override
	public Long save(Cupon entity) {
		return null;
	}

	@Override
	public void update(Cupon entity) {
	}

	@Override
	public void delete(Cupon o) {
	}

	@Override
	public void remove(Long pkEntity) {
	}
	
}
