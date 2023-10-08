package com.ms;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class CustomerEntry {

	public static void main(String[] args) {

		Session session = Utility.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		session.save(new Customer(101, "smith", "palasia", "indore", 19, new Card(1)));
		session.save(new Customer(501, "pankaj", "mig", "bhopal", 25, new Card(2)));
		session.save(new Customer(301, "john", "newmarket", "bhopal", 17, new Card(3)));
		session.save(new Customer(201, "priya", "andheri", "mumbai", 22, new Card(4)));
		session.save(new Customer(401, "rahul", "cplace", "delhi", 32, new Card(5)));
		session.save(new Customer(234, "chetan", "vijaynagar", "indore", 44, new Card(6)));
		transaction.commit();
		session.close();

		System.out.println("Customer Data Stored....!");

	}

}
