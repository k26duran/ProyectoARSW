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
import edu.eci.arsw.evern.model.Conductor;
import edu.eci.arsw.evern.model.Pasajero;
import edu.eci.arsw.evern.services.contracts.IAutomovilServices;
import edu.eci.arsw.evern.services.contracts.IConductorServices;

@RestController
@RequestMapping(value = "v1/conductores")
public class ConductorController {

	@Autowired
	IConductorServices conductorServices;
	@Autowired
	IAutomovilServices automovilesServices;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> getConductores() {
		try {
			return new ResponseEntity<>(conductorServices.getConductores(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getStackTrace(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	
	@GetMapping("/{correo}")
	public ResponseEntity<?> getConductorByCorreo(@PathVariable String correo) {
		try {		
			return new ResponseEntity<>(conductorServices.getConductorByCorreo(correo), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getStackTrace(), HttpStatus.NOT_FOUND);

		}
	}
	
	/**
	 * Obtiene la lista de viajes que tiene un pasajero
	 * @param correo
	 * @return lista de viajes
	 */
	@GetMapping("/{correo}/viajes")
	public ResponseEntity<?> getViajesConductorByCorreo(@PathVariable String correo){
		try {
			return new ResponseEntity<>(conductorServices.getConductorByCorreo(correo),HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<>("Error", HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/saveConductor")
	public ResponseEntity<?> postSaveConductor(@RequestBody Conductor conductor) {
		try {
			System.out.println("------ VAMOS A REGISTRAR UN CONDUCTOR ---------");
			System.out.println(conductor);
			return new ResponseEntity<>(conductorServices.createConductor(conductor),HttpStatus.CREATED);
		} catch (Exception ex) {
			return new ResponseEntity<>("Error", HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/aceptarViaje/{idViaje}")
	public ResponseEntity<?> apartarViajeConductor(@RequestBody Conductor conductor ,@PathVariable Long idViaje) {
		try {
			System.out.println(idViaje+" "+conductor.toString());
			conductorServices.aceptarViajeConductor(conductor,idViaje);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<>("Error", HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/{correo}/{clave}")
	public ResponseEntity<?> loginConductor(@PathVariable String correo, @PathVariable String clave){
		try {
			Conductor conductor = conductorServices.getConductorByCorreoYClave(correo, clave);
			if(conductor.getCorreo()==null) {
				return new ResponseEntity<>("Error", HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<>(conductor,HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<>("Error", HttpStatus.NOT_FOUND);
		}
	}

}
