package com.techsea;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CheckDatabaseData {
	
	public static Emp checkData(){
		Configuration configuration=new Configuration();
		configuration.configure("hibernate.cfg.xml");
		SessionFactory sessionFactory=configuration.buildSessionFactory();
		Session session =sessionFactory.openSession();
		List list =session.getNamedQuery("login").list();
		System.out.println(list);
		Iterator it = list.iterator();
		Emp e=null;
		while(it.hasNext()){
			 e =(Emp) it.next();
		}
		
		session.close();
		sessionFactory.close();
		return e;
		
	}

}
