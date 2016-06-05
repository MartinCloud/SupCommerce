package com.supinfo.supcommerce.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.supinfo.supcommerce.dao.DaoFactory;
import com.supinfo.supcommerce.dao.jpa.JpaProductDao;
import com.supinfo.supcommerce.entity.Product;

@Path("/products")
public class ProductResource {
	
	private JpaProductDao productDao;
	
	@GET @Produces(MediaType.APPLICATION_XML)
	public List<Product> getAllProductsInXml(){
		
		productDao = (JpaProductDao) DaoFactory.getProductDao();
		List<Product> productList = productDao.getAllProduct();
		
		return productList;
		
	}
	
	@GET @Produces(MediaType.APPLICATION_JSON)
	public void getAllProductsInJson(){
		
		
	}
	
	@GET @Produces(MediaType.APPLICATION_XML)
    public void getProductInXml(Long productId){
		
	}
	
	@GET @Produces(MediaType.APPLICATION_JSON)
    public void getProductInJson(Long productId){
    	
    }
    public  void removeProduct(Long productId){
    	
    }

}
