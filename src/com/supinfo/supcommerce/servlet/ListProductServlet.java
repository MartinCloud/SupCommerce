package com.supinfo.supcommerce.servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import com.supinfo.supcommerce.dao.DaoFactory;
import com.supinfo.supcommerce.dao.jpa.JpaProductDao;
import com.supinfo.supcommerce.entity.Product;

@WebServlet(name="ListProductServlet",urlPatterns="/listProduct")
public class ListProductServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private JpaProductDao productDao;
	@Override
    public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
			
		//PrintWriter out =resp.getWriter();
		System.out.println("List product servlet page");
		//out.println(req.getAttribute("username"));
		   
		productDao = (JpaProductDao) DaoFactory.getProductDao();
		List <Product> allProducts = productDao.getAllProduct();
		req.setAttribute("productList", allProducts);
		   
		RequestDispatcher rq = req.getRequestDispatcher("./listProduct.jsp");
		rq.forward(req, resp);
		   
	}

}
