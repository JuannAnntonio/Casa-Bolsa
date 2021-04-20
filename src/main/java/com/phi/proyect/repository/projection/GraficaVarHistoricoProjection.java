package com.phi.proyect.repository.projection;

import org.springframework.beans.factory.annotation.Value;

public interface GraficaVarHistoricoProjection {

	@Value("#{target.fh_date}")
	String getFhDate();

	@Value("#{target.tp_grafica}")
	Integer getTpGrafica();

	@Value("#{target.tp_percentil}")
	Integer getTpPercentil();

	@Value("#{target.nb_serie}")
	String getNbSerie();

	@Value("#{target.cd_mercado}")
	Integer getCdMercado();

	@Value("#{target.mercado}")
	String getMercado();
	
	@Value("#{target.limite}")
	Double getLimite();

	@Value("#{target.instrumento}")
	String getInstrumento();

	@Value("#{target.cd_instrumento}")
	Integer getCdInstrumento();

	@Value("#{target.cd_transaccion}")
	String getCdTransaccion();

	@Value("#{target.nu_valuacionD}")
	Double getNuValuaciond();

	@Value("#{target.nu_valuacionH}")
	Double getNuValuacionh();

	@Value("#{target.nu_diferencia}")
	Double getNuDiferencia();

}
