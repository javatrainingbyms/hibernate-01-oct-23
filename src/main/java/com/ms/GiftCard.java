package com.ms;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="gift_card")
public class GiftCard {
	@Id
	private int id;
	private String type;
	private double amount;
	
	@ManyToOne
	private Customer customer;	//gift_card	(customer_id)
}
