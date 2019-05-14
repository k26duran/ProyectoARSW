package edu.eci.arsw.evern.persistence;

import java.util.List;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import edu.eci.arsw.evern.controller.EvernException;
import edu.eci.arsw.evern.model.*;
import edu.eci.arsw.evern.persistence.repositories.IViajeRepository;

@Component
@Qualifier("ViajeRepository")
public class  ViajeRepository implements  IViajeRepository {
	
	@Autowired
	private RepositoryDataBases database;

	@Override
	public List<Viaje> findAll() throws EvernException {
		String query = "SELECT * FROM viaje;";
		List<Viaje> viajes = new ArrayList<>();
		Connection connection = null;
		try {
			connection = database.dataSource().getConnection();
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				Viaje viaje = new Viaje();
				viaje.setId(rs.getLong("id"));
				viaje.setAceptado(rs.getBoolean("aceptado"));
				viaje.setCalificacionAlConductor(rs.getInt("calificacion_al_conductor"));
				viaje.setCalificacionAlPasajero(rs.getInt("calificacion_al_pasajero"));
				viaje.setCorreoConductor(rs.getString("correo_conductor"));
				viaje.setCorreoPasajero(rs.getString("correo_pasajero"));
				viaje.setCosto(rs.getInt("costo"));
				viaje.setTiempo(rs.getInt("tiempo"));
				viaje.setFecha(rs.getString("fecha"));
				viaje.setLugarDestino(rs.getString("lugar_destino"));
				viaje.setLugarOrigen(rs.getString("lugar_origen"));
				viajes.add(viaje);
			}
			connection.close();
			return viajes;
		} catch(Exception e) {
			throw new EvernException(e.getMessage());
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new EvernException("Failed to close connection");
			}
		}
	}

	@Override
	public Viaje find(Long id) throws EvernException {
		//String query = "SELECT * FROM viaje WHERE id="+id.toString()+";";
		String query = "SELECT * FROM viaje, automovil WHERE id="+id.toString()+" AND placa_automovil=placa;";
		Viaje viaje = new Viaje();
		Automovil automovil = new Automovil();
		
		Connection connection = null;
		try {
			connection = database.dataSource().getConnection();
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				viaje.setId(rs.getLong("id"));
				viaje.setAceptado(rs.getBoolean("aceptado"));
				viaje.setCalificacionAlConductor(rs.getInt("calificacion_al_conductor"));
				viaje.setCalificacionAlPasajero(rs.getInt("calificacion_al_pasajero"));
				viaje.setCorreoConductor(rs.getString("correo_conductor"));
				viaje.setCorreoPasajero(rs.getString("correo_pasajero"));
				viaje.setCosto(rs.getInt("costo"));
				viaje.setTiempo(rs.getInt("tiempo"));
				viaje.setFecha(rs.getString("fecha"));
				viaje.setLugarDestino(rs.getString("lugar_destino"));
				viaje.setLugarOrigen(rs.getString("lugar_origen"));
				automovil.setColor(rs.getString("color"));
				automovil.setModelo(rs.getString("modelo"));
				automovil.setPlaca(rs.getString("placa"));
				automovil.setTipo(rs.getString("tipo"));
				viaje.setAutomovil(automovil);
				return viaje;
			}
			connection.close();
			return viaje;
		} catch(Exception e) {
			throw new EvernException(e.getMessage());
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new EvernException("Failed to close connection");
			}
		}
	}

	@Override
	public Long save(Viaje entity) throws EvernException {
		String query =String.format("insert into  viaje(aceptado,calificacion_al_conductor,calificacion_al_pasajero,"
								  + "correo_conductor,correo_pasajero,costo,fecha,lugar_destino,lugar_origen,tiempo, placa_automovil)"+
				"values(%b,0,0,'%s','%s',%d,now(),'%s','%s',%d, '%s');",
						entity.isAceptado(), entity.getCorreoConductor(), entity.getCorreoPasajero(),
						entity.getCosto(),entity.getLugarDestino(),entity.getLugarOrigen(),
						entity.getTiempo(), entity.getAutomovil().getPlaca());
		System.out.println(query);
		
		Connection connection = null;
		try {
			connection = database.dataSource().getConnection();
			Statement stmt = connection.createStatement();
			stmt.execute(query);
			connection.close();
			return new Long(200);
		} catch(Exception e) {
			throw new EvernException(e.getMessage());
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new EvernException("Failed to close connection");
			}
		}
	}

	@Override
	public void update(Viaje viaje) {
	}
 
	@Override
	public void delete(Viaje viaje) throws EvernException {
		String query = "DELETE FROM viaje WHERE id="+viaje.getId().toString()+";";
		Connection connection = null;
		try {
			connection = database.dataSource().getConnection();
			Statement stmt = connection.createStatement();
			stmt.execute(query);
			connection.close();
		} catch(Exception e) {
			throw new EvernException(e.getMessage());
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new EvernException("Failed to close connection");
			}
		}
	}

	@Override
	public List<Comentario> getComentariosByViaje(Long idViaje) throws EvernException {
		String query = "SELECT c.* FROM viaje as v, comentario as c WHERE v.id="+
				idViaje.toString()+" AND c.viaje_id=v.id;";
		Connection connection = null;
		try {
			connection = database.dataSource().getConnection();
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			List<Comentario> comentarios = new ArrayList<Comentario>();
			while(rs.next()) {
				Comentario comentario = new Comentario();
				comentario.setId(rs.getLong("id"));
				comentario.setFecha(rs.getString("fecha"));
				comentario.setContenido(rs.getString("contenido"));
				comentarios.add(comentario);
			}
			connection.close();
			return comentarios;
		} catch(Exception e) {
			throw new EvernException(e.getMessage());
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new EvernException("Failed to close connection");
			}
		}
	}

	@Override
	public void remove(Long pkEntity) throws EvernException {
		String query = "DELETE FROM viaje WHERE id="+pkEntity.toString()+";";
		Connection connection = null;
		try {
			connection = database.dataSource().getConnection();
			Statement stmt = connection.createStatement();
			stmt.execute(query);
			connection.close();
		} catch(Exception e) {
			throw new EvernException(e.getMessage());
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new EvernException("Failed to close connection");
			}
		}
	}

}
