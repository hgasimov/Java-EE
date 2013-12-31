package com.example.repository;
import java.io.Serializable;
import java.util.Iterator;

import org.hibernate.EmptyInterceptor;
import org.hibernate.type.Type;


public class AuditInterceptor extends EmptyInterceptor{

	@Override
	public boolean onSave(Object entity, Serializable id, Object[] state,
			String[] propertyNames, Type[] types) {
		
		System.out.println("[onSave]: nothing to do");
		return false;
	}

	@Override
	public void postFlush(Iterator entities) {
		System.out.println("[postFlush]: After the entity has been flushed, baby!");
	}
	
}
