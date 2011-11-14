/**
 * 
 */
package com.ateam.webstore.model.test;

import java.util.Collection;

import com.ateam.webstore.model.Orders;
import com.ateam.webstore.service.impl.OrdersService;

/**
 * @author Hendrix Tavarez
 *
 */
public class LoadTestData {
	
	
	
	public static void main(String[] args) {
//		
//		Brand brand = new Brand("Sony");
//		new BrandService().store(brand);
		
//		ProductService prodService = new ProductService();
//		Collection<Product> products = prodService.getAll();		
//		for (Product product : products) {			
//			System.out.println(product.getProductName() + " " + product.getSubCategory().getSubcategoryName());			
//		}
		
		
//		CustomerService custService = new CustomerService();
//		Collection<Customer> customers = custService.getAll();
//		for (Customer customer : customers) {
//			System.out.println(customer.getPerson().getSecurityQuestion().getId());
//		}
		
//		System.out.println((new SecurityQuestionService().getById(new Long(22))).getQuestion());

		
//		CustomerService cs = new CustomerService();
//		Customer customer = cs.authenticateCustomer("valerie@pou.com", "password");
//		System.out.println(customer.getFirstName());
		
//		ProductService prodServ = new ProductService();
//		Collection<Product> products = prodServ.getFeaturedProducts();
//		for (Product product : products) {
//			System.out.println(product.getProductName());
//		}
		
//		CategoryService catServ = new CategoryService();
//		Collection<Category> categories = catServ.getAll();
//		for (Category category : categories) {
//			System.out.println(category.getName());
//			Collection<SubCategory> subCategories = category.getSubCategories();
//			for (SubCategory subCategory : subCategories) {
//				System.out.println(subCategory.getSubcategoryName());
//			}
//		}
		
		
//		SubCategoryService subCatServ = new SubCategoryService();
//		Collection<SubCategory> subCategories = subCatServ.getAll();
//		for (SubCategory subCategory : subCategories) {
//			System.out.println(subCategory.getSubcategoryName());
//			Collection<Product> products = subCategory.getProducts();
//			for (Product product : products) {
//				System.out.println(product.getProductName());
//			}			
//		}
		
//		ProductService productService = new ProductService();
//		Collection<Product> products = productService.getProductsBySubCategory(new Long(12));
//		for (Product product : products) {
//			System.out.println(product.getProductName());
//		}
		
//		CategoryService categoryService = new CategoryService();
//		Category category = categoryService.getById(new Long(102));
//		Collection<SubCategory> subCategories = category.getSubCategories();
//		for (SubCategory subCategory : subCategories) {
//			Collection<Product> products = subCategory.getProducts();
//			for (Product product : products) {
//				System.out.println(subCategory.getSubcategoryName() + " ** " + product.getProductName());
//			}
//		}
		
//		ProductService productService = new ProductService();
//		Collection<ProductListing> products = productService.getProductsByCategory(new Long(102));
//		for (ProductListing product : products) {
//			System.out.println(product.getProductName());
//		}
		
		OrdersService ordersService = new OrdersService();
		Collection<Orders> orders = ordersService.getAll();
		for (Orders orders2 : orders) {
			System.out.println(orders2.getId() + " " + orders2.getTransactNumber() + " " + orders2.getTrackingNumber());
		}
	}

}
