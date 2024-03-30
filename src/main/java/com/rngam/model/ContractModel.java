package com.rngam.model;



import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Entity
@Data
public class ContractModel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
	@ManyToMany
	List<ClientModel> clientList;
	@CreationTimestamp
	LocalDateTime creationDateTime;
	@UpdateTimestamp
	LocalDateTime updateDateTime;
	
	public void addClient(ClientModel client) {
		clientList.add(client);
	}
	
	
}
