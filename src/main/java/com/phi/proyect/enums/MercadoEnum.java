package com.phi.proyect.enums;

public enum MercadoEnum {

	Mercado_Global(1, "Mercado Global"), 
	Mercado_Capital(2, "Mercado Capital"), 
	Mercado_Dinero(3, "Mercado Dinero"),
	Mercado_Divisas(4, "Mercado Divisas"), 
	Mercado_Derivado(5, "Mercado Derivado");

	private Integer id;
	private String nombre;

	private MercadoEnum(Integer id, String nombre) {
		this.id = id;
		this.nombre = nombre;
	}

	public Integer getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

}
