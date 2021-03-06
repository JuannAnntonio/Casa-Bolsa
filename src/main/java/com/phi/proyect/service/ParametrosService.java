package com.phi.proyect.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.phi.proyect.models.Parametros;
import com.phi.proyect.repository.ParametrosRepository;

@Service
@Transactional(readOnly = true)
public class ParametrosService  {
	
	@Autowired
	private ParametrosRepository pr;
	
	public List<Parametros>findParametro(String descripcion) {
		return this.pr.findParametro(descripcion);
	}
	
	

}
