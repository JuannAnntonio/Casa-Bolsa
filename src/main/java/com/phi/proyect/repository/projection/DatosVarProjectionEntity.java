package com.phi.proyect.repository.projection;

import org.springframework.beans.factory.annotation.Value;

public interface DatosVarProjectionEntity {

	@Value("#{target.nombre}")
	String getNombre();

	@Value("#{target.limite}")
	Double getLimite();
	
	@Value("#{target.cd_instrumento}")
	String getCdInstrumento();

	@Value("#{target.fecha}")
	String getFecha();

	@Value("#{target.var1}")
	Double getVar1();

	@Value("#{target.var2}")
	Double getVar2();

	@Value("#{target.var3}")
	Double getVar3();

	@Value("#{target.cd_transaccion}")
	String getCdTransaccion();

	@Value("#{target.cd_mercado}")
	String getCdMercado();

	@Value("#{target.cd_usuario}")
	String getCdUsuario();

	@Value("#{target.valuacion}")
	String getValuacion();

}
