package edu.eci.arsw.evern.persistence;

public class EvernPersistenceException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EvernPersistenceException(String message){
		super(message);
		
	}
	
	public EvernPersistenceException(String message, Throwable cause){
		super(message, cause);
		
	}

}
