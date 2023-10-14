package com.ms;


import org.hibernate.Session;
import org.hibernate.Transaction;

public class CardUpdate {
	public static void main(String[] args) {
		Session session=Utility.getSessionFactory().openSession();
		//Card card=session.get(Card.class, 4);
		//card.setType("platinum");
		Transaction tr=session.beginTransaction();
		//session.update(card);
		Card card=new Card();
		card.setId(8);
		session.delete(card);
		tr.commit();
		session.close();
	}
}
