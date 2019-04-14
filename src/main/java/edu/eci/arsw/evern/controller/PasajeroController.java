package edu.eci.arsw.evern.controller;

import java.util.List;

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
	
	/**
	 * @return Lista de pasajeros de EVERN DRIVER
	 */
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<?> getPasajeros() {
		try {
			List<Pasajero> pasajeros = pasajerosServices.getPasajeros();
			System.out.println(pasajeros);
			return new ResponseEntity<>(pasajeros, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getStackTrace(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	
	/**
	 * Obtiene la informacion de un pasajero dado su correo
	 * @param correo
	 * @return Un Pasajero
	 */
	@GetMapping("/{correo}")
	public ResponseEntity<?> getPasajeroByCorreo(@PathVariable String correo) {
		try {
			return new ResponseEntity<>(pasajerosServices.getPasajeroByCorreo(correo), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getStackTrace(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	/**
	 * Guarda un pasajero a la base de datos
	 * @param pasajero
	 * @return
	 */
	@PostMapping("/savePasajero")
	public ResponseEntity<?> postSavePasajero(@RequestBody Pasajero pasajero) {
		try {
			return new ResponseEntity<>(pasajerosServices.createPasajero(pasajero),HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
	/**
	 * Obtiene la lista de viajes que tiene un pasajero
	 * @param correo
	 * @return lista de viajes
	 */
	@GetMapping("/{correo}/viajes")
	public ResponseEntity<?> getViajesPasajeroByCorreo(@PathVariable String correo){
		try {
			return new ResponseEntity<>(pasajerosServices.getViajesPasajeroByCorreo(correo),HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<>("Error", HttpStatus.NOT_FOUND);
		}
	}

}
