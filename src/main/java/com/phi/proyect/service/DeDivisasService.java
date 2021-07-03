package com.phi.proyect.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phi.proyect.models.DeDivisas;
import com.phi.proyect.repository.DeDivisasRepository;

@Service
public class DeDivisasService {

	@Autowired
	private DeDivisasRepository divisasRepository;

	public List<DeDivisas> findDivisasVarFactory(Integer cdInstrumento) {
		List<DeDivisas> deDivisas = divisasRepository.findDivisasVarFactory(cdInstrumento);
		if (deDivisas == null || deDivisas.isEmpty()) {
			return new ArrayList<>();
		}
		return deDivisas;
	}
}
