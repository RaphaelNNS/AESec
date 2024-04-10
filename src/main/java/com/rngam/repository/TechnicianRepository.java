package com.rngam.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rngam.model.TechnicianModel;

public interface TechnicianRepository extends JpaRepository<TechnicianModel, Long>  {
	
	public List<TechnicianModel> findTechnicianByName(String name);
}
