package com.phi.proyect.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.phi.proyect.models.FlujosDeuda;
import com.phi.proyect.models.PrimaryKeyFlujosDeuda;

public interface FlujosDeudaRepository extends JpaRepository<FlujosDeuda, PrimaryKeyFlujosDeuda> {

}
