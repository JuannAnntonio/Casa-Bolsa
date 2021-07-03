package com.phi.proyect.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "de_divisas")
public class DeDivisas implements Serializable {

	private static final long serialVersionUID = 61348924359201554L;

	@Id
	private String cdTransaccion;
	private Integer cdInstrumento;
	private Double tcOriginal;
	private Integer cdCurva;
	private Double nuMonto;
	private Integer cdMoneda;
	private Integer tpPosicion;
	private String nbTrader;
	private String nbContraparte;

	public String getCdTransaccion() {
		return cdTransaccion;
	}

	public void setCdTransaccion(String cdTransaccion) {
		this.cdTransaccion = cdTransaccion;
	}

	public Integer getCdInstrumento() {
		return cdInstrumento;
	}

	public void setCdInstrumento(Integer cdInstrumento) {
		this.cdInstrumento = cdInstrumento;
	}

	public Double getTcOriginal() {
		return tcOriginal;
	}

	public void setTcOriginal(Double tcOriginal) {
		this.tcOriginal = tcOriginal;
	}

	public Integer getCdCurva() {
		return cdCurva;
	}

	public void setCdCurva(Integer cdCurva) {
		this.cdCurva = cdCurva;
	}

	public Double getNuMonto() {
		return nuMonto;
	}

	public void setNuMonto(Double nuMonto) {
		this.nuMonto = nuMonto;
	}

	public Integer getCdMoneda() {
		return cdMoneda;
	}

	public void setCdMoneda(Integer cdMoneda) {
		this.cdMoneda = cdMoneda;
	}

	public Integer getTpPosicion() {
		return tpPosicion;
	}

	public void setTpPosicion(Integer tpPosicion) {
		this.tpPosicion = tpPosicion;
	}

	public String getNbTrader() {
		return nbTrader;
	}

	public void setNbTrader(String nbTrader) {
		this.nbTrader = nbTrader;
	}

	public String getNbContraparte() {
		return nbContraparte;
	}

	public void setNbContraparte(String nbContraparte) {
		this.nbContraparte = nbContraparte;
	}

}
