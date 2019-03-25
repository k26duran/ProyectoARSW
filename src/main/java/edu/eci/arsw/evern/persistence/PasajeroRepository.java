package edu.eci.arsw.evern.persistence;

import java.util.List;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import edu.eci.arsw.evern.model.*;
import edu.eci.arsw.evern.persistence.repositories.IPasajeroRepository;

@Component
@Qualifier("PasajeroRepository")
public class PasajeroRepository implements  IPasajeroRepository {
	
	private String dbUrl = System.getenv().get("JDBC_DATABASE_URL");
	
	@Autowired
	private RepositoryDataBases repositoryDataBases;

	@Override
	public List<Pasajero> findAll() {
		String query = "SELECT * FROM pasajeros;";
		List<Pasajero> pasajeros = new ArrayList<>();
		try {
			Connection connection = repositoryDataBases.dataSource().getConnection();
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				Pasajero pasajero = new Pasajero();
				pasajero.setApellidos(rs.getString("apellidos"));
				pasajero.setNombres(rs.getString("nombres"));
				pasajero.setCelular(rs.getString("celular"));
				pasajero.setCorreo(rs.getString("correo"));		
				pasajeros.add(pasajero);
			}
			connection.close();
			return pasajeros;
		} catch (Exception e) {
			System.out.println();
			
			throw new RuntimeException(e);

		}
	}

	@Override
	public Pasajero find(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long save(Pasajero entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Pasajero entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Pasajero o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Bean("pasajeroDataSource")
	public DataSource pasajeroDataSource() throws SQLException {
		System.out.println("Host : " +  System.getenv().get("JDBC_DATABASE_URL"));
		if (dbUrl == null || dbUrl.isEmpty()) {
		
			return new HikariDataSource();
		} else {
			HikariConfig config = new HikariConfig();
			config.setJdbcUrl(dbUrl);
			return new HikariDataSource(config);
		}
	}

}
