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
import edu.eci.arsw.evern.persistence.repositories.IViajeRepository;

@Component
@Qualifier("ViajeRepository")
public class  ViajeRepository implements  IViajeRepository {
		

	@Override
	public List<Viaje> findAll() {
		String query = "SELECT * FROM viajes;";
		List<Viaje> viajes = new ArrayList<>();
		try {
			Connection connection = RepositoryDataBases.dataSource().getConnection();
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				Viaje viaje = new Viaje();
				viaje.setId(rs.getInt("id"));
				viaje.setAceptado(rs.getBoolean("aceptado"));
				viaje.setCalificacionAlConductor(rs.getInt("calificacion_al_conductor"));
				viaje.setCalificacionAlPasajero(rs.getInt("calificacion_al_pasajero"));
				viaje.setCorreoConductor(rs.getString("correo_conductor"));
				viaje.setCorreoPasajero(rs.getString("correo_pasajero"));
				viaje.setCosto(rs.getInt("costo"));
				viaje.setLugarDestino(rs.getString("lugar_destino"));
				viaje.setLugarOrigen(rs.getString("lugar_origen"));
				viajes.add(viaje);
			}
			RepositoryDataBases.dataSource().close();
			connection.close();
			return viajes;
		} catch (Exception e) {	
			throw new RuntimeException(e);
		}	
	}

	@Override
	public Viaje find(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long save(Viaje entity) {
		String query =String.format("insert into  viajes(aceptado,calificacion_al_conductor,calificacion_al_pasajero,"
											+ "correo_conductor,correo_pasajero,costo,fecha,lugar_destino,lugar_origen,tiempo)"+
				"values(false,0,0,null,'%s',%d,now(),'%s','%s',0);",entity.getCorreoPasajero(),
						entity.getCosto(),entity.getLugarDestino(),entity.getLugarOrigen());
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
	public void update(Viaje entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Viaje o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(Long id) {
		// TODO Auto-generated method stub
		
	}
	

}
