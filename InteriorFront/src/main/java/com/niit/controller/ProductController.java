package com.niit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.dao.CategoryDAO;
import com.niit.dao.ProductDAO;
import com.niit.model.Category;
import com.niit.model.Product;

@Controller
public class ProductController 
{
	@Autowired
	CategoryDAO categoryDAO;
	
	boolean flag = true;
	
	@Autowired
	ProductDAO productDAO;
	
	@RequestMapping("/product")
	public String showProductPage(Model m)
	{
		Product product=new Product();
		m.addAttribute("product",product);
		List<Product> listProducts = productDAO.getProducts();
		m.addAttribute("listProducts", listProducts);
		for (Product nproduct : productDAO.getProducts()) {
			System.out.println(nproduct.getproductName() + ",");
		}
		return "Product";	
	}
	
	@RequestMapping(value = "/InsertProduct", method = RequestMethod.POST)
	public String insertProductData(@ModelAttribute("product")Product product,Model m) {
		productDAO.addProduct(product);
		List<Product> listProducts = productDAO.getProducts();
		m.addAttribute("listProducts", listProducts);
		flag = false;
		return "Product";
	}
	
	@RequestMapping(value = "/deleteProduct/{product}", method = RequestMethod.GET)
	public String deleteProduct(@PathVariable("product") int product,Model m)
	{
		
		productDAO.deleteProduct(productDAO.getProduct(product));
		List<Product> listProducts=productDAO.getProducts();
		m.addAttribute("listProduct",listProducts);
		m.addAttribute("product", new Product());
		flag=false;
		return "Product";
	}

	
	
	/*@RequestMapping(value = "/updateProduct/{pid}", method = RequestMethod.GET)
	public String updateProductcall(@PathVariable("pid") int prodId,Model m)
	{
		Product product=productDAO.getProduct(prodId);
		
		
		
		List<Product> listProducts=productDAO.getProducts();
		m.addAttribute("listProducts",listProducts);
		m.addAttribute("product",product);
		return "Product";
	}
	*/
	
	/*@RequestMapping(value = "/updateProduct/InsertProduct", method = RequestMethod.POST)
	public String updateProductpost(@ModelAttribute("product")Product product,Model m)
	{
		
		try {
		if(productDAO.updateProduct(product))
		{
		List<Product> listProducts=productDAO.getProducts();
		m.addAttribute("listProducts",listProducts);
		m.addAttribute("product",new Product());
		}
		else
		{
			System.out.println("\n\n\n\n\n\n\\t\t\terror");
			
		}
		}
		catch(Exception ex){
			System.out.println("ex here="+ex);
		}
		return "Product";
	}*/

	private Object listCategories() {
		return null;
	}


	@RequestMapping(value="/productpage",method=RequestMethod.GET)
	public String showProductsPage(Model m)
	{
		List<Product> listProducts=productDAO.getProducts();
		m.addAttribute("listProducts",listProducts);
		return "ProductPage";
	}
	
	
	@RequestMapping(value="/productDesc/{productId}",method=RequestMethod.GET)
	public String showProductDesc(@PathVariable("productId")int productId,Model m)
	{
		Product product=productDAO.getProduct(productId);
		String categoryName=categoryDAO.getCategory(product.getCategoryId()).getCategoryName();
		m.addAttribute("ProductInfo",product);
		m.addAttribute("categoryName",categoryName);
		return "ProductDesc";
	}
}

