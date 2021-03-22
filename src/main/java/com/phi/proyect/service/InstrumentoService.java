package com.phi.proyect.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phi.proyect.models.CdInstrumento;
import com.phi.proyect.repository.CdInstrumentoRepository;

@Service
public class InstrumentoService {

	@Autowired
	private CdInstrumentoRepository cdIntrumentoRepo;

	public List<CdInstrumento> getAllInstrumentos() {
		List<CdInstrumento> instrumentos = cdIntrumentoRepo.findAll();
		if (null == instrumentos || instrumentos.isEmpty()) {
			return new ArrayList<>();
		}
		return cdIntrumentoRepo.findAll();
	}

}
