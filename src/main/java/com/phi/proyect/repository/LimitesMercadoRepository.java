package com.phi.proyect.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.phi.proyect.models.LimitesMercado;

public interface LimitesMercadoRepository extends JpaRepository<LimitesMercado, Integer>{

	public List<LimitesMercado> findAll();
	
	public LimitesMercado findByMercado(String mercado);
}
