package edu.eci.arsw.evern.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import edu.eci.arsw.evern.model.Conductor;
import edu.eci.arsw.evern.model.Login;
import edu.eci.arsw.evern.services.contracts.IAutomovilServices;
import edu.eci.arsw.evern.services.contracts.IConductorServices;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@RestController
@RequestMapping(value = "v1/conductores")
@CrossOrigin(value = "*")
public class ConductorController {

	@Autowired
	IConductorServices conductorServices;
	@Autowired
	IAutomovilServices automovilesServices;

	//private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody Login login){
		try {
			//login.setClave(bCryptPasswordEncoder.encode(login.getClave()));
			Conductor conductor = conductorServices.getConductorByCorreoYClave(login.getCorreo(),
				login.getClave());
			if(conductor.getCorreo()==null) {
				return new ResponseEntity<>("Error", HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<>("OK",HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<>("Error", HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/signup")
	public ResponseEntity<?> signup(@RequestBody Conductor conductor) {
		try {
			//conductor.setClave(bCryptPasswordEncoder.encode(conductor.getClave()));
			String registrarAutomovil = automovilesServices.createAutomovil(conductor.getAutomovil());
			if(registrarAutomovil == null) {
				return new ResponseEntity<>("Error", HttpStatus.BAD_REQUEST);
			}
			return new ResponseEntity<>(conductorServices.createConductor(conductor),HttpStatus.CREATED);
		} catch (Exception ex) {
			return new ResponseEntity<>("Error", HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/{correo}")
	public ResponseEntity<?> getConductorByCorreo(@PathVariable String correo) {
		try {		
			System.out.println(correo);
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
			System.out.println(correo);
			return new ResponseEntity<>(conductorServices.getViajesConductorByCorreo(correo),HttpStatus.OK);
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
}
