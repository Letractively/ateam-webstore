package com.ateam.webstore.servlets;

import javax.servlet.http.HttpServletRequest;

import com.ateam.webstore.ui.forms.FormSubmission;
import com.ateam.webstore.ui.forms.OrderPaymentForm;
import com.ateam.webstore.ui.forms.OrderShippingForm;
import com.ateam.webstore.ui.views.OrderDetailsView;
import com.ateam.webstore.ui.views.OrderPaymentView;
import com.ateam.webstore.ui.views.OrderShippingView;

/**
 * Handles the order process.  The 'current' order is the Orders object found in the session associated to the request.
 * @author Brendon Drew
 *
 */
public class OrderHandler extends Handler {

	public OrderHandler(HttpServletRequest req) {
		super(req);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Get Order Details from DB
	 * @param req
	 * @return
	 */
	private Object getOrderDetails(HttpServletRequest req) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public OrderShippingView getOrderShippingView() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public OrderPaymentView getOrderPaymentView() {
		// TODO Auto-generated method stub
		return null;
	}

	
	public OrderDetailsView getOrderPreView() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public OrderDetailsView getOrderDetailsView(String id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public OrderDetailsView submit() {
		// TODO Auto-generated method stub
		return null;
	}

	public OrderPaymentForm getOrderPaymentRequest() {
		// TODO Auto-generated method stub
		return null;
	}

	public OrderShippingForm getOrderShipppingRequest() {
		// TODO Auto-generated method stub
		return null;
	}

	public FormSubmission getOrderConfirmationRequest() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Adds the shipping options to the current order.
	 * @param submission
	 * @return
	 */
	public FormSubmission processOrderShipppingRequest() {
		OrderShippingForm osf = getOrderShipppingRequest();
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Submits the oder.
	 * @param submission
	 * @return
	 */
	public FormSubmission processOrderConfirmationRequest() {
		
		FormSubmission submission = getOrderConfirmationRequest();
				
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Adds the payment options to the current order.
	 * @param submission
	 * @return
	 */
	public FormSubmission processOrderPaymentRequest() {
		OrderPaymentForm osf = getOrderPaymentRequest();
		// TODO Auto-generated method stub
		return null;
	}
}
