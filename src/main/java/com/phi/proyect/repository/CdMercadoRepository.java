package com.phi.proyect.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.phi.proyect.models.CdMercado;

public interface CdMercadoRepository extends JpaRepository<CdMercado, Integer> {

	@Query(value = "SELECT * FROM cd_mercado where cd_activo=1", nativeQuery = true)
	public List<CdMercado> findAll();

}
