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
import edu.eci.arsw.evern.repository.ConductorRepository;

@RestController
@RequestMapping(value = "v1/evern")
public class EvernController {

	  @Autowired
	  ComentarioRepository comentarioRepository;

	  
	  @Autowired
	  ConductorRepository conductorRepository;

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


	  @GetMapping("/allConductor")
	  public List<Conductor> getAllConductor() {
	      return conductorRepository.findAll();
	  }
	  
	  @PostMapping("/saveConductor")
	  public Conductor addConductor(@RequestBody Conductor comentario) {
	      return conductorRepository.save(comentario);

	  }

}