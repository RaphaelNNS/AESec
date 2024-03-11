package com.rngam.model;



import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Contrato {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
	Date creationDate;
	Date StartDate;
}
