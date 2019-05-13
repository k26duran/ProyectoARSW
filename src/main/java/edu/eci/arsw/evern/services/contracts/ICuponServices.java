package edu.eci.arsw.evern.services.contracts;
import org.springframework.stereotype.Service;

import edu.eci.arsw.evern.model.Cupon;

@Service
public interface ICuponServices {

	Long createCupon(Cupon cupon);
	void updateCupon(Cupon cupon);
	void deleteCupon(Cupon cupon);
	
}
