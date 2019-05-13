package edu.eci.arsw.evern.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import edu.eci.arsw.evern.model.Automovil;
import edu.eci.arsw.evern.persistence.repositories.IAutomovilRepository;
import edu.eci.arsw.evern.services.contracts.IAutomovilServices;

@Component
public class AutomovilServices  implements IAutomovilServices  {
	
	
	@Autowired
	@Qualifier("AutomovilRepository")
	private IAutomovilRepository automovilRepository;

	@Override
	public String createAutomovil(Automovil automovil) {
		return automovilRepository.save(automovil);
	}

	@Override
	public List<Automovil> getAutomoviles() {
		return automovilRepository.findAll();
	}

	@Override
	public void updateAutomovil(Automovil automovil) {
		automovilRepository.update(automovil);
	}

	@Override
	public void deleteAutomovil(Automovil automovil) {
		automovilRepository.delete(automovil);
	}

	@Override
	public Automovil getAutomovilByPlaca(String placa) {
		return automovilRepository.find(placa);
	}

}
