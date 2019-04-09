package edu.eci.arsw.evern.sockets;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.eci.arsw.evern.model.Viaje;
import edu.eci.arsw.evern.model.Viaje2;

@Controller
@RequestMapping("/")
public class EvernControllerSockets {
	
	
	@MessageMapping("/topic/newpoint")
    @SendTo("/topic/newpoint")
    public Viaje2 sendMessage(@Payload Viaje2 viaje) {
		System.err.println("ACAAAAAAAA");
        return viaje;
    }
	
}
