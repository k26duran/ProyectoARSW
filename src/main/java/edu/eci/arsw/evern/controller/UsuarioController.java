package edu.eci.arsw.evern.controller;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

@RestController
@RequestMapping(value = "v1/usuarios")
@CrossOrigin()
public class UsuarioController {

	@GetMapping("/{correo}/{clave}")
	public ResponseEntity<?> getUsuarioByCorreoAndClave(@PathVariable String correo, @PathVariable String clave) {
		System.out.println("ENTRO A USUARIO CONTROLLER");
		try {
			String resultConductor = httpUsuario("conductores",correo);
			String resultPasajero = httpUsuario("pasajeros",correo);
			JSONObject jsonObjConductor = new JSONObject(resultConductor);
			System.out.println(jsonObjConductor);
			if(!jsonObjConductor.isNull("correo")) {
				String claveJSON = jsonObjConductor.getString("clave");
				//System.out.println(claveJSON +" - "+clave);
				if(claveJSON.equals(clave)) {
					return new ResponseEntity<>("conductor", HttpStatus.OK);
				}
				return new ResponseEntity<>("none", HttpStatus.NOT_FOUND);
			}
			JSONObject jsonObjPasajero = new JSONObject(resultPasajero);
			System.out.println(jsonObjPasajero);
			if(!jsonObjPasajero.isNull("correo")) {
				String claveJSON = jsonObjPasajero.getString("clave");
				//System.out.println(claveJSON +" - "+clave);
				if(claveJSON.equals(clave)) {
					return new ResponseEntity<>("pasajero", HttpStatus.OK);
				}
				return new ResponseEntity<>("none", HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<>("none", HttpStatus.NOT_FOUND);
			
			
		} catch (Exception ex) {
			return new ResponseEntity<>("Error", HttpStatus.NOT_FOUND);
		}
	}

	private String httpUsuario(String tipo, String correoUsuario) {

		final String USER_AGENT = "Mozilla/5.0";

		String GET_URL = "https://backarsw.herokuapp.com/v1/" + tipo + "/" + correoUsuario;

		System.out.println("THIS IS THE URL ->"+GET_URL);

		URL obj;
		try {
			obj = new URL(GET_URL);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("User-Agent", USER_AGENT);

			// The following invocation perform the connection implicitly before getting the
			// code
			int responseCode = con.getResponseCode();
			System.out.println("GET Response Code :: " + responseCode);

			if (responseCode == HttpURLConnection.HTTP_OK) { // success
				BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
				String inputLine;
				StringBuffer response = new StringBuffer();

				while ((inputLine = in.readLine()) != null) {
					response.append(inputLine);
				}
				in.close();

				// print result
				return response.toString();
			} else {
				return "none";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		return "none";

	}

}
