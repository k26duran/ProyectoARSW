package edu.eci.arsw.evern.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import edu.eci.arsw.evern.model.Comentario;
import edu.eci.arsw.evern.persistence.repositories.IComentarioRepository;
import edu.eci.arsw.evern.persistence.repositories.IViajeRepository;
import edu.eci.arsw.evern.services.contracts.IComentarioServices;


@Component
public  class ComentarioServices  implements  IComentarioServices{
	
	
	@Autowired
	@Qualifier("ComentarioRepository")
	private IComentarioRepository comentarioRepository;

	@Override
	public List<Comentario> getComentariosByViajeAndUsuario(Long idViaje, String correoUsuario) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void agregarComentarioAlViaje(Long idViaje, Comentario comentario) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminarComentarioAlViaje(Long idViaje, Long idComentario) {
		// TODO Auto-generated method stub
		
	}

}
