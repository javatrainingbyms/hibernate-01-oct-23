package com.ms;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;

public class QBCProjectionOne {

	public static void main(String[] args) {
		Session session=Utility.getSessionFactory().openSession();
		Criteria criteria=session.createCriteria(Customer.class);
		Projection projection=Projections.property("code");
		criteria.setProjection(projection);
		
		List<Integer> codes=criteria.list();
		for(Integer code:codes) {
			System.out.println(code);
		}
		//here we are projecting only names
		/*
		Projection projection=Projections.property("name");
		criteria.setProjection(projection);
		
		List<String> names=criteria.list();
		for(String name:names) {
			System.out.println(name);
		}
		*/
		session.close();

	}

}
