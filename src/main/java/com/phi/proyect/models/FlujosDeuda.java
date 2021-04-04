package com.phi.proyect.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "flujos_deuda")
public class FlujosDeuda implements Serializable {

	private static final long serialVersionUID = 442774597847908535L;

	@Id
	private String cdTransaccion;
	private Integer nuFlujo;
	private Integer nuPlazo;
	private Double nuNominal;
	private Double nuAmortizacion;
	private String fhInicio;
	private String fhFin;

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

	public Integer getNuPlazo() {
		return nuPlazo;
	}

	public void setNuPlazo(Integer nuPlazo) {
		this.nuPlazo = nuPlazo;
	}

	public Double getNuNominal() {
		return nuNominal;
	}

	public void setNuNominal(Double nuNominal) {
		this.nuNominal = nuNominal;
	}

	public Double getNuAmortizacion() {
		return nuAmortizacion;
	}

	public void setNuAmortizacion(Double nuAmortizacion) {
		this.nuAmortizacion = nuAmortizacion;
	}

	public String getFhInicio() {
		return fhInicio;
	}

	public void setFhInicio(String fhInicio) {
		this.fhInicio = fhInicio;
	}

	public String getFhFin() {
		return fhFin;
	}

	public void setFhFin(String fhFin) {
		this.fhFin = fhFin;
	}

}
