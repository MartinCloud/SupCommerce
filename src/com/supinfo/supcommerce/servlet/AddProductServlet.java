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
import com.supinfo.supcommerce.dao.jpa.JpaCategoryDao;
import com.supinfo.supcommerce.dao.jpa.JpaProductDao;
import com.supinfo.supcommerce.entity.Category;
import com.supinfo.supcommerce.entity.Product;

@WebServlet(urlPatterns="/auth/addProduct")
public class AddProductServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private JpaCategoryDao categoryDao;
	private JpaProductDao productDao;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("add product servlet");
		
		String pName = req.getParameter("username");
		String pContent = req.getParameter("content");
		String pPrice = req.getParameter("price");
		Float price = Float.parseFloat(pPrice);
		Long ctgId = Long.parseLong(req.getParameter("ctgid"));
		System.out.println(ctgId);		
		Product supProduct = new Product();
		supProduct.setName(pName);
		supProduct.setContent(pContent);
		supProduct.setPrice(price);
		
		categoryDao = (JpaCategoryDao) DaoFactory.getCategoryDao();
		productDao = (JpaProductDao) DaoFactory.getProductDao();
		
		Category category = categoryDao.getCategory(ctgId);
		supProduct.setCtg(category);
		
		productDao.addProduct(supProduct);
		
		resp.sendRedirect("../showProduct?id=" + supProduct.getId());
		
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		categoryDao = (JpaCategoryDao) DaoFactory.getCategoryDao();
		
		List <Category> allCategories = categoryDao.getAllCtg();
		req.setAttribute("categoriesList", allCategories);
		
		RequestDispatcher rq = req.getRequestDispatcher("./addProduct.jsp");
		rq.forward(req, resp);
		
	}
	
	
}
