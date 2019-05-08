package edu.eci.arsw.evern;

import edu.eci.arsw.evern.security.EvernSecurity;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import edu.eci.arsw.evern.security.EvernSecurity;

@SpringBootApplication
@EnableAutoConfiguration

@ComponentScan("edu.eci")
public class EvernApplication {
	
	@Bean
	public WebSecurityConfigurerAdapter webSecurityConfigurerAdapter() {
		return new EvernSecurity();
	}

	public static void main(String[] args) {
		SpringApplication.run(EvernApplication.class, args);
	}

}