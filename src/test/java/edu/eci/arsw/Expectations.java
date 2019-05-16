package edu.eci.arsw;


import org.mockserver.integration.ClientAndServer;
import static org.mockserver.model.HttpRequest.request;
import static org.mockserver.model.HttpResponse.response;

import com.google.gson.Gson;

import edu.eci.arsw.evern.model.Automovil;
import edu.eci.arsw.evern.model.Conductor;
import edu.eci.arsw.evern.model.Pasajero;

public class Expectations {

	private static Gson gson = new Gson();

	public static void createDefaultExpectations(ClientAndServer mockServer) {
		getPasajero(mockServer); //GET
	}
	
	private static void getPasajero(ClientAndServer mockServer) {
        Pasajero pasajero = new Pasajero();
        String correo = "prueba0513@evern.com";
		mockServer.when(request().withMethod("GET")
				.withHeader("Accept", "application/json").withPath("/v1/pasajeros/"+correo))
				.respond(response().withStatusCode(200).withBody(gson.toJson(pasajero)));
	}
	
	public static Pasajero crearPasajero() {
		Pasajero pasajero = new Pasajero("benito.camelas@pasajero.evern.com",
							"benito", "camelas", "3001002001000",
							"benito.camelas");
		return pasajero;
	}
	
	public static Conductor crearConductor() {
		Automovil automovil = new Automovil("QWE-987", "2012", "camioneta", "negra");
		Conductor conductor = new Conductor("melo.caramelo@conductor.evern.com",
							  "melo", "caramelo", "30010020010001", "melo.caramelo", automovil);
		return conductor;
	}
}
