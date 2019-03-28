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
	
	
	@Override
	public List<Pasajero> findAll() {
		String query = "SELECT * FROM pasajeros;";
		List<Pasajero> pasajeros = new ArrayList<>();
		try {
			Connection connection = RepositoryDataBases.dataSource().getConnection();
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				Pasajero pasajero = new Pasajero();
				pasajero.setApellidos(rs.getString("apellidos"));
				pasajero.setNombres(rs.getString("nombres"));
				pasajero.setCelular(rs.getString("celular"));
				pasajero.setCorreo(rs.getString("correo"));
				pasajero.setClave(rs.getString("clave"));
				pasajeros.add(pasajero);
			}
			RepositoryDataBases.dataSource().close();
			connection.close();
			return pasajeros;
		} catch (Exception e) {	
			throw new RuntimeException(e);
		}
	}

	@Override
	public Pasajero find(Long id) {
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

	@Override
	public Pasajero getPasajero(String correo) {
		
		String query = "SELECT * FROM pasajeros p where p.correo = '"+correo+"';";
		try {
			Pasajero pasajero = new Pasajero();
			Connection connection = RepositoryDataBases.dataSource().getConnection();
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				pasajero.setApellidos(rs.getString("apellidos"));
				pasajero.setNombres(rs.getString("nombres"));
				pasajero.setCelular(rs.getString("celular"));
				pasajero.setCorreo(rs.getString("correo"));		
				pasajero.setClave(rs.getString("clave"));
			}
			RepositoryDataBases.dataSource().close();
			connection.close();
			return pasajero;
		} catch (Exception e) {	
			throw new RuntimeException(e);
		}
	}

	@Override
	public Long save(Pasajero entity) {
		String query = "INSERT INTO pasajeros(nombres,apellidos,calificacion,celular,clave,correo,fecha_nacimiento)"
		 +"values ('"+entity.getNombres()+"','"+entity.getApellidos()+"',0,'"+entity.getCelular()+"','"+entity.getClave()+"','"
				+entity.getCorreo()+"',null);";
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
	
	public List<Viaje> getViajesPasajeroByCorreo(String correoPasajero){
		String query = "SELECT * FROM viajes WHERE correo_pasajero ='"+correoPasajero+"';" ;
		System.out.println("Consultar los viajes del pasajero: "+correoPasajero);
		try {
			List<Viaje> viajesPasajero = new ArrayList<>();
			
			Connection connection = RepositoryDataBases.dataSource().getConnection();
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			while (rs.next()) {
				Viaje viaje=new Viaje();
				viaje.setId(rs.getInt("id"));
				viaje.setAceptado(rs.getBoolean("aceptado"));
				viaje.setCalificacionAlConductor(rs.getInt("calificacion_al_conductor"));
				viaje.setCalificacionAlPasajero(rs.getInt("calificacion_al_pasajero"));
				viaje.setCorreoConductor(rs.getString("correo_conductor"));
				viaje.setCorreoPasajero(rs.getString("correo_pasajero"));
				viaje.setCosto(rs.getInt("costo"));
				viaje.setFecha(rs.getString("fecha"));
				viaje.setLugarDestino(rs.getString("lugar_destino"));
				viaje.setLugarOrigen(rs.getString("lugar_origen"));
				viaje.setTiempo(rs.getInt("tiempo"));
				
				viajesPasajero.add(viaje);
			}
			RepositoryDataBases.dataSource().close();
			connection.close();
			
			return viajesPasajero;
		} catch (Exception e) {	
			throw new RuntimeException(e);
		}
	}
	
}
