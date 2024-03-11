package com.rngam.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rngam.exceptions.EmptyClienteValue;
import com.rngam.model.Cliente;
import com.rngam.repository.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	ClienteRepository repository;
	
	public Optional<Cliente> findClienteByName(String name) throws EmptyClienteValue {
		Optional<Cliente> cliente = repository.findClienteByNome(name);
		if (cliente.isPresent()) {
			return cliente;
		}
		throw new EmptyClienteValue();
	}
	
	public Optional<List<Cliente>> findAll() throws EmptyClienteValue{
		Optional<List<Cliente>> list = Optional.of(repository.findAll());
		if (list.isPresent()) {
			return list;
		}
		throw new EmptyClienteValue();
	}
	
	public Cliente addClient(Cliente cliente) {
		Cliente client = repository.save(cliente);
		return client;
	}
	
}
