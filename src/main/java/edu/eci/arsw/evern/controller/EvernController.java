package edu.eci.arsw.evern.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.eci.arsw.evern.services.EvernServices;

@RestController
@RequestMapping(value = "evern/v1")
public class EvernController {

	@Autowired
	EvernServices evernServices;
	
}
