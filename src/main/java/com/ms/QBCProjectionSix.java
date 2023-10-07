package com.ms;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.transform.Transformers;

public class QBCProjectionSix {
	public static void main(String[] args) {
		Session session=Utility.getSessionFactory().openSession();
		Criteria criteria=session.createCriteria(Customer.class);
		Projection projection1=Projections.property("name");
		Projection projection2=Projections.property("age");
		ProjectionList pList=Projections.projectionList();
		
		pList.add(projection1, "name");//2nd param is alias (which will be used for key in map)
		pList.add(projection2, "age");
		
		criteria.setProjection(pList);
		criteria.setResultTransformer(Transformers.aliasToBean(Customer.class));
		List<Customer> list=criteria.list();
		for(Customer customer:list) {
			System.out.println(customer);
			System.out.println("___________________________________");
		}
		session.close();

	}
}
