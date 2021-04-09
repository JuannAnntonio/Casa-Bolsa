package com.phi.proyect.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phi.proyect.models.CdMercado;
import com.phi.proyect.repository.CdMercadoRepository;

@Service
public class CdMercadoService {

	@Autowired
	private CdMercadoRepository mercadoRepository;

	public List<CdMercado> findAll() {
		List<CdMercado> lista = mercadoRepository.findAll();
		if (lista != null) {
			return lista;
		}
		return new ArrayList<>();
	}

	public CdMercado updateMercado(CdMercado mercado) {
		Optional<CdMercado> mercadoOption = mercadoRepository.findById(mercado.getIdMercado());
		mercadoOption.get().setLimite(mercado.getLimite());
		return mercadoRepository.save(mercadoOption.get());

	}

	public CdMercado deleteLogico(Integer idMercado) {
		Optional<CdMercado> instrumentoOption = mercadoRepository.findById(idMercado);
		instrumentoOption.get().setCdActivo(0);
		return mercadoRepository.save(instrumentoOption.get());
	}

	public CdMercado create(CdMercado mercado) {
		return this.mercadoRepository.save(mercado);
	}

}
