package edu.eci.arsw.evern.controller;

import java.net.Authenticator.RequestorType;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import edu.eci.arsw.evern.model.Pasajero;
import edu.eci.arsw.evern.model.Login;
import edu.eci.arsw.evern.services.contracts.IPasajerosServices;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@RestController
@RequestMapping(value = "v1/pasajeros")
@CrossOrigin(value = "*")
public class PasajeroController{
	
	ObjectMapper mapper = new ObjectMapper();


	@Autowired
	IPasajerosServices pasajerosServices;
	
	//private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody Login login){
		try {
			//login.setClave(bCryptPasswordEncoder.encode(login.getClave()));
			Pasajero pasajero = pasajerosServices.getPasajeroByCorreoYClave(login.getCorreo(),
				login.getClave());
			if(pasajero.getCorreo()==null) {
				return new ResponseEntity<>("Credenciales erroneas", HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<>("OK",HttpStatus.OK);
		} catch (Exception ex) {
			ex.printStackTrace();
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
	
	
	 @RequestMapping(value = "/update/clave")
	 public ResponseEntity<?> updateClavePasajero(@RequestBody Object json){
		try {
			String jsonInString = mapper.writeValueAsString(json);
			JSONObject jsonObj = new JSONObject(jsonInString);
			
			String correo = jsonObj.getString("correo");
			String clave = jsonObj.getString("clave");
			String nuevaClave = jsonObj.getString("nuevaClave");
			
			Pasajero pasajero = pasajerosServices.getPasajeroByCorreoYClave(correo, clave);
			if(pasajero.getCorreo() == null) {
				return new ResponseEntity<>("Credenciales erroneas",HttpStatus.NOT_FOUND);
			}
			pasajerosServices.updateClave(correo, nuevaClave);
			return new ResponseEntity<>("OK",HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<>("Error", HttpStatus.NOT_FOUND);
		}
	}

	 @RequestMapping(value = "/update/celular")
	 public ResponseEntity<?> updateCelularPasajero(@RequestBody Object json){
		try {
			String jsonInString = mapper.writeValueAsString(json);
			JSONObject jsonObj = new JSONObject(jsonInString);
			
			String correo = jsonObj.getString("correo");
			String clave = jsonObj.getString("clave");
			String nuevoCelular = jsonObj.getString("nuevoCelular");
			
			Pasajero pasajero = pasajerosServices.getPasajeroByCorreoYClave(correo, clave);
			if(pasajero.getCorreo() == null) {
				return new ResponseEntity<>("Credenciales erroneas",HttpStatus.NOT_FOUND);
			}
			pasajerosServices.updateCelular(correo, nuevoCelular);
			return new ResponseEntity<>("OK",HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<>("Error", HttpStatus.NOT_FOUND);
		}
	}
	 
	 @RequestMapping(value = "/update/nombres")
	 public ResponseEntity<?> updateNombresPasajero(@RequestBody Object json){
		try {
			String jsonInString = mapper.writeValueAsString(json);
			JSONObject jsonObj = new JSONObject(jsonInString);
			
			String correo = jsonObj.getString("correo");
			String clave = jsonObj.getString("clave");
			String nuevosNombres = jsonObj.getString("nuevosNombres");
			
			Pasajero pasajero = pasajerosServices.getPasajeroByCorreoYClave(correo, clave);
			if(pasajero.getCorreo() == null) {
				return new ResponseEntity<>("Credenciales erroneas",HttpStatus.NOT_FOUND);
			}
			pasajerosServices.updateNombres(correo, nuevosNombres);
			return new ResponseEntity<>("OK",HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<>("Error", HttpStatus.NOT_FOUND);
		}
	}
	 
	 @RequestMapping(value = "/update/apellidos")
	 public ResponseEntity<?> updateApellidosPasajero(@RequestBody Object json){
		try {
			String jsonInString = mapper.writeValueAsString(json);
			JSONObject jsonObj = new JSONObject(jsonInString);
			
			String correo = jsonObj.getString("correo");
			String clave = jsonObj.getString("clave");
			String nuevosApellidos = jsonObj.getString("nuevosApellidos");
			
			Pasajero pasajero = pasajerosServices.getPasajeroByCorreoYClave(correo, clave);
			if(pasajero.getCorreo() == null) {
				return new ResponseEntity<>("Credenciales erroneas",HttpStatus.NOT_FOUND);
			}
			pasajerosServices.updateApellidos(correo, nuevosApellidos);
			return new ResponseEntity<>("OK",HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<>("Error", HttpStatus.NOT_FOUND);
		}
	}
	 
	 @RequestMapping(value = "/update/fechaNacimiento")
	 public ResponseEntity<?> updateFechaNacimientoPasajero(@RequestBody Object json){
		try {
			String jsonInString = mapper.writeValueAsString(json);
			JSONObject jsonObj = new JSONObject(jsonInString);
			
			String correo = jsonObj.getString("correo");
			String clave = jsonObj.getString("clave");
			String nuevaFechaNacimiento = jsonObj.getString("nuevaFechaNacimiento");
			
			Pasajero pasajero = pasajerosServices.getPasajeroByCorreoYClave(correo, clave);
			if(pasajero.getCorreo() == null) {
				return new ResponseEntity<>("Credenciales erroneas",HttpStatus.NOT_FOUND);
			}
			pasajerosServices.updateFechaNacimiento(correo, nuevaFechaNacimiento);
			return new ResponseEntity<>("OK",HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<>("Error", HttpStatus.NOT_FOUND);
		}
	}
	 
	 @RequestMapping(value = "/update/casa")
	 public ResponseEntity<?> updateCasaPasajero(@RequestBody Object json){
		try {
			String jsonInString = mapper.writeValueAsString(json);
			JSONObject jsonObj = new JSONObject(jsonInString);
			
			String correo = jsonObj.getString("correo");
			String clave = jsonObj.getString("clave");
			String nuevaCasa = jsonObj.getString("nuevaCasa");
			Pasajero pasajero = pasajerosServices.getPasajeroByCorreoYClave(correo, clave);
			if(pasajero.getCorreo() == null) {
				return new ResponseEntity<>("Credenciales erroneas",HttpStatus.NOT_FOUND);
			}
			pasajerosServices.updateCasa(correo, nuevaCasa);
			return new ResponseEntity<>("OK",HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<>("Error", HttpStatus.NOT_FOUND);
		}
	}

}
