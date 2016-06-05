package com.supinfo.supcommerce.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.supinfo.supcommerce.dao.DaoFactory;
import com.supinfo.supcommerce.dao.jpa.JpaProductDao;

@WebServlet(urlPatterns="/auth/removeProduct")

public class RemoveProductServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private JpaProductDao productDao;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("Remove user page");

		Long id = Long.parseLong(req.getParameter("id"));
		req.setAttribute("userid", id);
		
		doPost(req,resp);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Long id = (Long) req.getAttribute("userid");
		
		productDao = (JpaProductDao) DaoFactory.getProductDao();
		int numDelete = productDao.DeleteProduct(id);
		System.out.println(numDelete);
		
		resp.sendRedirect("/SupCommerce1/listProduct");
		
	}

}
