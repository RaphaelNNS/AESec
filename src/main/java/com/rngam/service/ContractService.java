package com.rngam.service;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rngam.model.ClientModel;
import com.rngam.model.ContractModel;
import com.rngam.repository.ClientRepository;
import com.rngam.repository.ContractRepository;

@Service
public class ContractService {
	
	@Autowired
	ContractRepository repository;
	@Autowired
	ClientRepository clientRepository;
	
	
	
	public List<ContractModel> findAll(){
		List<ContractModel> list = repository.findAll();
		return list;
	}
	
	public ContractModel addContract(ContractModel contract) {
		Calendar calendar = Calendar.getInstance();
		contract.setStartDate(calendar.getTime());
		ContractModel contractToBeAdded = repository.save(contract);
		return contractToBeAdded;
	}
	
	
	public void removeContractByID(Long id) {
		ContractModel contractToBeRemoved = repository.getOne(id);
		repository.delete(contractToBeRemoved);
		
	}
	
	
	public ContractModel updateList(Long contractId, List<ClientModel> clientList) {
		ContractModel contractUpdated = repository.getOne(contractId);
		contractUpdated.setClientList(clientList);
		return contractUpdated;
	}
}
