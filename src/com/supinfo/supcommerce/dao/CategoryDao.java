package com.supinfo.supcommerce.dao;

import java.util.List;

import com.supinfo.supcommerce.entity.Category;

public interface CategoryDao {
	
	public void addCategory(Category category);
	public Category getCategory(Long id);
	public List <Category> getAllCtg();
	public int DeleteCtg(Long id);
	public int updateCtg();
}
