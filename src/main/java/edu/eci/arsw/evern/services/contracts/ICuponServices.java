package edu.eci.arsw.evern.services.contracts;
import org.springframework.stereotype.Service;

import edu.eci.arsw.evern.controller.EvernException;
import edu.eci.arsw.evern.model.Cupon;

@Service
public interface ICuponServices {

	Long createCupon(Cupon cupon) throws EvernException ;
	void updateCupon(Cupon cupon) throws EvernException ;
	void deleteCupon(Cupon cupon) throws EvernException ;
	
}
