package com.phi.proyect.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.phi.proyect.models.DeDivisas;

public interface DeDivisasRepository extends JpaRepository<DeDivisas, String> {

	@Query(value = "select * from de_divisas where cd_instrumento=:cdInstrumento", nativeQuery = true)
	List<DeDivisas> findDivisasVarFactory(@Param("cdInstrumento") Integer cdInstrumento);
	
	@Query(value = "Select count(1) FROM de_divisas", nativeQuery = true)//WHERE Fh_Date=:fecha
	Integer getNumRegistros();//@Param("fecha") String fecha
	
}