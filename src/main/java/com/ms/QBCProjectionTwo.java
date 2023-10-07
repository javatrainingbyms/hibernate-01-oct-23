package com.ms;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;

public class QBCProjectionTwo {
	public static void main(String[] args) {
		Session session=Utility.getSessionFactory().openSession();
		Criteria criteria=session.createCriteria(Customer.class);
		Projection projection1=Projections.property("name");
		Projection projection2=Projections.property("age");
		ProjectionList pList=Projections.projectionList();
		pList.add(projection1);
		pList.add(projection2);
		criteria.setProjection(pList);
		List<Object[]> list=criteria.list();
		for(Object array[]:list) {
			for(Object item:array) {
				System.out.println(item);
			}
			System.out.println("___________________________________");
		}
		session.close();

	}
}
