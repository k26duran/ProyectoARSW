package edu.eci.arsw.enerv.persistence.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.eci.arsw.enerv.model.AutoMovil;
import edu.eci.arsw.enerv.model.Comentario;
import edu.eci.arsw.enerv.model.Conductor;
import edu.eci.arsw.enerv.model.Pasajero;
import edu.eci.arsw.enerv.model.Viaje;
import edu.eci.arsw.enerv.persistence.EnervPersistence;
import edu.eci.arsw.enerv.persistence.EnervPersistenceException;

@Service("EnervBean")
public class InMemoryPersistence implements EnervPersistence{

	@Override
	public Conductor getConductorById(int id) throws EnervPersistenceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pasajero getPasajeroById(int id) throws EnervPersistenceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addConductor(Conductor c) throws EnervPersistenceException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addPasajero(Pasajero p) throws EnervPersistenceException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addTarjeta(int idUsuario, int idTarjeta, String banco) throws EnervPersistenceException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteTarjeta(int idUsuario, int idTarjeta, String banco) throws EnervPersistenceException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteTarjetas(int idUsuario) throws EnervPersistenceException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addComentario(int idDestinatario, int idCreador, String comentario) throws EnervPersistenceException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Comentario> getComentariosById(int id) throws EnervPersistenceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addAuto(int idConductor, AutoMovil auto) throws EnervPersistenceException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateAuto(int idConductor, AutoMovil auto) throws EnervPersistenceException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAuto(int idConductor) throws EnervPersistenceException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addViaje(Viaje viaje) throws EnervPersistenceException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Viaje> getViajes(int idPasajero) throws EnervPersistenceException {
		// TODO Auto-generated method stub
		return null;
	}

}
