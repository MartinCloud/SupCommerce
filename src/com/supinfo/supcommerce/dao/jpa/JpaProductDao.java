package com.supinfo.supcommerce.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.supinfo.supcommerce.dao.ProductDao;

import com.supinfo.supcommerce.entity.Product;

public class JpaProductDao implements ProductDao {
	
	EntityManager em;
	
	public JpaProductDao(EntityManagerFactory emf){
		
		em = emf.createEntityManager();
	}
	@Override
	public Product getProduct(Long id) {
		EntityTransaction t = em.getTransaction();
		Product product = null ;
		
		try{
			
			t.begin();
			Query query  = em.createQuery("SELECT p FROM Product AS p WHERE p.id= :id");
			query.setParameter("id", id);
			product = (Product) query.getSingleResult();
			t.commit();
			
		}finally{
			
			if (t.isActive())
				t.rollback();
		}
		
		return product;
	}
	
	@Override
	public void addProduct(Product product) {
		EntityTransaction t = em.getTransaction();
		
		try{
			
			t.begin();
			em.persist(product);
			t.commit();
			
		}finally{
			
			if (t.isActive())
				t.rollback();
		}
		
	}
	@Override
	public List <Product> findProduct(Float price) {
		EntityTransaction t = em.getTransaction();
		
		List <Product> allProducts = null;
		try{
			t.begin();
			
			Query query = em.createQuery(" SELECT p FROM Product AS p WHERE p.price < 100 ");
			allProducts = query.getResultList();
			
			t.commit();
		}finally{
			
			if (t.isActive())
				t.rollback();
		}
	   
		return allProducts;
	}
	@Override
	public List <Product> getAllProduct() {
		EntityTransaction t = em.getTransaction();
		List <Product> allProducts = null;
		try{
			t.begin();
			
			Query query = em.createQuery("SELECT p FROM Product AS p");
			allProducts = query.getResultList();
			
			t.commit();
			
		}finally{
			
			if (t.isActive())
				t.rollback();
		}
		return allProducts;
	}
	@Override
	public int DeleteProduct(Long id) {
		EntityTransaction t =em.getTransaction();
		int numDelete;
		
		try{
			
			t.begin();
			Query query = em.createQuery("DELETE FROM Product as product WHERE product.id=:id");
			query.setParameter("id", id);
			numDelete = query.executeUpdate();
			t.commit();
			
		}finally{
			
			if (t.isActive())
				t.rollback();
		}
		
		return numDelete;
	} 

	@Override
	public int updatePro() {
		
		return 0;
	}
	

}
