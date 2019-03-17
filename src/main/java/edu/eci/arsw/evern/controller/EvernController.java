package edu.eci.arsw.evern.controller;

import java.util.List;

import edu.eci.arsw.evern.model.Automovil;
import edu.eci.arsw.evern.model.Pasajero;
import edu.eci.arsw.evern.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.eci.arsw.evern.model.Comentario;
import edu.eci.arsw.evern.model.Conductor;

@RestController
@RequestMapping(value = "v1/evern")
public class EvernController {

	@Autowired
	ComentarioRepository comentarioRepository;

	@Autowired
	ViajeRepository viajeRepository;

	@Autowired
	ConductorRepository conductorRepository;

	@Autowired
	AutomovilRepository automovilRepository;

	@Autowired
	PasajeroRepository pasajeroRepository;

	@GetMapping("/allComentarios")
	public List<Comentario> getAllComentario() {
		return comentarioRepository.findAll();
	}

	@GetMapping("/allConductores")
	public List<Conductor>  getAllConductores(){
		return conductorRepository.findAll();
	}

	@GetMapping("/allAutomoviles")
	public List<Automovil>  getAllAutomoviles(){
		return automovilRepository.findAll();
	}

	@GetMapping("/allPasajeros")
	public List<Pasajero> getAllPasajeros(){
		return pasajeroRepository.findAll();
	}

	@PostMapping("/saveComentarios")
	public Comentario createComentarios(@RequestBody Comentario comentario) {
		return comentarioRepository.save(comentario);
	}



}