package com.cognizant.truyum.dao;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.cognizant.truyum.exception.MenuItemNotFoundException;
import com.cognizant.truyum.model.MenuItem;

public interface MenuItemDao {

	public ArrayList<MenuItem> getMenuItemListCustomer();
	
	public MenuItem getMenuItem(long id) throws MenuItemNotFoundException ;
	
	public void modifyMenuItem(MenuItem menuItem);
}
