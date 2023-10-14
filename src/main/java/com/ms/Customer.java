package com.ms;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
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
	//@Column(name = "code")
	private int code;
	//@ Column(name="name", length = 100, nullable = false, unique = true)
	private String name;
	private String address;
	private String city;
	private int age;
	@OneToOne//(fetch = FetchType.LAZY)
	private Card card;	//card_id
	@OneToMany(mappedBy = "customer")	//avoid the additional table customer_giftcard
	private List<GiftCard> giftCards;
	public Customer(int code, String name, String address, String city, int age, Card card) {
		super();
		this.code = code;
		this.name = name;
		this.address = address;
		this.city = city;
		this.age = age;
		this.card = card;
	}
	
}
