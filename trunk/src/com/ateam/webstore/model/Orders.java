/**
 * 
 */
package com.ateam.webstore.model;

import java.io.Serializable;
import java.util.Date;

import javax.jdo.annotations.PersistenceCapable;

import com.ateam.webstore.dao.common.BaseModel;

/**
 * @author Hendrix Tavarez
 *
 */
@PersistenceCapable
public class Orders extends BaseModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -42150248692474387L;
	
	private Long id;
	
	private int numOfItems;
	
	private Double itemSubTotal;
	
	private Double shippingTotal;
	
	private Double salesTax;
	
	private Date timePlaced;
	
	private Date timeShipped;
	
	private String trackingNumber;
	
	private String transactNumber;
	
	private boolean returnInd;
	
	private Customer customer;
	
	private Address address;
	
	private CreditCard creditCard;
	
	private ShippingCode shippingCode;
		
	@SuppressWarnings("unused")
	private Orders() {
	}

	public Orders(int numOfItems, Double itemSubTotal, Double shippingTotal,
			Double salesTax, Customer customer, Address address,
			CreditCard creditCard, ShippingCode shippingCode) {
		super();
		this.numOfItems = numOfItems;
		this.itemSubTotal = itemSubTotal;
		this.shippingTotal = shippingTotal;
		this.salesTax = salesTax;
		this.customer = customer;
		this.address = address;
		this.creditCard = creditCard;
		this.shippingCode = shippingCode;
	}

	public int getNumOfItems() {
		return numOfItems;
	}

	public void setNumOfItems(int numOfItems) {
		this.numOfItems = numOfItems;
	}

	public Double getItemSubTotal() {
		return itemSubTotal;
	}

	public void setItemSubTotal(Double itemSubTotal) {
		this.itemSubTotal = itemSubTotal;
	}

	public Double getShippingTotal() {
		return shippingTotal;
	}

	public void setShippingTotal(Double shippingTotal) {
		this.shippingTotal = shippingTotal;
	}

	public Double getSalesTax() {
		return salesTax;
	}

	public void setSalesTax(Double salesTax) {
		this.salesTax = salesTax;
	}

	public Date getTimePlaced() {
		return timePlaced;
	}

	public void setTimePlaced(Date timePlaced) {
		this.timePlaced = timePlaced;
	}

	public Date getTimeShipped() {
		return timeShipped;
	}

	public void setTimeShipped(Date timeShipped) {
		this.timeShipped = timeShipped;
	}

	public String getTrackingNumber() {
		return trackingNumber;
	}

	public void setTrackingNumber(String trackingNumber) {
		this.trackingNumber = trackingNumber;
	}

	public String getTransactNumber() {
		return transactNumber;
	}

	public void setTransactNumber(String transactNumber) {
		this.transactNumber = transactNumber;
	}

	public boolean isReturnInd() {
		return returnInd;
	}

	public void setReturnInd(boolean returnInd) {
		this.returnInd = returnInd;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public CreditCard getCreditCard() {
		return creditCard;
	}

	public void setCreditCard(CreditCard creditCard) {
		this.creditCard = creditCard;
	}

	public ShippingCode getShippingCode() {
		return shippingCode;
	}

	public void setShippingCode(ShippingCode shippingCode) {
		this.shippingCode = shippingCode;
	}

	public Long getId() {
		return id;
	}
	
	
	

}
