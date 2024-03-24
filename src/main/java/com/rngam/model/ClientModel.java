package com.rngam.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
public class ClientModel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long clientId;
	@Column(nullable = true, length = 11, unique = true)
	String CPF;
	@Column(nullable = true, length = 14, unique = true)
	String CNPJ;
	@Column(nullable = true, length = 128)
	String name;
	@Column(length = 400)
	String adress;
	
	@JsonIgnore
	@ManyToMany
	List<ContractModel> contractList;
}
