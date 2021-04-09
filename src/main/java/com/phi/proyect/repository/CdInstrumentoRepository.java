package com.phi.proyect.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.phi.proyect.models.CdInstrumento;
import com.phi.proyect.repository.projection.LimitesLineasProjectionEntity;

public interface CdInstrumentoRepository extends JpaRepository<CdInstrumento, Integer>{

	@Query(value="SELECT * FROM cd_instrumento where ID_Instrumento =:id limit 1", nativeQuery =  true)
	public List<CdInstrumento> findByFkIdInstrumento(@Param("id") int id);
	
	String SQL_LIMITES_VAR = "select ins.id_instrumento,\n" + 
			"    ins.nombre as producto, \n" + 
			"    mer.nu_limite as limiteGlobal,\n" + 
			"    ins.nu_limite_instrumento as limiteInstrumento, \n" + 
			"    ins.nu_limite_transaccion as limiteOperacion, \n" + 
			"    mer.nombre as mercado \n" + 
			"from cd_instrumento ins\n" + 
			"join cd_mercado mer\n" + 
			"    ON mer.id_mercado = ins.id_mercado\n" + 
			"where ins.cd_activo =1";

	@Query(value = SQL_LIMITES_VAR, nativeQuery = true)
	List<LimitesLineasProjectionEntity> findAllLimitesVar();
}
