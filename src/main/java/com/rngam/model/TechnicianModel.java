package com.rngam.model;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.rngam.model.embeddable.Address;

import lombok.Data;

@Entity
@Data
public class TechnicianModel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
	@Column(nullable = false)
	String name;
	@Embedded
	Address address;
}
