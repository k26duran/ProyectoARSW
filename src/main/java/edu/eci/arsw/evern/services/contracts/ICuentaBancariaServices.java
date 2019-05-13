package edu.eci.arsw.evern.services.contracts;

import org.springframework.stereotype.Service;

import edu.eci.arsw.evern.controller.EvernException;
import edu.eci.arsw.evern.model.CuentaBancaria;


@Service
public interface ICuentaBancariaServices {

	Long createCuentaBancaria(CuentaBancaria cuentaBancaria) throws EvernException ;
	void deleteCuentaBancaria(CuentaBancaria cuentaBancaria) throws EvernException ;
	
}
