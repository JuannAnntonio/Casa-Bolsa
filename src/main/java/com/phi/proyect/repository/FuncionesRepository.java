package com.phi.proyect.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.phi.proyect.models.Divisas;

public interface FuncionesRepository extends JpaRepository<Divisas, String> {

	@Query(value = "SELECT getfechaanterior(:fecha,:dias);", nativeQuery = true)
	public Date getfechaanterior(@Param("fecha") Date fecha, @Param("dias") int dias);

	@Query(value = "SELECT ValFuDivisas(:CdTransaccion,:CdCurva,:LdFecha,:CdIndice,:CdCurvaFor);", nativeQuery = true)
	public double ValFuDivisas(@Param("CdTransaccion") String CdTransaccion, @Param("CdCurva") int CdCurva,
			@Param("LdFecha") Date LdFecha, @Param("CdIndice") int CdIndice, @Param("CdCurvaFor") int CdCurvaFor);

	@Query(value = "SELECT ValFuIndices(:CdTransaccion,:CdCurva,:LdFecha,:CdIndice);", nativeQuery = true)
	public double ValFuIndices(@Param("CdTransaccion") String CdTransaccion, @Param("CdCurva") int CdCurva,
			@Param("LdFecha") Date LdFecha, @Param("CdIndice") int CdIndice);

	@Query(value = "SELECT ValFuTasas(:CdTransaccion,:CdCurva,:LdFecha);", nativeQuery = true)
	public double ValFuTasas(@Param("CdTransaccion") String CdTransaccion, @Param("CdCurva") int CdCurva,
			@Param("LdFecha") Date LdFecha);

	@Query(value = "SELECT ValSwapStarting(:CdTransaccion,:CdCurva,:LdFecha);", nativeQuery = true)
	public double ValSwapStarting(@Param("CdTransaccion") String CdTransaccion, @Param("CdCurva") int CdCurva,
			@Param("LdFecha") Date LdFecha);

	@Query(value = "SELECT ValSwapTiie(:CdTransaccion,:CdCurva,:LdFecha,:CdDescuento);", nativeQuery = true)
	public Double ValSwapTiie(@Param("CdTransaccion") String CdTransaccion, @Param("CdCurva") int CdCurva,
			@Param("LdFecha") String LdFecha, @Param("CdDescuento") int CdDescuento);

	@Query(value = "SELECT VaRFuDivisas(:CdTransaccion,:CdCurva,:LdFecha,:CdIndice,:CdCurvaFor);", nativeQuery = true)
	public double VaRFuDivisas(@Param("CdTransaccion") String CdTransaccion, @Param("CdCurva") int CdCurva,
			@Param("LdFecha") Date LdFecha, @Param("CdIndice") int CdIndice, @Param("CdCurvaFor") int CdCurvaFor);

	@Query(value = "SELECT VaRFuIndices(:CdTransaccion,:CdCurva,:LdFecha,:CdIndice);", nativeQuery = true)
	public double VaRFuIndices(@Param("CdTransaccion") String CdTransaccion, @Param("CdCurva") int CdCurva,
			@Param("LdFecha") Date LdFecha, @Param("CdIndice") int CdIndice);

	@Query(value = "SELECT VaRFuTasas(:CdTransaccion,:CdCurva,:LdFecha);", nativeQuery = true)
	public double VaRFuTasas(@Param("CdTransaccion") String CdTransaccion, @Param("CdCurva") int CdCurva,
			@Param("LdFecha") Date LdFecha);

	@Query(value = "SELECT VarPPPPPPP(:CdTransaccion,:CdCurva,:LdFecha);", nativeQuery = true)
	public double VarPPPPPPP(@Param("CdTransaccion") String CdTransaccion, @Param("CdCurva") int CdCurva,
			@Param("LdFecha") Date LdFecha);

	@Query(value = "SELECT VarSwapTiie(:cdtransaccion,:cdcurva,:ldfecha,:cddescuento,:nupercentil);", nativeQuery = true)
	public Double VaRSwapTiie(@Param("cdtransaccion") String cdtransaccion, @Param("cdcurva") int cdcurva,
			@Param("ldfecha") String ldfecha, @Param("cddescuento") int cddescuento,
			@Param("nupercentil") int nupercentil);

	// Portafolio
	@Query(value = "SELECT VaLRxInstrumento(:cdInstrumento,:nuPercentil,:tipoDato)", nativeQuery = true)
	public Double VaLRxInstrumento(@Param("cdInstrumento") Integer cdInstrumento,
			@Param("nuPercentil") Integer nuPercentil, @Param("tipoDato") Integer tipoDato);

