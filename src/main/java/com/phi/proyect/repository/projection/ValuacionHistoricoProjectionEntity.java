package com.phi.proyect.repository.projection;

import org.springframework.beans.factory.annotation.Value;

public interface ValuacionHistoricoProjectionEntity {

	@Value("#{target.fh_date}")
	String getFhDate();

	@Value("#{target.cd_mercado}")
	Integer getCdMercado();

	@Value("#{target.mercado}")
	String getMercado();

	@Value("#{target.instrumento}")
	String getInstrumento();

	@Value("#{target.cd_instrumento}")
	Integer getCdInstrumento();

	@Value("#{target.cd_transaccion}")
	String getCdTransaccion();

	@Value("#{target.nu_valuacion_dia}")
	Double getNuValuacionDia();

	@Value("#{target.nu_valuacion_historico}")
	Double getNuValuacionHistorico();

	@Value("#{target.nu_diferencia}")
	Double getNuDiferencia();

	@Value("#{target.nb_trader}")
	String getTrader();

	@Value("#{target.nb_contraparte}")
	String getContraparte();

}
