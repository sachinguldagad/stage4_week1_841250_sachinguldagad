package com.cognizant.truyum.service;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.cognizant.truyum.TruYumApplication;
import com.cognizant.truyum.dao.CartDaoCollectionImpl;
import com.cognizant.truyum.model.MenuItem;

@Service
public class CartService {

	@Autowired
	private CartDaoCollectionImpl cartDaoCollectionImpl;

	private static final Logger LOGGER = LoggerFactory.getLogger(TruYumApplication.class);

	public void addCartItem(String userId, long menuItemId) {
		LOGGER.info("CartService addCartItem() START");

		cartDaoCollectionImpl.addCartItem(userId, menuItemId);

		LOGGER.info("CartService addCartItem() END");
	}

	public ArrayList<MenuItem> getAllCartItems(String userId) {
		LOGGER.info("CartService  getAllCartItems(long userId) START");

		LOGGER.info("CartService  getAllCartItems(long userId) END");
		return cartDaoCollectionImpl.getAllCartItems(userId);
	}
	
	public void removeCartItem(String userId, long menuItemId) {
		
		LOGGER.info("CartService removeCartItem(long userId, long menuItemId) START");

		cartDaoCollectionImpl.removeCartItem(userId, menuItemId);

		LOGGER.info("CartService removeCartItem(long userId, long menuItemId) END");
	}
}
