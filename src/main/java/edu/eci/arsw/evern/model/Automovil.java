package edu.eci.arsw.evern.model;

import javax.persistence.*;


@Entity
@Table( name = "automovil")
public class Automovil{


	@Id
	private String placa;

	private String modelo;


	private String color;


	private String tipo;

	@OneToOne(mappedBy = "auto" ,
			 cascade = CascadeType.ALL,
			 fetch = FetchType.LAZY,
			 optional = false)
	Conductor conductor;

	public Automovil(){

	}

	public Automovil(String placa, String modelo, String tipo, String color){
		this.color=color;
		this.modelo=modelo;
		this.placa=placa;
		this.tipo=tipo;
	}

	public Conductor getConductor() {
		return conductor;
	}

	public void setConductor(Conductor conductor) {
		this.conductor = conductor;
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
		return "Automovil [placa=" + placa + ", modelo=" + modelo + ", color=" + color + ", tipo=" + tipo + "]";
	}


}
