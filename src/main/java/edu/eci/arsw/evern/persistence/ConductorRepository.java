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
	
	
	
	@Override
	public List<Conductor> findAll() {
		String query = "SELECT * FROM conductores;";
		List<Conductor> conductors = new ArrayList<>();
		try {
			Connection connection = RepositoryDataBases.dataSource().getConnection();
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				Conductor conductor = new Conductor();
				conductor.setApellidos(rs.getString("apellidos"));
				conductor.setNombres(rs.getString("nombres"));
				conductor.setCelular(rs.getString("celular"));
				conductor.setCorreo(rs.getString("correo"));
				conductor.setCorreo(rs.getString("clave"));
				conductors.add(conductor);
			}
			RepositoryDataBases.dataSource().close();
			connection.close();
			return conductors;
		} catch (Exception e) {	
			throw new RuntimeException(e);
		}
	}
	
	@Override
	public Conductor getCondutor(String correo) {
		String query = "SELECT * FROM conductores c where c.correo = '"+correo+"';";
		try {
			Conductor conductor = new Conductor();
			Connection connection = RepositoryDataBases.dataSource().getConnection();
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				conductor.setApellidos(rs.getString("apellidos"));
				conductor.setNombres(rs.getString("nombres"));
				conductor.setCelular(rs.getString("celular"));
				conductor.setCorreo(rs.getString("correo"));		
				conductor.setClave(rs.getString("clave"));
			}
			RepositoryDataBases.dataSource().close();
			connection.close();
			return conductor;
		} catch (Exception e) {	
			throw new RuntimeException(e);
		}
	}


	

	
	@Override
	public Conductor find(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long save(Conductor entity) {
		 	String FK_CONDUCTOR_AUTO  = (entity.getAutomovil()!= null) ? "'"+entity.getAutomovil().getPlaca()+"'" : "null" ; 
			String query = "INSERT INTO conductores(nombres, apellidos , calificacion , celular , clave  , correo , fecha_nacimiento , automovil_id)"
			 +"values ('"+entity.getNombres()+"','"+entity.getApellidos()+"',0,'"+entity.getCelular()+"','"+entity.getClave()+"','"
					+entity.getCorreo()+"',null,"+FK_CONDUCTOR_AUTO+");";
			System.out.println(query);
			try {
				Connection connection = RepositoryDataBases.dataSource().getConnection();
				Statement stmt = connection.createStatement();
				stmt.execute(query);
				RepositoryDataBases.dataSource().close();
				connection.close();
				return (long) 200;
			} catch (Exception e) {	
				throw new RuntimeException(e);
			}
	}
	
	
	@Override
	public void aceptarViajeConductor(Conductor conductor , int idViaje) {
			String query = String.format("UPDATE viajes SET correo_conductor = '%s' , aceptado = true WHERE id = %d;",conductor.getCorreo() , idViaje); 
			try {
				Connection connection = RepositoryDataBases.dataSource().getConnection();
				Statement stmt = connection.createStatement();
				stmt.execute(query);
				RepositoryDataBases.dataSource().close();
				connection.close();
			} catch (Exception e) {	
				throw new RuntimeException(e);
			}
	
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



	
	

}
