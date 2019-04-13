package edu.eci.arsw.evern.services.contracts;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.eci.arsw.evern.model.Automovil;
import edu.eci.arsw.evern.model.Comentario;
import edu.eci.arsw.evern.model.Conductor;
import edu.eci.arsw.evern.model.Viaje;

@Service
public interface IViajeServices {

	Long createViaje(Viaje viaje);
	void updateViaje(Viaje viaje);
	void deleteViaje(Viaje viaje);
	
	List<Viaje> getViajes();
	Viaje getViajeById(Long idViaje);
	List<Comentario> getComentariosByViaje(Long idViaje);
	Automovil getAutomovilByViaje(Long idViaje);
	
}
