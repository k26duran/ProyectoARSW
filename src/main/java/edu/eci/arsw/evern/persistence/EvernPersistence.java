package edu.eci.arsw.evern.persistence;

import java.util.List;

import edu.eci.arsw.evern.model.Automovil;
import edu.eci.arsw.evern.model.Comentario;
import edu.eci.arsw.evern.model.Conductor;
import edu.eci.arsw.evern.model.CuentaBancaria;
import edu.eci.arsw.evern.model.Pasajero;
import edu.eci.arsw.evern.model.Usuario;
import edu.eci.arsw.evern.model.Viaje;

public interface EvernPersistence {
	
	// REGISTRO DE USUARIOS
	public void registrarConductor(Conductor conductor) throws EvernPersistenceException;
	public void registrarPasajero(Pasajero pasajero) throws EvernPersistenceException;
	
	public void eliminarUsuario(Usuario usuario) throws EvernPersistenceException;
	
	public void agregarCuentaBancaria(String correoUsuario, CuentaBancaria cuentaBancaria) throws EvernPersistenceException;
	public void eliminarCuentaBancaria(String correoUsuario, long idCuentaBancaria, String banco) throws EvernPersistenceException;
	
	public void eliminarCuentas(String correoUsuario ) throws EvernPersistenceException;
	
	public Conductor getConductorByCorreo(String correoConductor) throws EvernPersistenceException;
	public Pasajero getPasajeroByCorreo(String correoPasajero) throws EvernPersistenceException;
	
	public void agregarComentarioAlViaje(long idViaje, Comentario comentario) throws EvernPersistenceException;
	public void eliminarComentarioAlViaje(long idViaje, long idComentario) throws EvernPersistenceException;
	
	public void agregarViaje(Viaje viaje) throws EvernPersistenceException;
	public List<Viaje> getViajesDelUsuario(String correoUsuario) throws EvernPersistenceException;
	
	// ACTUALIZAR INFORMACION DEL USUARIO
	public void actualizarNombres(String correoUsuario, String nuevosNombres) throws EvernPersistenceException;
	public void actualizarApellidos(String correoUsuario, String nuevosApellidos) throws EvernPersistenceException;
	public void actualizarCorreo(String correoUsuario, String nuevoCorreo) throws EvernPersistenceException;
	public void actualizarClave(String correoUsuario, String nuevaClave) throws EvernPersistenceException;
	// CAMBIAR EL VEHICULO DEL CONDUCTOR
	public void actualizarAutomovil(String correoConductor, Automovil auto) throws EvernPersistenceException;
	
	//LOGIN
	public void login(String correoUsuario, String clave) throws EvernPersistenceException;
	
}
