package com.phi.proyect.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cd_instrumento")
public class CdInstrumento implements Serializable {

	private static final long serialVersionUID = -4635609240201450178L;

	@Id
	@Column(name = "ID_Instrumento")
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer idInstrumento;
	private String nombre;
	private Integer idMercado;
	private Integer cdActivo;
	@Column(name = "nu_limite_instrumento")
	private Double limiteInstrumento;
	@Column(name = "nu_limite_transaccion")
	private Double limiteTransaccion;

	public CdInstrumento() {
		super();
	}

	public Integer getIdInstrumento() {
		return idInstrumento;
	}

	public void setIdInstrumento(Integer idInstrumento) {
		this.idInstrumento = idInstrumento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getIdMercado() {
		return idMercado;
	}

	public void setIdMercado(Integer idMercado) {
		this.idMercado = idMercado;
	}

	public Integer getCdActivo() {
		return cdActivo;
	}

	public void setCdActivo(Integer cdActivo) {
		this.cdActivo = cdActivo;
	}

	public Double getLimiteInstrumento() {
		return limiteInstrumento;
	}

	public void setLimiteInstrumento(Double limiteInstrumento) {
		this.limiteInstrumento = limiteInstrumento;
	}

	public Double getLimiteTransaccion() {
		return limiteTransaccion;
	}

	public void setLimiteTransaccion(Double limiteTransaccion) {
		this.limiteTransaccion = limiteTransaccion;
	}

}
