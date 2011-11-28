package com.ateam.webstore.handlers;

import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;

import com.ateam.webstore.model.Address;
import com.ateam.webstore.service.impl.AddressService;
import com.ateam.webstore.ui.Constants;

public class AddressHandler extends Handler {
	AddressService service;
	public AddressHandler(HttpServletRequest req) {
		super(req);
		service = new AddressService();
	}

	/**
	 * 
	 * @param id  User ID
	 * @return
	 */
	public Collection<Address> getUserAddresses(Long id) {

		
		return service.getAll();
//		// TODO Get from DB
//		
//		Collection<Address> addrs = new ArrayList<Address>();
//		
//		Address addr1 = new Address("PO Box 123","Pougheepsie","NY","12601",true, null);
//		addrs.add(addr1);
//
//		Address addr2 = new Address("2455 South Rd","Pougheepsie","NY","12466",true, null);
//		addrs.add(addr2);
//
//		
//		return addrs;
		
	}

	public Address getUserAddress(Long id, String parameter) {
		
		//TODO get from DB
		Address addr = new Address("PO Box 123","Pougheepsie","NY","12601",true, null);
		return addr;
	}
	
	/**
	 * 
	 * @return
	 */
	public Address getAddressFromRequest() {
		
		Address addr = new Address(
		req.getParameter(Constants.Parameters.ADDRESS_1.getId()),
		req.getParameter(Constants.Parameters.CITY.getId()),
		req.getParameter(Constants.Parameters.STATE.getId()),
		req.getParameter(Constants.Parameters.ZIP.getId()),
		false,
		null);
		
		return addr;

	}

}
