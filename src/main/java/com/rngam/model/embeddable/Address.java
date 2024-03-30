package com.rngam.model.embeddable;


import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class Address {
	@Column(name = "cep", length = 8)
	Long CEP;
	@Column(name = "number", length = 5)
	Long number;
	@Column(name = "complement", length = 400)
	String complement;
}
