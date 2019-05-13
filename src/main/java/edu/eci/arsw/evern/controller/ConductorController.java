package edu.eci.arsw.evern.controller;

import org.json.JSONObject;
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

import com.fasterxml.jackson.databind.ObjectMapper;

import edu.eci.arsw.evern.model.Conductor;
import edu.eci.arsw.evern.model.Login;
import edu.eci.arsw.evern.model.Pasajero;
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
	
	 @RequestMapping(value = "/update/clave")
	 public ResponseEntity<?> updateClavePasajero(@RequestBody Object json){
		try {
			String jsonInString = mapper.writeValueAsString(json);
			JSONObject jsonObj = new JSONObject(jsonInString);
			
			String correo = jsonObj.getString("correo");
			String clave = jsonObj.getString("clave");
			String nuevaClave = jsonObj.getString("nuevaClave");
			
			Conductor conductor = conductorServices.getConductorByCorreoYClave(correo, clave);
			if(conductor.getCorreo() == null) {
				return new ResponseEntity<>("Credenciales erroneas",HttpStatus.NOT_FOUND);
			}
			
			conductorServices.updateClave(correo, nuevaClave);
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
			
			Conductor conductor = conductorServices.getConductorByCorreoYClave(correo, clave);
			if(conductor.getCorreo() == null) {
				return new ResponseEntity<>("Credenciales erroneas",HttpStatus.NOT_FOUND);
			}
			conductorServices.updateCelular(correo, nuevoCelular);
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
			
			Conductor conductor = conductorServices.getConductorByCorreoYClave(correo, clave);
			if(conductor.getCorreo() == null) {
				return new ResponseEntity<>("Credenciales erroneas",HttpStatus.NOT_FOUND);
			}
			conductorServices.updateNombres(correo, nuevosNombres);
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
			
			Conductor conductor = conductorServices.getConductorByCorreoYClave(correo, clave);
			if(conductor.getCorreo() == null) {
				return new ResponseEntity<>("Credenciales erroneas",HttpStatus.NOT_FOUND);
			}
			conductorServices.updateApellidos(correo, nuevosApellidos);
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
			
			Conductor conductor = conductorServices.getConductorByCorreoYClave(correo, clave);
			if(conductor.getCorreo() == null) {
				return new ResponseEntity<>("Credenciales erroneas",HttpStatus.NOT_FOUND);
			}
			conductorServices.updateFechaNacimiento(correo, nuevaFechaNacimiento);
			return new ResponseEntity<>("OK",HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<>("Error", HttpStatus.NOT_FOUND);
		}
	}
	
}
