package com.phi.proyect.models;

import java.io.Serializable;

public class PrimaryKeyFlujosSwaps implements Serializable {

	private static final long serialVersionUID = -7024008983471462959L;
	private String cdTransaccion;
	private Integer nuPago;

	public PrimaryKeyFlujosSwaps() {
		super();
	}

	public PrimaryKeyFlujosSwaps(String cdTransaccion, Integer nuPago) {
		super();
		this.cdTransaccion = cdTransaccion;
		this.nuPago = nuPago;
	}

	public String getCdTransaccion() {
		return cdTransaccion;
	}

	public void setCdTransaccion(String cdTransaccion) {
		this.cdTransaccion = cdTransaccion;
	}

	public Integer getNuPago() {
		return nuPago;
	}

	public void setNuPago(Integer nuPago) {
		this.nuPago = nuPago;
	}

}
