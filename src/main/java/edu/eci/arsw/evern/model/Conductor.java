package edu.eci.arsw.evern.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.stereotype.Service;



public class Conductor extends Usuario implements Serializable {


    private Automovil automovil;

    public Conductor() {}
    
    public Conductor(String correo, String nombres, String apellidos, String celular, String clave,
            Automovil auto) {
	super(correo, nombres, apellidos, celular, clave);
	this.automovil = auto;
	}

    public Automovil getAutomovil() {
        return automovil;
    }

    public void setAutomovil(Automovil automovil) {
        this.automovil = automovil;
    }

    
    @Override
    public String getTipoUsuario() {
    	return "conductor";
    }

	@Override
	public String toString() {
		return "Conductor [automovil=" + automovil + ", getAutomovil()=" + getAutomovil() + ", getTipoUsuario()="
				+ getTipoUsuario() + ", getCuentasBancarias()=" + getCuentasBancarias() + ", getViajes()=" + getViajes()
				+ ", getCorreo()=" + getCorreo() + ", getNombres()=" + getNombres() + ", getApellidos()="
				+ getApellidos() + ", getCalificacion()=" + getCalificacion() + ", getCelular()=" + getCelular()
				+ ", toString()=" + super.toString() + ", getClave()=" + getClave() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + "]";
	}


}
