package com.cognizant.truyum.service;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.truyum.TruYumApplication;
import com.cognizant.truyum.dao.MenuItemDao;
import com.cognizant.truyum.dao.MenuItemDaoCollectionImpl;
import com.cognizant.truyum.model.MenuItem;

@Service
public class MenuItemService {

	private static final Logger LOGGER = LoggerFactory.getLogger(TruYumApplication.class);
	@Autowired
	private MenuItemDao menuItemDao;
	@Autowired 
	private MenuItemDaoCollectionImpl menuItemDaoImpl;
	
	public ArrayList<MenuItem> getMenuItemListCustomer()
	{
		LOGGER.info("MenuItemService getMenuItemListCustomer() START");
		ArrayList<MenuItem> listOfMenuItem = menuItemDaoImpl.getMenuItemListCustomer();
		
		LOGGER.debug("List:", listOfMenuItem);
		LOGGER.info("MenuItemService getMenuItemListCustomer() END");
		return listOfMenuItem;
	}
	
	public MenuItem getMenuItem(long id)
	{
		LOGGER.info("MenuItemService getMenuItem(long id) START");
		MenuItem menuItem = menuItemDaoImpl.getMenuItem(id);
		
		LOGGER.debug("MenuItem: {}",menuItem);		
		LOGGER.info("MenuItemService getMenuItem(long id) END");
		return menuItem;
	}
	
	public void modifyMenuItem(MenuItem menuItem)
	{
		LOGGER.info("MenuItemService modifyMenuItem(MenuItem menuItem) START");
		
		menuItemDaoImpl.modifyMenuItem(menuItem);
		
		LOGGER.info("MenuItemService modifyMenuItem(MenuItem menuItem) END");
		return;
	}
}
