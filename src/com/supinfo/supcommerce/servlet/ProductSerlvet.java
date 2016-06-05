package com.supinfo.supcommerce.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import com.supinfo.supcommerce.dao.DaoFactory;
import com.supinfo.supcommerce.dao.jpa.JpaProductDao;
import com.supinfo.supcommerce.entity.Product;

@WebServlet(name="ProductSerlvet",urlPatterns="/auth/basicInsert")
public class ProductSerlvet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private JpaProductDao productDao;
	@Override
	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
		
		Product product = new Product();
		//product.setId(6L);
		product.setContent("a good product");
		product.setName("jupe");
		product.setPrice(100f);
		
		productDao = (JpaProductDao) DaoFactory.getProductDao();
		productDao.addProduct(product);
	}


}
