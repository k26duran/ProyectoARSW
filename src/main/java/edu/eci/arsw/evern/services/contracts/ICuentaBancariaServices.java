package edu.eci.arsw.evern.services.contracts;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.eci.arsw.evern.model.CuentaBancaria;
import edu.eci.arsw.evern.model.Pasajero;

@Service
public interface ICuentaBancariaServices {

	Long createCuentaBancaria(CuentaBancaria cuentaBancaria);
	void deleteCuentaBancaria(CuentaBancaria cuentaBancaria);
	
}
