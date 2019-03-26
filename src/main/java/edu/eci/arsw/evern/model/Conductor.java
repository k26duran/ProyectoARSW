package edu.eci.arsw.evern.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.stereotype.Service;



public class Conductor extends Usuario implements Serializable {


    private Automovil automovil;

    private List<CuentaBancaria> cuentasBancarias = new ArrayList<CuentaBancaria>();

    private List<Viaje> viajes = new ArrayList<Viaje>();


    public Conductor() {

    }

    public Automovil getAutomovil() {
        return automovil;
    }

    public void setAutomovil(Automovil automovil) {
        this.automovil = automovil;
    }

    public Conductor(String correo, String nombres, String apellidos, String celular, String fechaNacimiento, String clave,
                     Automovil auto) {
        super(correo, nombres, apellidos, celular, fechaNacimiento, clave);
        this.automovil = auto;
    }

    public Automovil getAuto() {
        return automovil;
    }

    public void setAuto(Automovil automovil) {
        this.automovil = automovil;
    }

    public List<CuentaBancaria> getCuentasBancarias() {
        return cuentasBancarias;
    }

    public void setCuentasBancarias(List<CuentaBancaria> cuentasBancarias) {
        this.cuentasBancarias = cuentasBancarias;
    }


    public void setViajes(List<Viaje> viajes) {
        this.viajes = viajes;
    }

    public void agregarViaje(Viaje viaje) {
        this.viajes.add(viaje);
    }


    public List<Viaje> getViajes() {
        return viajes;
    }
    
    @Override
    public String getTipoUsuario() {
    	return "conductor";
    }

	@Override
	public String toString() {
		return "Conductor [automovil=" + automovil + ", cuentasBancarias=" + cuentasBancarias + ", viajes=" + viajes
				+ "]";
	}

}
