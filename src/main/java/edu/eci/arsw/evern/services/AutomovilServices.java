package edu.eci.arsw.evern.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import edu.eci.arsw.evern.controller.EvernException;
import edu.eci.arsw.evern.model.Automovil;
import edu.eci.arsw.evern.persistence.repositories.IAutomovilRepository;
import edu.eci.arsw.evern.services.contracts.IAutomovilServices;

@Component
public class AutomovilServices  implements IAutomovilServices  {
	
	
	@Autowired
	@Qualifier("AutomovilRepository")
	private IAutomovilRepository automovilRepository;

	@Override
	public String createAutomovil(Automovil automovil) throws EvernException {
		return automovilRepository.save(automovil);
	}

	@Override
	public List<Automovil> getAutomoviles() throws EvernException {
		return automovilRepository.findAll();
	}

	@Override
	public void updateAutomovil(Automovil automovil) throws EvernException {
		automovilRepository.update(automovil);
	}

	@Override
	public void deleteAutomovil(Automovil automovil) throws EvernException {
		automovilRepository.delete(automovil);
	}

	@Override
	public Automovil getAutomovilByPlaca(String placa) throws EvernException {
		return automovilRepository.find(placa);
	}

	@Override
	public void removeAutomovil(String placa) throws EvernException {
		automovilRepository.remove(placa);
	}

}
