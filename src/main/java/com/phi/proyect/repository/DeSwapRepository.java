package com.phi.proyect.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.phi.proyect.models.DeSwap;

public interface DeSwapRepository extends JpaRepository<DeSwap, Integer> {

	@Query(value = "SELECT count(1) FROM de_swap where Cd_Transaccion =:id", nativeQuery = true)
	Integer findByTransaccion(@Param("id") String id);

	@Query(value = "Select count(1) FROM de_swap", nativeQuery = true)
	Integer getNumRegistros();

	@Query(value = "select * from de_swap where Cd_Instrumento=:idInstrumento", nativeQuery = true)
	public List<DeSwap> findByInstrumento(@Param("idInstrumento") Integer id);

}
