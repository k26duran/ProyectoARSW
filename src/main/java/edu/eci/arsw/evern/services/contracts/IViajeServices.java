package edu.eci.arsw.evern.services.contracts;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.eci.arsw.evern.model.Conductor;
import edu.eci.arsw.evern.model.Viaje;

@Service
public interface IViajeServices {

	List<Viaje> list();

	Long create(Viaje car);

	void updateViaje(Viaje car);

	void deleteViaje(Viaje car);

	void agregarViaje(Viaje viaje);

	List<Viaje> getViajesDelUsuario(String correoUsuario);

}
