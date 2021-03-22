package com.phi.proyect.models;

import java.io.Serializable;

public class DatosVarId implements Serializable {

	private static final long serialVersionUID = -1915368400458771704L;
	private Integer cdInstrumento;
	private String cdTransaccion;
	private Integer cdMercado;
	private String fecha;

	public Integer getCdInstrumento() {
		return cdInstrumento;
	}

	public void setCdInstrumento(Integer cdInstrumento) {
		this.cdInstrumento = cdInstrumento;
	}

	public String getCdTransaccion() {
		return cdTransaccion;
	}

	public void setCdTransaccion(String cdTransaccion) {
		this.cdTransaccion = cdTransaccion;
	}

	public Integer getCdMercado() {
		return cdMercado;
	}

	public void setCdMercado(Integer cdMercado) {
		this.cdMercado = cdMercado;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

}
