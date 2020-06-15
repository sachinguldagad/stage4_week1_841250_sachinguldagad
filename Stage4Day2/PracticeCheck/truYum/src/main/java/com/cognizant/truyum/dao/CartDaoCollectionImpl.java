package com.cognizant.truyum.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.cognizant.truyum.TruYumApplication;
import com.cognizant.truyum.exception.CartEmptyException;
import com.cognizant.truyum.exception.MenuItemNotFoundException;
import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;

@Service
public class CartDaoCollectionImpl implements CartDao {

	@Autowired
	private MenuItemDaoCollectionImpl menuItemDaoCollectionImpl;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(TruYumApplication.class);
	private static HashMap<String, Cart> userCarts;

	public CartDaoCollectionImpl()
	{
		super();
		if(userCarts==null)
		{
			userCarts = new HashMap<String,Cart>();
		}
	}
	@Override
	public void addCartItem(String userId, long menuItemId) {
		LOGGER.info("CartDaoImpl addCartItem() START");

		MenuItem menuItem = menuItemDaoCollectionImpl.getMenuItem(menuItemId);

		if (userCarts.containsKey(userId)) {
			ArrayList<MenuItem> menuItemList = userCarts.get(userId).getCartItemList();
			menuItemList.add(menuItem);
		} else {
			Cart cart = new Cart(new ArrayList<MenuItem>(), userId);
			cart.getCartItemList().add(menuItem);
			userCarts.put(userId, cart);
		}
		LOGGER.debug("userId: {}", userId);
		LOGGER.debug("menuItemId: {}", menuItemId);
		LOGGER.debug("UserCart : {}", userCarts);
		LOGGER.info("CartDaoImpl addCartItem() END");

	}

	@Override
	public ArrayList<MenuItem> getAllCartItems(String userId) throws CartEmptyException {
		// TODO Auto-generated method stub
		LOGGER.info("CartDaoImpl getAllCartItems(long userId) START");

		if (userCarts.containsKey(userId)) {
			double total = 0.0;
			ArrayList<MenuItem> menuItemList = userCarts.get(userId).getCartItemList();
			if (menuItemList.isEmpty()) {
				throw new CartEmptyException();
			} else {

				for (int i = 0; i < menuItemList.size(); i++) {
					total += menuItemList.get(i).getPrice();
				}
			}
			LOGGER.debug("CartItemList : {}", menuItemList);
			LOGGER.debug("Total: {} ", total);

			return menuItemList;
		}
		LOGGER.info("CartDaoImpl getAllCartItems(long userId) END");
		throw new CartEmptyException();
	}

	@Override
	public void removeCartItem(String userId, long menuItemId) {

		LOGGER.info("CartDaoImpl removeCartItem(String userId, long menuItemId) START");
		if (userCarts.containsKey(userId)) {
			ArrayList<MenuItem> menuItemList = userCarts.get(userId).getCartItemList();
			
			
			for(int i =0;i<menuItemList.size();i++)
			{
				if(menuItemList.get(i).getId()==menuItemId)
				{
					menuItemList.remove(i);
					
				}
				
			}
			
			LOGGER.debug("userId: {}", userId);
			LOGGER.debug("menuItemId: {}", menuItemId);
			LOGGER.debug("CartItemList: {}",menuItemList);
			LOGGER.debug("UserCarts: {}",userCarts);
			
		} else {
			throw new MenuItemNotFoundException();
		}
		LOGGER.info("CartDaoImpl removeCartItem(String userId, long menuItemId) END");
	}

}
