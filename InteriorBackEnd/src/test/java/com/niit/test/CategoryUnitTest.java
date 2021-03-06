package com.niit.test;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.CategoryDAO;
import com.niit.model.Category;

public class CategoryUnitTest 
{
	static CategoryDAO categoryDAO;

	@SuppressWarnings("resource")
	@BeforeClass
	public static void executeFirst()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		categoryDAO=(CategoryDAO)context.getBean("categoryDAO");
	}
	
	@Test
	public void addCategoryTest()
	{
		Category category=new Category();
		category.setCategoryName("Book Cupboard");
		category.setCateogryDesc("All the Book Cupboard Types");
		assertTrue("Problem in Category Insertion",categoryDAO.addCategory(category));
		
		category.setCategoryName("Cupboard");
		category.setCateogryDesc("All the Cupboard Types");
		assertTrue("Problem in Category Insertion",categoryDAO.addCategory(category));
		
		category.setCategoryName("Board");
		category.setCateogryDesc("All the Board Types");
		assertTrue("Problem in Category Insertion",categoryDAO.addCategory(category));
	}

	/*	
	@Test
	public void getCategoryTest()
	{
		assertNotNull("Problem in get Category",categoryDAO.getCategory(1));
	}
	
	
	@Test
	public void deleteCategoryTest()
	{
		Category category=categoryDAO.getCategory(5);
		assertTrue("Problem in Deletion:",categoryDAO.deleteCategory(category));
	}

	
	@Test
	public void updateCategoryTest()
	{
		Category category=categoryDAO.getCategory(4);
		category.setCategoryName("L Sofa Model");
		assertTrue("Problem in Updation",categoryDAO.updateCategory(category));
	}
	
	
	@Test
	public void listCategoriesTest()
	{
		List<Category> listCategories=categoryDAO.getCategories();
		assertNotNull("No Categories",listCategories);
		
		for(Category category:listCategories)
		{
			System.out.print(category.getCategoryId()+":::");
			System.out.print(category.getCategoryName()+":::");
			System.out.println(category.getCateogryDesc());
		}
	}
	
	*/
}

