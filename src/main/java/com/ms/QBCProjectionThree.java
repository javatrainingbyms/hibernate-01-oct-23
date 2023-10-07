package com.ms;

import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.transform.Transformers;

//here we are transforming result to List<Map> , List<Bean>
public class QBCProjectionThree {
	public static void main(String[] args) {
		Session session=Utility.getSessionFactory().openSession();
		Criteria criteria=session.createCriteria(Customer.class);
		Projection projection1=Projections.property("name");
		Projection projection2=Projections.property("age");
		ProjectionList pList=Projections.projectionList();
		
		pList.add(projection1, "cname");//2nd param is alias (which will be used for key in map)
		pList.add(projection2, "cage");
		
		criteria.setProjection(pList);
		criteria.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		List<Map> list=criteria.list();
		for(Map map:list) {
			System.out.println(map);
			System.out.println("___________________________________");
		}
		session.close();

	}
}
