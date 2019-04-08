package edu.eci.arsw.evern.sockets;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import edu.eci.arsw.evern.model.Viaje;

@Controller
public class EvernControllerSockets {

	@MessageMapping("/topic/newpoint")
    @SendTo("/topic/newpoint")
    public Viaje sendMessage(@Payload Viaje viaje) {
        return viaje;
    }
	
}
