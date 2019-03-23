package com.mitocode.beans;

import org.springframework.stereotype.Repository;

import com.mitocode.interfaces.IEquipo;

@Repository //Para Capa datos
//@Service Para Capa logica de negocio
//@Controller Para capa controlador
//@Component Vale para todos
public class Barcelona implements IEquipo{

	public String mostrar() {
		return "Barcelona FC";
	}

}