	// Bpag
	@Query(value = "SELECT VaRRevisables(:cdTransaccion,:cdSobretasa,:cdTMercado,:ldFecha,:nuPercentil)", nativeQuery = true)
	public Double VaRRevisables(@Param("cdTransaccion") String cdTransaccion, @Param("cdSobretasa") Integer cdSobretasa,
			@Param("cdTMercado") Integer cdTMercado, @Param("ldFecha") String ldFecha,
			@Param("nuPercentil") Integer nuPercentil);

	@Query(value = "SELECT ValRevisables(:cdTransaccion)", nativeQuery = true)
	public Double ValRevisables(@Param("cdTransaccion") String cdTransaccion);

	
	//DeudaAmortizable
	@Query(value = "SELECT VaRDeudaAmortizable(:cdTransaccion,:cdCurva,:cdSobretasa,:ldFecha,:nuPercentil)", nativeQuery = true)
	public Double VaRDeudaAmortizable(
			@Param("cdTransaccion") String cdTransaccion,
			@Param("cdCurva") Integer cdCurva,
			@Param("cdSobretasa") Integer cdSobretasa,
			@Param("ldFecha") String ldFecha,
			@Param("nuPercentil") Integer nuPercentil);

	@Query(value = "SELECT ValDeudaAmortizable(:cdTransaccion,:fecha)", nativeQuery = true)
	public Double ValDeudaAmortizable(@Param("cdTransaccion") String cdTransaccion, @Param("fecha") String fecha);
	
	//BonosM
	@Query(value = "SELECT VarBonosM(:cdTransaccion,:cdCurva,:ldFecha,:nuPercentil)", nativeQuery = true)
	public Double VarBonosM(
			@Param("cdTransaccion") String cdTransaccion,
			@Param("cdCurva") Integer cdCurva,
			@Param("ldFecha") String ldFecha,
			@Param("nuPercentil") Integer nuPercentil);

	@Query(value = "SELECT ValBonosM(:cdTransaccion)", nativeQuery = true)
	public Double ValBonosM(@Param("cdTransaccion") String cdTransaccion);
	
	//Forward
	@Query(value = "SELECT ValForward(:cdTransaccion,:cdCurvaLocal,:cdCurvaForanea,:cdTipoCambio,:fecha)", nativeQuery = true)
	public Double ValForward(
			@Param("cdTransaccion") String cdTransaccion,
			@Param("cdCurvaLocal") Integer cdCurvaLocal,
			@Param("cdCurvaForanea") Integer cdCurvaForanea,
			@Param("cdTipoCambio") Integer cdTipoCambio,
			@Param("fecha") String fecha);

	@Query(value = "SELECT VaRForward(:cdTransaccion,:cdCurvaLocal,:cdCurvaForanea,:cdTipoCambio,:fecha,:nuPercentil)", nativeQuery = true)
	public Double VaRForward(
			@Param("cdTransaccion") String cdTransaccion,
			@Param("cdCurvaLocal") Integer cdCurvaLocal,
			@Param("cdCurvaForanea") Integer cdCurvaForanea,
			@Param("cdTipoCambio") Integer cdTipoCambio,
			@Param("fecha") String fecha,
			@Param("nuPercentil") Integer nuPercentil);
	
	//Bondes D
	@Query(value = "SELECT ValBondes(:cdTransaccion)", nativeQuery = true)
	public Double ValBondes(
			@Param("cdTransaccion") String cdTransaccion);

	@Query(value = "SELECT VaRBondes(:cdTransaccion,:cdSobretasa,:cdMercado,:fecha,:nuPercentil)", nativeQuery = true)
	public Double VaRBondes(
			@Param("cdTransaccion") String cdTransaccion,
			@Param("cdSobretasa") Integer cdSobretasa,
			@Param("cdMercado") Integer cdMercado,
			@Param("fecha") String fecha,
			@Param("nuPercentil") Integer nuPercentil);
	
	
	//Mercados
	@Query(value = "SELECT VaLRxMercado(:cdMercado,:nuPercentil,:tipoDato)", nativeQuery = true)
	public Double VaLRxMercado(
			@Param("cdMercado") Integer cdMercado,
			@Param("nuPercentil") Integer nuPercentil,
			@Param("tipoDato") Integer tipoDato);
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
