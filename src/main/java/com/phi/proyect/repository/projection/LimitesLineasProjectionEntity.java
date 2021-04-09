package com.phi.proyect.repository.projection;

import org.springframework.beans.factory.annotation.Value;

public interface LimitesLineasProjectionEntity {

	@Value("#{target.id_instrumento}")
	Integer getIdInstrumento();
	
	@Value("#{target.producto}")
	String getProducto();

	@Value("#{target.limiteGlobal}")
	Double getLimiteGlobal();
	
	@Value("#{target.limiteInstrumento}")
	Double getLimiteInstrumento();

	@Value("#{target.limiteOperacion}")
	Double getLimiteOperacion();

	@Value("#{target.mercado}")
	String getMercado();

}
