package com.phi.proyect.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.phi.proyect.models.CdInstrumento;
import com.phi.proyect.repository.CdInstrumentoRepository;
import com.phi.proyect.repository.projection.LimitesLineasProjectionEntity;

@Service
@Transactional(readOnly = true)
public class VarLimiteService {

	@Autowired
	private CdInstrumentoRepository cdIntrumentoRepo;

	public List<LimitesLineasProjectionEntity> findAllLimitesVar() {
		return cdIntrumentoRepo.findAllLimitesVar();
	}

	@Transactional
	public CdInstrumento create(CdInstrumento instrumento) {
		return this.cdIntrumentoRepo.save(instrumento);

	}

	@Transactional
	public CdInstrumento updateInstrumento(CdInstrumento instrumento) {
		Optional<CdInstrumento> instrumentoOption = cdIntrumentoRepo.findById(instrumento.getIdInstrumento());
		instrumentoOption.get().setLimiteInstrumento(instrumento.getLimiteInstrumento());
		instrumentoOption.get().setLimiteTransaccion(instrumento.getLimiteTransaccion());
		return cdIntrumentoRepo.save(instrumentoOption.get());
	}

	@Transactional
	public CdInstrumento deleteLogico(Integer idInstrumento) {
		Optional<CdInstrumento> instrumentoOption = cdIntrumentoRepo.findById(idInstrumento);
		instrumentoOption.get().setCdActivo(0);
		return cdIntrumentoRepo.save(instrumentoOption.get());
	}

}
