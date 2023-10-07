package com.ms;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class CardEntry {

	public static void main(String[] args) {
		Session session=Utility.getSessionFactory().openSession();
		Transaction transaction=session.beginTransaction();
		
		session.save(new Card(1,"123456","golden"));
		session.save(new Card(2,"234567","silver"));
		session.save(new Card(3,"345678","silver"));
		session.save(new Card(4,"456789","golden"));
		session.save(new Card(5,"566789","diamond"));
		session.save(new Card(6,"787880","diamond"));
		
		
		transaction.commit();
		
		session.close();
		
		System.out.println("Card Data Stored....!");

	}

}
