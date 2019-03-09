package edu.eci.arsw.enerv.persistence;

import java.util.List;

import edu.eci.arsw.enerv.model.AutoMovil;
import edu.eci.arsw.enerv.model.Comentario;
import edu.eci.arsw.enerv.model.Conductor;
import edu.eci.arsw.enerv.model.Pasajero;
import edu.eci.arsw.enerv.model.Viaje;

public interface EnervPersistence {
	/**
	 * 
	 * @param id
	 * @return
	 * @throws EnervPersistenceException
	 */
	public Conductor getConductorById(int id) throws EnervPersistenceException;
	/**
	 * 
	 * @param id
	 * @return
	 * @throws EnervPersistenceException
	 */
	public Pasajero getPasajeroById(int id) throws EnervPersistenceException;
	/**
	 * 
	 * @param c
	 * @throws EnervPersistenceException
	 */
	public void addConductor(Conductor c) throws EnervPersistenceException;
	/**
	 * 
	 * @param p
	 * @throws EnervPersistenceException
	 */
	public void addPasajero(Pasajero p) throws EnervPersistenceException;
	/**
	 * 
	 * @param idUsuario
	 * @param idTarjeta
	 * @param banco
	 * @throws EnervPersistenceException
	 */
	public void addTarjeta(int idUsuario,int idTarjeta, String banco) throws EnervPersistenceException;
	/**
	 * 
	 * @param idUsuario
	 * @param idTarjeta
	 * @param banco
	 * @throws EnervPersistenceException
	 */
	public void deleteTarjeta(int idUsuario,int idTarjeta, String banco) throws EnervPersistenceException;
	/**
	 * 
	 * @param idUsuario
	 * @throws EnervPersistenceException
	 */
	public void deleteTarjetas(int idUsuario)throws EnervPersistenceException;
	/**
	 * 
	 * @param idDestinatario
	 * @param idCreador
	 * @param comentario
	 * @throws EnervPersistenceException
	 */
	public void addComentario(int idDestinatario,int idCreador,String comentario) throws EnervPersistenceException;
	/**
	 * 
	 * @param id
	 * @return
	 * @throws EnervPersistenceException
	 */
	public List<Comentario> getComentariosById(int id) throws EnervPersistenceException;
	/**
	 * 
	 * @param idConductor
	 * @param auto
	 * @throws EnervPersistenceException
	 */
	public void addAuto(int idConductor, AutoMovil auto) throws EnervPersistenceException;
	/**
	 * 
	 * @param idConductor
	 * @param auto
	 * @throws EnervPersistenceException
	 */
	public void updateAuto(int idConductor, AutoMovil auto) throws EnervPersistenceException;
	/**
	 * 
	 * @param idConductor
	 * @throws EnervPersistenceException
	 */
	public void deleteAuto(int idConductor) throws EnervPersistenceException;
	/**
	 * 
	 * @param viaje
	 * @throws EnervPersistenceException
	 */
	public void addViaje(Viaje viaje) throws EnervPersistenceException;
	/**
	 * 
	 * @param idPasajero
	 * @return
	 * @throws EnervPersistenceException
	 */
	public List<Viaje> getViajes(int idPasajero) throws EnervPersistenceException;
	
	
	

}
