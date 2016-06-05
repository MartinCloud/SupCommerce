package com.supinfo.supcommerce.servlet;

import java.io.IOException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import com.supinfo.supcommerce.dao.DaoFactory;
import com.supinfo.supcommerce.dao.jpa.JpaProductDao;
import com.supinfo.supcommerce.entity.Product;

@WebServlet(name="ShowProductServlet",urlPatterns="/showProduct")
public class ShowProductServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private JpaProductDao productDao;
	@Override
	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
		
		String parameterId = req.getParameter("id");
		System.out.println(parameterId);
		
		productDao = (JpaProductDao) DaoFactory.getProductDao();
		Product product = productDao.getProduct(Long.parseLong(parameterId));
		req.setAttribute("productName", product.getName());
	    req.setAttribute("categoryName", product.getCtg().getName());
	    
		RequestDispatcher rq = req.getRequestDispatcher("./showProduct.jsp");
		rq.forward(req, resp);
		   
	}

}
