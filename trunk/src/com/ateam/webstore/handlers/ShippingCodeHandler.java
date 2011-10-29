package com.ateam.webstore.handlers;

import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;

import com.ateam.webstore.model.ShippingCode;

public class ShippingCodeHandler extends Handler {

	public ShippingCodeHandler(HttpServletRequest req) {
		super(req);
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 * @return
	 */
	public Collection<ShippingCode> getShippingCodes() {

		
		// TODO Get from DB
		
		Collection<ShippingCode> codes = new ArrayList<ShippingCode>();
		
		ShippingCode code1 = new ShippingCode(1, "UPS Ground", null);
		codes.add(code1);
		ShippingCode code2 = new ShippingCode(2, "UPS Next Day", null);
		codes.add(code2);
		
		
		return codes;
	}

	/**
	 * 
	 * @param parseInt
	 * @return
	 */
	public ShippingCode getShippingCode(int parseInt) {
		ShippingCode code = new ShippingCode(2, "UPS Next Day", null);
		
		return code;
	}

}
