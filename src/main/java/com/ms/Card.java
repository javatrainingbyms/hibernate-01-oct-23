package com.ms;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Card {
	@Id
	private int id;
	private String cno;
	private String type;
	@OneToOne ( fetch = FetchType.LAZY, mappedBy="card")
	private Customer customer;	
	public Card(int id) {
		super();
		this.id = id;
	}
	public Card(int id, String cno, String type) {
		super();
		this.id = id;
		this.cno = cno;
		this.type = type;
	}
	
}
