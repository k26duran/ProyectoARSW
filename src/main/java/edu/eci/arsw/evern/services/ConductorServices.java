package edu.eci.arsw.evern.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import edu.eci.arsw.evern.model.Conductor;
import edu.eci.arsw.evern.persistence.repositories.IConductorRepository;
import edu.eci.arsw.evern.persistence.repositories.IViajeRepository;
import edu.eci.arsw.evern.services.contracts.IConductorServices;


@Component
public class ConductorServices implements IConductorServices {
	
	
	@Autowired
	@Qualifier("ConductorRepository")
	private IConductorRepository conductorRepository;

	@Override
	public List<Conductor> list() {
		return conductorRepository.findAll();
	}

	@Override
	public Conductor getConductorCorreo(String correo) {
		return conductorRepository.getCondutor(correo);
	}

	@Override
	public Long createConductor(Conductor conductor) {
		return conductorRepository.save(conductor);
	}

	@Override
	public void delete(Conductor pasajero) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void conductorCalificaAlPasajeroByViaje(long idViaje, int calificacion) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actualizarNombres(String correoUsuario, String nuevosNombres) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actualizarApellidos(String correoUsuario, String nuevosApellidos) {
		// TODO Auto-generated method stub
		
	}


}
