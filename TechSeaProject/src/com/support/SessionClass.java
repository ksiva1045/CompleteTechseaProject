package com.support;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionClass {
	private static SessionFactory sessionFactory;
	static {
		Configuration configuration=new Configuration();
		configuration.configure();
		sessionFactory=configuration.buildSessionFactory();
	}
	public static Session getSession()
	{
		return sessionFactory.openSession();
	}
}

	
	
