package com.rngam.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rngam.model.TechnicianModel;
import com.rngam.repository.TechnicianRepository;

@Service
public class TechnicianService {
	
	@Autowired
	TechnicianRepository technicianRepository;
	
	public List<TechnicianModel> findTechnicianByName(String name){
		List<TechnicianModel> tecs = technicianRepository.findTechnicianByName(name);
		return tecs;
		
	}
	
	public Optional<TechnicianModel> findTechnicianById(Long id) {
		return  technicianRepository.findById(id);
	}
	
	public List< TechnicianModel> findAll(){
		List<TechnicianModel> list = technicianRepository.findAll();
		return list;
	}
	
	public TechnicianModel addTechnician(TechnicianModel technician) {
		TechnicianModel technicianToBeAdded = technicianRepository.save(technician);
		return technicianToBeAdded;
	}
	
	public void removeClient(Long id) {
		technicianRepository.deleteById(id);
	}
}
