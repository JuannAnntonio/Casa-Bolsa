package com.phi.proyect.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "valuacion_historico_var")
@IdClass(DatosVarId.class)
public class ValuacionHistoricoVar implements Serializable {

	private static final long serialVersionUID = 2903492597272770522L;
	@Id
	@Column(name = "fh_date")
	private String fecha;
	@Id
	private Integer cdMercado;
	@Id
	private Integer cdInstrumento;
	@Id
	private String cdTransaccion;
	private Double nuValuacionDia;
	private Double nuValuacionHistorico;
	private Double nuDiferencia;
	private String nbTrader;
	private String nbContraparte;

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public Integer getCdMercado() {
		return cdMercado;
	}

	public void setCdMercado(Integer cdMercado) {
		this.cdMercado = cdMercado;
	}

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

	public Double getNuValuacionDia() {
		return nuValuacionDia;
	}

	public void setNuValuacionDia(Double nuValuacionDia) {
		this.nuValuacionDia = nuValuacionDia;
	}

	public Double getNuValuacionHistorico() {
		return nuValuacionHistorico;
	}

	public void setNuValuacionHistorico(Double nuValuacionHistorico) {
		this.nuValuacionHistorico = nuValuacionHistorico;
	}

	public Double getNuDiferencia() {
		return nuDiferencia;
	}

	public void setNuDiferencia(Double nuDiferencia) {
		this.nuDiferencia = nuDiferencia;
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
