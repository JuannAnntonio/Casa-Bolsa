package com.phi.proyect.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phi.proyect.repository.ValuacionHistoricoRepository;
import com.phi.proyect.repository.projection.ValuacionHistoricoProjectionEntity;

@Service
public class ValuacionHistoricoService {

	@Autowired
	private ValuacionHistoricoRepository valuacionRepository;
	@Autowired
	private MercadoDeDerivadosService mercadoService;

	public List<ValuacionHistoricoProjectionEntity> getDataValuacionHistorico() {
		List<ValuacionHistoricoProjectionEntity> result = valuacionRepository
				.getDataValuacionHistorico(mercadoService.findValueDate());
		if (result != null) {
			return result;
		}
		return new ArrayList<>();
	}

}
