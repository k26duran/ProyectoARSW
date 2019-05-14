package edu.eci.arsw.evern.controller;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import edu.eci.arsw.evern.model.Conductor;
import edu.eci.arsw.evern.model.Login;
import edu.eci.arsw.evern.services.contracts.IAutomovilServices;
import edu.eci.arsw.evern.services.contracts.IConductorServices;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@RestController
@RequestMapping(value = "v1/conductores")
@CrossOrigin(value = "*")
public class ConductorController {

	ObjectMapper mapper = new ObjectMapper();
	
	@Autowired
	IConductorServices conductorServices;
	@Autowired
	IAutomovilServices automovilesServices;

	//private BCryptPasswordEncoder bCryptPasswordEncoder;
	/**
	 * 
	 * @param login
	 * @return OK, si las credenciales son correctas
	 */
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody Login login){
		try {
			//login.setClave(bCryptPasswordEncoder.encode(login.getClave()));
			Conductor conductor = conductorServices.getConductorByCorreoYClave(login.getCorreo(),
				login.getClave());
			if(conductor.getCorreo()==null) {
				return new ResponseEntity<>("Credenciales erroneas", HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<>("OK",HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<>("Error", HttpStatus.NOT_FOUND);
		}
	}
	
	/**
	 * Registra a un conductor
	 * @param conductor
	 * @return correo del conductor, si se puede registrar satisfactoriamente
	 */
	@PostMapping("/signup")
	public ResponseEntity<?> signup(@RequestBody Conductor conductor) {
		try {
			//conductor.setClave(bCryptPasswordEncoder.encode(conductor.getClave()));
			String registrarAutomovil = automovilesServices.createAutomovil(conductor.getAutomovil());
			if(registrarAutomovil == null) {
				return new ResponseEntity<>("El automovil no se pudo registrar", HttpStatus.BAD_REQUEST);
			}
			return new ResponseEntity<>(conductorServices.createConductor(conductor),HttpStatus.CREATED);
		} catch (Exception ex) {
			return new ResponseEntity<>("Error", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	/**
	 * Obtiene la informacion del conductor por medio del correo
	 * @param correo
	 * @return objeto de tipo Conductor
	 */
	@GetMapping("/{correo}")
	public ResponseEntity<?> getConductorByCorreo(@PathVariable String correo) {
		try {		
			return new ResponseEntity<>(conductorServices.getConductorByCorreo(correo), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getStackTrace(), HttpStatus.NOT_FOUND);
		}
	}
	
	/**
	 * Obtiene la lista de viajes que tiene un conductor
	 * @param correo
		 * @return lista de viajes
	 */
	@GetMapping("/{correo}/viajes")
	public ResponseEntity<?> getViajesConductorByCorreo(@PathVariable String correo){
		try {
			return new ResponseEntity<>(conductorServices.getViajesConductorByCorreo(correo),HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<>("Error", HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/aceptarViaje/{idViaje}")
	public ResponseEntity<?> apartarViajeConductor(@RequestBody Conductor conductor ,@PathVariable Long idViaje) {
		try {
			conductorServices.aceptarViajeConductor(conductor,idViaje);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<>("Error", HttpStatus.NOT_FOUND);
		}
	}
	
	

	
	/**
	 * Actualiza la clave de un conductor
	 * 
	 * @param json
	 * @param correoconductor
	 * @return Una cadena, OK si puede actualizar correctamente la clave, No autorizado si un
	 * 		   conductor quiere actualizar la información de otro, Error si no puede
	 * 		   actualizar la informacion en la base de datos, y Credenciales erroneas.
	 */
	@PutMapping(value = "/{correoconductor}/update/clave")
	 public ResponseEntity<?> updateClaveconductor(@RequestBody Object json, @PathVariable String correoconductor){
		try {
			String jsonInString = mapper.writeValueAsString(json);
			JSONObject jsonObj = new JSONObject(jsonInString);
			
			String correo = jsonObj.getString("correo");
			String clave = jsonObj.getString("clave");
			String nuevaClave = jsonObj.getString("nuevaClave");
			
			if(!correoconductor.equals(correo)) {
				return new ResponseEntity<>("No autorizado",HttpStatus.UNAUTHORIZED);
			}
			
			Conductor conductor = conductorServices.getConductorByCorreoYClave(correo, clave);
			if(conductor.getCorreo() == null) {
				return new ResponseEntity<>("Credenciales erroneas",HttpStatus.NOT_FOUND);
			}
			conductorServices.updateClave(correoconductor, nuevaClave);
			return new ResponseEntity<>("OK",HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<>("Error", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	/**
	 * Actualiza el numero celular del conductor.
	 * 
	 * @param json
	 * @param correoconductor
	 * @return Una cadena, OK si puede actualizar correctamente el celular, No autorizado si un
	 * 		   conductor quiere actualizar la información de otro, Error si no puede
	 * 		   actualizar la informacion en la base de datos, y Credenciales erroneas.
	 */
	@PutMapping(value = "/{correoconductor}/update/celular")
	 public ResponseEntity<?> updateCelularconductor(@RequestBody Object json, @PathVariable String correoconductor){
		try {
			String jsonInString = mapper.writeValueAsString(json);
			JSONObject jsonObj = new JSONObject(jsonInString);
			
			String correo = jsonObj.getString("correo");
			String clave = jsonObj.getString("clave");
			String nuevoCelular = jsonObj.getString("nuevoCelular");
			
			if(!correoconductor.equals(correo)) {
				return new ResponseEntity<>("No autorizado",HttpStatus.UNAUTHORIZED);
			}
			
			Conductor conductor = conductorServices.getConductorByCorreoYClave(correo, clave);
			if(conductor.getCorreo() == null) {
				return new ResponseEntity<>("Credenciales erroneas",HttpStatus.NOT_FOUND);
			}
			conductorServices.updateCelular(correoconductor, nuevoCelular);
			return new ResponseEntity<>("OK",HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<>("Error", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	 
	
	/**
	 * Actualiza los nombres del conductor.
	 * 
	 * @param json
	 * @param correoconductor
	 * @return Una cadena, OK si puede actualizar correctamente los nombres, No autorizado si un
	 * 		   conductor quiere actualizar la información de otro, Error si no puede
	 * 		   actualizar la informacion en la base de datos, y Credenciales erroneas.
	 */
	 @PutMapping(value = "/{correoconductor}/update/nombres")
	 public ResponseEntity<?> updateNombresconductor(@RequestBody Object json, @PathVariable String correoconductor){
		try {
			String jsonInString = mapper.writeValueAsString(json);
			JSONObject jsonObj = new JSONObject(jsonInString);
			
			String correo = jsonObj.getString("correo");
			String clave = jsonObj.getString("clave");
			String nuevosNombres = jsonObj.getString("nuevosNombres");
			
			if(!correoconductor.equals(correo)) {
				return new ResponseEntity<>("No autorizado",HttpStatus.UNAUTHORIZED);
			}
			
			Conductor conductor = conductorServices.getConductorByCorreoYClave(correo, clave);
			if(conductor.getCorreo() == null) {
				return new ResponseEntity<>("Credenciales erroneas",HttpStatus.NOT_FOUND);
			}
			conductorServices.updateNombres(correoconductor, nuevosNombres);
			return new ResponseEntity<>("OK",HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<>("Error", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	 
	 
	 /**
	  *  Actualiza los apellidos del conductor.
	  *  
	  * @param json
	  * @param correoconductor
	  * @return Una cadena, OK si puede actualizar correctamente los apellidos, No autorizado si un
	 * 		   conductor quiere actualizar la información de otro, Error si no puede
	 * 		   actualizar la informacion en la base de datos, y Credenciales erroneas.
	  */
	 @PutMapping(value = "/{correoconductor}/update/apellidos")
	 public ResponseEntity<?> updateApellidosconductor(@RequestBody Object json, @PathVariable String correoconductor){
		try {
			String jsonInString = mapper.writeValueAsString(json);
			JSONObject jsonObj = new JSONObject(jsonInString);
			
			String correo = jsonObj.getString("correo");
			String clave = jsonObj.getString("clave");
			String nuevosApellidos = jsonObj.getString("nuevosApellidos");
			
			if(!correoconductor.equals(correo)) {
				return new ResponseEntity<>("No autorizado",HttpStatus.UNAUTHORIZED);
			}
			
			Conductor conductor = conductorServices.getConductorByCorreoYClave(correo, clave);
			if(conductor.getCorreo() == null) {
				return new ResponseEntity<>("Credenciales erroneas",HttpStatus.NOT_FOUND);
			}
			conductorServices.updateApellidos(correoconductor, nuevosApellidos);
			return new ResponseEntity<>("OK",HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<>("Error", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	 
	 /**
	  * Actualiza la fecha de nacimiento del conductor.
	  * 
	  * @param json
	  * @param correoconductor
	  * @return Una cadena, OK si puede actualizar correctamente la fecha de nacimiento, No autorizado si un
	 * 		   conductor quiere actualizar la información de otro, Error si no puede
	 * 		   actualizar la informacion en la base de datos, y Credenciales erroneas.
	  */
	 @PutMapping(value = "/{correoconductor}/update/fechaNacimiento")
	 public ResponseEntity<?> updateFechaNacimientoconductor(@RequestBody Object json, @PathVariable String correoconductor){
		try {
			String jsonInString = mapper.writeValueAsString(json);
			JSONObject jsonObj = new JSONObject(jsonInString);
			
			String correo = jsonObj.getString("correo");
			String clave = jsonObj.getString("clave");
			String nuevaFechaNacimiento = jsonObj.getString("nuevaFechaNacimiento");
			
			if(!correoconductor.equals(correo)) {
				return new ResponseEntity<>("No autorizado",HttpStatus.UNAUTHORIZED);
			}
			
			Conductor conductor = conductorServices.getConductorByCorreoYClave(correo, clave);
			if(conductor.getCorreo() == null) {
				return new ResponseEntity<>("Credenciales erroneas",HttpStatus.NOT_FOUND);
			}
			conductorServices.updateFechaNacimiento(correoconductor, nuevaFechaNacimiento);
			return new ResponseEntity<>("OK",HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<>("Error", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	 
	 
	 /**
	  * Actualiza la casa, ubicacion del conductor.
	  * 
	  * 
	  * @param json
	  * @param correoconductor
	  * @return Una cadena, OK si puede actualizar correctamente la casa, No autorizado si un
	 * 		   conductor quiere actualizar la información de otro, Error si no puede
	 * 		   actualizar la informacion en la base de datos, y Credenciales erroneas.
	  */
	 @PutMapping(value = "/{correoconductor}/update/casa")
	 public ResponseEntity<?> updateCasaconductor(@RequestBody Object json, @PathVariable String correoconductor){
		try {
			String jsonInString = mapper.writeValueAsString(json);
			JSONObject jsonObj = new JSONObject(jsonInString);
			
			String correo = jsonObj.getString("correo");
			String clave = jsonObj.getString("clave");
			String nuevaCasa = jsonObj.getString("nuevaCasa");
			
			if(!correoconductor.equals(correo)) {
				return new ResponseEntity<>("No autorizado",HttpStatus.UNAUTHORIZED);
			}
			
			Conductor conductor = conductorServices.getConductorByCorreoYClave(correo, clave);
			if(conductor.getCorreo() == null) {
				return new ResponseEntity<>("Credenciales erroneas",HttpStatus.NOT_FOUND);
			}
			
			conductorServices.updateCasa(correoconductor, nuevaCasa);
			return new ResponseEntity<>("OK",HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<>("Error", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
