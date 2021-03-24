package com.phi.proyect.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ln_curvas")
public class LnCurvas implements Serializable{
	
	private static final long serialVersionUID = 3258618037719711648L;
	@Id
	private Integer	cdCurva;
	private String	fhDate;
	private Double	N1;
	private Double	N2;
	private Double	N3;
	private Double	N4;
	private Double	N5;
	//TODO: Falta completar hasta la columna N107

	
	public Integer getCdCurva() {
		return cdCurva;
	}
	public void setCdCurva(Integer cdCurva) {
		this.cdCurva = cdCurva;
	}
	public String getFhDate() {
		return fhDate;
	}
	public void setFhDate(String fhDate) {
		this.fhDate = fhDate;
	}
	public Double getN1() {
		return N1;
	}
	public void setN1(Double n1) {
		N1 = n1;
	}
	public Double getN2() {
		return N2;
	}
	public void setN2(Double n2) {
		N2 = n2;
	}
	public Double getN3() {
		return N3;
	}
	public void setN3(Double n3) {
		N3 = n3;
	}
	public Double getN4() {
		return N4;
	}
	public void setN4(Double n4) {
		N4 = n4;
	}
	public Double getN5() {
		return N5;
	}
	public void setN5(Double n5) {
		N5 = n5;
	}
	
	
	

}
