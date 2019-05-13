package edu.eci.arsw.evern.persistence;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import edu.eci.arsw.evern.controller.EvernException;
import edu.eci.arsw.evern.model.*;
import edu.eci.arsw.evern.persistence.repositories.IAutomovilRepository;

@Component
@Qualifier("AutomovilRepository")
public class AutomovilRepository implements IAutomovilRepository {

	
	@Autowired
	private RepositoryDataBases database;
	
	@Override
	public List<Automovil> findAll() throws EvernException {
		String query = "SELECT * FROM automovil;";
		List<Automovil> automoviles = new ArrayList<>();
		Connection connection = null;
		try {
			connection = database.dataSource().getConnection();
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				Automovil automovil = new Automovil();
				automovil.setColor(rs.getString("color"));
				automovil.setModelo(rs.getString("modelo"));
				automovil.setPlaca(rs.getString("placa"));
				automovil.setTipo(rs.getString("tipo"));
				automoviles.add(automovil);
			}
			database.dataSource().close();
			connection.close();
			return automoviles;
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
	public Automovil find(String placa) throws EvernException {
		String query = "SELECT * FROM automovil;";
		Automovil automovil = new Automovil();
		Connection connection = null;
		try {
			connection = database.dataSource().getConnection();
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				automovil.setColor(rs.getString("color"));
				automovil.setModelo(rs.getString("modelo"));
				automovil.setPlaca(rs.getString("placa"));
				automovil.setTipo(rs.getString("tipo"));
			}
			database.dataSource().close();
			connection.close();
			return automovil;
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
	public String save(Automovil automovil) throws EvernException {
		String query = "INSERT INTO automovil(color,modelo, placa, tipo)"
				+ " values ('" + automovil.getColor() + "','" + automovil.getModelo()+"','"+
					automovil.getPlaca()+"','"+automovil.getTipo()+"');";
		
		Connection connection = null;
		try {
			connection = database.dataSource().getConnection();
			Statement stmt = connection.createStatement();
			stmt.execute(query);
			database.dataSource().close();
			connection.close();
			return automovil.getPlaca();
		}  catch(Exception e) {
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
	public void update(Automovil entity) {
	}

	@Override
	public void delete(Automovil o) throws EvernException {
		String query = "DELETE FROM automovil WHERE placa='"+o.getPlaca()+"';";
		Connection connection = null;
		try {
			connection = database.dataSource().getConnection();
			Statement stmt = connection.createStatement();
			stmt.execute(query);
			database.dataSource().close();
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
	public void remove(String pkEntity) throws EvernException {
		String query = "DELETE FROM automovil WHERE placa='"+pkEntity+"';";
		Connection connection = null;
		try {
			connection = database.dataSource().getConnection();
			Statement stmt = connection.createStatement();
			stmt.execute(query);
			database.dataSource().close();
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
