package com.ateam.webstore.ui.views;

import java.util.Collection;

import com.ateam.webstore.model.Vendor;


public class InventorySupplierListView extends View {
	Collection<Vendor> vendor;
	String listTitle;
		
	
	public Collection<Vendor> getVendor() {
		return vendor;
	}

	public void setVendor(Collection<Vendor> vendor) {
		this.vendor = vendor;
	}

	
	public InventorySupplierListView(View v) {
		super(v);
	}
	
	public String getListTitle() {
		return listTitle;
	}

	public void setListTitle(String listTitle) {
		this.listTitle = listTitle;
	}

	

	
}
