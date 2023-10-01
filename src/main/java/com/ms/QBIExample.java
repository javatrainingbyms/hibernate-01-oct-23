package com.ms;

import org.hibernate.Session;

public class QBIExample {

	public static void main(String[] args) {
		//reading a record using its id
		
		Session session=Utility.getSessionFactory().openSession();
		Customer customer=session.get(Customer.class, 301);	//select column_names from customer where id=?
		System.out.println(customer.getCode());
		System.out.println(customer.getName());
		System.out.println(customer.getAddress());
		System.out.println(customer.getCity());
		session.close();
	}

}
