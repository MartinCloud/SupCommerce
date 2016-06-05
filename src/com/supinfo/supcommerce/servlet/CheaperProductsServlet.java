package com.supinfo.supcommerce.servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.supinfo.supcommerce.dao.DaoFactory;
import com.supinfo.supcommerce.dao.jpa.JpaProductDao;
import com.supinfo.supcommerce.entity.Product;
@WebServlet(urlPatterns="/cheaperProducts")
public class CheaperProductsServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private JpaProductDao productDao;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		productDao = (JpaProductDao) DaoFactory.getProductDao();
		
		List <Product> allProducts = productDao.findProduct(100F);
		req.setAttribute("productList", allProducts);
		
	    RequestDispatcher rq = req.getRequestDispatcher("./listProduct.jsp");
	    rq.forward(req, resp);
		
		
	}
	
	

}
