package com.ms;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class CustomerEntry {

	public static void main(String[] args) {
	
		Session session=Utility.getSessionFactory().openSession();
		Transaction transaction=session.beginTransaction();
		/*
		session.save(new Customer(101,"smith","palasia", "indore"));
		session.save(new Customer(501,"pankaj","mig", "bhopal"));
		session.save(new Customer(301,"john","newmarket", "bhopal"));
		session.save(new Customer(201,"priya","andheri", "mumbai"));
		session.save(new Customer(401,"rahul","cplace", "delhi"));
		*/
		//session.save(new Customer(234,"chetan","vijaynagar","indore",22));
		session.save(new Customer(343,"bhawesh","santacruz","mumbai",25,new Card(7,"345356","platinum")));
		transaction.commit();
		
		session.close();
		
		System.out.println("Customer Data Stored....!");
		
		
	}

}
