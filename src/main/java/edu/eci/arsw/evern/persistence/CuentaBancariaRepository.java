package edu.eci.arsw.evern.persistence;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import edu.eci.arsw.evern.model.*;
import edu.eci.arsw.evern.persistence.repositories.ICuentaBancariaRepository;


@Component
@Qualifier("CuentaBancariaRepository")
public class CuentaBancariaRepository implements ICuentaBancariaRepository   {

	//private String dbUrl = System.getenv().get("JDBC_DATABASE_URL");
	
	@Override
	public List<CuentaBancaria> findAll() {
		return null;
	}

	@Override
	public CuentaBancaria find(Long id) {
		return null;
	}

	@Override
	public Long save(CuentaBancaria entity) {
		return null;
	}

	@Override
	public void update(CuentaBancaria entity) {
	}

	@Override
	public void delete(CuentaBancaria o) {
	}

	@Override
	public void remove(Long pkEntity) {
	}

}
