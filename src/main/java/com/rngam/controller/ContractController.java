package com.rngam.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rngam.model.ContractModel;
import com.rngam.service.ClientService;
import com.rngam.service.ContractService;

@Controller
@RequestMapping("contracts")
public class ContractController {
	
	@Autowired
	ContractService contractService;
	@Autowired
	ClientService  clientService;
	
	@GetMapping
	public ResponseEntity<?> getAll(){
		return ResponseEntity.ok(contractService.findAll());
	}
	
	@GetMapping("/{clientId}")
	public ResponseEntity<?> findContractById(@PathVariable("clientId") Long id){
		Optional<ContractModel> contract =  contractService.findContractById(id);
		if (contract.isPresent()) {
			return ResponseEntity.ok(contract);
		}
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public ResponseEntity<?> addContrato(@RequestBody ContractModel contract){
		Optional<ContractModel> addedContract = Optional.of(contractService.addContract(contract));
		if (addedContract.isPresent()) {
			return ResponseEntity.ok(contract);
		}
		return ResponseEntity.status(HttpStatus.CONFLICT).build();
	}
	
	@DeleteMapping("/{contractId}")
	public ResponseEntity<?> removeContrato(@PathVariable("contractId") Long id){
		contractService.removeContractByID(id);
		return ResponseEntity.noContent().build();
	}
	
	//TODO 
	@PostMapping("/add-client-to-contract/{contractId}/{clientId}")
	public ResponseEntity<?> addClientToContract(@PathVariable("contractId")Long contractId, @PathVariable("clientId") Long clientId){
		ContractModel contract = contractService.addClientToContract(contractId, clientId);
		return ResponseEntity.ok(contract);
	}
}