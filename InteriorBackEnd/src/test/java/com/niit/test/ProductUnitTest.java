package com.niit.test;
import org.junit.BeforeClass;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.ProductDAO;


public class ProductUnitTest 
{
	static ProductDAO productDAO;

	@SuppressWarnings("resource")
	@BeforeClass
	public static void executeFirst()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		productDAO=(ProductDAO)context.getBean("productDAO");
	}
	
	/*@Test
	public void addProductTest()
	{
		Product product=new Product();
		product.setproductName("Book Cupboard");
		product.setproductDesc("All the Book Cupboard Types");
		assertTrue("Problem in Category Insertion",productDAO.addProduct(product));
		
		product.setproductName("Cupboard");
		product.setproductDesc("All the Cupboard Types");
		assertTrue("Problem in Category Insertion",productDAO.addProduct(product));
		
		product.setproductName("Board");
		product.setproductDesc("All the Board Types");
		assertTrue("Problem in Category Insertion",productDAO.addProduct(product));
	}
*/
	/*
	@Test
	public void getProductTest()
	{
		assertNotNull("Problem in get Category",productDAO.getProduct(1));
	}
	
	
	@Test
	public void deleteProductTest()
	{
		Product product=productDAO.getProduct(5);
		assertTrue("Problem in Deletion:",productDAO.deleteProduct(product));
	}

	
	@Test
	public void updateCategoryTest()
	{
		Product product=productDAO.getProduct(4);
		product.setproductName("L Sofa Model");
		assertTrue("Problem in Updation",productDAO.updateProduct(product));
	}
	
	@Test
	public void listProductsTest()
	{
		List<Product> listProducts=productDAO.getProducts();
		assertNotNull("No Products",listProducts);
		
		for(Product product:listProducts)
		{
			System.out.print(product.getproductId()+":::");
			System.out.print(product.getproductName()+":::");
			System.out.println(product.getproductDesc());
		}
	}
*/
}

