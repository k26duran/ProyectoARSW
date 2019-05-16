package edu.eci.arsw.evern.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import edu.eci.arsw.evern.controller.EvernException;
import edu.eci.arsw.evern.model.Conductor;
import edu.eci.arsw.evern.model.Viaje;
import edu.eci.arsw.evern.persistence.repositories.IConductorRepository;
import edu.eci.arsw.evern.services.contracts.IConductorServices;


@Component
public class ConductorServices implements IConductorServices {
	
	
	@Autowired
	@Qualifier("ConductorRepository")
	private IConductorRepository conductorRepository;

	@Override
	public String createConductor(Conductor conductor) throws EvernException {
		return conductorRepository.save(conductor);
	}

	@Override
	public void updateConductor(Conductor conductor) throws EvernException  {
		conductorRepository.update(conductor);
	}

	@Override
	public void deleteConductor(Conductor conductor) throws EvernException {
		conductorRepository.delete(conductor);		
	}

	@Override
	public void removeConductor(String correoconductor) throws EvernException {
		conductorRepository.remove(correoconductor);
	}

	@Override
	public List<Conductor> getConductores() throws EvernException {
		return conductorRepository.findAll();
	}

	@Override
	public Conductor getConductorByCorreo(String correo) throws EvernException {
		return conductorRepository.find(correo);
	}

	@Override
	public List<Viaje> getViajesConductorByCorreo(String correoConductor) throws EvernException {
		return conductorRepository.getViajesConductorByCorreo(correoConductor);
	}
	
	@Override
	public Conductor getConductorByCorreoYClave(String correoConductor, String clave) throws EvernException {
		return conductorRepository.getConductorByCorreoYClave(correoConductor, clave);		
	}
	

	@Override
	public void conductorCalificaAlPasajeroByViaje(Long idViaje, int calificacion) {
		// TODO Auto-generated method stub
	}

	@Override
	public void updateNombres(String correoUsuario, String nuevosNombres) throws EvernException {
		conductorRepository.updateNombres(correoUsuario, nuevosNombres);
	}

	@Override
	public void updateApellidos(String correoUsuario, String nuevosApellidos) throws EvernException {
		conductorRepository.updateApellidos(correoUsuario, nuevosApellidos);
	}

	@Override
	public void updateCelular(String correoUsuario, String celular) throws EvernException {
		conductorRepository.updateCelular(correoUsuario, celular);
	}

	@Override
	public void updateClave(String correoUsuario, String nuevaClave) throws EvernException {
		conductorRepository.updateClave(correoUsuario, nuevaClave);
	}

	@Override
	public void updateFechaNacimiento(String correoUsuario, String nuevaClave) throws EvernException {
		conductorRepository.updateFechaNacimiento(correoUsuario, nuevaClave);
	}
	
	@Override
	public void updateCasa(String correoUsuario, String nuevaCasa) throws EvernException {
		conductorRepository.updateCasa(correoUsuario, nuevaCasa);
	}
	
	@Override
	public void aceptarViajeConductor(Conductor conductor, Long idViaje) {
		// TODO Auto-generated method stub
		
	}

	
	

}
