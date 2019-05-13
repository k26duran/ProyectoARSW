package edu.eci.arsw.evern.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import edu.eci.arsw.evern.model.CuentaBancaria;
import edu.eci.arsw.evern.persistence.repositories.ICuentaBancariaRepository;
import edu.eci.arsw.evern.services.contracts.ICuentaBancariaServices;

@Component
public class CuentaBancariaServices  implements ICuentaBancariaServices {
	
	
	@Autowired
	@Qualifier("CuentaBancariaRepository")
	private ICuentaBancariaRepository cuentaBancRepository;

	@Override
	public Long createCuentaBancaria(CuentaBancaria cuentaBancaria) {
		return cuentaBancRepository.save(cuentaBancaria);
	}

	@Override
	public void deleteCuentaBancaria(CuentaBancaria cuentaBancaria) {
		cuentaBancRepository.update(cuentaBancaria);
	}


}
