package edu.eci.arsw.evern.persistence;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import edu.eci.arsw.evern.model.*;
import edu.eci.arsw.evern.persistence.repositories.IConductorRepository;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.sql.DataSource;

@Component
@Qualifier("ConductorRepository")
public class  ConductorRepository implements IConductorRepository {
	
	private String dbUrl = System.getenv().get("JDBC_DATABASE_URL");
	@Autowired
	@Qualifier("conductorDataSource")
	private DataSource conductorDataSource;

	
	@Override
	public List<Conductor> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Conductor find(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long save(Conductor entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Conductor entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Conductor o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(Long id) {
		// TODO Auto-generated method stub
		
	}
	
	@Bean("conductorDataSource")
	public DataSource conductorDataSource() throws SQLException {
		if (dbUrl == null || dbUrl.isEmpty()) {
			return new HikariDataSource();
		} else {
			HikariConfig config = new HikariConfig();
			config.setJdbcUrl(dbUrl);
			return new HikariDataSource(config);
		}
	}

}
