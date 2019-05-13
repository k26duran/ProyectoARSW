package edu.eci.arsw.evern.persistence;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import edu.eci.arsw.evern.model.*;
import edu.eci.arsw.evern.persistence.repositories.IAutomovilRepository;

@Component
@Qualifier("AutomovilRepository")
public class AutomovilRepository implements IAutomovilRepository {

	@Override
	public List<Automovil> findAll() {
		String query = "SELECT * FROM automovil;";
		List<Automovil> automoviles = new ArrayList<>();
		try {
			Connection connection = RepositoryDataBases.dataSource().getConnection();
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
			RepositoryDataBases.dataSource().close();
			connection.close();
			return automoviles;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public Automovil find(String placa) {
		String query = "SELECT * FROM automovil;";
		Automovil automovil = new Automovil();
		try {
			Connection connection = RepositoryDataBases.dataSource().getConnection();
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				automovil.setColor(rs.getString("color"));
				automovil.setModelo(rs.getString("modelo"));
				automovil.setPlaca(rs.getString("placa"));
				automovil.setTipo(rs.getString("tipo"));
			}
			RepositoryDataBases.dataSource().close();
			connection.close();
			return automovil;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public String save(Automovil automovil) {
		String query = "INSERT INTO automovil(color,modelo, placa, tipo)"
				+ " values ('" + automovil.getColor() + "','" + automovil.getModelo()+"','"+
					automovil.getPlaca()+"','"+automovil.getTipo()+"');";
		System.out.println("SQL-SAVE AUTOMOVIL -> "+query);
		try {
			Connection connection = RepositoryDataBases.dataSource().getConnection();
			Statement stmt = connection.createStatement();
			stmt.execute(query);
			RepositoryDataBases.dataSource().close();
			connection.close();
			return automovil.getPlaca();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void update(Automovil entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Automovil o) {
		// TODO Auto-generated method stub

	}

	@Override
	public void remove(String pkEntity) {
		// TODO Auto-generated method stub
		
	}

}
