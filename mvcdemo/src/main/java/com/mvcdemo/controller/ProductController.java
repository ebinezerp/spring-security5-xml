package com.mvcdemo.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.niit.dao.CategoryDAO;
import com.niit.dao.ProductDAO;
import com.niit.dao.SuplierDAO;
import com.niit.model.Category;
import com.niit.model.Product;


//import com.niit.model.Suplier;

@Controller
public class ProductController 
{

	
	@Autowired
	CategoryDAO categoryDAO;
	
	boolean flag = true;
	
	@Autowired
	ProductDAO productDAO;
	
	@Autowired
	SuplierDAO suplierDAO;
	
	@RequestMapping("/product")
	public String showProductPage(Model m)
	{
		Product product=new Product();
		m.addAttribute("product",product);
		List<Product> listProducts = productDAO.getProducts();
		m.addAttribute("listProducts", listProducts);
		//m.addAttribute("suplist",this.listSupplier());
		m.addAttribute("catlist", categoryDAO.getCategories());
		for (Product nproduct : productDAO.getProducts()) {
			System.out.println(nproduct.getproductName() + ",");
		}
		return "Product";	
	}
	
	
	@RequestMapping(value="/InsertProduct",method=RequestMethod.POST)
	public String addProduct(@ModelAttribute("product")Product product,Model m,@RequestParam(value="pimage")MultipartFile filedet)
	{
		if(filedet==null) {
			System.out.println("error");
		}
		Product product1=new Product();
		m.addAttribute(product1);
		//product.setSuplierId(1);
		productDAO.addProduct(product);
		
		//===> Image Uploading
		String imagePath="C:\\Users\\Admin\\project1\\mvcdemo\\src\\main\\webapp\\resources\\images\\";
		imagePath=imagePath+String.valueOf(product.getproductId())+".jpg";
		File image=new File(imagePath);
		
		if(!filedet.isEmpty())
		{
			
			try 
			{
				byte[] fileBuffer=filedet.getBytes();	
				FileOutputStream fos=new FileOutputStream(image);
				BufferedOutputStream bs=new BufferedOutputStream(fos);
				bs.write(fileBuffer);
				bs.close();
			} catch (Exception e)
			{
				System.out.println("Exception Arised:"+e);
				e.printStackTrace();
			}
			
		}
		else
		{
			System.out.println("Problem Occured in File Uploading");
		}
		
		//==>End of Image Uploading
		
		
		m.addAttribute("catlist",this.listCategories());
		//m.addAttribute("suplist",this.listSupplier());
		return "Product";	
	}
	public LinkedHashMap<Integer,String> listCategories()
	{
		List<Category> listCategories=categoryDAO.getCategories();
		LinkedHashMap<Integer,String> catlist=new LinkedHashMap<Integer,String>();
		for(Category category:listCategories)
		{
			catlist.put(category.getCategoryId(),category.getCategoryName());
		}
		return catlist;
	}
	
	/*public LinkedHashMap<Integer,String> listSupplier()
	{
		List<Suplier> listsuplier=suplierDAO.getsupliers();
		LinkedHashMap<Integer,String> suplist=new LinkedHashMap<Integer,String>();
		for(Suplier suplier:listsuplier)
		{
			suplist.put(suplier.getsuplierId(),suplier.getsuplierName());
		}
		return suplist;
	}
	*/
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
	}
	private Object listCategories() {
		return null;
	}
*/


	@RequestMapping(value="/productPage",method=RequestMethod.GET)
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

