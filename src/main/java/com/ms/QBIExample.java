package com.ms;

import java.util.List;

import org.hibernate.Session;

public class QBIExample {

	public static void main(String[] args) {
		//reading a record using its id
		
		Session session=Utility.getSessionFactory().openSession();
		Customer customer=session.get(Customer.class, 201);	//select column_names from customer where id=?
		System.out.println(customer.getCode());
		System.out.println(customer.getName());
		System.out.println(customer.getAddress());
		System.out.println(customer.getCity());
		Card card=customer.getCard();
		List<GiftCard> giftCards=customer.getGiftCards();
		for(GiftCard giftCard:giftCards) {
			System.out.println(giftCard.getId()+","+giftCard.getType()+","+giftCard.getAmount());
		}
		session.close();
	}

}
