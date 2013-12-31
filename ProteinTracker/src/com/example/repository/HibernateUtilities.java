package com.example.repository;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateUtilities {
	private static SessionFactory sessionFactory;
	private static ServiceRegistry serviceRegistry;
	
	static
	{
		try {
			Configuration configuration = new Configuration().setInterceptor(new AuditInterceptor()).configure();
			
			serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
			sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		}
		catch(HibernateException ex) {
			System.err.println("Were not able to create a sessionFactory: " + ex.toString());			
		}
	}
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
