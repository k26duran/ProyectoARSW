package edu.eci.arsw.evern.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import edu.eci.arsw.evern.model.Cupon;
import edu.eci.arsw.evern.persistence.repositories.ICuponRepository;
import edu.eci.arsw.evern.services.contracts.ICuponServices;


@Component
public  class  CuponServices  implements ICuponServices {
	
	
	@Autowired
	@Qualifier("CuponRepository")
	private ICuponRepository cuponRepository;

	@Override
	public Long createCupon(Cupon cupon) {
		return cuponRepository.save(cupon);
	}

	@Override
	public void updateCupon(Cupon cupon) {
		cuponRepository.delete(cupon);
	}

	@Override
	public void deleteCupon(Cupon cupon) {
		cuponRepository.delete(cupon);
	}

}
