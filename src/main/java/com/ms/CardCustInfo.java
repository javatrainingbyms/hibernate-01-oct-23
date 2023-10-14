package com.ms;

import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.transform.Transformers;

public class CardCustInfo {

	public static void main(String[] args) {
		
		Session session=Utility.getSessionFactory().openSession();
		Criteria criteria=session.createCriteria(GiftCard.class);
		criteria.createAlias("customer", "customer");
		ProjectionList pList=Projections.projectionList();
		pList.add(Projections.property("id"),"gift_card_id");
		pList.add(Projections.property("amount"), "amount");
		pList.add(Projections.property("customer.id"),"customer_id");
		pList.add(Projections.property("customer.name"),"customer_name");
		criteria.setProjection(pList);
		criteria.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		List<Map> list=criteria.list();
		for(Map map:list) {
			System.out.println(map);
		}
		session.close();

	}

}
