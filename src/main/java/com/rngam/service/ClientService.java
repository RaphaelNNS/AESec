package com.rngam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rngam.model.ClientModel;
import com.rngam.repository.ClientRepository;

@Service
public class ClientService {
	
	@Autowired
	ClientRepository repository;
	
	public List<ClientModel> findClientByName(String name){
		List<ClientModel> clients = repository.findClienteByName(name);
		return clients;
		
	}
	
	public List<ClientModel> findAll(){
		List<ClientModel> list = repository.findAll();
		return list;
	}
	
	public ClientModel addClient(ClientModel client) {
		ClientModel clientToBeAdded = repository.save(client);
		return clientToBeAdded;
	}
	
	public void removeClient(Long id) {
		repository.deleteById(id);
	}
	

	
}
