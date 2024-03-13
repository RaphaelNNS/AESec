package com.rngam.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rngam.exceptions.EmptyContratoValue;
import com.rngam.model.Contrato;
import com.rngam.repository.ContratoRepository;

@Service
public class ContratoService {
	
	@Autowired
	ContratoRepository repository;
	
	public Optional<Contrato> findContratoByName(String name) throws EmptyContratoValue {
		Optional<Contrato> contrato = repository.findContratoByNome(name);
		if (contrato.isPresent()) {
			return contrato;
		}
		throw new EmptyContratoValue();
	}
	
	public Optional<List<Contrato>> findAll() throws EmptyContratoValue{
		Optional<List<Contrato>> list = Optional.of(repository.findAll());
		if (list.isPresent()) {
			return list;
		}
		throw new EmptyContratoValue();
	}
	
	public Contrato addClient(Contrato contrato) {
		Contrato contract = repository.save(contrato);
		return contract;
	}
}
