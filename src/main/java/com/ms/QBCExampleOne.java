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
		/*
		Order order=Order.asc("name");
		criteria.addOrder(order);
		criteria.addOrder(Order.asc("age"));
		*/
		//criteria.add(Restrictions.between("age", 15, 20));
		//criteria.add(Restrictions.in("city","indore","mumbai"));
		criteria.add(Restrictions.like("name","p%"));
		//criteria.add(Restrictions.or(Restrictions.eq("city","indore"), Restrictions.le("age", 20)));
		/*
		Criterion crt1=Restrictions.eq("city", "indore");	//where city='indore'
		Criterion crt2=Restrictions.lt("age", 20);			//where age<20
		Criterion crt3=Restrictions.and(crt1,crt2);
		//criteria.add(crt1);
		//criteria.add(crt2);
		criteria.add(crt3);
		*/
		List<Customer> customers=criteria.list();	//select * from customer
		//customer.forEach(System.out::println);
		for(Customer customer:customers) {
			System.out.println(customer.getCode()+","+customer.getName()+","+customer.getAddress()+","+customer.getCity()+","+customer.getAge());
			System.out.println("____________________________________");
		}
		session.close();
	}
}
