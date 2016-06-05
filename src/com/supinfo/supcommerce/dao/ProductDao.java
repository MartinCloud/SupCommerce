package com.supinfo.supcommerce.dao;

import java.util.List;

import com.supinfo.supcommerce.entity.Product;

public interface ProductDao {
	
	public void addProduct(Product product);
	public Product getProduct(Long id);
	public List <Product> findProduct(Float price);
	public List <Product> getAllProduct();
	public int DeleteProduct(Long id);
	public int updatePro();

}
