package com.phi.proyect.models;

import java.io.Serializable;

public class PrimaryKeyFlujosDeuda implements Serializable {

	private static final long serialVersionUID = -7024008983471462959L;
	private String cdTransaccion;
	private Integer nuFlujo;

	public PrimaryKeyFlujosDeuda() {
		super();
	}
	public PrimaryKeyFlujosDeuda(String cdTransaccion, Integer nuFlujo) {
		super();
		this.cdTransaccion = cdTransaccion;
		this.nuFlujo = nuFlujo;
	}

	public String getCdTransaccion() {
		return cdTransaccion;
	}

	public void setCdTransaccion(String cdTransaccion) {
		this.cdTransaccion = cdTransaccion;
	}

	public Integer getNuFlujo() {
		return nuFlujo;
	}

	public void setNuFlujo(Integer nuFlujo) {
		this.nuFlujo = nuFlujo;
	}

}
