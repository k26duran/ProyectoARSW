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
import edu.eci.arsw.evern.model.Pasajero;
import edu.eci.arsw.evern.model.Login;
import edu.eci.arsw.evern.services.contracts.IPasajerosServices;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@RestController
@RequestMapping(value = "v1/pasajeros")
@CrossOrigin(value = "*")
public class PasajeroController{

	@Autowired
	IPasajerosServices pasajerosServices;
	
	//private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody Login login){
		try {
			//login.setClave(bCryptPasswordEncoder.encode(login.getClave()));
			System.out.println(login);
			Pasajero pasajero = pasajerosServices.getPasajeroByCorreoYClave(login.getCorreo(),
				login.getClave());
			if(pasajero.getCorreo()==null) {
				return new ResponseEntity<>("Error", HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<>("OK",HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<>("Error", HttpStatus.NOT_FOUND);
		}
	}

	/**
	 * Guarda un pasajero a la base de datos
	 * @param pasajero
	 * @return
	 */
	@PostMapping("/signup")
	public ResponseEntity<?> postSavePasajero(@RequestBody Pasajero pasajero) {
		try {
			//pasajero.setClave(bCryptPasswordEncoder.encode(pasajero.getClave()));
			return new ResponseEntity<>(pasajerosServices.createPasajero(pasajero),HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
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
