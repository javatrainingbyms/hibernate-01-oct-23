package com.ms;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Customer {
	@Id
	private int code;
	private String name;
	private String address;
	private String city;
	private int age;
	@OneToOne//(fetch = FetchType.LAZY)
	private Card card;	//card_id
}
