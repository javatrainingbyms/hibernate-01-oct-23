package com.ms;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

public class QBCExampleOne {
	public static void main(String[] args) {
		//QBC- will fetch multiple records using Criteria object
		
		Session session=Utility.getSessionFactory().openSession();
		Criteria criteria=session.createCriteria(Customer.class);
		List<Customer> customers=criteria.list();
		for(Customer customer:customers) {
			System.out.println(customer.getCode()+","+customer.getName()+","+customer.getAddress()+","+customer.getCity()+","+customer.getAge());
			Card card=customer.getCard();
			System.out.println(card.getId()+","+card.getCno()+","+card.getType());
			System.out.println("____________________________________");
		}
		session.close();
	}
}
