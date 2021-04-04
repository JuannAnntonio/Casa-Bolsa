package com.phi.proyect.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "flujos_swap")
public class FlujosSwap implements Serializable {

	private static final long serialVersionUID = -2750379947678674230L;

	@Id
	private String cdTransaccion;
	private Integer nuPago;
	private String fhPago;
	private Double nuMontoPago;
	private Integer nuPlazoCupon;
	private Double NuTasaVigente;
	private Integer cdActivo;
	private String fhPagoB;
	private Double nuMontoPagoB;
	private Integer nuPlazoCuponB;

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

	public String getFhPago() {
		return fhPago;
	}

	public void setFhPago(String fhPago) {
		this.fhPago = fhPago;
	}

	public Double getNuMontoPago() {
		return nuMontoPago;
	}

	public void setNuMontoPago(Double nuMontoPago) {
		this.nuMontoPago = nuMontoPago;
	}

	public Integer getNuPlazoCupon() {
		return nuPlazoCupon;
	}

	public void setNuPlazoCupon(Integer nuPlazoCupon) {
		this.nuPlazoCupon = nuPlazoCupon;
	}

	public Double getNuTasaVigente() {
		return NuTasaVigente;
	}

	public void setNuTasaVigente(Double nuTasaVigente) {
		NuTasaVigente = nuTasaVigente;
	}

	public Integer getCdActivo() {
		return cdActivo;
	}

	public void setCdActivo(Integer cdActivo) {
		this.cdActivo = cdActivo;
	}

	public String getFhPagoB() {
		return fhPagoB;
	}

	public void setFhPagoB(String fhPagoB) {
		this.fhPagoB = fhPagoB;
	}

	public Double getNuMontoPagoB() {
		return nuMontoPagoB;
	}

	public void setNuMontoPagoB(Double nuMontoPagoB) {
		this.nuMontoPagoB = nuMontoPagoB;
	}

	public Integer getNuPlazoCuponB() {
		return nuPlazoCuponB;
	}

	public void setNuPlazoCuponB(Integer nuPlazoCuponB) {
		this.nuPlazoCuponB = nuPlazoCuponB;
	}

}
