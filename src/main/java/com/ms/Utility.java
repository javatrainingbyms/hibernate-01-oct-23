package com.ms;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Utility {
	public static SessionFactory getSessionFactory() {
		//Configuration Object
		Configuration configuration=new Configuration().configure();
		//SessionFactory Object
		SessionFactory sessionFactory=configuration.buildSessionFactory();
		//Session Object
		return sessionFactory;
	}
}
