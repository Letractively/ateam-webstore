/**
 * 
 */
package com.ateam.webstore.model.test;

import java.util.Collection;

import com.ateam.webstore.model.Address;
import com.ateam.webstore.model.CreditCard;
import com.ateam.webstore.model.Orders;
import com.ateam.webstore.service.impl.AddressService;
import com.ateam.webstore.service.impl.CreditCardService;
import com.ateam.webstore.service.impl.OrdersService;

/**
 * @author Hendrix Tavarez
 *
 */
public class LoadTestData {
	
	
	
	public static void main(String[] args) {
		
//		Brand brand = new Brand("Sony");
//		new BrandService().store(brand);
//		
//		Category category = new Category("Electronics");
//		new CategoryService().store(category);
//		
//		SubCategory subCategory = new SubCategory("TV");
//		subCategory.setCategory(category);
//		new SubCategoryService().store(subCategory);
//		
//		Product product = new Product("Viao", 199.99, "Sony TV");
//		product.setSKU("1SK1");
//		product.setModelNumber("1MS11");
//		product.setBrand(new BrandService().getById(new Long(100001)));
//		product.setSubCategory(new SubCategoryService().getById(new Long(1001)));
//		product.setPercentDiscount(0.10);
//		new ProductService().store(product);
		
//		Product p = new ProductService().getById(new Long(100001));
//		System.out.println(p.getProductName());
//		p.setActive(true);
//		new ProductService().store(p);
		
		
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
		
//		OrdersService ordersService = new OrdersService();
//		Collection<Orders> orders = ordersService.getAll();
//		for (Orders orders2 : orders) {
//			System.out.println(orders2.getId() + " " + orders2.hasShipped() + " " + orders2.getTrackingNumber());
//		}
		
//		Product product = new Product("Testing", 99.99, "test product");
//		product.setSKU("1998038");
//		product.setModelNumber("24SL");
//		product.setSubCategory(new SubCategoryService().getById(new Long(1001)));
//		product.setBrand(new BrandService().getById(new Long(100033)));
//		product.setPercentDiscount(9.5);
//		product.setQtyOnHand(10);
//		new ProductService().store(product);
		
		
//		CartService cartService = new CartService();
////		Cart cart = cartService.getById(new Long (100002));
//		Cart cart = cartService.getByCustomerId(new Long (100002));
//		ProductsInCart prodInCart = new ProductsInCart(1, cart, new ProductService().getById(new Long(100001)));
//		cart.addProduct(prodInCart);
//		cartService.store(cart);
		

//		ProductsInCart prodInCart = new ProductsInCart(1, cart, new ProductService().getById(new Long(100001)));
//		cart.addProduct(prodInCart);
//		cartService.store(cart);

//		Collection<ProductsInCart> productsInCart = cart.getProducts();
//		for (ProductsInCart list : productsInCart) {
//			System.out.println( list.getCart().getId() + " ** " + list.getCart().getCustomer().getId() + " ** " + list.getProduct().getProductName());
//		}
		
//		ProductService productService = new ProductService();
//		Collection<ProductListing> products = productService.searchProductsByNameOrDescription("sony");
//		for (ProductListing product : products) {
//			System.out.println(product.getProductName() + " ** " + product.getDescription());
//		}
		
//		CartService cartService = new CartService();
////	Cart cart = cartService.getById(new Long (100002));
//	Cart cart = cartService.getByCustomerId(new Long (100002));
//	System.out.println(cart.getCustomer().getPerson().getLogin());
//	ProductsInCart prodInCart = new ProductsInCart(1, cart, new ProductService().getById(new Long(100001)));
//	cart.addProduct(prodInCart);
//	cartService.store(cart);
//	
//	WishListService ws = new WishListService();
//	WishList wishList = ws.getByCustomerId(new Long(100002));
//	System.out.println(wishList.getCustomer().getPerson().getLogin());	
		
//		EmployeeService employeeServ = new EmployeeService();
//		Collection<Employee> employees = employeeServ.getAll();
//		for (Employee employee : employees) {
//			System.out.println(employee.getPerson().getLogin() + "**" + employee.getPerson().getPassword());
//		}	
		
//		Employee employee = employeeServ.authenticateEmployee("claudio@loose.com", "password");
//		System.out.println(employee.getJobTitle());
		
//		employeeServ.registerEmployee(fname, lname, email, password, securityQuestionID, securityAnswer, ssn, jobTitle, dateOfHire, deptCode, salary)
		
		
//		CategoryService catServ = new CategoryService();
//		Category category = catServ.getById(new Long(102));
//		System.out.println(category.getName());
		
//		String queryText = "SELECT * FROM PRODUCT";
//		Collection<Object> results = new HelperService().runAnyQuery(queryText);
//		for (Object columns : results) {
//			Object[] row = (Object[])columns;
//			for (Object column : row) {
//				System.out.print(column + " ");
//			}
//			System.out.println("");
//		}
		
		Collection<Address> addresses = new AddressService().getByCustomerId(new Long(100002));
		for (Address address : addresses) {
			System.out.println(address.getCity());
		}
		
		Collection<CreditCard> creditCards = new CreditCardService().getByCustomerId(new Long(100002));
		for (CreditCard creditCard : creditCards) {
			System.out.println(creditCard.getCardNumber());
		}
		
		Collection<Orders> orders = new OrdersService().getByCustomerId(new Long(100001));
		for (Orders order : orders) {
			System.out.println(order.getCreditCard().getBillingAddress().getCity());
		}
	}

}
