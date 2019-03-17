package edu.eci.arsw.evern.repository;

import edu.eci.arsw.evern.model.Automovil;
import edu.eci.arsw.evern.model.CuentaBancaria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CuentaBancariaRepository  extends JpaRepository<CuentaBancaria, Long> {
}
