package edu.eci.arsw.evern.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import edu.eci.arsw.evern.model.Viaje;
import edu.eci.arsw.evern.services.contracts.IViajeServices;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;


@RestController
@RequestMapping(value = "v1/viajes")
@CrossOrigin()
public class ViajeController {

	@Autowired
	IViajeServices viajeServices;
	/**
	 * @return Todos los viajes que se han realizado
	 */
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> getViajes() {
		try {
			return new ResponseEntity<>(viajeServices.getViajes(),HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getStackTrace(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	/**
	 * Dado un id obtiene la informacion de un viaje
	 * @param idviaje
	 * @return un objeto de tipo Viaje
	 */
	@GetMapping("/{idviaje}")
	public ResponseEntity<?> getViajeById(@PathVariable Long idviaje) {
		try {
			return new ResponseEntity<>(viajeServices.getViajeById(idviaje), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getStackTrace(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}	
	
	/**
	 * El viaje es creado por un pasajero, el pasajero pide el viaje
	 * @param viaje
	 * @return 200 si puede registrarse correctamente
	 */
	@PostMapping("/save")
	public ResponseEntity<?> create(@RequestBody Viaje viaje) {
		try {
			System.out.println(viaje);
			return new ResponseEntity<>(viajeServices.createViaje(viaje), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>("ERROR", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	/**
	 * Actualiza la información de un viaje
	 * @param viaje
	 * @return OK, si puede actualizar correctamente
	 */
	@PutMapping("/update")
	public ResponseEntity<?>  updateViaje(@RequestBody Viaje viaje) {
		try {
			viajeServices.updateViaje(viaje);
			return new ResponseEntity<>("OK",HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("ERROR", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	/**
	 * Elimina un viaje
	 * @param idviaje
	 * @return OK, si puede eliminar correctamente
	 */
	@DeleteMapping("/{idviaje}/delete")
	public ResponseEntity<?>  deleteViaje(@PathVariable Long idviaje) {
		try {
			viajeServices.deleteViaje(idviaje);
			return new ResponseEntity<>("OK", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("ERROR", HttpStatus.INTERNAL_SERVER_ERROR);
		}		
	}
	
}
