package com.phi.proyect.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

import com.phi.proyect.models.CdMercado;
import com.phi.proyect.service.CdMercadoService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/limitesMercado")
public class LimitesMercadoController {

	private static final Logger log = LoggerFactory.getLogger(LimitesMercadoController.class);

	@Autowired
	private CdMercadoService mercadoService;

	@GetMapping(value = "/findAll")
	public List<CdMercado> findAll() {
		log.info("### ENTRO -> /findAll");
		List<CdMercado> lista = mercadoService.findAll();
		if (lista != null) {
			return lista;
		}
		return new ArrayList<>();
	}

	@PostMapping(consumes = "application/json")
	public ResponseEntity<CdMercado> createLimite(@RequestBody CdMercado mercado) {
		return new ResponseEntity<>(mercadoService.create(mercado), HttpStatus.CREATED);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<CdMercado> updateLimite(@PathVariable("id") String idMercado,
			@RequestBody CdMercado mercado) {

		CdMercado mercadoUpdate = mercadoService.updateMercado(mercado);
		if (mercadoUpdate != null) {
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<CdMercado> delete(@PathVariable("id") Integer idMercado) {
		CdMercado instrumentoUpdate = mercadoService.deleteLogico(idMercado);
		if (instrumentoUpdate != null) {
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
