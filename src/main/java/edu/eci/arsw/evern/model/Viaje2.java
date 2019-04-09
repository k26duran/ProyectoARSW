package edu.eci.arsw.evern.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Viaje2 implements Serializable {
	
	
	private String lugarOrigen;
	private String lugarDestino;
	private int costo;


	public Viaje2(){}
	
	public Viaje2(String lugarOrigen, String lugarDestino, int costo) {
		this.lugarOrigen = lugarOrigen;
		this.lugarDestino = lugarDestino;
		this.costo = costo;
	}

	public String getLugarOrigen() {
		return lugarOrigen;
	}

	public void setLugarOrigen(String lugarOrigen) {
		this.lugarOrigen = lugarOrigen;
	}

	public String getLugarDestino() {
		return lugarDestino;
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




}
