package edu.eci.arsw;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import edu.eci.arsw.evern.model.Automovil;
import edu.eci.arsw.evern.model.Conductor;
import edu.eci.arsw.evern.model.Pasajero;
import edu.eci.arsw.evern.model.Viaje;
import edu.eci.arsw.evern.persistence.ConductorRepository;
import edu.eci.arsw.evern.persistence.PasajeroRepository;
import edu.eci.arsw.evern.persistence.ViajeRepository;
import edu.eci.arsw.evern.services.ConductorServices;
import edu.eci.arsw.evern.services.PasajerosServices;

public class EnervTest {
	
	@Autowired
	PasajerosServices pasajeroServices;
	@Autowired
	ConductorServices conductorServices;
	
	@Test
	public void savePasajeroConViajes() {
		/*
		Pasajero p= new Pasajero("prueba5@correo", "prueba1", "prueba", "1283", "123");
		Pasajero p1= new Pasajero("prueba4@correo", "prueba1", "prueba", "22333", "123");
		Pasajero p2= new Pasajero("prueba3@correo", "prueba1", "prueba", "222222", "123");
		pr.save(p);
		pr.save(p1);
		pr.save(p2);
		assertNotNull(pr.getPasajero(p.getCorreo()));
		Viaje v= new Viaje("santa fe", "escuela colombiana", 2000,"coductor@correo", "prueba5@correo");
		List<Viaje> viajes = p.getViajes();
		viajes.add(v);
		p.setViajes(viajes);
		assertNotNull(pr.getViajesPasajeroByCorreo(p.getCorreo()));*/
	}
	
	@Test
	public void saveConductorConViajes() {
		/*
		ConductorRepository cr= new ConductorRepository();
		Automovil auto= new Automovil("cwe341", "2018", "camioneta", "blanco");
		Conductor c=new Conductor("coductorPrueba3@correo", "conductor3", "prueba", "88818", "123",null);
		cr.save(c);
		assertNotNull(cr.getCondutor("coductorPrueba1@correo"));
		assertNotNull(cr.findAll());
		ViajeRepository vr= new ViajeRepository();
		assertNotNull(vr.findAll());*/
	}
	
}
