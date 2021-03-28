package com.phi.proyect.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "grafica_var_historico")
@IdClass(DatosVarId.class)
public class GraficaVarHistorico implements Serializable {

	private static final long serialVersionUID = -6571539682169165714L;

	@Id
	@Column(name = "fhDate")
	private String fecha;
	private Integer tpGrafica;
	private Integer tpPercentil;
	private String nbSerie;
	@Id
	private Integer cdMercado;
	@Id
	private Integer cdInstrumento;
	@Id
	private String cdTransaccion;
	private Double nuValuacionD;
	private Double nuValuacionH;
	private Double nuDiferencia;

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public Integer getTpGrafica() {
		return tpGrafica;
	}

	public void setTpGrafica(Integer tpGrafica) {
		this.tpGrafica = tpGrafica;
	}

	public Integer getTpPercentil() {
		return tpPercentil;
	}

	public void setTpPercentil(Integer tpPercentil) {
		this.tpPercentil = tpPercentil;
	}

	public String getNbSerie() {
		return nbSerie;
	}

	public void setNbSerie(String nbSerie) {
		this.nbSerie = nbSerie;
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

	public Double getNuValuacionD() {
		return nuValuacionD;
	}

	public void setNuValuacionD(Double nuValuacionD) {
		this.nuValuacionD = nuValuacionD;
	}

	public Double getNuValuacionH() {
		return nuValuacionH;
	}

	public void setNuValuacionH(Double nuValuacionH) {
		this.nuValuacionH = nuValuacionH;
	}

	public Double getNuDiferencia() {
		return nuDiferencia;
	}

	public void setNuDiferencia(Double nuDiferencia) {
		this.nuDiferencia = nuDiferencia;
	}

}
