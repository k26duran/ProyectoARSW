package edu.eci.arsw.evern.persistence.repositories;

import java.io.Serializable;
import java.util.List;

import edu.eci.arsw.evern.controller.EvernException;

public interface DAO<T extends Serializable, PK>{
	
	public List<T> findAll() throws EvernException;
	public T find(PK findByPK) throws EvernException;
	public PK save(T entity) throws EvernException;
	public void update(T entity) throws EvernException;
	public void delete(T entity) throws EvernException;
	public void remove(PK pkEntity) throws EvernException;
}
