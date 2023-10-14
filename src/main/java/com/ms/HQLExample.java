package com.ms;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class HQLExample {

	public static void main(String[] args) {
		
		Session session=Utility.getSessionFactory().openSession();
		Query query=session.createQuery("update Customer set age=age+1 where age>40");
		Transaction tr=session.beginTransaction();
		int n=query.executeUpdate();
		tr.commit();
		System.out.println("Total Rows Modified : "+n);
		/*
		//String hql="from Customer where city='indore'";
		String hql="from Customer where city=:ct";
		Query query=session.createQuery(hql);
		query.setParameter("ct", "mumbai");
		List<Customer> customerList=query.list();

		for(Customer customer:customerList) {
			System.out.println(customer.getName()+","+customer.getCity());
		}
		*/
		session.close();
	}

}
