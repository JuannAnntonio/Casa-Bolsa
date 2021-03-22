package com.phi.proyect.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "de_forward")
public class DeForward implements Serializable {

	private static final long serialVersionUID = 4820003446340167490L;

	@Id
	private Integer cdTransaccion;
	private Integer cdInstrumento;
	private String fechaInicio;
	private String fechaFin;
	private Integer nuCurvaLocal;
	private Integer nuCurvaForanea;
	private Integer nuIndice;
	private Double nuPactado;
	private Integer nuContratos;
	private Integer nuPosicion;
	private Integer nuPlazo;
	private Integer nuConvencion;
	private String nbTrader;
	private String nbContraparte;

	public Integer getCdTransaccion() {
		return cdTransaccion;
	}

	public void setCdTransaccion(Integer cdTransaccion) {
		this.cdTransaccion = cdTransaccion;
	}

	public Integer getCdInstrumento() {
		return cdInstrumento;
	}

	public void setCdInstrumento(Integer cdInstrumento) {
		this.cdInstrumento = cdInstrumento;
	}

	public String getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public String getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}

	public Integer getNuCurvaLocal() {
		return nuCurvaLocal;
	}

	public void setNuCurvaLocal(Integer nuCurvaLocal) {
		this.nuCurvaLocal = nuCurvaLocal;
	}

	public Integer getNuCurvaForanea() {
		return nuCurvaForanea;
	}

	public void setNuCurvaForanea(Integer nuCurvaForanea) {
		this.nuCurvaForanea = nuCurvaForanea;
	}

	public Integer getNuIndice() {
		return nuIndice;
	}

	public void setNuIndice(Integer nuIndice) {
		this.nuIndice = nuIndice;
	}

	public Double getNuPactado() {
		return nuPactado;
	}

	public void setNuPactado(Double nuPactado) {
		this.nuPactado = nuPactado;
	}

	public Integer getNuContratos() {
		return nuContratos;
	}

	public void setNuContratos(Integer nuContratos) {
		this.nuContratos = nuContratos;
	}

	public Integer getNuPosicion() {
		return nuPosicion;
	}

	public void setNuPosicion(Integer nuPosicion) {
		this.nuPosicion = nuPosicion;
	}

	public Integer getNuPlazo() {
		return nuPlazo;
	}

	public void setNuPlazo(Integer nuPlazo) {
		this.nuPlazo = nuPlazo;
	}

	public Integer getNuConvencion() {
		return nuConvencion;
	}

	public void setNuConvencion(Integer nuConvencion) {
		this.nuConvencion = nuConvencion;
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
