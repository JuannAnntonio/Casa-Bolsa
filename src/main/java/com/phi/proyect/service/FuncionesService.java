package com.phi.proyect.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.phi.proyect.repository.FuncionesRepository;

@Service
@Transactional(readOnly = true)
public class FuncionesService {

	@Autowired
	private FuncionesRepository fr;

	public Date getfechaanterior(Date fecha, int dias) {
		return this.fr.getfechaanterior(fecha, dias);
	}

	public double ValFuDivisas(String CdTransaccion, int CdCurva, Date LdFecha, int CdIndice, int CdCurvaFor) {
		return this.fr.ValFuDivisas(CdTransaccion, CdCurva, LdFecha, CdIndice, CdCurvaFor);
	}

	public double ValFuIndices(String CdTransaccion, int CdCurva, Date LdFecha, int CdIndice) {
		return this.fr.ValFuIndices(CdTransaccion, CdCurva, LdFecha, CdIndice);
	}

	public double ValFuTasas(String CdTransaccion, int CdCurva, Date LdFecha) {
		return this.fr.ValFuTasas(CdTransaccion, CdCurva, LdFecha);
	}

	public double ValSwapStarting(String CdTransaccion, int CdCurva, Date LdFecha) {
		return this.fr.ValSwapStarting(CdTransaccion, CdCurva, LdFecha);
	}

	public Double ValSwapTiie(String CdTransaccion, int CdCurva, String LdFecham, int cdDescuento) {
		return getValue(this.fr.ValSwapTiie(CdTransaccion, CdCurva, LdFecham, cdDescuento));
	}

	public double VaRFuDivisas(String CdTransaccion, int CdCurva, Date LdFecha, int CdIndice, int CdCurvaFor) {
		return this.fr.VaRFuDivisas(CdTransaccion, CdCurva, LdFecha, CdIndice, CdCurvaFor);
	}

	public double VaRFuIndices(String CdTransaccion, int CdCurva, Date LdFecha, int CdIndice) {
		return this.fr.VaRFuIndices(CdTransaccion, CdCurva, LdFecha, CdIndice);
	}

	public double VaRFuTasas(String CdTransaccion, int CdCurva, Date LdFecha) {
		return this.fr.VaRFuTasas(CdTransaccion, CdCurva, LdFecha);
	}

	public double VarPPPPPPP(String CdTransaccion, int CdCurva, Date LdFecha) {
		return this.fr.VarPPPPPPP(CdTransaccion, CdCurva, LdFecha);
	}

	public Double VaRSwapTiie(String CdTransaccion, int CdCurva, String LdFecham, int cdDescuento, int NuPercentil) {
		return getValue(this.fr.VaRSwapTiie(CdTransaccion, CdCurva, LdFecham, cdDescuento, NuPercentil));
	}

	public Double VaLRxInstrumento(Integer cdInstrumento, Integer nuPercentil, Integer tipoDato) {
		return getValue(this.fr.VaLRxInstrumento(cdInstrumento, nuPercentil, tipoDato));
	}

	public Double VaRRevisables(String cdTransaccion, Integer cdSobretasa, Integer cdTMercado, String ldFecha,
			Integer nuPercentil) {
		return getValue(this.fr.VaRRevisables(cdTransaccion, cdSobretasa, cdTMercado, ldFecha, nuPercentil));
	}

	public Double ValRevisables(String cdTransaccion) {
		return getValue(this.fr.ValRevisables(cdTransaccion));
	}

	public Double VaRDeudaAmortizable(String cdTransaccion, Integer cdCurva, Integer cdSobretasa, String ldFecha,
			Integer nuPercentil) {
		return getValue(this.fr.VaRDeudaAmortizable(cdTransaccion, cdCurva, cdSobretasa, ldFecha, nuPercentil));
	}

	public Double ValDeudaAmortizable(String cdTransaccion, String fecha) {
		return getValue(this.fr.ValDeudaAmortizable(cdTransaccion, fecha));
	}

	public Double VarBonosM(String cdTransaccion, Integer cdCurva, String ldFecha, Integer nuPercentil) {
		return getValue(this.fr.VarBonosM(cdTransaccion, cdCurva, ldFecha, nuPercentil));
	}

	public Double ValBonosM(String cdTransaccion) {
		return getValue(this.fr.ValBonosM(cdTransaccion));
	}

	public Double VaRForward(String cdTransaccion, Integer cdCurvaLocal, Integer cdCurvaForanea, Integer cdTipoCambio,
			String fecha, Integer nuPercentil) {
		return getValue(
				this.fr.VaRForward(cdTransaccion, cdCurvaLocal, cdCurvaForanea, cdTipoCambio, fecha, nuPercentil));
	}

	public Double ValBondes(String cdTransaccion) {
		return getValue(this.fr.ValBondes(cdTransaccion));
	}

	public Double VaRBondes(String cdTransaccion, Integer cdSobretasa, Integer cdMercado, String fecha,
			Integer nuPercentil) {
		return getValue(this.fr.VaRBondes(cdTransaccion, cdSobretasa, cdMercado, fecha, nuPercentil));
	}

	public Double ValForward(String cdTransaccion, Integer cdCurvaLocal, Integer cdCurvaForanea, Integer cdTipoCambio,
			String fecha) {
		return getValue(this.fr.ValForward(cdTransaccion, cdCurvaLocal, cdCurvaForanea, cdTipoCambio, fecha));
	}

	public Double VaLRxMercado(Integer cdMercado, Integer nuPercentil, Integer tipoDato) {
		return getValue(this.fr.VaLRxMercado(cdMercado, nuPercentil, tipoDato));
	}

	/**
	 * AUX
	 */
	private Double getValue(Double value) {
		if (value == null) {
			value = new Double(0.0);
		}
		return value;
	}

}
