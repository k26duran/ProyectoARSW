package edu.eci.arsw.enerv.model;

public class TarjetaDeCredito {
	private int id;
	private String banco;
	private boolean activa;
	
	public TarjetaDeCredito(){}
	
	public TarjetaDeCredito(int id, String banco, boolean activa) {
		this.id = id;
		this.banco = banco;
		this.activa = activa;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBanco() {
		return banco;
	}
	public void setBanco(String banco) {
		this.banco = banco;
	}
	public boolean isActiva() {
		return activa;
	}
	public void setActiva(boolean activa) {
		this.activa = activa;
	}
	@Override
	public String toString() {
		return "TarjetaDeCredito [id=" + id + ", banco=" + banco + ", activa=" + activa + "]";
	}

}
