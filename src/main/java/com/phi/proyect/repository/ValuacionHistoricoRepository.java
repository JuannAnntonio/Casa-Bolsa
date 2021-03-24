package com.phi.proyect.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;

import com.phi.proyect.models.DatosVarId;
import com.phi.proyect.models.ValuacionHistoricoVar;

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
}
