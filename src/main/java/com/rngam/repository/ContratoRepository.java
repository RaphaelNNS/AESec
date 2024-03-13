package com.rngam.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rngam.model.Contrato;

@Repository
public interface ContratoRepository extends JpaRepository<Contrato, Long> {
	
	
	public Optional<Contrato> findContratoByNome(String name);

}
