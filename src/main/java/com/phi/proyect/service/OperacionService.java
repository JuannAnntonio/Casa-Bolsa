package com.phi.proyect.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.phi.proyect.models.OperacionesMd;
import com.phi.proyect.repository.OperacionRepository;

/*En los servicios se implementa el crud de las tablas*/

@Service
@Transactional(readOnly = true)
public class OperacionService {

    @Autowired
    private OperacionRepository operacionRepository;

    public List<OperacionesMd> findAll(){
    	return operacionRepository.findAll();
    }
    
	public List<OperacionesMd> find(String contraparte){
		return this.operacionRepository.find(contraparte);
	}
	
	public List<OperacionesMd> find2(String contraparte){
		return this.operacionRepository.find2(contraparte);
	}
	
	public List<OperacionesMd> findStatus(){
		return this.operacionRepository.findStatus();
	}
}
