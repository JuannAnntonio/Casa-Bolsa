package com.phi.proyect.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import com.phi.proyect.models.DatosVarId;
import com.phi.proyect.models.ValuacionHistoricoVar;
import com.phi.proyect.repository.projection.ValuacionHistoricoProjectionEntity;

public interface ValuacionHistoricoRepository extends JpaRepository<ValuacionHistoricoVar, DatosVarId> {

	@Procedure("Insertaswap_uno")
	void insertaSwapUno(String cdTransaccion, Integer cdCurva, String ldFecha);
	
	@Procedure("Insertaswap_dos")
	void insertaSwapDos(Integer cdCurva, String ldFecha);
	
	@Procedure("Insertaswap_tres")
	void insertaSwapTres(Integer cdDescuento, String ldFecha);
	
	@Procedure("InsertaSwap_cuatro")
	void insertaSwapCuatro(Integer cdCurva, String ldFecha);
	
	@Procedure("InsertaSwap_cinco")
	void insertaSwapCinco(Integer cdDescuento, String ldFecha);
	
	@Procedure("InsertaValSwap")
	void insertaValSwap();
	
	@Procedure("InsertaValRevisables")
	void insertaValRevisables(String cdTransaccion, Integer cdCurva, Integer cdSobretasa, String ldFecha);

	@Procedure("InsertaValRForward")
	void insertaValRForward(String cdTransaccion, Integer cdCurvaLocal, Integer CdCurvaForanea, Integer cdTipoCambio,
			String ldFecha);

	@Procedure("InsertaValBondes")
	void insertaValBondes(String cdTransaccion, Integer cdSobretasa, Integer cdMercado, String ldFecha);

	@Procedure("InsertaValDeudaAmortizable")
	void insertaValDeudaAmortizable(String cdTransaccion, Integer cdCurva, Integer cdSobretasa, String ldFecha);

	@Procedure("InsertaBonosM")
	void insertaBonosM(String cdTransaccion, Integer cdCurva, String ldFecha);
	
	
	@Query(value = "select merc.Nombre as mercado, inst.Nombre as instrumento, hist.* \n" + 
			"from valuacion_historico_var hist \n" + 
			"join cd_mercado merc \n" + 
			"	on merc.ID_Mercado = hist.cd_mercado \n" + 
			"join cd_instrumento inst \n" + 
			"	on inst.ID_Instrumento = hist.cd_instrumento \n" + 
			"where hist.fh_date=:fecha", nativeQuery = true)
	List<ValuacionHistoricoProjectionEntity> getDataValuacionHistorico(@Param("fecha") String fecha);
}
