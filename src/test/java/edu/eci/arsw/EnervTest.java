package edu.eci.arsw;

import static org.junit.Assert.assertEquals;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.json.JSONObject;
import org.junit.Test;
import edu.eci.arsw.evern.controller.EvernException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

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

}
