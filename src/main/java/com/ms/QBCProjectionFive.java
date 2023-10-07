package com.ms;

import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.transform.Transformers;



public class QBCProjectionFive {

	public static void main(String[] args) {
		Session session=Utility.getSessionFactory().openSession();
		Criteria criteria=session.createCriteria(Customer.class);
		
		//aggregation/grouping
		
		Projection projection1=Projections.groupProperty("city");
		Projection projection2=Projections.count("city");
		Projection projection3=Projections.avg("age");
		
		ProjectionList pList=Projections.projectionList();
		pList.add(projection1, "city");
		pList.add(projection2, "count");
		pList.add(projection3, "average");
		criteria.setProjection(pList);
		criteria.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		List<Map> list=criteria.list();
		for(Map map:list) {
			System.out.println(map);
		}
		/*
		criteria.setProjection(pList);
		criteria.setResultTransformer(Transformers.aliasToBean(Summary.class));
		
		List<Summary> summaries=criteria.list();
		for(Summary summary:summaries) {
			System.out.println(summary);
		}
		*/
		session.close();
	}

}
