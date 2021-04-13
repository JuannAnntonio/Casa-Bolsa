package com.phi.proyect.models;

import java.io.Serializable;

import javax.persistence.Column;
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
	@Column(name = "Nu_Plazocupon")
	private Integer nu_Plazocupon;
	@Column(name = "Nu_Tasavigente")
	private Double nu_Tasavigente;
	private Integer cdActivo;
	@Column(name = "Fh_Pago_B")
	private String fhPagoB;
	@Column(name = "Nu_Monto_Pago_B")
	private Double nuMontoPagoB;
	@Column(name = "Nu_Plazocupon_B")
	private Integer nu_Plazocupon_B;

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

	public Integer getNu_Plazocupon() {
		return nu_Plazocupon;
	}

	public void setNu_Plazocupon(Integer nu_PlazoCupon) {
		this.nu_Plazocupon = nu_PlazoCupon;
	}

	public Double getNu_Tasavigente() {
		return nu_Tasavigente;
	}

	public void setNu_Tasavigente(Double nu_TasaVigente) {
		this.nu_Tasavigente = nu_TasaVigente;
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

	public Integer getNu_Plazocupon_B() {
		return nu_Plazocupon_B;
	}

	public void setNu_Plazocupon_B(Integer nu_PlazoCupon_B) {
		this.nu_Plazocupon_B = nu_PlazoCupon_B;
	}

}
