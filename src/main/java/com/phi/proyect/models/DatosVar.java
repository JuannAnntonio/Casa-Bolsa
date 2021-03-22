package com.phi.proyect.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "datos_var")
@IdClass(DatosVarId.class)
public class DatosVar implements Serializable {

	private static final long serialVersionUID = 5344393673163029308L;

	@Id
	private Integer cdInstrumento;
	@Id
	private String cdTransaccion;
	@Id
	private Integer cdMercado;
	@Id
	private String fecha;
	private String cdUsuario;
	private Double var1;
	private Double var2;
	private Double var3;
	private Double valuacion;

	public DatosVar() {
		super();
	}

	public DatosVar(Integer cdInstrumento, String cdTransaccion, Integer cdMercado, String cdUsuario, String fecha,
			Double var1, Double var2, Double var3, Double valuacion) {
		super();
		this.cdInstrumento = cdInstrumento;
		this.cdTransaccion = cdTransaccion;
		this.cdMercado = cdMercado;
		this.cdUsuario = cdUsuario;
		this.fecha = fecha;
		this.var1 = var1;
		this.var2 = var2;
		this.var3 = var3;
		this.valuacion = valuacion;
	}

	public DatosVar(Integer cdInstrumento, String fecha, Double var1, Double var2, Double var3) {
		super();
		this.cdInstrumento = cdInstrumento;
		this.fecha = fecha;
		this.var1 = var1;
		this.var2 = var2;
		this.var3 = var3;
	}

	public Integer getCdInstrumento() {
		return cdInstrumento;
	}

	public void setCdInstrumento(Integer cdInstrumento) {
		this.cdInstrumento = cdInstrumento;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public Double getVar1() {
		return var1;
	}

	public void setVar1(Double var1) {
		this.var1 = var1;
	}

	public Double getVar2() {
		return var2;
	}

	public void setVar2(Double var2) {
		this.var2 = var2;
	}

	public Double getVar3() {
		return var3;
	}

	public void setVar3(Double var3) {
		this.var3 = var3;
	}

	public String getCdTransaccion() {
		return cdTransaccion;
	}

	public void setCdTransaccion(String cdTransaccion) {
		this.cdTransaccion = cdTransaccion;
	}

	public Integer getCdMercado() {
		return cdMercado;
	}

	public void setCdMercado(Integer cdMercado) {
		this.cdMercado = cdMercado;
	}

	public String getCdUsuario() {
		return cdUsuario;
	}

	public void setCdUsuario(String cdUsuario) {
		this.cdUsuario = cdUsuario;
	}

	public Double getValuacion() {
		return valuacion;
	}

	public void setValuacion(Double valuacion) {
		this.valuacion = valuacion;
	}

}
