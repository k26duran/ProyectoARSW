package edu.eci.arsw.evern.services.contracts;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.eci.arsw.evern.model.Automovil;

@Service
public interface IAutomovilServices {

	public String createAutomovil(Automovil automovil);
	public void updateAutomovil(Automovil automovil);
	public void deleteAutomovil(Automovil automovil);
	
	public List<Automovil> getAutomoviles();
	public Automovil getAutomovilByPlaca(String placa);
	
}
