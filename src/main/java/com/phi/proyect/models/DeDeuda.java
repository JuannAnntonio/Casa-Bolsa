package com.phi.proyect.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "de_deuda")
public class DeDeuda implements Serializable {

	private static final long serialVersionUID = 615675731487161371L;
	@Id
	private String cdTransaccion;
	private String tv;
	private String emision;
	private String serie;
	private Integer diasVencimiento;
	private Integer cuponesPendientes;
	private Integer plazoCupon;
	private Integer diasTranscurridosCupon;
	private Integer diasCorteCupon;
	private Double valorNominal;
	private Integer nuTitulos;
	private Double tasaCuponVigente;
	private Double tasaRendimiento;
	private Double sobretasa;
	private Double sobretasaCupon;
	private Double tasaMercado;
	private Integer cdCurva;
	private Integer cdSobretasa;
	private Integer cdPosicion;
	private Integer cdInstrumento;
	private String tasaLibros;
	private Integer nuAccrual;
	private Integer cdAmortizable;
	private String nbTrader;
	private String nbContraparte;

	public String getCdTransaccion() {
		return cdTransaccion;
	}

	public void setCdTransaccion(String cdTransaccion) {
		this.cdTransaccion = cdTransaccion;
	}

	public String getTv() {
		return tv;
	}

	public void setTv(String tv) {
		this.tv = tv;
	}

	public String getEmision() {
		return emision;
	}

	public void setEmision(String emision) {
		this.emision = emision;
	}

	public String getSerie() {
		return serie;
	}

	public void setSerie(String serie) {
		this.serie = serie;
	}

	public Integer getDiasVencimiento() {
		return diasVencimiento;
	}

	public void setDiasVencimiento(Integer diasVencimiento) {
		this.diasVencimiento = diasVencimiento;
	}

	public Integer getCuponesPendientes() {
		return cuponesPendientes;
	}

	public void setCuponesPendientes(Integer cuponesPendientes) {
		this.cuponesPendientes = cuponesPendientes;
	}

	public Integer getPlazoCupon() {
		return plazoCupon;
	}

	public void setPlazoCupon(Integer plazoCupon) {
		this.plazoCupon = plazoCupon;
	}

	public Integer getDiasTranscurridosCupon() {
		return diasTranscurridosCupon;
	}

	public void setDiasTranscurridosCupon(Integer diasTranscurridosCupon) {
		this.diasTranscurridosCupon = diasTranscurridosCupon;
	}

	public Integer getDiasCorteCupon() {
		return diasCorteCupon;
	}

	public void setDiasCorteCupon(Integer diasCorteCupon) {
		this.diasCorteCupon = diasCorteCupon;
	}

	public Double getValorNominal() {
		return valorNominal;
	}

	public void setValorNominal(Double valorNominal) {
		this.valorNominal = valorNominal;
	}

	public Integer getNuTitulos() {
		return nuTitulos;
	}

	public void setNuTitulos(Integer nuTitulos) {
		this.nuTitulos = nuTitulos;
	}

	public Double getTasaCuponVigente() {
		return tasaCuponVigente;
	}

	public void setTasaCuponVigente(Double tasaCuponVigente) {
		this.tasaCuponVigente = tasaCuponVigente;
	}

	public Double getTasaRendimiento() {
		return tasaRendimiento;
	}

	public void setTasaRendimiento(Double tasaRendimiento) {
		this.tasaRendimiento = tasaRendimiento;
	}

	public Double getSobretasa() {
		return sobretasa;
	}

	public void setSobretasa(Double sobretasa) {
		this.sobretasa = sobretasa;
	}

	public Double getSobretasaCupon() {
		return sobretasaCupon;
	}

	public void setSobretasaCupon(Double sobretasaCupon) {
		this.sobretasaCupon = sobretasaCupon;
	}

	public Double getTasaMercado() {
		return tasaMercado;
	}

	public void setTasaMercado(Double tasaMercado) {
		this.tasaMercado = tasaMercado;
	}

	public Integer getCdCurva() {
		return cdCurva;
	}

	public void setCdCurva(Integer cdCurva) {
		this.cdCurva = cdCurva;
	}

	public Integer getCdSobretasa() {
		return cdSobretasa;
	}

	public void setCdSobretasa(Integer cdSobretasa) {
		this.cdSobretasa = cdSobretasa;
	}

	public Integer getCdPosicion() {
		return cdPosicion;
	}

	public void setCdPosicion(Integer cdPosicion) {
		this.cdPosicion = cdPosicion;
	}

	public Integer getCdInstrumento() {
		return cdInstrumento;
	}

	public void setCdInstrumento(Integer cdInstrumento) {
		this.cdInstrumento = cdInstrumento;
	}

	public String getTasaLibros() {
		return tasaLibros;
	}

	public void setTasaLibros(String tasaLibros) {
		this.tasaLibros = tasaLibros;
	}

	public Integer getNuAccrual() {
		return nuAccrual;
	}

	public void setNuAccrual(Integer nuAccrual) {
		this.nuAccrual = nuAccrual;
	}

	public Integer getCdAmortizable() {
		return cdAmortizable;
	}

	public void setCdAmortizable(Integer cdAmortizable) {
		this.cdAmortizable = cdAmortizable;
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
