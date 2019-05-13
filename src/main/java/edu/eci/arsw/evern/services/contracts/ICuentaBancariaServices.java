package edu.eci.arsw.evern.services.contracts;

import org.springframework.stereotype.Service;
import edu.eci.arsw.evern.model.CuentaBancaria;


@Service
public interface ICuentaBancariaServices {

	Long createCuentaBancaria(CuentaBancaria cuentaBancaria);
	void deleteCuentaBancaria(CuentaBancaria cuentaBancaria);
	
}
