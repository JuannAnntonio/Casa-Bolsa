package com.phi.proyect.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.phi.proyect.models.DatosVar;
import com.phi.proyect.models.DatosVarId;
import com.phi.proyect.repository.projection.DatosVarProjectionEntity;
import com.phi.proyect.repository.projection.PosicionGlobalProjectionEntity;

@Repository
public interface CalculoDeVarSwapRepository extends JpaRepository<DatosVar, DatosVarId> {

	@Modifying
	@Query(value = "INSERT INTO datos_var (cd_instrumento,fecha,var1,var2,var3) VALUES( :cd, :fecha, :var1, :var2, :var3)", nativeQuery = true)
	int saveDeVarSwap(@Param("cd") Integer cd, @Param("fecha") String fecha, @Param("var1") Double valor,
			@Param("var2") Double var2, @Param("var3") Double var3);
	
	@Modifying
	@Query(value = "INSERT INTO datos_var (cd_mercado,cd_instrumento,cd_transaccion,cd_usuario,fecha,var1,var2,var3,valuacion)"
			+ " VALUES(:cdMercado,:cdInstrumento,:cdTransaccion,:cdUsuario,:fecha,:var1,:var2,:var3,:valuacion)", nativeQuery = true)
	Integer saveDatosVar(@Param("cdMercado") Integer cdMercado, 
			@Param("cdInstrumento") Integer cdInstrumento,
			@Param("cdTransaccion") String cdTransaccion,
			@Param("cdUsuario") String cdUsuario,
			@Param("fecha") String fecha, 
			@Param("var1") Double var1,
			@Param("var2") Double var2, 
			@Param("var3") Double var3,
			@Param("valuacion") Double valuacion);

	
	@Query(value = "select * from datos_var WHERE cd_instrumento =:cdInstrumento AND fecha = :fecha", nativeQuery = true)
	public List<DatosVar> findByCdInstrumento(@Param("cdInstrumento") String cdInstrumento,
			@Param("fecha") String fecha);

	@Query(value = "select * from datos_var WHERE fecha =:fecha", nativeQuery = true)
	public List<DatosVar> findByFecha(@Param("fecha") String fecha);

	@Modifying
	@Transactional
	@Query(value = "SET SQL_SAFE_UPDATES = 0", nativeQuery = true)
	void setSafeMode();

	@Query(value = "SELECT COUNT(1)FROM datos_var WHERE fecha=:fecha", nativeQuery = true)
	Integer existsByDate(@Param("fecha") String fecha);
	
	@Modifying
	@Query(value = "delete from datos_var where fecha =:fecha", nativeQuery = true)
	void deleteUltimo(@Param("fecha") String fecha);

	String SQL_POS_GLOBAL = "SELECT datv.var1,datv.var2,datv.var3,datv.valuacion, mer.nu_limite\n" + 
			"FROM datos_var datv\n" + 
			"    JOIN cd_mercado mer ON mer.ID_Mercado = datv.cd_mercado\n" + 
			"WHERE mer.cd_activo = 1 and datv.cd_mercado=1 and datv.fecha =:fecha";

	@Query(value = SQL_POS_GLOBAL, nativeQuery = true)
	PosicionGlobalProjectionEntity findPosicionGlobalByFecha(@Param("fecha") String fecha);

	String SQL_MERCADOS_VAR = "SELECT mer.nombre,mer.nu_limite as limite, datv.* FROM datos_var datv \n"
			+ "JOIN cd_mercado mer ON mer.ID_Mercado = datv.cd_mercado\n" + "WHERE datv.cd_instrumento=0 \n"
			+ "    and datv.cd_mercado<>1\n" + " and datv.fecha =:fecha";

	@Query(value = SQL_MERCADOS_VAR, nativeQuery = true)
	List<DatosVarProjectionEntity> findByFechaMercados(@Param("fecha") String fecha);

	String SQL_PRODUCTOS_VAR = "SELECT dvar.*, inst.nombre,inst.nu_limite_instrumento as limite \n" + 
			"FROM datos_var dvar\n" + 
			"JOIN cd_instrumento inst \n" + 
			"    ON inst.ID_Instrumento = dvar.cd_instrumento\n" + 
			"WHERE inst.cd_activo=1 \n" + 
			"    and dvar.cd_transaccion='Portafolio'\n" + 
			"    and dvar.cd_instrumento!=0  \n"
			+ "    and dvar.cd_mercado=:idMercado \n" + "    and dvar.fecha =:fecha";

	@Query(value = SQL_PRODUCTOS_VAR, nativeQuery = true)
	List<DatosVarProjectionEntity> findProductosByMercado(@Param("idMercado") String idMercado,
			@Param("fecha") String fecha);
	
	
	String SQL_TRANSACCIONES_VAR = "SELECT dvar.*, inst.nombre,inst.nu_limite_transaccion as limite \n" + 
			"FROM datos_var dvar\n" + 
			"JOIN cd_instrumento inst \n" + 
			"    ON inst.ID_Instrumento = dvar.cd_instrumento\n" + 
			"WHERE dvar.cd_transaccion!='Portafolio' \n" + 
			"    and dvar.cd_mercado=:idMercado\n" + 
			"    and dvar.cd_instrumento=:idInstrumento \n" +
			"    and dvar.fecha =:fecha";

	@Query(value = SQL_TRANSACCIONES_VAR, nativeQuery = true)
	List<DatosVarProjectionEntity> findTransaccionesByMercadoAndInstrumento(@Param("idMercado") String idMercado,@Param("idInstrumento") String idInstrumento,
			@Param("fecha") String fecha);

}
