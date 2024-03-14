package com.rngam.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long clientId;
	@Column(nullable = true, length = 11, unique = true)
	String CPF;
	@Column(nullable = true, length = 14, unique = true)
	String CNPJ;
	@Column(nullable = true, length = 128)
	String nome;
	@Column(length = 400)
	String endereco;
}
