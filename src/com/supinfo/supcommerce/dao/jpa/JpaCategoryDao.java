package com.supinfo.supcommerce.dao.jpa;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.supinfo.supcommerce.dao.CategoryDao;
import com.supinfo.supcommerce.entity.Category;

public class JpaCategoryDao implements CategoryDao{
	private EntityManager em;
	
	public JpaCategoryDao(EntityManagerFactory emf){
		
		em = emf.createEntityManager();
		
	}
	
	@Override
	public void addCategory(Category category) {
		
		EntityTransaction t =em.getTransaction();
		try{
			t.begin();
			em.persist(category);
			t.commit();
		}finally{
			
			if (t.isActive())
				t.rollback();
		}
	}
	
	@Override
	public Category getCategory(Long id) {
		
		EntityTransaction t =em.getTransaction();
		Category category;
		
		try{
			
			t.begin();
			
			Query query = em.createQuery(" SELECT ctg FROM Category AS ctg WHERE ctg.id= :id ");
			query.setParameter("id", id);
		    category = (Category) query.getSingleResult();
			
			t.commit();
			
		}finally{
			
			if (t.isActive())
				t.rollback();
		}
		
		return category;
	}

	@Override
	public List <Category> getAllCtg() {
		
		EntityTransaction t =em.getTransaction();
		List <Category> allCategories = null;
		
		try{
			t.begin();
			
			Query query = em.createQuery("SELECT ctg FROM Category AS ctg ");
			allCategories = query.getResultList();
			
			t.commit();
			
		}finally{
			
			if (t.isActive())
				t.rollback();	
		}
		
		return allCategories ;
		
	}

	@Override
	public int DeleteCtg(Long id) {
		
		return 0;
	}

	@Override
	public int updateCtg() {
		
		return 0;
	}
	
}
