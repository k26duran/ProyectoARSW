package edu.eci.arsw.enerv.model;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

import org.springframework.stereotype.Service;

//@Service("ConductorBean")
@Entity
@Table(name = "Coductores")
public class Conductor implements Usuario{
	
	@Column(name  = "nombres")
	private String nombres;
	

	@Column(name  = "apellidos")
	private String apellidos;
	

	@Column(name  = "nombres")
	private Date fechaDeNacimiento;
	
	
	
	private AutoMovil auto;
	/*
	 private List<Comentario> comentarios;
	 private List<TarjetaDeCredito> cuentasBancarias;
	
	 */

	public Conductor(){}
	
	public Conductor(String nombres, String apellidos, Date fechaDeNacimiento, List<TarjetaDeCredito> cuentasBancarias,
			AutoMovil auto, List<Comentario> comentarios) {
		
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.fechaDeNacimiento = fechaDeNacimiento;
		this.auto = auto;
		//this.cuentasBancarias = cuentasBancarias;
		//this.comentarios = comentarios;
	}
	

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public Date getFechaDeNacimiento() {
		return fechaDeNacimiento;
	}

	public void setFechaDeNacimiento(Date fechaDeNacimiento) {
		this.fechaDeNacimiento = fechaDeNacimiento;
	}

	/*
	public List<TarjetaDeCredito> getCuentasBancarias() {
		return cuentasBancarias;
	}

	public void setCuentasBancarias(List<TarjetaDeCredito> cuentas) {
		this.cuentasBancarias = cuentas;
	}
	
	public List<Comentario> getComentarios() {
		return comentarios;
	}

	public void setComentarios(List<Comentario> comentarios) {
		this.comentarios = comentarios;
	}
	
	
	*/

	public AutoMovil getAuto() {
		return auto;
	}

	public void setAuto(AutoMovil auto) {
		this.auto = auto;
	}

	

	@Override
	public void updateFoto() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void registrarTarjetas(int id, String Banco) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteTarjetas(int id, String Banco) {
		// TODO Auto-generated method stub
		
	}

}
