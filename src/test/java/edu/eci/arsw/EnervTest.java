package edu.eci.arsw;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.json.JSONObject;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import edu.eci.arsw.evern.controller.EvernException;
import edu.eci.arsw.evern.model.Automovil;
import edu.eci.arsw.evern.model.Conductor;
import edu.eci.arsw.evern.model.Pasajero;
import edu.eci.arsw.evern.model.Viaje;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class EnervTest {

	
	ObjectMapper mapper = new ObjectMapper();
	private static HttpURLConnection con;
	final String USER_AGENT = "Mozilla/5.0";

	@Test
	public void getPasajero() {
		String correopasajero = "prueba0513@evern.com";
		String url = "https://backarsw.herokuapp.com/v1/pasajeros/" + correopasajero;
		String response = "";
		try {
			response = httpGET(url);
			System.out.println(response);
			JSONObject jsonObj = new JSONObject(response);
			String correo = jsonObj.getString("correo");
			assertEquals(correopasajero, correo);
		} catch (EvernException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void savePasajero(){
		String url = "https://backarsw.herokuapp.com/v1/pasajeros/signup";
		String data = "{"+
						"'nombres': 'prueba001', "+
						"'apellidos': 'prueba001', "+
						"'correo': 'prueba001@pasajero.evern.com', "+
						"'clave': 'prueba001', "+
						"'fechaNacimiento': '05/05/1992', "+
						"'celular': '3001005000'"+
						"}";
		JSONObject jsonObj = new JSONObject(data);
		data = jsonObj.toString();
		System.out.println(data);
		try {
			String response = httpPOST(url, data);
			System.out.println(response);
			assertEquals(response, "200");
		} catch (EvernException e) {
			e.printStackTrace();
		}
	}

	public String httpGET(String GET_URL) throws EvernException {
		try{
			URL urlObject = new URL(GET_URL);
			con = (HttpURLConnection) urlObject.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("User-Agent", USER_AGENT);
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
				return response.toString();
			} else {
				throw new EvernException("ERROR");
			}
		}catch (Exception e) {
			throw new EvernException("No pudo hacer la conexion");
		}finally{
			con.disconnect();
		}
	}


	public String httpPOST(String GET_URL, String urlParameters) throws EvernException {
		System.out.println(urlParameters);
		byte[] postData = urlParameters.getBytes(StandardCharsets.UTF_8);
		try{
			URL urlObject = new URL(GET_URL);
			
			con = (HttpURLConnection) urlObject.openConnection();

            con.setDoOutput(true);
            con.setRequestMethod("POST");
            con.setRequestProperty("User-Agent", "Java client");
            con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

            try (DataOutputStream wr = new DataOutputStream(con.getOutputStream())) {
                wr.write(postData);
            }
			System.out.println(postData.toString());

            StringBuilder content;

            try (BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()))) {

                String line;
                content = new StringBuilder();

                while ((line = in.readLine()) != null) {
                    content.append(line);
                    content.append(System.lineSeparator());
                }
            }
			return content.toString();
		}catch (Exception e) {
			throw new EvernException("No pudo hacer la conexion");
		}finally{
			con.disconnect();
		}
	}
	
}
