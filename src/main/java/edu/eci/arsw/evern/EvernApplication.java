package edu.eci.arsw.evern;

import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@ComponentScan("edu.eci")
public class EvernApplication {
	
	/*
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}*/

	public static void main(String[] args) {
		long expiration = 000_000_060;
		System.out.println("FECHA DE EXPIFRACION ->"+new Date(System.currentTimeMillis()+expiration));
		SpringApplication.run(EvernApplication.class, args);
	}

}