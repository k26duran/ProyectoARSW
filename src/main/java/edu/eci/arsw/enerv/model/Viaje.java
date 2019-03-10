package edu.eci.arsw.enerv.model;

public class Viaje {
	private String lugarDestino;
	private int costo;
	private int tiempo;
	private Conductor conductor;
	
	public Viaje(){}
	
	public Viaje(String lugarDestino, int costo, int tiempo, Conductor conductor) {
		super();
		this.lugarDestino = lugarDestino;
		this.costo = costo;
		this.tiempo = tiempo;
		this.conductor = conductor;
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


	@Override
	public String toString() {
		return "Viaje [lugarDestino=" + lugarDestino + ", costo=" + costo + ", tiempo=" + tiempo + ", conductor="
				+ conductor + "]";
	}
	

}
