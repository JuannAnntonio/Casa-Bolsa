package com.phi.proyect.vo;

import java.io.Serializable;

public class MesaDerivados implements Serializable {

	private static final long serialVersionUID = -5075126855374686340L;

	private String producto;
	private Double valuacion;
	private Double var1;
	private Double var2;
	private Double var3;
	private Double limite;

	public MesaDerivados(String producto, Double valuacion, Double var1, Double var2, Double var3, Double limite) {
		super();
		this.producto = producto;
		this.valuacion = valuacion;
		this.var1 = var1;
		this.var2 = var2;
		this.var3 = var3;
		this.limite = limite;
	}

	public MesaDerivados() {
		super();
	}

	public String getProducto() {
		return producto;
	}

	public void setProducto(String producto) {
		this.producto = producto;
	}

	public Double getValuacion() {
		return valuacion;
	}

	public void setValuacion(Double valuacion) {
		this.valuacion = valuacion;
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

	public Double getLimite() {
		return limite;
	}

	public void setLimite(Double limite) {
		this.limite = limite;
	}

}
