package edu.eci.arsw.evern.services.contracts;

import java.util.List;

import org.springframework.stereotype.Service;
import edu.eci.arsw.evern.model.Comentario;

@Service
public interface IComentarioServices {

	List<Comentario> getComentariosByViajeAndUsuario(Long idViaje, String correoUsuario);
	void agregarComentarioAlViaje(Long idViaje, Comentario comentario);
	void eliminarComentarioAlViaje(Long idViaje, Long idComentario);

	/*Long createComentario(Comentario comentario);
	void updateComentario(Comentario comentario);
	void deleteComentario(Comentario comentario);
	*/
}
