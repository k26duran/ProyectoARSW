package edu.eci.arsw.evern.persistence.repositories;

import java.io.Serializable;
import java.util.List;

public interface DAO<T extends Serializable, PK>{
	
	public List<T> findAll();
	public T find(PK findByPK);
	public PK save(T entity);
	public void update(T entity);
	public void delete(T entity);
	public void remove(PK pkEntity);
}
