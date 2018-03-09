package com.niit.dao;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.model.CartItem;


@Repository("cartDAO")
public class CartDAOImpl implements CartDAO 
{

	@Autowired
	SessionFactory sessionFactory;
	
	//addCategory
	@Transactional
	@Override
	public boolean addcartItem(CartItem cartItem)
	{	
		try
		{
		sessionFactory.getCurrentSession().save(cartItem);
		return true;
		}
		catch(Exception e)
		{
		System.out.println("Exception Arised:"+e);
		return false;
		}
	}
	
	
	//updateCategory()
		@Transactional
		@Override
		public boolean updateCartItemId(CartItem cartItem)
		{
			try
			{
				sessionFactory.getCurrentSession().update(cartItem);
				return true;
			}
			catch(Exception e)
			{
				System.out.println("Exception Arised:"+e);
				return false;
			}
		
		}

	//getCategory()
	@Override
	public CartItem getCartItemId(int cartItemId) 
	{
		Session session=sessionFactory.openSession();
		CartItem cart=(CartItem)session.get(CartItem.class,cartItemId);
		session.close();
		return cart;
	}

	//deleteCategory()
	@Transactional
	@Override
	public boolean deleteCart(CartItem  cartItem)
	{
		try
		{
			sessionFactory.getCurrentSession().delete(cartItem);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception Arised:"+e);
			return false;
		}
		
	}
	
	
	//listCategories()	
	@Override
	public List<CartItem> getcartitemId(String username) 
	{
		Session session=sessionFactory.openSession();
		
		List<CartItem> listCartItems=session.createQuery("from CartItem where username=:username").setParameter("username", username).list();
		return listCartItems;
	}
}
