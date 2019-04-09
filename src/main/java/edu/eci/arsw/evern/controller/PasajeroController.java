package edu.eci.arsw.evern.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import edu.eci.arsw.evern.model.Pasajero;
import edu.eci.arsw.evern.model.Viaje;
import edu.eci.arsw.evern.persistence.repositories.IAutomovilRepository;
import edu.eci.arsw.evern.persistence.repositories.IComentarioRepository;
import edu.eci.arsw.evern.persistence.repositories.IConductorRepository;
import edu.eci.arsw.evern.persistence.repositories.IPasajeroRepository;
import edu.eci.arsw.evern.persistence.repositories.IViajeRepository;
import edu.eci.arsw.evern.services.contracts.IPasajerosServices;

@RestController
@RequestMapping(value = "v1/pasajeros")
@CrossOrigin()
public class PasajeroController{
	
	
	@Autowired
	IPasajerosServices pasajerosServices;

	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<?> getAllPasajeros() {
		try {
			return new ResponseEntity<>(pasajerosServices.list(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getStackTrace(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/{correo}")
	public ResponseEntity<?> getAllPasajeros(@PathVariable String correo) {
		try {
			return new ResponseEntity<>(pasajerosServices.getPasajeroByCorreo(correo), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getStackTrace(), HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}
	
	@GetMapping("/{correo}/viajes")
	public ResponseEntity<?> getViajesPasajeroByCorreo(@PathVariable String correo){
		try {
			return new ResponseEntity<>(pasajerosServices.getViajesPasajeroByCorreo(correo),HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<>("Error", HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/savePasajero")
	public ResponseEntity<?> postSavePasajero(@RequestBody Pasajero pasajero) {
		try {
			//System.out.println("SE CONECTO");
			//System.out.println(pasajero);
			pasajerosServices.createPasajero(pasajero);
			return new ResponseEntity<>(HttpStatus.CREATED);
		} catch (Exception ex) {
			return new ResponseEntity<>("Error", HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/login/{correo}/{clave}")
	public ResponseEntity<?> login(@PathVariable String correo, @PathVariable String clave){
		try {
			System.out.println("LOGIN!!!!!!! "+correo+ " -> "+clave);
			if(pasajerosServices.getPasajeroByCorreo(correo).getClave().equals(clave)) {
				return new ResponseEntity<>("Acepted",HttpStatus.OK);
				//System.out.println("ACEPTADO");
			}else {
				return new ResponseEntity<>("Error", HttpStatus.NOT_FOUND);
				//System.out.println("ERROR");
			}
		} catch (Exception ex) {
			return new ResponseEntity<>("Error", HttpStatus.NOT_FOUND);
			//System.out.println("ERROR");
		}
		
	}
	
	
	
	
	
	
}
