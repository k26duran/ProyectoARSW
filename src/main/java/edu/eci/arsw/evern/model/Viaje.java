package edu.eci.arsw.evern.model;

public class Viaje {
	
	
	private long id;
	private String lugarOrigen;
	private String lugarDestino;
	private String fecha;
	private int calificacion;
	private int costo;
	private int tiempo;
	
	private Conductor conductor;
	private Pasajero pasajero;
	
	
	public Viaje(){}
	
	public Viaje(String lugarOrigen, String lugarDestino, int costo, int tiempo, Conductor conductor, Pasajero pasajero) {
		this.lugarDestino = lugarDestino;
		this.costo = costo;
		this.tiempo = tiempo;
		this.conductor = conductor;
	}


	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public int getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(int calificacion) {
		this.calificacion = calificacion;
	}

	public String getLugarDestino() {
		return lugarDestino;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLugarOrigen() {
		return lugarOrigen;
	}

	public void setLugarOrigen(String lugarOrigen) {
		this.lugarOrigen = lugarOrigen;
	}

	public Pasajero getPasajero() {
		return pasajero;
	}

	public void setPasajero(Pasajero pasajero) {
		this.pasajero = pasajero;
	}

	public void setLugarDestino(String lugarDestino) {
		this.lugarDestino = lugarDestino;
	}

	public int getCosto() {
		return costo;
	}

	public void setCosto(int costo) {
		this.costo = costo;
	}

	public int getTiempo() {
		return tiempo;
	}

	public void setTiempo(int tiempo) {
		this.tiempo = tiempo;
	}

	public Conductor getConductor() {
		return conductor;
	}

	public void setConductor(Conductor conductor) {
		this.conductor = conductor;
	}

	

}
