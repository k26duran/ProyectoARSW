package edu.eci.arsw.evern.persistence.impl;

import java.util.ArrayList;
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
	Map<Long, Viaje> viajes = new HashMap<Long, Viaje>();
	
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
		if(!usuarios.containsKey(conductor.getCorreo())) {
			throw new EvernPersistenceException("El conductor no se puede registrar, ya existe una cuenta afiliada al correo" +conductor.getCorreo());
		}else {
			usuarios.put(conductor.getCorreo(), conductor);
		}
	}

	@Override
	public void registrarPasajero(Pasajero pasajero) throws EvernPersistenceException {
		if(!usuarios.containsKey(pasajero.getCorreo())) {
			throw new EvernPersistenceException("El pasajero no se puede registrar, ya existe una cuenta afiliada al correo" +pasajero.getCorreo());
		}else {
			usuarios.put(pasajero.getCorreo(), pasajero);
		}
	}

	@Override
	public void eliminarUsuario(Usuario usuario) throws EvernPersistenceException {
		if(!usuarios.containsKey(usuario.getCorreo())) {
			throw new EvernPersistenceException("El usuario con correo "+usuario.getCorreo()+"no existe");
		}else {
			usuarios.remove(usuario.getCorreo(), usuario);
		}
	}

	@Override
	public void agregarCuentaBancaria(String correoUsuario, CuentaBancaria cuentaBancaria)
			throws EvernPersistenceException {
		Usuario usuario = usuarios.get(correoUsuario);
		usuario.addCuentaBancaria(cuentaBancaria);
	}

	@Override
	public void eliminarCuentaBancaria(String correoUsuario, long idCuentaBancaria) 
			throws EvernPersistenceException {
		Usuario usuario = usuarios.get(correoUsuario);
		usuario.removeCuentaBancaria(idCuentaBancaria);
	}

	@Override
	public void eliminarCuentas(String correoUsuario) throws EvernPersistenceException {
		Usuario usuario = usuarios.get(correoUsuario);
		List<CuentaBancaria> cuentasBancarias = new ArrayList<CuentaBancaria>();
		usuario.setCuentasBancarias(cuentasBancarias);
	}

	@Override
	public Usuario getUsuarioByCorreo(String correoUsuario) throws EvernPersistenceException {
		if(!usuarios.containsKey(correoUsuario)) {
			throw new EvernPersistenceException("El usuario con correo "+correoUsuario+"no existe");
		}else {
			return usuarios.get(correoUsuario);
		}
	}

	@Override
	public void agregarComentarioAlViaje(long idViaje,Comentario comentario) throws EvernPersistenceException {
		if(!viajes.containsKey(idViaje)) {
			throw new EvernPersistenceException("El viaje "+idViaje+"no existe");
		}else {
			Viaje viaje = viajes.get(idViaje);
			viaje.addComentario(comentario);
		}		
	}

	@Override
	public void eliminarComentarioAlViaje(long idViaje, long idComentario) throws EvernPersistenceException {
		if(!viajes.containsKey(idViaje)) {
			throw new EvernPersistenceException("El viaje "+idViaje+"no existe");
		}else {
			Viaje viaje = viajes.get(idViaje);
			viaje.removeComentario(idComentario);
		}
	}

	@Override
	public void agregarViaje(Viaje viaje) throws EvernPersistenceException {
		if(viajes.containsKey(viaje.getId())) {
			throw new EvernPersistenceException("El viaje con id "+viaje.getId() +"ya existe");
		}else {
			viajes.put(viaje.getId(), viaje);
		}
	}

	@Override
	public List<Viaje> getViajesDelUsuario(String correoUsuario) throws EvernPersistenceException {
		if(!usuarios.containsKey(correoUsuario)) {
			throw new EvernPersistenceException("El usuario con correo "+correoUsuario+"no existe");
		}else {
			Usuario usuario = usuarios.get(correoUsuario);
			return usuario.getViajes();
		}
	}

	@Override
	public void actualizarNombres(String correoUsuario, String nuevosNombres) throws EvernPersistenceException {
		if(!usuarios.containsKey(correoUsuario)) {
			throw new EvernPersistenceException("El usuario con correo "+correoUsuario+"no existe");
		}else {
			Usuario usuario = usuarios.get(correoUsuario);
			usuario.setNombres(nuevosNombres);
		}
	}

	@Override
	public void actualizarApellidos(String correoUsuario, String nuevosApellidos) throws EvernPersistenceException {
		if(!usuarios.containsKey(correoUsuario)) {
			throw new EvernPersistenceException("El usuario con correo "+correoUsuario+"no existe");
		}else {
			Usuario usuario = usuarios.get(correoUsuario);
			usuario.setNombres(nuevosApellidos);
		}
	}

	@Override
	public void actualizarCorreo(String correoUsuario, String nuevoCorreo) throws EvernPersistenceException {
		if(!usuarios.containsKey(correoUsuario)) {
			throw new EvernPersistenceException("El usuario con correo "+correoUsuario+"no existe");
		}else {
			Usuario usuario = usuarios.get(correoUsuario);
			usuario.setNombres(nuevoCorreo);
		}
	}

	@Override
	public void actualizarClave(String correoUsuario, String nuevaClave) throws EvernPersistenceException {
		if(!usuarios.containsKey(correoUsuario)) {
			throw new EvernPersistenceException("El usuario con correo "+correoUsuario+"no existe");
		}else {
			Usuario usuario = usuarios.get(correoUsuario);
			usuario.setNombres(nuevaClave);
		}
	}

	@Override
	public void actualizarAutomovil(String correoConductor, Automovil auto) throws EvernPersistenceException {
		if(!usuarios.containsKey(correoConductor)) {
			throw new EvernPersistenceException("El conductor con correo "+correoConductor+"no existe");
		}else{
			try {
				Conductor conductor = (Conductor) usuarios.get(correoConductor);
				conductor.setAuto(auto);
			}catch(ClassCastException e) {
				throw new EvernPersistenceException("El conductor con correo "+correoConductor+"no existe");
			}
		}
	}

	@Override
	public boolean login(String correoUsuario, String clave) throws EvernPersistenceException {
		if(!usuarios.containsKey(correoUsuario)) {
			throw new EvernPersistenceException("El usuario con correo "+correoUsuario+"no existe");
		}else{
			Usuario usuario = usuarios.get(correoUsuario);
			return usuario.getClave().equals(clave);
		}
	}

	@Override
	public List<Comentario> getComentariosByViajeAndUsuario(long idViaje, String correoUsuario)
			throws EvernPersistenceException {
		Viaje viaje = viajes.get(idViaje);
		return viaje.getComentariosByUsuario(correoUsuario);
	}

	@Override
	public void pasajeroCalificaAlConductorByViaje(long idViaje, int calificacion) {
		Viaje viaje = viajes.get(idViaje);
		viaje.setCalificacionAlConductor(calificacion);
	}

	@Override
	public void conductorCalificaAlPasajeroByViaje(long idViaje, int calificacion) {
		Viaje viaje = viajes.get(idViaje);
		viaje.setCalificacionAlPasajero(calificacion);
	}

}
