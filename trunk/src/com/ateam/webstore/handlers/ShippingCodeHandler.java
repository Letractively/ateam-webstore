package com.ateam.webstore.handlers;

import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;

import com.ateam.webstore.model.ShippingCode;
import com.ateam.webstore.service.impl.ShippingCodeService;

public class ShippingCodeHandler extends Handler {
	ShippingCodeService service;
	
	public ShippingCodeHandler(HttpServletRequest req) {
		super(req);
		service = new ShippingCodeService();
	}

	/**
	 * 
	 * @return
	 */
	public Collection<ShippingCode> getShippingCodes() {
//		Collection<ShippingCode> codes = new ArrayList<ShippingCode>();
//		
//		ShippingCode code1 = new ShippingCode(1, "UPS Ground", null);
//		codes.add(code1);
//		ShippingCode code2 = new ShippingCode(2, "UPS Next Day", null);
//		codes.add(code2);
		return service.getAll();
	}

	/**
	 * 
	 * @param parseInt
	 * @return
	 */
	public ShippingCode getShippingCode() {
		
		Long id = Long.parseLong(req.getParameter(Parameters.SHIPPING_CODE.getId()));
		
		l.fine("get shipping code id:"+id);
		//ShippingCode code = new ShippingCode(2, "UPS Next Day", null);
		
		return service.getById(id);
	}

}
