package edu.eci.arsw.evern.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import edu.eci.arsw.evern.model.*;
import edu.eci.arsw.evern.services.contracts.*;
import java.util.*;


@RestController
@RequestMapping(value = "v1/viajes")
@CrossOrigin()
public class ViajeController {

	@Autowired
	IViajeServices viajeServices;
	
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> list() {
		try {
			return new ResponseEntity<>(viajeServices.list(),HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getStackTrace(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * El viaje es creado por un pasajero, el pasajero pide el viaje
	 * @param viaje
	 * @return
	 */
	@PostMapping("/saveViaje")
	public ResponseEntity<?>  create(@RequestBody Viaje viaje) {
		try {
			return new ResponseEntity<>(viajeServices.create(viaje), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getStackTrace(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	public ResponseEntity<?>  updateViaje(Viaje car) {
		try {
			return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getStackTrace(), HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	public ResponseEntity<?>  deleteViaje(Viaje car) {
		try {
			return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getStackTrace(), HttpStatus.INTERNAL_SERVER_ERROR);
		}		
	}

	public ResponseEntity<?> agregarViaje(Viaje viaje) {
		try {
			return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getStackTrace(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public ResponseEntity<?> getViajesDelUsuario(String correoUsuario) {
		try {
			return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getStackTrace(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	
}
