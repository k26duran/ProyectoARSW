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
import edu.eci.arsw.evern.model.Pasajero;
import edu.eci.arsw.evern.model.Viaje;
import edu.eci.arsw.evern.persistence.repositories.IPasajeroRepository;

@Component
@Qualifier("PasajeroRepository")
public class PasajeroRepository implements  IPasajeroRepository {
	
	@Autowired
	private RepositoryDataBases database;
	 
	@Override
	public List<Pasajero> findAll() throws EvernException {
		String query = "SELECT * FROM pasajero;";
		List<Pasajero> pasajeros = new ArrayList<>();
		Connection connection = null;
		try {
			connection = database.dataSource().getConnection();
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				Pasajero pasajero = new Pasajero();
				pasajero.setApellidos(rs.getString("apellidos"));
				pasajero.setNombres(rs.getString("nombres"));
				pasajero.setCelular(rs.getString("celular"));
				pasajero.setCorreo(rs.getString("correo"));
				pasajero.setFechaNacimiento(rs.getString("fecha_nacimiento"));
				pasajeros.add(pasajero);
			}
			connection.close();
			return pasajeros;
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
	public Pasajero find(String correo) throws EvernException {
		String query = "SELECT * FROM pasajero p where p.correo = '"+correo+"';";
		Connection connection = null;
		Pasajero pasajero = new Pasajero();
		try {
			connection = database.dataSource().getConnection();
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				pasajero.setApellidos(rs.getString("apellidos"));
				pasajero.setNombres(rs.getString("nombres"));
				pasajero.setCelular(rs.getString("celular"));
				pasajero.setCorreo(rs.getString("correo"));
				pasajero.setFechaNacimiento(rs.getString("fecha_nacimiento"));
				pasajero.setCalificacion(rs.getInt("calificacion"));
				pasajero.setCasa(rs.getString("casa"));
			}
			System.out.println(pasajero);
			connection.close();
			return pasajero;
		}catch(Exception e) {
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
	public void update(Pasajero entity) {// TODO Auto-generated method stub
	}

	@Override
	public void delete(Pasajero o) throws EvernException {
		String query = "DELETE FROM pasajero WHERE correo = '"+o.getCorreo()+"'; ";
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
	public String save(Pasajero pasajero) throws EvernException {
		String query = "INSERT INTO pasajero(nombres,apellidos,calificacion,celular,clave,correo,fecha_nacimiento, casa)"
		 +"values ('"+pasajero.getNombres()+"','"+pasajero.getApellidos()+"',0,'"+pasajero.getCelular()+"','"+pasajero.getClave()+"','"
				+pasajero.getCorreo()+"',null,'"+pasajero.getCasa()+"');";
		System.err.println("SAVE PASAJERO");
		Connection connection = null;
		try {
			connection = database.dataSource().getConnection();
			Statement stmt = connection.createStatement();
			stmt.execute(query);
			connection.close();
			return pasajero.getCorreo();
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
	
	public List<Viaje> getViajesPasajeroByCorreo(String correoPasajero) throws EvernException{
		String query = "SELECT * FROM viaje WHERE correo_pasajero ='"+correoPasajero+"';" ;
		List<Viaje> viajesPasajero = new ArrayList<>();
		Connection connection = null;
		try {
			connection = database.dataSource().getConnection();
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				Viaje viaje=new Viaje();
				viaje.setId(rs.getLong("id"));
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
			connection.close();
			return viajesPasajero;
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
	public void pasajeroCalificaAlConductorByViaje(Long idViaje, int calificacion) throws EvernException {
		String sql = "UPDATE viaje"+
				" SET calificacion_al_conductor="+String.valueOf(calificacion)+
				" WHERE id="+idViaje.toString()+";";
		Connection connection = null;
		try {
			connection = database.dataSource().getConnection();
			Statement stmt = connection.createStatement();
			stmt.execute(sql);
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
	public void updateNombres(String correoUsuario, String nuevosNombres) throws EvernException {
		String sql = "UPDATE pasajero"+
				" SET nombres='"+nuevosNombres+"'"+
				" WHERE correo='"+correoUsuario+"';";
		Connection connection = null;
		try {
			connection = database.dataSource().getConnection();
			Statement stmt = connection.createStatement();
			stmt.execute(sql);
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
	public void updateApellidos(String correoUsuario, String nuevosApellidos) throws EvernException {
		String sql = "UPDATE pasajero"+
				" SET apellidos='"+nuevosApellidos+"'"+
				" WHERE correo='"+correoUsuario+"';";
		Connection connection = null;
		try {
			connection = database.dataSource().getConnection();
			Statement stmt = connection.createStatement();
			stmt.execute(sql);
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
	public void updateCelular(String correoUsuario, String nuevoCelular) throws EvernException {
		String sql = "UPDATE pasajero"+
				" SET celular='"+nuevoCelular+"'"+
				" WHERE correo='"+correoUsuario+"';";
		Connection connection = null;
		try {
			connection = database.dataSource().getConnection();
			Statement stmt = connection.createStatement();
			stmt.execute(sql);
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
	public void updateClave(String correoUsuario, String nuevaClave) throws EvernException {
		String sql = "UPDATE pasajero"+
				" SET clave='"+nuevaClave+"'"+
				" WHERE correo='"+correoUsuario+"';";
		Connection connection = null;
		try {
			connection = database.dataSource().getConnection();
			Statement stmt = connection.createStatement();
			stmt.execute(sql);
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
	public void updateFechaNacimiento(String correoUsuario, String nuevaFechaNacimiento) throws EvernException {
		String sql = "UPDATE pasajero"+
				" SET fecha_nacimiento='"+nuevaFechaNacimiento+"'"+
				" WHERE correo='"+correoUsuario+"';";
		Connection connection = null;
		try {
			connection = database.dataSource().getConnection();
			Statement stmt = connection.createStatement();
			stmt.execute(sql);
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
	public void updateCasa(String correoUsuario, String nuevaCasa) throws EvernException {
		String sql = "UPDATE pasajero"+
				" SET casa='"+nuevaCasa+"'"+
				" WHERE correo='"+correoUsuario+"';";
		Connection connection = null;
		try {
			connection = database.dataSource().getConnection();
			Statement stmt = connection.createStatement();
			stmt.execute(sql);
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
	public void updateCalificacion(String correoUsuario, int nuevaCalificacion) throws EvernException {
		String sql = "UPDATE pasajero"+
				" SET calificacion='"+String.valueOf(nuevaCalificacion)+"'"+
				" WHERE correo='"+correoUsuario+"';";
		Connection connection = null;
		try {
			connection = database.dataSource().getConnection();
			Statement stmt = connection.createStatement();
			stmt.execute(sql);
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
	public Pasajero getPasajeroByCorreoYClave(String correoPasajero, String clave) throws EvernException {
		String query = "SELECT * FROM pasajero p WHERE p.correo = '"+correoPasajero+"' AND p.clave='"+clave+"';";
		Connection connection = null;
		Pasajero pasajero = new Pasajero();
		try {
			connection = database.dataSource().getConnection();
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				pasajero.setApellidos(rs.getString("apellidos"));
				pasajero.setNombres(rs.getString("nombres"));
				pasajero.setCelular(rs.getString("celular"));
				pasajero.setCorreo(rs.getString("correo"));
			}
			connection.close();
			return pasajero;
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
	public void remove(String pkEntity) throws EvernException {
		String query = "DELETE FROM pasajero WHERE correo = '"+pkEntity+"'; ";
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
