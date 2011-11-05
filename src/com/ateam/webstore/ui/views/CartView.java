package com.ateam.webstore.ui.views;

import java.util.Collection;

import com.ateam.webstore.ui.models.ProductInCart;

public class CartView extends View{
private static final long serialVersionUID = 6996210412301012927L;
	
Collection<ProductInCart> productincart;
String listTitle;

public CartView(View v) {
	super(v);
}
public Collection<ProductInCart> getProducts() {
	return productincart;
}

public void setProducts(Collection<ProductInCart> productincart) {
	this.productincart = productincart;
}


	

}
