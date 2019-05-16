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
			return new ResponseEntity<>("ERROR", HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/{automovilPlaca}")
	public ResponseEntity<?> getAutomovilByPlaca(@PathVariable String automovilPlaca){
		try {
			Automovil automovil = automovilesServices.getAutomovilByPlaca(automovilPlaca);
			if(automovil.getPlaca()==null){
				return new ResponseEntity<>("NO EXISTE",HttpStatus.OK);
			}
			return new ResponseEntity<>(automovil,HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<>("ERROR", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
