package com.phi.proyect.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phi.proyect.models.GraficaVarHistorico;
import com.phi.proyect.repository.GraficaVarHistoricoRepository;

@Service
public class GraficaVarHistoricoService {

	@Autowired
	private GraficaVarHistoricoRepository graficaRepository;

	public List<GraficaVarHistorico> getDataChart(String tpPercentil, String fecha) {
		return graficaRepository.selectGraficaForPortafolioGlobal(tpPercentil, fecha);
	}

	public List<GraficaVarHistorico> getDataChart(String tpPercentil, String cdMercado, String fecha) {
		return graficaRepository.selectGraficaDos(tpPercentil, cdMercado, fecha);
	}

	public List<GraficaVarHistorico> getDataChart(String tpPercentil, String cdMercado, String cdInstrumento, String fecha) {
		System.out.println("### DATA CHART_3 ::: ");
		System.out.println(tpPercentil);
		System.out.println(cdMercado);
		System.out.println(cdInstrumento);
		System.out.println(fecha);
		return graficaRepository.selectGraficaTres(tpPercentil, cdMercado, cdInstrumento, fecha);
	}

}
