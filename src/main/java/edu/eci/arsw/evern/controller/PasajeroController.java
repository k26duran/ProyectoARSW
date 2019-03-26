package edu.eci.arsw.evern.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import edu.eci.arsw.evern.model.Pasajero;
import edu.eci.arsw.evern.persistence.repositories.IAutomovilRepository;
import edu.eci.arsw.evern.persistence.repositories.IComentarioRepository;
import edu.eci.arsw.evern.persistence.repositories.IConductorRepository;
import edu.eci.arsw.evern.persistence.repositories.IPasajeroRepository;
import edu.eci.arsw.evern.persistence.repositories.IViajeRepository;
import edu.eci.arsw.evern.services.contracts.IPasajerosServices;

@RestController
@RequestMapping(value = "v1/pasajero")
@CrossOrigin()
public class PasajeroController{
	
	
	@Autowired
	IPasajerosServices iPasajerosServices;

	@GetMapping("/allPasajeros")
	public ResponseEntity<?> getAllPasajeros() {
		try {
			return new ResponseEntity<>(iPasajerosServices.list(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getStackTrace(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/pasajero/{correo}")
	public ResponseEntity<?> getAllPasajeros(@PathVariable String correo) {
		try {
			return new ResponseEntity<>(iPasajerosServices.getPasajeroCorreo(correo), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getStackTrace(), HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}
	
	
	@PostMapping("/savePasajero")
	public ResponseEntity<?> postSavePasajero(@RequestBody Pasajero pasajero) {
		try {
			System.out.println(pasajero.toString());
			System.out.println("FECHA: "+pasajero.getFechaNacimiento());
			iPasajerosServices.createPasajero(pasajero);
			return new ResponseEntity<>(HttpStatus.CREATED);
		} catch (Exception ex) {
			return new ResponseEntity<>("Error", HttpStatus.NOT_FOUND);
		}
	}
	
}
