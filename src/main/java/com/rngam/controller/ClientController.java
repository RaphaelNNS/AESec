package com.rngam.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rngam.exceptions.EmptyClienteValue;
import com.rngam.model.Cliente;
import com.rngam.service.ClienteService;

@Controller
@RequestMapping(value = "/clients")
public class ClientController {
	
	@Autowired
	ClienteService clienteService;
	
	@GetMapping
	public ResponseEntity<Optional<List<Cliente>>> getAll(){
		Optional<List<Cliente>> list;
		try {
			list = clienteService.findAll();
			return ResponseEntity.ok(list);
			
		} catch (EmptyClienteValue e) {
			return ResponseEntity.notFound().build();
		}
	}
	
	@GetMapping("/client-name/{clientName}")
	public ResponseEntity<Optional<Cliente>> getClientByName(@PathVariable("clientName") String name){
		Optional<Cliente> client;
		try {
			client = clienteService.findClienteByName(name);
			return ResponseEntity.ok(client);
		} catch (EmptyClienteValue e) {
			return ResponseEntity.notFound().build();
		}
		
	}
	
	@PostMapping
	public ResponseEntity<?> addClient(@RequestBody Cliente client){
		Cliente cliente = clienteService.addClient(client);
		return ResponseEntity.status(HttpStatus.CREATED).body(cliente);
	}
	
	
	
}
