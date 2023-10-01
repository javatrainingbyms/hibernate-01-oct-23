package com.ms;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;

public class QBCExampleOne {
	public static void main(String[] args) {
		//QBC- will fetch multiple records using Criteria object
		
		Session session=Utility.getSessionFactory().openSession();
		Criteria criteria=session.createCriteria(Customer.class);
		List<Customer> customers=criteria.list();	//select * from customer
		//customer.forEach(System.out::println);
		for(Customer customer:customers) {
			System.out.println(customer.getCode());
			System.out.println(customer.getName());
			System.out.println(customer.getAddress());
			System.out.println(customer.getCity());
			System.out.println("____________________________________");
		}
		session.close();
	}
}
