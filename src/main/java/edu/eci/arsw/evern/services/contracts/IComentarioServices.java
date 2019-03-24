package edu.eci.arsw.evern.services.contracts;

import java.util.List;

import org.springframework.stereotype.Service;
import edu.eci.arsw.evern.model.Comentario;

@Service
public interface IComentarioServices {

	List<Comentario> getComentariosByViajeAndUsuario(long idViaje, String correoUsuario);
	
	void agregarComentarioAlViaje(long idViaje, Comentario comentario);
	
	void eliminarComentarioAlViaje(long idViaje, long idComentario);

}
