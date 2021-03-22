package com.phi.proyect.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phi.proyect.models.DeDeuda;
import com.phi.proyect.repository.DeDeudaRepository;

@Service
public class DeDeudaService {

	@Autowired
	private DeDeudaRepository deDeudaRepository;

	public List<DeDeuda> findBpagProcessVarFactory() {
		List<DeDeuda> deDeudas = deDeudaRepository.findByProcessVarFactory(22);
		if (deDeudas == null || deDeudas.isEmpty()) {
			return new ArrayList<>();
		}
		return deDeudas;
	}

	public List<DeDeuda> findBonosCorporativosProcessVarFactory() {
		List<DeDeuda> deDeudas = deDeudaRepository.findByProcessVarFactory(30);
		if (deDeudas == null || deDeudas.isEmpty()) {
			return new ArrayList<>();
		}
		return deDeudas;
	}

	public List<DeDeuda> findBondesD() {
		List<DeDeuda> deDeudas = deDeudaRepository.findByProcessVarFactory(21);
		if (deDeudas == null || deDeudas.isEmpty()) {
			return new ArrayList<>();
		}
		return deDeudas;
	}
}
