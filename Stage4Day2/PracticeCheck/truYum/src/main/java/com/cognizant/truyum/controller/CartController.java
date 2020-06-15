package com.cognizant.truyum.controller;

import java.util.ArrayList;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.truyum.TruYumApplication;
import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.service.CartService;

@RestController
@RequestMapping("/carts")
public class CartController {

	private static final Logger LOGGER = LoggerFactory.getLogger(TruYumApplication.class);
	@Autowired
	private CartService cartService;

	@PostMapping("/{userId}/{menuItemId}")
	public void addCartItem(@PathVariable @Valid String userId, @PathVariable @Valid long menuItemId) {

		LOGGER.info("CartController addCartItem(long userId, long menuItemId) START");

		cartService.addCartItem(userId, menuItemId);

		LOGGER.info("CartController addCartItem(long userId, long menuItemId) END");
	}

	@GetMapping("/{userId}")
	public ArrayList<MenuItem> getAllCartItems(@PathVariable @Valid String userId) {
		LOGGER.info("CartController getAllCartItems(long userId) START");

		LOGGER.info("CartController getAllCartItems(long userId) END");
		return cartService.getAllCartItems(userId);
	}
	
	@DeleteMapping("/{userId}/{menuItemId}")
	public void removeCartItem(@PathVariable @Valid String userId,@PathVariable @Valid long menuItemId) {
		
		LOGGER.info("CartController removeCartItem(long userId, long menuItemId) START");

		cartService.removeCartItem(userId, menuItemId);

		LOGGER.info("CartController removeCartItem(long userId, long menuItemId) END");
	}
}
