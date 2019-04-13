package edu.eci.arsw.evern.persistence;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import edu.eci.arsw.evern.model.*;
import edu.eci.arsw.evern.persistence.repositories.ICuponRepository;

@Component

@Qualifier("CuponRepository")
public class CuponRepository implements ICuponRepository {
	
	


	@Override
	public List<Cupon> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cupon find(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long save(Cupon entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Cupon entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Cupon o) {
		// TODO Auto-generated method stub
		
	}
	
}
