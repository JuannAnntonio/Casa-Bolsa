package com.phi.proyect.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cd_mercado")
public class CdMercado implements Serializable {

	private static final long serialVersionUID = 2365520466475007692L;

	@Id
	@Column(name = "ID_Mercado")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idMercado;
	private String nombre;
	private Integer cdActivo;
	@Column(name = "nu_limite")
	private Double limite;

	public Integer getIdMercado() {
		return idMercado;
	}

	public void setIdMercado(Integer idMercado) {
		this.idMercado = idMercado;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getCdActivo() {
		return cdActivo;
	}

	public void setCdActivo(Integer cdActivo) {
		this.cdActivo = cdActivo;
	}

	public Double getLimite() {
		return limite;
	}

	public void setLimite(Double limite) {
		this.limite = limite;
	}

}
