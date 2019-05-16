package edu.eci.arsw.evern.services.contracts;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.eci.arsw.evern.controller.EvernException;
import edu.eci.arsw.evern.model.Automovil;

@Service
public interface IAutomovilServices {

	public String createAutomovil(Automovil automovil) throws EvernException ;
	public void updateAutomovil(Automovil automovil) throws EvernException ;
	public void deleteAutomovil(Automovil automovil) throws EvernException ;
	public void removeAutomovil(String placa) throws EvernException;

	public List<Automovil> getAutomoviles() throws EvernException;
	public Automovil getAutomovilByPlaca(String placa) throws EvernException ;
	
}
