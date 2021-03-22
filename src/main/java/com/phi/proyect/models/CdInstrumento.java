package com.phi.proyect.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cd_instrumento")
public class CdInstrumento implements Serializable {

	private static final long serialVersionUID = -4635609240201450178L;

	@Id
	@Column(name = "ID_Instrumento")
	private Integer idInstrumento;
	private String nombre;

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

}
