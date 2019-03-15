package edu.eci.arsw.evern.controller;

import java.util.List;

import edu.eci.arsw.evern.repository.ViajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.eci.arsw.evern.model.Comentario;
import edu.eci.arsw.evern.model.Conductor;
import edu.eci.arsw.evern.repository.ComentarioRepository;

@RestController
@RequestMapping(value = "v1/evern")
public class EvernController {

	  @Autowired
	  ComentarioRepository comentarioRepository;

	  

	  @Autowired
	  ViajeRepository viajeRepository;

	  
	  @GetMapping("/allComentarios")
	  public List<Comentario> getAllComentario() {
	      return comentarioRepository.findAll();
	  }
	  
	  @PostMapping("/saveComentarios")
	  public Comentario createNote(@RequestBody Comentario comentario) {
	      return comentarioRepository.save(comentario);
	  }


}