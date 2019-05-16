package edu.eci.arsw;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import edu.eci.arsw.evern.model.Pasajero;

public class TestingAPIRest extends AbstractTest {
    @Test
    public void getPasajeros() throws Exception {
        
        String uri = "https://backarsw.herokuapp.com/v1/pasajeros/prueba0513@evern.com";
        System.out.println(uri);

        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
            .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
        System.out.println("DESPUES DE MVC RESULT");
        int status = mvcResult.getResponse().getStatus();
        System.out.println("STATUS ------------------>>>> "+status);
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        Pasajero pasajero = super.mapFromJson(content, Pasajero.class);
        assertNotNull(pasajero.getCorreo());
    }
}