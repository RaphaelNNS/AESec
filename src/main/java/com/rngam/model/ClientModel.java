package com.rngam.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rngam.model.embeddable.Address;

import lombok.Data;

@Data
@Entity

public class ClientModel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long clientId;
	@Column(name = "cpf", nullable = true, length = 11, unique = true)
	String CPF;
	@Column(name = "cnpj", nullable = true, length = 14, unique = true)
	String CNPJ;
	@Column(name = "name", nullable = true, length = 128)
	String name;
	
	@JsonIgnore
	@ManyToMany
	List<ContractModel> contractList;
	
	@Embedded
	Address address;
}
