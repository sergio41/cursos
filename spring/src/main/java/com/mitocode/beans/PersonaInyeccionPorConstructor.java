package com.mitocode.beans;

public class PersonaInyeccionPorConstructor {
	private int id;
	private String nombre;
	private String apodo;
	
	public PersonaInyeccionPorConstructor(int id, String nombre, String apodo) {
		this.id = id;
		this.nombre = nombre;
		this.apodo = apodo;
	}
	
	public PersonaInyeccionPorConstructor(int id) {
		this.id = id;
	}
	
	public PersonaInyeccionPorConstructor(String apodo) {
		this.apodo = apodo;
	}

	public int getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApodo() {
		return apodo;
	}
}
