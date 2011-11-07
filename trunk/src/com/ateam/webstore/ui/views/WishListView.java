package com.ateam.webstore.ui.views;

import java.util.Collection;

import com.ateam.webstore.model.ProductsInWishList;
import com.ateam.webstore.model.WishList;

public class WishListView extends View {
	WishList wishList;

	Collection<ProductsInWishList> productsInWishList;
	
	public WishListView(View v) {
		super(v);
	}

	public WishList getWishList() {
		return wishList;
	}

	public void setWishList(WishList wishList) {
		this.wishList = wishList;
	}

	public Collection<ProductsInWishList> getProductsInWishList() {
		return productsInWishList;
	}

	public void setProductsInWishList(
			Collection<ProductsInWishList> productsInWishList) {
		this.productsInWishList = productsInWishList;
	}
}
