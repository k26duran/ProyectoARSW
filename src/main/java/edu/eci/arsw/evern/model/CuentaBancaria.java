package edu.eci.arsw.evern.model;

public class CuentaBancaria {
	private long id;
	private String banco;
	private boolean activa;
	
	public CuentaBancaria(){}
	
	public CuentaBancaria(long id, String banco, boolean activa) {
		this.id = id;
		this.banco = banco;
		this.activa = activa;
	}
	
	public long getId() {
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
		return "CuentaBancaria [id=" + id + ", banco=" + banco + ", activa=" + activa + "]";
	}

}
