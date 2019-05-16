package edu.eci.arsw;

import org.json.JSONObject;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.mockito.Mockito;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.core.Appender;
import ch.qos.logback.core.ConsoleAppender;
import edu.eci.arsw.evern.EvernApplication;
import edu.eci.arsw.evern.controller.EvernException;
import edu.eci.arsw.evern.model.Automovil;
import edu.eci.arsw.evern.model.Conductor;
import edu.eci.arsw.evern.model.Pasajero;
import edu.eci.arsw.evern.services.contracts.IAutomovilServices;
import edu.eci.arsw.evern.services.contracts.IConductorServices;
import edu.eci.arsw.evern.services.contracts.IPasajerosServices;

@RunWith(SpringJUnit4ClassRunner.class)
@AutoConfigureMockMvc
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest(classes = EvernApplication.class)
@WebAppConfiguration
public class ServiceApplicationTests extends TestingAPIRest {

    @Autowired
    private IPasajerosServices pasajeroServices;
    @Autowired
    private IConductorServices conductorServices;
    @Autowired
	private IAutomovilServices automovilServices;

    private Gson gson = new Gson();
    private Appender mockAppender;
    ObjectMapper mapper = new ObjectMapper();

    @Before
    public void setupClient() {
        mockAppender = Mockito.mock(ConsoleAppender.class);
        final Logger logger = (Logger) LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME);
        logger.addAppender(mockAppender);
        logger.setLevel(Level.ERROR);
    }

    @After
    public void teardown() {
        final Logger logger = (Logger) LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME);
        logger.detachAppender(mockAppender);
    }

    @Test
    public void deberiaObtenerPasajero() {
        
        try {
        	String correo = "prueba0513@evern.com";
            Pasajero response = pasajeroServices.getPasajeroByCorreo(correo);
		    Assert.assertEquals(response.getCorreo(), correo);
        } catch (EvernException e) {
            e.printStackTrace();
        }
	}
    
    @Test
    public void deberiaCrearConsultarYEliminarPasajero() {
    	try {
            // CREANDO EL PASAJERO
    		Pasajero pasajero = Expectations.crearPasajero();
            String response = pasajeroServices.createPasajero(pasajero);       
            Assert.assertEquals(response, pasajero.getCorreo());

            // CONSULTANDO EL PASAJERO
            Pasajero consultarxcorreo = pasajeroServices.getPasajeroByCorreo(pasajero.getCorreo());
            Assert.assertEquals(consultarxcorreo.getCorreo(), pasajero.getCorreo());

            // CONSULTANDO POR CORREO Y CONTRASENA
            Pasajero consultarxcorreoyclave = pasajeroServices.getPasajeroByCorreoYClave(pasajero.getCorreo(), pasajero.getClave());
            Assert.assertEquals(consultarxcorreoyclave.getCorreo(), pasajero.getCorreo());

            //ELIMINANDO EL PASAJERO
            pasajeroServices.removePasajero(pasajero.getCorreo());

            Pasajero pasajero_eliminado = pasajeroServices.getPasajeroByCorreo(pasajero.getCorreo());
            Assert.assertNull(pasajero_eliminado.getCorreo());
            
        } catch (EvernException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void deberiaCrearConsultarYEliminarConductorYAutomovil() {
    	try {
            // CREANDO EL OBJETO CONDUCTOR
            Conductor conductor = Expectations.crearConductor();
            Conductor consultarxcorreo = conductorServices.getConductorByCorreo(conductor.getCorreo());
            
        } catch (EvernException e) {
            e.printStackTrace();
        }
    }

}