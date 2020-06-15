package com.cognizant.truyum.dao;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.cognizant.truyum.TruYumApplication;
import com.cognizant.truyum.exception.MenuItemNotFoundException;
import com.cognizant.truyum.model.MenuItem;

@Service
public class MenuItemDaoCollectionImpl implements MenuItemDao {

	private static final Logger LOGGER = LoggerFactory.getLogger(TruYumApplication.class);
	
	private static ArrayList<MenuItem> listOfMenuItem;
	
	
	@Override
	public ArrayList<MenuItem> getMenuItemListCustomer()
	{
		LOGGER.info("MenuItemDaoImpl getMenuItemListCustomer() START");
		ApplicationContext context = new ClassPathXmlApplicationContext("truyum.xml");
		listOfMenuItem = context.getBean("menuItemList",java.util.ArrayList.class);
		
		LOGGER.debug("MenuItemList: {} ",listOfMenuItem.toString());
		
		((ConfigurableApplicationContext)context).close();
		LOGGER.info("MenuItemDaoImpl getMenuItemListCustomer() END");
		return listOfMenuItem;
	}
	
	@Override
	public MenuItem getMenuItem(long id)
	{
		LOGGER.info("MenuItemDaoImpl getMenuItem(long id) START");
		
		listOfMenuItem = getMenuItemListCustomer();
		
		LOGGER.debug("MenuItemList: {} ",listOfMenuItem);
		
		
		LOGGER.info("MenuItemDaoImpl getMenuItem(long id) END");
		
		return listOfMenuItem.stream().filter(item->(item.getId()==id )).findFirst().orElseThrow(() -> {throw new MenuItemNotFoundException();});
	}
	
	@Override
	public void modifyMenuItem(MenuItem menuItem)
	{
		LOGGER.info("MenuItemDaoImpl modifyMenuItem(MenuItem menuItem) START");
		MenuItem menuItemUpdate = getMenuItem(menuItem.getId());
		
		menuItemUpdate.setName(menuItem.getName());
		menuItemUpdate.setPrice(menuItem.getPrice());
		menuItemUpdate.setActive(menuItem.isActive());
		menuItemUpdate.setDateOfLaunch(menuItem.getDateOfLaunch());
		menuItemUpdate.setCategory(menuItem.getCategory());
		menuItemUpdate.setFreeDelivery(menuItem.isFreeDelivery());
		
		LOGGER.debug("MenuItemUpdated: {}",menuItemUpdate);
		LOGGER.info("MenuItemDaoImpl modifyMenuItem(MenuItem menuItem) END");
		
		return;
	}
}
