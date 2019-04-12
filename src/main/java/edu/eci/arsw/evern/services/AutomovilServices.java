package edu.eci.arsw.evern.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import edu.eci.arsw.evern.model.Automovil;
import edu.eci.arsw.evern.persistence.repositories.IAutomovilRepository;
import edu.eci.arsw.evern.persistence.repositories.IViajeRepository;
import edu.eci.arsw.evern.services.contracts.IAutomovilServices;

@Component
public class AutomovilServices  implements IAutomovilServices  {
	
	
	@Autowired
	@Qualifier("AutomovilRepository")
	private IAutomovilRepository automovilRepository;

	@Override
	public Long createAutomovil(Automovil automovil) {
		// TODO Auto-generated method stub
		return null;
	}


}
