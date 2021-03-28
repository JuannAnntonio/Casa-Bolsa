package com.phi.proyect.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import com.phi.proyect.models.GraficaVarHistorico;

public interface GraficaVarHistoricoRepository extends JpaRepository<GraficaVarHistorico, String> {

	@Modifying
	@Query(value = "delete from grafica_var_historico where fh_date =:fecha", nativeQuery = true)
	void deleteByFecha(@Param("fecha") String fecha);

	@Procedure("InsertaGraficaVaRHistoricoP")
	void insertaGraficaVaRHistoricoP(Integer tpPercentil, Integer nuPercentil, Integer cdInstrumento, String ldFecha);

	@Procedure("InsertaGraficaVarHistoricoM")
	void insertaGraficaVarHistoricoM(Integer tpPercentil, Integer nuPercentil, Integer cdMercado, String ldFecha);

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

}
