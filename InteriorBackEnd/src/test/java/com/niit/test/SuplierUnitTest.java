package com.niit.test;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.SuplierDAO;
import com.niit.model.Suplier;


public class SuplierUnitTest 
{
	static SuplierDAO suplierDAO;

	@SuppressWarnings("resource")
	@BeforeClass
	public static void executeFirst()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		suplierDAO=(SuplierDAO)context.getBean("suplierDAO");
	}
	
	@Test
	public void addSuplierTest()
	{
		Suplier suplier=new Suplier();
		suplier.setsuplierName("Book Cupboard");
		suplier.setSuplierDesc("All the Book Cupboard Types");
		assertTrue("Problem in Category Insertion",suplierDAO.addSuplier(suplier));
		
		suplier.setsuplierName("Cupboard");
		suplier.setSuplierDesc("All the Cupboard Types");
		assertTrue("Problem in Category Insertion",suplierDAO.addSuplier(suplier));
		
		suplier.setsuplierName("Board");
		suplier.setSuplierDesc("All the Board Types");
		assertTrue("Problem in Category Insertion",suplierDAO.addSuplier(suplier));
	}

	/*	
	@Test
	public void getSuplierTest()
	{
		assertNotNull("Problem in get Suplier",suplierDAO.getSuplier(1));
	}
	
	@Test
	public void deleteSuplierTest()
	{
		Suplier suplier=suplierDAO.getSuplier(5);
		assertTrue("Problem in Deletion:",suplierDAO.deleteSuplier(suplier));
	}

	@Test
	public void updateSuplierTest()
	{
		Suplier suplier=suplierDAO.getSuplier(4);
		suplier.setsuplierName("L Sofa Model");
		assertTrue("Problem in Updation",suplierDAO.updateSuplier(suplier));
	}
	
	
	@Test
	public void listCategoriesTest()
	{
		List<Suplier> listSupliers=suplierDAO.getsupliers();
		assertNotNull("No supliers",listSupliers);
		
		for(Suplier suplier:listSupliers)
		{
			System.out.print(suplier.getsuplierId()+":::");
			System.out.print(suplier.getsuplierName()+":::");
			System.out.println(suplier.getsuplierDesc());
		}
		
	}
	*/
	
}

