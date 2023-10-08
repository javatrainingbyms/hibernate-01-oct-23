package com.ms;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public class AssociationMappingRestriction {
	public static void main(String[] args) {
		Session session=Utility.getSessionFactory().openSession();
		Criteria criteria=session.createCriteria(Customer.class);
		//criteria.add(Restrictions.eq("city", "indore"));
		
		criteria.createAlias("card", "cr");
		criteria.add(Restrictions.eq("cr.type", "golden"));
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
