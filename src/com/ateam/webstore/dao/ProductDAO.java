package com.ateam.webstore.dao;

import java.io.Serializable;
import java.util.Collection;

import javax.jdo.Query;

import com.ateam.webstore.dao.common.GenericDAOImpl;
import com.ateam.webstore.model.Product;
import com.ateam.webstore.model.ProductListing;

public class ProductDAO extends GenericDAOImpl<Product, Serializable>{
	
	@SuppressWarnings("unchecked")
	public Collection<Product> getProductByName(String name) {
		
		Collection<Product> products = null;
		
		try {
			Query query = getPersistenceManager().newQuery(getPersistentClass(), "productName == :name");
			products = (Collection<Product>) query.execute(name);
			
			return (Collection<Product>) getPersistenceManager().detachCopyAll(products);
			
		} catch (RuntimeException re) {
			throw re;
		} finally {
			getPersistenceManager().close();
		}
	}
	
	@SuppressWarnings("unchecked")
	public Collection<Product> getFeaturedProducts() {
		
		Collection<Product> products = null;
		
		try {
			Query query = getPersistenceManager().newQuery(getPersistentClass(), "saleInd == 'T'");
			query.setRange(0, 6); // returns the top 6 records
			products = (Collection<Product>) query.execute();
			
			return (Collection<Product>) getPersistenceManager().detachCopyAll(products);
			
		} catch (RuntimeException re) {
			throw re;
		} finally {
			getPersistenceManager().close();
		}
	}	
	
	@SuppressWarnings("unchecked")
	public Collection<ProductListing> getProductsByCategory(Serializable categoryId) {
				
		try {
			String sqlText = "SELECT A.productId, A.productName, A.sku, A.modelNumber, A.price, A.percentDiscount"
					+ ", A.description, A.qtyOnHand, A.imagePath, A.firstOffered, A.saleInd, A.lastUpdated "
					+ "FROM PRODUCT A INNER JOIN (SELECT X.subcategoryID FROM SUBCATEGORY X INNER JOIN CATEGORY Y ON X.categoryID = Y.categoryID AND Y.categoryID = ?) B "
					+ " ON A.subcategoryID = B.subcategoryID ";      
		    	      
			Query query = getPersistenceManager().newQuery("javax.jdo.query.SQL", sqlText);
			query.setResultClass(ProductListing.class);
		    	      
			return (Collection<ProductListing>) query.execute(categoryId);	
			
		} catch (RuntimeException re) {
			throw re;
		} finally {
			getPersistenceManager().close();
		}
	}		

}
