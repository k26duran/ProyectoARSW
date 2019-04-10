package edu.eci.arsw.evern.services.contracts;

import org.springframework.stereotype.Service;

import edu.eci.arsw.evern.model.Automovil;

@Service
public interface IAutomovilServices {

	public Long createAutomovil(Automovil automovil);
	
}
