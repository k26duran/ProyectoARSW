package edu.eci.arsw.evern.persistence.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import edu.eci.arsw.evern.model.Automovil;
import edu.eci.arsw.evern.model.Comentario;
import edu.eci.arsw.evern.model.Conductor;
import edu.eci.arsw.evern.model.CuentaBancaria;
import edu.eci.arsw.evern.model.Pasajero;
import edu.eci.arsw.evern.model.Usuario;
import edu.eci.arsw.evern.model.Viaje;
import edu.eci.arsw.evern.persistence.EvernPersistence;
import edu.eci.arsw.evern.persistence.EvernPersistenceException;

@Component("inMemoryPersistence")
public class InMemoryPersistence implements EvernPersistence{

	Map<String,Usuario> usuarios = new HashMap<String, Usuario>();
	
	public InMemoryPersistence() {
		
		// FULL DATABASE
		Usuario john = new Pasajero("john@hotmail.com", "john", "arsw", "01/01/1997", "john");
		
		Usuario karen = new Pasajero("karen@hotmail.com", "karen", "arsw", "03/03/1999","karen");
		
		Automovil autoCamilo = new Automovil("BBC-123", "Vitara", "Camioneta", "negro");
		Usuario camilo = new Conductor("camilo@hotmail.com","camilo", "arsw", "02/02/1998","camilo", autoCamilo);
		
		// AGREGAR VIAJES		
	}

	@Override
	public void registrarConductor(Conductor conductor) throws EvernPersistenceException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void registrarPasajero(Pasajero pasajero) throws EvernPersistenceException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminarUsuario(Usuario usuario) throws EvernPersistenceException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void agregarCuentaBancaria(String correoUsuario, CuentaBancaria cuentaBancaria)
			throws EvernPersistenceException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminarCuentaBancaria(String correoUsuario, long idCuentaBancaria, String banco)
			throws EvernPersistenceException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminarCuentas(String correoUsuario) throws EvernPersistenceException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Conductor getConductorByCorreo(String correoConductor) throws EvernPersistenceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pasajero getPasajeroByCorreo(String correoPasajero) throws EvernPersistenceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void agregarComentarioAlViaje(long idViaje, Comentario comentario) throws EvernPersistenceException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminarComentarioAlViaje(long idViaje, long idComentario) throws EvernPersistenceException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void agregarViaje(Viaje viaje) throws EvernPersistenceException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Viaje> getViajesDelUsuario(String correoUsuario) throws EvernPersistenceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void actualizarNombres(String correoUsuario, String nuevosNombres) throws EvernPersistenceException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actualizarApellidos(String correoUsuario, String nuevosApellidos) throws EvernPersistenceException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actualizarCorreo(String correoUsuario, String nuevoCorreo) throws EvernPersistenceException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actualizarClave(String correoUsuario, String nuevaClave) throws EvernPersistenceException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actualizarAutomovil(String correoConductor, Automovil auto) throws EvernPersistenceException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void login(String correoUsuario, String clave) throws EvernPersistenceException {
		// TODO Auto-generated method stub
		
	}

}
