package com.rngam.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rngam.model.ClientModel;
import com.rngam.service.ClientService;

@Controller
@CrossOrigin("*")
@RequestMapping(value = "/clients")
public class ClientController {
	
	@Autowired
	ClientService clientService;
	
	@GetMapping
	public ResponseEntity<?> getAll(){
		List<ClientModel> list = clientService.findAll();
		return ResponseEntity.ok().body(list);
		
	}
	
	@GetMapping("/client-name/{clientName}")
	public ResponseEntity<?> getClientByName(@PathVariable("clientName") String name){
		Optional<List<ClientModel>> clientList = Optional.of(clientService.findClientByName(name));
		if (clientList.isPresent()) {
			return ResponseEntity.ok(clientList);
		}
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public ResponseEntity<?> addClient(@RequestBody ClientModel client){
		Optional<ClientModel> cliente = Optional.of(clientService.addClient(client));
		return ResponseEntity.status(HttpStatus.CREATED).body(cliente);
	}
	
	@DeleteMapping("/{clienteId}")
	public ResponseEntity<?> removeCliente(@PathVariable("clienteId") Long id){
		clientService.removeClient(id);
		return ResponseEntity.noContent().build();
	}
	
	
	
	
	
}
