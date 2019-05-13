package edu.eci.arsw.evern.services.contracts;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.eci.arsw.evern.controller.EvernException;
import edu.eci.arsw.evern.model.Comentario;

@Service
public interface IComentarioServices {

	List<Comentario> getComentariosByViajeAndUsuario(Long idViaje, String correoUsuario) throws EvernException ;
	void agregarComentarioAlViaje(Long idViaje, Comentario comentario) throws EvernException ;
	void eliminarComentarioAlViaje(Long idViaje, Long idComentario) throws EvernException ;

	/*Long createComentario(Comentario comentario);
	void updateComentario(Comentario comentario);
	void deleteComentario(Comentario comentario);
	*/
}
