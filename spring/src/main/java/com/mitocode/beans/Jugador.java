package com.mitocode.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.mitocode.interfaces.IEquipo;

@Component("messi")
public class Jugador {
	private int numero;
	@Value("Lionel Messi")
	private String nombre;
	private IEquipo equipo;

	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public IEquipo getEquipo() {
		return equipo;
	}
	
	//@Required
	@Autowired
	//@Qualifier("barcelonaQualifier")
	public void setEquipo(IEquipo equipo) {
		this.equipo = equipo;
	}
}
