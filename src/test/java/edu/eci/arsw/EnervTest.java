package edu.eci.arsw;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import edu.eci.arsw.evern.controller.EvernException;
import edu.eci.arsw.evern.model.Automovil;
import edu.eci.arsw.evern.model.Conductor;
import edu.eci.arsw.evern.model.Pasajero;
import edu.eci.arsw.evern.model.Viaje;
import edu.eci.arsw.evern.services.ConductorServices;
import edu.eci.arsw.evern.services.PasajerosServices;

public class EnervTest {
	
	@Autowired
	PasajerosServices pasajeroServices;
	
	@Autowired
	ConductorServices conductorServices;
	
	@Test
	public void buscarPasajeroxCorreo() {
		String correo = "prueba0513@evern.com";
		try {
			pasajeroServices.getPasajeroByCorreo(correo);
		} catch (EvernException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
