package edu.eci.arsw.evern.services.contracts;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.eci.arsw.evern.model.CuentaBancaria;

@Service
public interface ICuentaBancariaServices {

	List<CuentaBancaria> list();

	CuentaBancaria create(CuentaBancaria car);

	CuentaBancaria get(String licencePlate);

	void update(CuentaBancaria cuentaBancaria);

	void delete(CuentaBancaria cuentaBancaria);

	void agregarCuentaBancaria(String correoUsuario, CuentaBancaria cuentaBancaria);

	void eliminarCuentaBancaria(String correoUsuario, long idCuentaBancaria);

	void eliminarCuentas(String correoUsuario);
}
