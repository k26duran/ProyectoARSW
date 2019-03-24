package edu.eci.arsw.evern.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import edu.eci.arsw.evern.persistence.repositories.ICuponRepository;
import edu.eci.arsw.evern.persistence.repositories.IViajeRepository;
import edu.eci.arsw.evern.services.contracts.ICuponServices;


@Component
public  class  CuponServices  implements ICuponServices {
	
	
	@Autowired
	@Qualifier("CuponRepository")
	private ICuponRepository cuponRepository;


}
