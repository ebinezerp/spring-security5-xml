package com.niit.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.CategoryDAO;
import com.niit.dao.ProductDAO;
import com.niit.dao.SuplierDAO;
import com.niit.model.Category;
import com.niit.model.Product;
import com.niit.model.Suplier;


public class DemoTest 
{
	@SuppressWarnings("resource")
	public static void main(String arg[])
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		
		CategoryDAO categoryDAO=(CategoryDAO)context.getBean("categoryDAO");
		Category category=new Category();
		category.setCategoryName("Chimney");
		category.setCateogryDesc("Hindware Chimney-Kitchen Decor");
		categoryDAO.addCategory(category);
		
		SuplierDAO suplierDAO=(SuplierDAO)context.getBean("suplierDAO");
		Suplier suplier=new Suplier();
		suplier.setsuplierName("S1");
		suplier.setSuplierDesc("Hindware Chimney");
		suplierDAO.addSuplier(suplier);
		
		ProductDAO productDAO=(ProductDAO)context.getBean("productDAO");
		Product product=new Product();
		product.setproductName("P1");
		product.setproductDesc("First Product");
		productDAO.addProduct(product);
				
	}
}




