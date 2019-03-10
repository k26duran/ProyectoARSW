package edu.eci.arsw.enerv.model;

import javax.persistence.*;

@Entity
@Table(name = "AutoMoviles")
public class AutoMovil{
	
	@Column(name = "placa")
	private String placa;

	@Column(name = "modelo")
	private String modelo;

	@Column(name = "color")
	private String color;
	

	@Column(name = "tipo")
	private String tipo;
	
	public AutoMovil(){}
	
	public AutoMovil(String placa, String modelo, String tipo, String color){
		this.color=color;
		this.modelo=modelo;
		this.placa=placa;
		this.tipo=tipo;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "AutoMovil [placa=" + placa + ", modelo=" + modelo + ", color=" + color + ", tipo=" + tipo + "]";
	}
	

}
