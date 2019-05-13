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

import edu.eci.arsw.evern.model.Automovil;
import edu.eci.arsw.evern.services.contracts.IAutomovilServices;

@RestController
@RequestMapping(value = "v1/automoviles")
public class AutomovilController {



	@Autowired
	IAutomovilServices automovilesServices;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> getAutomoviles(){
		try {
			return new ResponseEntity<>(automovilesServices.getAutomoviles(),HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<>("Error", HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/{automovilPlaca}")
	public ResponseEntity<?> getAutomovilByPlaca(@PathVariable String automovilPlaca){
		try {
			return new ResponseEntity<>(automovilesServices.getAutomovilByPlaca(automovilPlaca),HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<>("Error", HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/saveAutomovil")
	public ResponseEntity<?> saveAutomovil(@RequestBody Automovil auto){
		try {
			return new ResponseEntity<>(automovilesServices.createAutomovil(auto),HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<>("Error", HttpStatus.NOT_FOUND);
		}
	}
	
}
