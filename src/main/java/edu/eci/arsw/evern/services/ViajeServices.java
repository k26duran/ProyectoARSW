package edu.eci.arsw.evern.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import edu.eci.arsw.evern.model.Automovil;
import edu.eci.arsw.evern.model.Comentario;
import edu.eci.arsw.evern.model.Conductor;
import edu.eci.arsw.evern.model.Viaje;
import edu.eci.arsw.evern.persistence.ViajeRepository;
import edu.eci.arsw.evern.persistence.repositories.*;
import edu.eci.arsw.evern.services.contracts.IViajeServices;

@Component
public class ViajeServices implements  IViajeServices {
	
	@Autowired
	@Qualifier("ViajeRepository")
	private IViajeRepository viajeRepository;

	@Override
	public Long createViaje(Viaje viaje) {
		return viajeRepository.save(viaje);
	}

	@Override
	public void updateViaje(Viaje viaje) {
		viajeRepository.update(viaje);
	}

	@Override
	public void deleteViaje(Viaje viaje) {
		viajeRepository.delete(viaje);
	}

	@Override
	public List<Viaje> getViajes() {
		return viajeRepository.findAll();
	}

	@Override
	public Viaje getViajeById(Long idViaje) {
		return viajeRepository.find(idViaje);
	}

	@Override
	public List<Comentario> getComentariosByViaje(Long idViaje) {
		return viajeRepository.getComentariosByViaje(idViaje);
	}

	@Override
	public Automovil getAutomovilByViaje(Long idViaje) {
		return viajeRepository.getAutomovilByViaje(idViaje);
	}

	
	
}
