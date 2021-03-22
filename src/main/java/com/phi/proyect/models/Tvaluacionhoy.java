package com.phi.proyect.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//ELIMINAR y sustituir DatosVar
@Entity
@Table(name = "tvaluacionhoy")
public class Tvaluacionhoy implements Serializable {

	private static final long serialVersionUID = -809275325970675137L;

	@Id
	private String CdTransaccion;
	private Double Valuacion;
	private Integer CdInstrumento;
	private String fecha;
	private Double var1;
	private Double var2;
	private Double var3;
	private Integer portafolio;//codigo de instrumento

	/*---------------cambios alejandro--------------------
	se creo un constructor vacio, se agregaron y cambiaron algunas de las variables de las columnas
	se creo un tercer contructor para evitar problemas en el controller "MercadoDerivadosController"
	*/

	public Tvaluacionhoy(String cdTransaccion, Double valuacion, Integer cdInstrumento, Double var1, Double var2,
			Double var3) {
		super();
		CdTransaccion = cdTransaccion;
		Valuacion = valuacion;
		CdInstrumento = cdInstrumento;
		this.var1 = var1;
		this.var2 = var2;
		this.var3 = var3;
	}

	public Tvaluacionhoy() {
		super();
	}

	public Tvaluacionhoy(String cdTransaccion, Double valuacion, Integer cdInstrumento, String fecha, Double var1,
			Double var2, Double var3, Integer portafolio) {
		super();
		CdTransaccion = cdTransaccion;
		Valuacion = valuacion;
		CdInstrumento = cdInstrumento;
		this.fecha = fecha;
		this.var1 = var1;
		this.var2 = var2;
		this.var3 = var3;
		this.portafolio = portafolio;
	}

	public String getCdTransaccion() {
		return CdTransaccion;
	}

	public void setCdTransaccion(String cdTransaccion) {
		CdTransaccion = cdTransaccion;
	}

	public Double getValuacion() {
		return Valuacion;
	}

	public void setValuacion(Double valuacion) {
		Valuacion = valuacion;
	}

	public Integer getCdInstrumento() {
		return CdInstrumento;
	}

	public void setCdInstrumento(Integer cdInstrumento) {
		CdInstrumento = cdInstrumento;
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

	public Integer getPortafolio() {
		return portafolio;
	}

	public void setPortafolio(Integer portafolio) {
		this.portafolio = portafolio;
	}

}
