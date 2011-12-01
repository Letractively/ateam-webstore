package com.ateam.webstore.handlers;

import java.util.Collection;
import java.util.logging.Level;

import javax.servlet.http.HttpServletRequest;

import com.ateam.webstore.model.Address;
import com.ateam.webstore.service.impl.AddressService;
import com.ateam.webstore.ui.Constants;
import com.ateam.webstore.ui.forms.AddressEditForm;
import com.ateam.webstore.ui.forms.FormSubmission;
import com.ateam.webstore.ui.models.Visitor;
import com.ateam.webstore.ui.views.AddressView;
import com.ateam.webstore.ui.views.View.Contexts;

public class AddressHandler extends Handler {
	AddressService service;
	Address addr;
	public AddressHandler(HttpServletRequest req) {
		super(req);
		service = new AddressService();
	}

	/**
	 * 
	 * @param id  User ID
	 * @return
	 */
	public Collection<Address> getUserAddresses() {

		Visitor v = (Visitor) req.getSession().getAttribute(SESSION_ATTRIBUTE_VISITOR);
		
		return service.getByCustomerId(v.getCustomer().getId());
		
	}

	public Address getUserAddress() {
		
		Long id = Long.parseLong(req.getParameter(Parameters.ADDRESS.getId()));
		l.fine("get user addr id:"+id);
		//Address addr = new Address("PO Box 123","Pougheepsie","NY","12601",true, null);
		
		return service.getById(id);
	}
	
//	/**
//	 * 
//	 * @return
//	 */
//	public Address getAddressFromRequest() {
//		
//		Address addr = new Address(
//		req.getParameter(Constants.Parameters.ADDRESS_1.getId()),
//		req.getParameter(Constants.Parameters.CITY.getId()),
//		req.getParameter(Constants.Parameters.STATE.getId()),
//		req.getParameter(Constants.Parameters.ZIP.getId()),false,
//		null);
//		
//		return addr;
//
//	}
	
	/**
	 * 
	 * @return
	 */
	public AddressEditForm getAddressFromRequest() {
		
		AddressEditForm ade = new AddressEditForm();

		ade.setStreetAddress1(req.getParameter(Constants.Parameters.ADDRESS_1.getId()));
		ade.setStreetAddress2(req.getParameter(Constants.Parameters.ADDRESS_2.getId()));
		ade.setCity(req.getParameter(Constants.Parameters.CITY.getId()));
		ade.setState(req.getParameter(Constants.Parameters.STATE.getId()));
		ade.setZip(req.getParameter(Constants.Parameters.ZIP.getId()));
		
		return ade;

	}
	
	public AddressView getAddressView(Address addr) {
		AddressView addrv = new AddressView();
		
		addrv.setAddress(addr);
		
		return addrv;
	}

	/**
	 * 
	 * @return
	 */
	public FormSubmission processAddAddressRequest() {
		
		//Get the form data 
		AddressEditForm ade = getAddressFromRequest();
		
		//Validate and add address
		if (ade.isValid()) try {
			Visitor v = (Visitor) req.getSession().getAttribute(SESSION_ATTRIBUTE_VISITOR);
			addr = new Address(ade.getStreetAddress1(), ade.getCity(), ade.getState(), ade.getZip(), false, v.getCustomer().getPerson());
			addr = service.store(addr);
		} catch (Exception e) {
			l.log(Level.WARNING, "Failed to store addr", e);
			ade.setResultMessage("Could not store address");
		}
		
		String context = req.getParameter(Parameters.CONTEXT.getId());
		l.info("context="+context);
		
		if (context != null && context.equals(Contexts.ORDER_SHIPPING.getId())) {
			OrderHandler oh = new OrderHandler(req);
			ade.setResultView(oh.getOrderShippingView());
			return ade;
		}
//		else if (context != null && context.equals(Contexts.ORDER_PAYMENT.getId())) {
//			OrderHandler oh = new OrderHandler(req);
//			return oh.processOrderAddCardRequest();
//		}
		else {
			ade.setResultView(getAddressView(addr));
		}
		
		return ade;
	}

	public Address getAddr() {
		return addr;
	}

	public void setAddr(Address addr) {
		this.addr = addr;
	}

}
