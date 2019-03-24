package edu.eci.arsw.evern.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import edu.eci.arsw.evern.model.CuentaBancaria;
import edu.eci.arsw.evern.persistence.repositories.ICuentaBancariaRepository;
import edu.eci.arsw.evern.persistence.repositories.IViajeRepository;
import edu.eci.arsw.evern.services.contracts.ICuentaBancariaServices;


@Component
public class CuentaBancariaServices  implements ICuentaBancariaServices {
	
	
	@Autowired
	@Qualifier("CuentaBancariaRepository")
	private ICuentaBancariaRepository bancariaRepository;


	@Override
	public List<CuentaBancaria> list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CuentaBancaria create(CuentaBancaria car) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CuentaBancaria get(String licencePlate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(CuentaBancaria cuentaBancaria) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(CuentaBancaria cuentaBancaria) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void agregarCuentaBancaria(String correoUsuario, CuentaBancaria cuentaBancaria) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminarCuentaBancaria(String correoUsuario, long idCuentaBancaria) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminarCuentas(String correoUsuario) {
		// TODO Auto-generated method stub
		
	}

}
