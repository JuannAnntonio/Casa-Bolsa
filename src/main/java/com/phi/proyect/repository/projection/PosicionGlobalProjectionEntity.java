package com.phi.proyect.repository.projection;

import org.springframework.beans.factory.annotation.Value;

public interface PosicionGlobalProjectionEntity {

	@Value("#{target.var1}")
	Double getVar1();

	@Value("#{target.var2}")
	Double getVar2();

	@Value("#{target.var3}")
	Double getVar3();

	@Value("#{target.valuacion}")
	Double getValuacion();

	@Value("#{target.nu_limite}")
	Double getLimite();

}
