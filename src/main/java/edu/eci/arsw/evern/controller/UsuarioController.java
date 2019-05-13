package edu.eci.arsw.evern.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.eci.arsw.evern.model.Pasajero;
import edu.eci.arsw.evern.persistence.PasajeroRepository;

@RestController
@RequestMapping("/login")
public class UsuarioController{

    private PasajeroRepository pasajeroRepository;
    //private BCryptPasswordEncoder bCryptPasswordEncoder;
    /*
    public UsuarioController(PasajeroRepository pasajeroRepository, BCryptPasswordEncoder bCryptPasswordEncoder){
        this.pasajeroRepository = pasajeroRepository;
        //this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }*/

    @PostMapping("/sign-up")
    public ResponseEntity<?> signUp(@RequestBody Pasajero pasajero) {
        if (pasajeroRepository.find(pasajero.getCorreo())!= null) {
            return new ResponseEntity<>("Pasajero ya existe", HttpStatus.FORBIDDEN);
        } else {
            //pasajero.setClave(bCryptPasswordEncoder.encode(pasajero.getClave()));
            pasajeroRepository.save(pasajero);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
    }

}