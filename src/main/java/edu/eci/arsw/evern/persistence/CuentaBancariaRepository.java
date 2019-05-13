package edu.eci.arsw.evern.persistence;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import edu.eci.arsw.evern.model.*;
import edu.eci.arsw.evern.persistence.repositories.ICuentaBancariaRepository;


@Component
@Qualifier("CuentaBancariaRepository")
public class CuentaBancariaRepository implements ICuentaBancariaRepository   {

	private String dbUrl = System.getenv().get("JDBC_DATABASE_URL");
	
	@Override
	public List<CuentaBancaria> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CuentaBancaria find(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long save(CuentaBancaria entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(CuentaBancaria entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(CuentaBancaria o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(Long pkEntity) {
		// TODO Auto-generated method stub
		
	}

}
