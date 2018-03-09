package com.niit.dao;
import java.util.List;
import javax.transaction.Transactional;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.model.Suplier;

@Repository("suplierDAO")
public class SuplierDAOImpl implements SuplierDAO 
{

	@Autowired
	SessionFactory sessionFactory;
	
	//addCategory
	@Transactional
	@Override
	public boolean addSuplier(Suplier suplier) 
	{	
		try
		{
		sessionFactory.getCurrentSession().save(suplier);
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
	public Suplier getSuplier(int suplierId) 
	{
		Session session=sessionFactory.openSession();
		Suplier suplier=(Suplier)session.get(Suplier.class,suplierId);
		session.close();
		return suplier;
	}

	//deleteCategory()
	@Transactional
	@Override
	public boolean deleteSuplier(Suplier suplier) 
	{
		try
		{
			sessionFactory.getCurrentSession().delete(suplier);
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
	public boolean updateSuplier(Suplier suplier) 
	{
		try
		{
			sessionFactory.getCurrentSession().update(suplier);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception Arised:"+e);
			return false;
		}
	
	}

	//listCategories()	
	@SuppressWarnings("unchecked")
	@Override
	public List<Suplier> getsupliers() 
	{
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Suplier");
		List<Suplier> listSupliers=(List<Suplier>)query.list();
		return listSupliers;
	}
}
