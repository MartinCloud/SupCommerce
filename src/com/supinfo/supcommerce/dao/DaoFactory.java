package com.supinfo.supcommerce.dao;

import com.supinfo.supcommerce.dao.jpa.JpaCategoryDao;
import com.supinfo.supcommerce.dao.jpa.JpaProductDao;
import com.supinfo.supcommerce.util.PersistenceManager;

public class DaoFactory {
	
	private DaoFactory(){
		
	}
	
	public static ProductDao getProductDao(){
		return new JpaProductDao(PersistenceManager.getEntityManagerFactory());

	}
	public static CategoryDao getCategoryDao(){
		return new JpaCategoryDao(PersistenceManager.getEntityManagerFactory());
		
	}
}
