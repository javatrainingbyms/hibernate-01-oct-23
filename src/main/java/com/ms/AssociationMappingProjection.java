package com.ms;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.hibernate.transform.Transformers;

public class AssociationMappingProjection {
		public static void main(String[] args) {
			Session session=Utility.getSessionFactory().openSession();
			
			//we will fetch name,city,cardno
			
			Criteria criteria=session.createCriteria(Customer.class);
			//criteria.createAlias("card", "card");	//default is inner
			criteria.createAlias("card", "card", JoinType.LEFT_OUTER_JOIN);
			//criteria.createAlias("card", "card", JoinType.RIGHT_OUTER_JOIN);
			//criteria.createAlias("card", "card", JoinType.FULL_JOIN);
			ProjectionList pList=Projections.projectionList();
			pList.add(Projections.property("name"), "name");
			pList.add(Projections.property("city"), "city");
			pList.add(Projections.property("card.cno"), "cardNo");
			criteria.setProjection(pList);
			criteria.setResultTransformer(Transformers.aliasToBean(CustomerCardInfo.class));
			criteria.add(Restrictions.eq("card.type", "golden"));
			List<CustomerCardInfo> list=criteria.list();
			for(CustomerCardInfo info:list) {
				System.out.println(info);
			}
			
			
			
			
			
			
			
			
			session.close();
		}

}
