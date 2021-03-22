package com.phi.proyect.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.phi.proyect.models.DatosVar;
import com.phi.proyect.repository.CalculoDeVarSwapRepository;
import com.phi.proyect.repository.projection.DatosVarProjectionEntity;

@Service
public class DatosVarService {

	@Autowired
	private CalculoDeVarSwapRepository cdvsr;

	@Transactional(readOnly = true)
	public List<DatosVar> findByCdInstrumento(String cdInstrumento, String fecha) {
		List<DatosVar> listCalculoDeVarSwap = cdvsr.findByCdInstrumento(cdInstrumento, fecha);
		if (listCalculoDeVarSwap == null || listCalculoDeVarSwap.isEmpty()) {
			return new ArrayList<>();
		}
		return listCalculoDeVarSwap;
	}

	@Transactional(readOnly = true)
	public DatosVar findPosicionGlobalByFecha(String fecha) {
		return cdvsr.findPosicionGlobalByFecha(fecha);
	}

	@Transactional(readOnly = true)
	public List<DatosVarProjectionEntity> findMercadosByFecha(String fecha) {
		List<DatosVarProjectionEntity> mercados = cdvsr.findByFechaMercados(fecha);
		if (mercados == null || mercados.isEmpty()) {
			return new ArrayList<>();
		}
		return mercados;
	}

	@Transactional(readOnly = true)
	public List<DatosVarProjectionEntity> findProductosByMercado(String idMercado, String fecha) {
		List<DatosVarProjectionEntity> productos = cdvsr.findProductosByMercado(idMercado, fecha);
		if (productos == null || productos.isEmpty()) {
			return new ArrayList<>();
		}
		return productos;
	}

	@Transactional(readOnly = true)
	public List<DatosVar> getTransacciones(String idMercado, String idInstrumento, String fecha) {
		List<DatosVar> productos = cdvsr.findTransaccionesByMercadoAndInstrumento(idMercado, idInstrumento, fecha);
		if (productos == null || productos.isEmpty()) {
			return new ArrayList<>();
		}
		return productos;
	}

}
