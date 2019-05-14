package edu.eci.arsw.evern.controller;

import java.net.Authenticator.RequestorType;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	/**
	 * Verifica que las credenciales del pasajero sea correcta
	 * @param login
	 * @return OK, si las credenciales son correctas.
	 */
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
			return new ResponseEntity<>("Error", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * Guarda un pasajero a la base de datos
	 * @param pasajero
	 * @return correo del pasajero, si se puede registrar satisfactoriamente
	 */
	@PostMapping("/signup")
	public ResponseEntity<?> postSavePasajero(@RequestBody Pasajero pasajero) {
		try {
			//pasajero.setClave(bCryptPasswordEncoder.encode(pasajero.getClave()));
			return new ResponseEntity<>(pasajerosServices.createPasajero(pasajero),HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * Obtiene la informacion de un pasajero dado su correo
	 * @param correo
	 * @return un objeto de tipo Pasajero
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
			return new ResponseEntity<>("Error", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	/**
	 * Actualiza la clave de un pasajero.
	 * 
	 * @param json
	 * @param correopasajero
	 * @return Una cadena, OK si puede actualizar correctamente la clave, No autorizado si un
	 * 		   conductor quiere actualizar la información de otro, Error si no puede
	 * 		   actualizar la informacion en la base de datos, y Credenciales erroneas.
	 */
	@PutMapping(value = "/{correopasajero}/update/clave")
	 public ResponseEntity<?> updateClavePasajero(@RequestBody Object json, @PathVariable String correopasajero){
		try {
			String jsonInString = mapper.writeValueAsString(json);
			JSONObject jsonObj = new JSONObject(jsonInString);
			
			String correo = jsonObj.getString("correo");
			String clave = jsonObj.getString("clave");
			String nuevaClave = jsonObj.getString("nuevaClave");
			
			if(!correopasajero.equals(correo)) {
				return new ResponseEntity<>("No autorizado",HttpStatus.UNAUTHORIZED);
			}
			
			Pasajero pasajero = pasajerosServices.getPasajeroByCorreoYClave(correo, clave);
			if(pasajero.getCorreo() == null) {
				return new ResponseEntity<>("Credenciales erroneas",HttpStatus.NOT_FOUND);
			}
			pasajerosServices.updateClave(correopasajero, nuevaClave);
			return new ResponseEntity<>("OK",HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<>("Error", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	/**
	 * Actualiza el numero de celular del pasajero. 
	 * @param json
	 * @param correopasajero
	 * @return Una cadena, OK si puede actualizar correctamente el celular, No autorizado si un
	 * 		   conductor quiere actualizar la información de otro, Error si no puede
	 * 		   actualizar la informacion en la base de datos, y Credenciales erroneas.
	 */
	@PutMapping(value = "/{correopasajero}/update/celular")
	 public ResponseEntity<?> updateCelularPasajero(@RequestBody Object json, @PathVariable String correopasajero){
		try {
			String jsonInString = mapper.writeValueAsString(json);
			JSONObject jsonObj = new JSONObject(jsonInString);
			
			String correo = jsonObj.getString("correo");
			String clave = jsonObj.getString("clave");
			String nuevoCelular = jsonObj.getString("nuevoCelular");
			
			if(!correopasajero.equals(correo)) {
				return new ResponseEntity<>("No autorizado",HttpStatus.UNAUTHORIZED);
			}
			
			Pasajero pasajero = pasajerosServices.getPasajeroByCorreoYClave(correo, clave);
			if(pasajero.getCorreo() == null) {
				return new ResponseEntity<>("Credenciales erroneas",HttpStatus.NOT_FOUND);
			}
			pasajerosServices.updateCelular(correopasajero, nuevoCelular);
			return new ResponseEntity<>("OK",HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<>("Error", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	 
	/**
	 * Actualiza los nombres del pasajero.
	 * 
	 * @param json
	 * @param correopasajero
	 * @return Una cadena, OK si puede actualizar correctamente los nombres, No autorizado si un
	 * 		   conductor quiere actualizar la información de otro, Error si no puede
	 * 		   actualizar la informacion en la base de datos, y Credenciales erroneas.
	 */
	 @PutMapping(value = "/{correopasajero}/update/nombres")
	 public ResponseEntity<?> updateNombresPasajero(@RequestBody Object json, @PathVariable String correopasajero){
		try {
			String jsonInString = mapper.writeValueAsString(json);
			JSONObject jsonObj = new JSONObject(jsonInString);
			
			String correo = jsonObj.getString("correo");
			String clave = jsonObj.getString("clave");
			String nuevosNombres = jsonObj.getString("nuevosNombres");
			
			if(!correopasajero.equals(correo)) {
				return new ResponseEntity<>("No autorizado",HttpStatus.UNAUTHORIZED);
			}
			
			Pasajero pasajero = pasajerosServices.getPasajeroByCorreoYClave(correo, clave);
			if(pasajero.getCorreo() == null) {
				return new ResponseEntity<>("Credenciales erroneas",HttpStatus.NOT_FOUND);
			}
			pasajerosServices.updateNombres(correopasajero, nuevosNombres);
			return new ResponseEntity<>("OK",HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<>("Error", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	 
	 /**
	  * Actualiza los apellidos del pasajero.
	  * 
	  * @param json
	  * @param correopasajero
	  * @return Una cadena, OK si puede actualizar correctamente los apellidos, No autorizado si un
	 * 		   conductor quiere actualizar la información de otro, Error si no puede
	 * 		   actualizar la informacion en la base de datos, y Credenciales erroneas.
	  */
	 @PutMapping(value = "/{correopasajero}/update/apellidos")
	 public ResponseEntity<?> updateApellidosPasajero(@RequestBody Object json, @PathVariable String correopasajero){
		try {
			String jsonInString = mapper.writeValueAsString(json);
			JSONObject jsonObj = new JSONObject(jsonInString);
			
			String correo = jsonObj.getString("correo");
			String clave = jsonObj.getString("clave");
			String nuevosApellidos = jsonObj.getString("nuevosApellidos");
			
			if(!correopasajero.equals(correo)) {
				return new ResponseEntity<>("No autorizado",HttpStatus.UNAUTHORIZED);
			}
			
			Pasajero pasajero = pasajerosServices.getPasajeroByCorreoYClave(correo, clave);
			if(pasajero.getCorreo() == null) {
				return new ResponseEntity<>("Credenciales erroneas",HttpStatus.NOT_FOUND);
			}
			pasajerosServices.updateApellidos(correopasajero, nuevosApellidos);
			return new ResponseEntity<>("OK",HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<>("Error", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	 
	 /**
	  * Actualiza la fecha de nacimiento del pasajero.
	  * 
	  * @param json
	  * @param correopasajero
	  * @return Una cadena, OK si puede actualizar correctamente la fecha de nacimiento, No autorizado si un
	 * 		   conductor quiere actualizar la información de otro, Error si no puede
	 * 		   actualizar la informacion en la base de datos, y Credenciales erroneas.
	  */
	 @PutMapping(value = "/{correopasajero}/update/fechaNacimiento")
	 public ResponseEntity<?> updateFechaNacimientoPasajero(@RequestBody Object json, @PathVariable String correopasajero){
		try {
			String jsonInString = mapper.writeValueAsString(json);
			JSONObject jsonObj = new JSONObject(jsonInString);
			
			String correo = jsonObj.getString("correo");
			String clave = jsonObj.getString("clave");
			String nuevaFechaNacimiento = jsonObj.getString("nuevaFechaNacimiento");
			
			if(!correopasajero.equals(correo)) {
				return new ResponseEntity<>("No autorizado",HttpStatus.UNAUTHORIZED);
			}
			
			Pasajero pasajero = pasajerosServices.getPasajeroByCorreoYClave(correo, clave);
			if(pasajero.getCorreo() == null) {
				return new ResponseEntity<>("Credenciales erroneas",HttpStatus.NOT_FOUND);
			}
			pasajerosServices.updateFechaNacimiento(correopasajero, nuevaFechaNacimiento);
			return new ResponseEntity<>("OK",HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<>("Error", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	 
	/**
	 * Actualiza la casa del pasajero
	 * 
	 * @param json
	 * @param correopasajero
	 * @return Una cadena, OK si puede actualizar correctamente la casa, No autorizado si un
	 * 		   conductor quiere actualizar la información de otro, Error si no puede
	 * 		   actualizar la informacion en la base de datos, y Credenciales erroneas.
	 */
	 @PutMapping(value = "/{correopasajero}/update/casa")
	 public ResponseEntity<?> updateCasaPasajero(@RequestBody Object json, @PathVariable String correopasajero){
		try {
			String jsonInString = mapper.writeValueAsString(json);
			JSONObject jsonObj = new JSONObject(jsonInString);
			
			String correo = jsonObj.getString("correo");
			String clave = jsonObj.getString("clave");
			String nuevaCasa = jsonObj.getString("nuevaCasa");
			
			if(!correopasajero.equals(correo)) {
				return new ResponseEntity<>("No autorizado",HttpStatus.UNAUTHORIZED);
			}
			
			Pasajero pasajero = pasajerosServices.getPasajeroByCorreoYClave(correo, clave);
			if(pasajero.getCorreo() == null) {
				return new ResponseEntity<>("Credenciales erroneas",HttpStatus.NOT_FOUND);
			}
			
			pasajerosServices.updateCasa(correopasajero, nuevaCasa);
			return new ResponseEntity<>("OK",HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<>("Error", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
