package edu.eci.arsw.evern.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import edu.eci.arsw.evern.model.Conductor;
import edu.eci.arsw.evern.services.contracts.IConductorServices;

@RestController
@RequestMapping(value = "v1/conductor")
public class ConductorController {

	@Autowired
	IConductorServices conductorServices;
	
	@GetMapping("/allConductor")
	public ResponseEntity<?> getAllPasajeros() {
		try {
			return new ResponseEntity<>(conductorServices.list(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getStackTrace(), HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}
	
	@GetMapping("/conductor/{correo}")
	public ResponseEntity<?> getAllPasajeros(@PathVariable String correo) {
		try {
			return new ResponseEntity<>(conductorServices.getConductorCorreo(correo), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getStackTrace(), HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}
	
	
	@PostMapping("/saveConductor")
	public ResponseEntity<?> postSavePasajero(@RequestBody Conductor conductor) {
		try {
			conductorServices.createConductor(conductor);
			return new ResponseEntity<>(HttpStatus.CREATED);
		} catch (Exception ex) {
			return new ResponseEntity<>("Error", HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/apartarViaje/{id}")
	public ResponseEntity<?> apartarViajeConductor(@RequestBody Conductor conductor ,@PathVariable int id) {
		try {
			System.out.println(id+" "+conductor.toString());
			conductorServices.apartarViajeConductor(conductor,id);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<>("Error", HttpStatus.NOT_FOUND);
		}
	}

}
