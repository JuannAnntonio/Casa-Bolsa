package com.phi.proyect.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.phi.proyect.models.FlujosSwap;
import com.phi.proyect.models.PrimaryKeyFlujosSwaps;

public interface FlujosSwapRepository extends JpaRepository<FlujosSwap, PrimaryKeyFlujosSwaps> {

	@Query(value = "SELECT * FROM flujos_swap group by Cd_Transaccion;", nativeQuery = true)
	List<FlujosSwap> getRegistros();

	@Query(value = "Select count(1) FROM flujos_swap", nativeQuery = true)
	Integer getNumRegistros();

	@Query(value = "Select count(1) FROM flujos_swap where Cd_Transaccion =:id", nativeQuery = true)
	Integer getRegistros(@Param("id") String cdTransaccion);

	@Modifying
	@Query(value = "delete from flujos_swap where Cd_Transaccion =:cdTransaccion", nativeQuery = true)
	void deleteAllFlujos(@Param("cdTransaccion") String cdTransaccion);

	@Modifying
	@Transactional
	@Query(value = "SET SQL_SAFE_UPDATES = 0;", nativeQuery = true)
	void setSafeMode();

}
