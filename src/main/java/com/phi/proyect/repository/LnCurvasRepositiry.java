package com.phi.proyect.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.phi.proyect.models.LnCurvas;

public interface LnCurvasRepositiry extends JpaRepository<LnCurvas, Integer> {

	@Query(value = "SELECT COUNT(1)FROM ln_curvas WHERE Fh_Date=:fecha", nativeQuery = true)
	Integer existsByDate(@Param("fecha") String fecha);
}
