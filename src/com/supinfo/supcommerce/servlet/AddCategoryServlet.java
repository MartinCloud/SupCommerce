package com.supinfo.supcommerce.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.supinfo.supcommerce.dao.DaoFactory;
import com.supinfo.supcommerce.dao.jpa.JpaCategoryDao;
import com.supinfo.supcommerce.entity.Category;
import com.supinfo.supcommerce.util.PersistenceManager;

@WebServlet(urlPatterns="/auth/addCategory")
public class AddCategoryServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private JpaCategoryDao categoryDao;

	@Override
	public void init(){
		categoryDao = (JpaCategoryDao) DaoFactory.getCategoryDao();
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.sendRedirect("../addCategory.jsp");		
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Long id = Long.parseLong(req.getParameter("id"));
		String cname = req.getParameter("cname");
		
		Category category = new Category();
		//category.setId(id);
		category.setName(cname);
		
		categoryDao.addCategory(category);
	}
	
	@Override
	public void destroy(){
		
	}
	
}
