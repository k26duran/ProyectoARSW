package edu.eci.arsw.evern.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.eci.arsw.evern.model.Automovil;
import edu.eci.arsw.evern.model.Conductor;
import edu.eci.arsw.evern.persistence.repositories.IAutomovilRepository;
import edu.eci.arsw.evern.persistence.repositories.IComentarioRepository;
import edu.eci.arsw.evern.persistence.repositories.IConductorRepository;
import edu.eci.arsw.evern.persistence.repositories.IPasajeroRepository;
import edu.eci.arsw.evern.persistence.repositories.IViajeRepository;
import edu.eci.arsw.evern.services.contracts.IAutomovilServices;
import edu.eci.arsw.evern.services.contracts.IPasajerosServices;

@RestController
@RequestMapping(value = "v1/automoviles")
public class AutomovilController {



	@Autowired
	IAutomovilServices automovilesServices;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> getAutomoviles(){
		try {
			return new ResponseEntity<>(automovilesServices,HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<>("Error", HttpStatus.NOT_FOUND);
		}
	}
	
}
