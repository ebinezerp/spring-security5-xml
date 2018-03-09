package com.niit.dao;

import java.util.List;

import com.niit.model.CartItem;

public interface CartDAO
{
	public boolean addcartItem(CartItem cartItem);
	public CartItem getCartItemId(int cartItemId);
	public boolean deleteCart(CartItem cartItem);
	public boolean updateCartItemId(CartItem cartItem);
	public List<CartItem> getcartitemId(String username);
}
