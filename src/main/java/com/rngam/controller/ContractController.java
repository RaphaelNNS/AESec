package com.rngam.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rngam.exceptions.EmptyContratoValue;
import com.rngam.model.Contrato;
import com.rngam.service.ContratoService;

@Controller
@RequestMapping
public class ContractController {
	
	@Autowired
	ContratoService contratoService;
	
	@GetMapping
	public ResponseEntity<?> getAll(){
		try {
			return ResponseEntity.ok(contratoService.findAll());
		} catch (EmptyContratoValue e) {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping()
	public ResponseEntity<?> addContrato(@RequestBody Contrato contrato){
		Contrato AddedContrato = contratoService.addClient(contrato);
		return ResponseEntity.status(HttpStatus.CREATED).body(AddedContrato);
	}
}