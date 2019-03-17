package edu.eci.arsw.evern.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import org.springframework.stereotype.Service;

@Entity
public class Conductor extends Usuario {


    @OneToOne(targetEntity = Automovil.class ,
            cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Automovil automovil;

    @OneToMany(mappedBy = "conductor" , fetch = FetchType.LAZY ,
            cascade =  CascadeType.ALL)
    private List<CuentaBancaria> cuentasBancarias = new ArrayList<CuentaBancaria>();

    @OneToMany(mappedBy = "conductor" , fetch = FetchType.LAZY , cascade =  CascadeType.ALL)
    private List<Viaje> viajes = new ArrayList<Viaje>();


    public Conductor() {

    }

    public Automovil getAutomovil() {
        return automovil;
    }

    public void setAutomovil(Automovil automovil) {
        this.automovil = automovil;
    }

    public Conductor(String correo, String nombres, String apellidos, Date fechaNacimiento, String clave,
                     Automovil auto) {
        super(correo, nombres, apellidos, fechaNacimiento, clave);
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



//	@Override
//	public String toString() {
//		return "Conductor [auto=" + auto + super.toString() + "]";
//	}
//

}
