package com.ms;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;

public class CardData {

	public static void main(String[] args) {
		Session session=Utility.getSessionFactory().openSession();
		Criteria criteria=session.createCriteria(Card.class);
		List<Card> cards=criteria.list();
		for(Card card:cards) {
			System.out.println(card.getId()+","+card.getCno()+","+card.getType());
			Customer customer=card.getCustomer();
			System.out.println(customer.getCode()+","+customer.getName()+","+customer.getAddress()+","+customer.getCity()+","+customer.getAge());
			System.out.println("_____________________________________________________________");
		}
		session.close();

	}

}
