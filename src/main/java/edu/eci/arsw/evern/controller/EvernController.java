package edu.eci.arsw.evern.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.eci.arsw.evern.model.Comentario;
import edu.eci.arsw.evern.repository.ComentarioRepository;

@RestController
@RequestMapping(value = "v1/evern")
public class EvernController {

	  @Autowired
	  ComentarioRepository conductorRepository;
	  
	  
	  @GetMapping("/allComentarios")
	  public List<Comentario> getAllComentario() {
	      return conductorRepository.findAll();
	  }
	  
	  @PostMapping("/sabeComentarios")
	  public Comentario createNote(@RequestBody Comentario comentario) {
	      return conductorRepository.save(comentario);
	  }
	
	
}