package com.phi.proyect.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import com.phi.proyect.models.GraficaVarHistorico;
import com.phi.proyect.repository.projection.GraficaVarHistoricoProjection;

public interface GraficaVarHistoricoRepository extends JpaRepository<GraficaVarHistorico, String> {

	@Modifying
	@Query(value = "delete from grafica_var_historico where fh_date=:fecha", nativeQuery = true)
	void deleteByFecha(@Param("fecha") String fecha);
	
	@Procedure("InsertaGraficaVarHistoricoM")
	void insertaGraficaVarHistoricoM(Integer tpPercentil, Integer nuPercentil, Integer cdMercado, String ldFecha);
	
	@Procedure("InsertaGraficaVaRHistoricoP")
	void insertaGraficaVaRHistoricoP(Integer tpPercentil, Integer nuPercentil, Integer cdInstrumento, String ldFecha);	

	@Query(value = "select * from grafica_var_historico where tp_grafica=1 and tp_percentil=:tpPercentil and fh_date =:fecha", nativeQuery = true)
	List<GraficaVarHistorico> selectGraficaForPortafolioGlobal(@Param("tpPercentil") String tpPercentil,
			@Param("fecha") String fecha);

	@Query(value = "select * from grafica_var_historico where tp_grafica=2 and tp_percentil=:tpPercentil and cd_mercado=:cdMercado and fh_date=:fecha", nativeQuery = true)
	List<GraficaVarHistorico> selectGraficaDos(@Param("tpPercentil") String tpPercentil,
			@Param("cdMercado") String cdMercado, @Param("fecha") String fecha);

	@Query(value = "select * from grafica_var_historico where tp_grafica=3 and tp_percentil=:tpPercentil and cd_mercado=:cdMercado and cd_instrumento=:cdInstrumento and fh_date=:fecha", nativeQuery = true)
	List<GraficaVarHistorico> selectGraficaTres(@Param("tpPercentil") String tpPercentil,
			@Param("cdMercado") String cdMercado, @Param("cdInstrumento") String cdInstrumento,
			@Param("fecha") String fecha);

	@Query(value = "select merc.Nombre as mercado, \n" +
			"			(SELECT nu_limite FROM cd_mercado WHERE id_mercado=1)  as limite, \n" + 
			"			inst.Nombre as instrumento, chart.* \n" + 
			"		from grafica_var_historico chart \n" + 
			"		join cd_mercado merc \n" + 
			"			on merc.ID_Mercado = chart.cd_mercado \n" + 
			"		join cd_instrumento inst \n" + 
			"           on inst.ID_Instrumento = chart.cd_instrumento \n" + 
			"           and chart.tp_percentil=1 \n" + 
			"           and chart.tp_grafica=1", nativeQuery = true)
	List<GraficaVarHistoricoProjection> getDataChartForDate();

}
