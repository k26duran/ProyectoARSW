package edu.eci.arsw.evern.services.contracts;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.eci.arsw.evern.controller.EvernException;
import edu.eci.arsw.evern.model.Comentario;
import edu.eci.arsw.evern.model.Viaje;

@Service
public interface IViajeServices {

	Long createViaje(Viaje viaje) throws EvernException ;
	void updateViaje(Viaje viaje) throws EvernException ;
	void deleteViaje(Viaje viaje) throws EvernException ;
	
	List<Viaje> getViajes() throws EvernException ;
	Viaje getViajeById(Long idViaje) throws EvernException ;
	List<Comentario> getComentariosByViaje(Long idViaje) throws EvernException ;
	
}
