package com.phi.proyect.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.phi.proyect.models.CdInstrumento;
import com.phi.proyect.repository.projection.LimitesLineasProjectionEntity;
import com.phi.proyect.service.VarLimiteService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/limitesVarMd")
public class LimitesVarMdController {

	private final VarLimiteService vls;

	public LimitesVarMdController(VarLimiteService vls) {
		super();
		this.vls = vls;
	}

	@GetMapping(value = "/findAllVar")
	public List<LimitesLineasProjectionEntity> listaVar() {
		return vls.findAllLimitesVar();
	}

	@PostMapping(consumes = "application/json")
	public ResponseEntity<CdInstrumento> createLimite(@RequestBody CdInstrumento instrumento) {
		return new ResponseEntity<>(this.vls.create(instrumento), HttpStatus.CREATED);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<CdInstrumento> updateLimite(@PathVariable("id") int id,
			@RequestBody CdInstrumento instrumento) {
		CdInstrumento instrumentoUpdate = vls.updateInstrumento(instrumento);
		if (instrumentoUpdate != null) {
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<CdInstrumento> delete(@PathVariable("id") Integer id) {
		CdInstrumento instrumentoUpdate = vls.deleteLogico(id);
		if (instrumentoUpdate != null) {
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
