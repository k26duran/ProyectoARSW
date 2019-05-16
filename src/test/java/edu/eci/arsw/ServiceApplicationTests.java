package edu.eci.arsw;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

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
import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.core.Appender;
import ch.qos.logback.core.ConsoleAppender;
import edu.eci.arsw.evern.EvernApplication;
import edu.eci.arsw.evern.controller.EvernException;
import edu.eci.arsw.evern.model.Automovil;
import edu.eci.arsw.evern.model.Conductor;
import edu.eci.arsw.evern.model.Pasajero;
import edu.eci.arsw.evern.model.Viaje;
import edu.eci.arsw.evern.services.contracts.IAutomovilServices;
import edu.eci.arsw.evern.services.contracts.IConductorServices;
import edu.eci.arsw.evern.services.contracts.IPasajerosServices;
import edu.eci.arsw.evern.services.contracts.IViajeServices;

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
    @Autowired
	private IViajeServices viajeServices;

    private Appender mockAppender;

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
            // CREANDO EL AUTOMOVIL
            String responseAutomovil = automovilServices.createAutomovil(conductor.getAutomovil());   
            Assert.assertEquals(responseAutomovil, conductor.getAutomovil().getPlaca());
            // CONSULTANDO EL AUTOMOVIL - CREADO
            Automovil consultarxplaca = automovilServices.getAutomovilByPlaca(conductor.getAutomovil().getPlaca());
            Assert.assertNotNull(consultarxplaca.getPlaca());
            //CREANDO EL CONDUCTOR
            String responseConductor = conductorServices.createConductor(conductor);
            Assert.assertEquals(responseConductor, conductor.getCorreo());
            // CONSULTANDO EL CONDUCTOR -CREADO
            Conductor consultarxcorreo = conductorServices.getConductorByCorreo(conductor.getCorreo());
            Assert.assertNotNull(consultarxcorreo.getCorreo());
            // ELIMINANDO AL CONDUCTOR
            conductorServices.removeConductor(conductor.getCorreo());
            // ELIMINANDO AL AUTOMOVIL
            automovilServices.removeAutomovil(conductor.getAutomovil().getPlaca());
            // CONSULTANDO AL CONDUCTOR - ELIMINADO
            Conductor conductor_eliminado = conductorServices.getConductorByCorreo(conductor.getCorreo());
            Assert.assertNull(conductor_eliminado.getCorreo());
            // CONSULTANDO AL AUTOMOVIL - ELIMINADO
            Automovil automovil_eliminado = automovilServices.getAutomovilByPlaca(conductor.getAutomovil().getPlaca());
            Assert.assertNull(automovil_eliminado.getPlaca());
        } catch (EvernException e) {
            e.printStackTrace();
        }
    }
    
    @Test
    public void deberiaCrearUnViaje(){
        try{

            Pasajero pasajero = Expectations.crearPasajero();
            Conductor conductor = Expectations.crearConductor();
            // CREANDO EL AUTOMOVIL
            String responseAutomovil = automovilServices.createAutomovil(conductor.getAutomovil());   
            Assert.assertEquals(responseAutomovil, conductor.getAutomovil().getPlaca());
            // CONSULTANDO EL AUTOMOVIL - CREADO
            Automovil consultarxplaca = automovilServices.getAutomovilByPlaca(conductor.getAutomovil().getPlaca());
            Assert.assertNotNull(consultarxplaca.getPlaca());
            // CREANDO EL CONDUCTOR
            String responseConductor = conductorServices.createConductor(conductor);
            Assert.assertEquals(responseConductor, conductor.getCorreo());

            // CREANDO EL PASAJERO
            String responsePasajero = pasajeroServices.createPasajero(pasajero);
            Assert.assertEquals(responsePasajero, pasajero.getCorreo());

            // CREANDO EL VIAJE
            Viaje viaje = Expectations.crearViaje();
            Long responseViaje = viajeServices.createViaje(viaje);
            Assert.assertNotNull(responseViaje);
            
            // CONSULTANDO LOS VIAJES DEL CONDUCTOR
            List<Viaje> viajesConductor = conductorServices.getViajesConductorByCorreo(conductor.getCorreo());
            List<Viaje> viajesPasajero = pasajeroServices.getViajesPasajeroByCorreo(pasajero.getCorreo());

            Assert.assertTrue(viajesConductor.size()==1);
            Assert.assertTrue(viajesConductor.size()==viajesPasajero.size()); //solamente tiene un viaje en comun
            Viaje viaje_registrado = viajesConductor.get(0);
            Viaje validar_viaje = viajeServices.getViajeById(viaje_registrado.getId());
            Assert.assertNotNull(validar_viaje.getId()); //validamos que el viaje esta registrado en la base de datos
            Assert.assertEquals(validar_viaje.getId(), viaje_registrado.getId()); //validamos que coincidan los id's

            // ELIMINAMOS EL VIAJE
            viajeServices.deleteViaje(viaje_registrado.getId());
            Viaje viaje_eliminado = viajeServices.getViajeById(viaje_registrado.getId());
            Assert.assertNull(viaje_eliminado.getId()); //validamos que se haya eliminado el viaje correctamente

            // ELIMINANDO AL CONDUCTOR
            conductorServices.removeConductor(conductor.getCorreo());
            // ELIMINANDO AL AUTOMOVIL
            automovilServices.removeAutomovil(conductor.getAutomovil().getPlaca());
            // CONSULTANDO AL CONDUCTOR - ELIMINADO
            Conductor conductor_eliminado = conductorServices.getConductorByCorreo(conductor.getCorreo());
            Assert.assertNull(conductor_eliminado.getCorreo());
            // CONSULTANDO AL AUTOMOVIL - ELIMINADO
            Automovil automovil_eliminado = automovilServices.getAutomovilByPlaca(conductor.getAutomovil().getPlaca());
            Assert.assertNull(automovil_eliminado.getPlaca());

            //ELIMINANDO EL PASAJERO
            pasajeroServices.removePasajero(pasajero.getCorreo());
            // CONSULTANDO AL PASAJERO - ELIMINADO
            Pasajero pasajero_eliminado = pasajeroServices.getPasajeroByCorreo(pasajero.getCorreo());
            Assert.assertNull(pasajero_eliminado.getCorreo());

        }catch(EvernException e){
            e.printStackTrace();
        }
    }

}