/**
 * 
 */
package com.ateam.webstore.model;

import java.io.Serializable;

import javax.jdo.annotations.PersistenceCapable;

import com.ateam.webstore.dao.common.BaseModel;

/**
 * @author Hendrix Tavarez
 *
 */
@PersistenceCapable
public class ProductQtyAtVendor extends BaseModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6996210412301012927L;
	
	private Long id;
	
	private String vendorSKU;
	
	private int qtyAvailable;
	
	private Product product;
	
	private Vendor vendor;
	
	@SuppressWarnings("unused")
	private ProductQtyAtVendor() {
	}

	public ProductQtyAtVendor(String vendorSKU, int qtyAvailable,
			Product product, Vendor vendor) {
		super();
		this.vendorSKU = vendorSKU;
		this.qtyAvailable = qtyAvailable;
		this.product = product;
		this.vendor = vendor;
	}

	public String getVendorSKU() {
		return vendorSKU;
	}

	public void setVendorSKU(String vendorSKU) {
		this.vendorSKU = vendorSKU;
	}

	public int getQtyAvailable() {
		return qtyAvailable;
	}

	public void setQtyAvailable(int qtyAvailable) {
		this.qtyAvailable = qtyAvailable;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Vendor getVendor() {
		return vendor;
	}

	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
	}

	public Long getId() {
		return id;
	}
	
	

}
