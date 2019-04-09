package edu.eci.arsw.evern.sockets;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

import edu.eci.arsw.evern.model.Viaje;

@Controller
@CrossOrigin
public class EvernControllerSockets {

	
	@MessageMapping("/topic/newpoint")
    @SendTo("/topic/newpoint")
    public Viaje sendMessage(@Payload Viaje viaje) {
		System.out.println(viaje.toString());
        return viaje;
    }
	
}
