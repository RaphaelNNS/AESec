package com.rngam.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rngam.model.ContractModel;

@Repository
public interface ContractRepository extends JpaRepository<ContractModel, Long> {
	
	
 
}
