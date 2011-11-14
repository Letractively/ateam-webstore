/**
 * 
 */
package com.ateam.webstore.model.test;

import com.ateam.webstore.model.Customer;
import com.ateam.webstore.model.Person;
import com.ateam.webstore.service.impl.CustomerService;
import com.ateam.webstore.service.impl.PersonService;

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

		
		CustomerService cs = new CustomerService();
		Customer customer = cs.authenticateCustomer("valerie@pou.com", "password");
		System.out.println(customer.getFirstName());
		
		
	}

}
