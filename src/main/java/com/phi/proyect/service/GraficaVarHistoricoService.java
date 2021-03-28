package com.phi.proyect.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.phi.proyect.models.GraficaVarHistorico;
import com.phi.proyect.repository.GraficaVarHistoricoRepository;

@Service
public class GraficaVarHistoricoService {

	@Autowired
	private GraficaVarHistoricoRepository graficaRepository;

	@Transactional
	public void deleteByFecha(String fecha) {
		graficaRepository.deleteByFecha(fecha);
	}

	void insertaGraficaVaRHistoricoP(Integer tpPercentil, Integer nuPercentil, Integer cdInstrumento, String ldFecha) {
		graficaRepository.insertaGraficaVaRHistoricoP(tpPercentil, nuPercentil, cdInstrumento, ldFecha);
	}

	void insertaGraficaVarHistoricoM(Integer tpPercentil, Integer nuPercentil, Integer cdMercado, String ldFecha) {
		graficaRepository.insertaGraficaVarHistoricoM(tpPercentil, nuPercentil, cdMercado, ldFecha);
	};

	public List<GraficaVarHistorico> getDataChart(String tpPercentil, String fecha) {
		return graficaRepository.selectGraficaForPortafolioGlobal(tpPercentil, fecha);
	}

	public List<GraficaVarHistorico> getDataChart(String tpPercentil, String cdMercado, String fecha) {
		return graficaRepository.selectGraficaDos(tpPercentil, cdMercado, fecha);
	}

	public List<GraficaVarHistorico> getDataChart(String tpPercentil, String cdMercado, String cdInstrumento,
			String fecha) {
		System.out.println("### DATA CHART_3 ::: ");
		System.out.println(tpPercentil);
		System.out.println(cdMercado);
		System.out.println(cdInstrumento);
		System.out.println(fecha);
		return graficaRepository.selectGraficaTres(tpPercentil, cdMercado, cdInstrumento, fecha);
	}

}
