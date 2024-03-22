package com.rngam.model;



import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import lombok.Data;

@Entity
@Data
public class ContractModel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
	Date StartDate;
	
	@ManyToMany
	List<ClientModel> clientList;
}
