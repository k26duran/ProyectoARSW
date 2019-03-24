package edu.eci.arsw.evern.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;


public class Automovil implements Serializable{

	private Long id;

	private String placa;

	private String modelo;

	private String color;

	private String tipo;


//	@OneToOne(targetEntity = Conductor.class, mappedBy = "automovil",
//			  fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//	@JoinColumn(name = "conductor")
//	@JsonIgnore
//	Conductor conductor;

	public Automovil() {

	}

	public Automovil(String placa, String modelo, String tipo, String color) {
		this.color = color;
		this.modelo = modelo;
		this.placa = placa;
		this.tipo = tipo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


//	public Conductor getConductor() {
//		return conductor;
//	}
//
//	public void setConductor(Conductor conductor) {
//		this.conductor = conductor;
//	}

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
