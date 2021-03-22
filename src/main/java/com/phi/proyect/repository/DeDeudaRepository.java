package com.phi.proyect.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.phi.proyect.models.DeDeuda;

public interface DeDeudaRepository extends JpaRepository<DeDeuda, String> {

	@Query(value = "select * from de_deuda where cd_instrumento=:cdInstrumento", nativeQuery = true)
	public List<DeDeuda> findByProcessVarFactory(@Param("cdInstrumento") Integer cdInstrumento);
}
