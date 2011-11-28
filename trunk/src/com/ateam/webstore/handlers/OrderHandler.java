package com.ateam.webstore.handlers;

import javax.servlet.http.HttpServletRequest;

import com.ateam.webstore.model.Address;
import com.ateam.webstore.model.Orders;
import com.ateam.webstore.model.ShippingCode;
import com.ateam.webstore.service.impl.OrdersService;
import com.ateam.webstore.ui.Constants;
import com.ateam.webstore.ui.forms.FormSubmission;
import com.ateam.webstore.ui.forms.OrderPaymentForm;
import com.ateam.webstore.ui.forms.OrderShippingForm;
import com.ateam.webstore.ui.models.Visitor;
import com.ateam.webstore.ui.views.ContentView;
import com.ateam.webstore.ui.views.OrderDetailsView;
import com.ateam.webstore.ui.views.OrderListView;
import com.ateam.webstore.ui.views.OrderPaymentView;
import com.ateam.webstore.ui.views.OrderShippingView;
import com.ateam.webstore.ui.views.View;

/**
 * Handles the order process.  The 'current' order is the Orders object found in the session associated to the request.
 * @author Brendon Drew
 *
 */
public class OrderHandler extends Handler {
	OrdersService service;
	/**
	 * 
	 * @param req
	 */
	public OrderHandler(HttpServletRequest req) {
		super(req);
		service = new OrdersService();
	}
	
	/**
	 * Get and Order from the DB
	 * @param id The Order ID
	 * @return
	 */
	private Orders getOrder() {
		String orderId = req.getParameter(Parameters.ORDER_ID.getId());
		return service.getById(new Long(orderId));
	}
	
	/**
	 * Collects the data needed to display the order shipping options
	 * @param custId
	 * @return
	 */
	public OrderShippingView getOrderShippingView(Long custId) {

		OrderShippingView osv = new OrderShippingView(getMainView());

		AddressHandler ah = new AddressHandler(req);
		osv.setUserAddresses(ah.getUserAddresses(custId));

		ShippingCodeHandler sch = new ShippingCodeHandler(req);
		osv.setShippers(sch.getShippingCodes());
		
		osv.addContentView(new ContentView(Constants.JSP_ORDER_SHIPPING, "Shipping Options"));
		osv.addContentView(new ContentView(Constants.JSP_ADDRESS, "Add New Shipping Address"));
		
		return osv;
		
	}
	
	/**
	 * Collects the data needed to display payment options to the user.
	 * @return
	 */
	public OrderPaymentView getOrderPaymentView() {
		OrderPaymentView opv = new OrderPaymentView(getMainView());
		
		CreditCardHandler cch = new CreditCardHandler(req);
		
		opv.setUserCards(cch.getUsersCards());
		
		opv.addContentView(new ContentView(Constants.JSP_ORDER_PAYMENT, "Payment Options"));
		opv.addContentView(new ContentView(Constants.JSP_CREDIT_CARD, "Add New Credit Card"));

		return opv;
	}

	/**
	 * Gets the order from the session.
	 * @return
	 */
	public OrderDetailsView getOrderPreView() {
		OrderDetailsView odv = new OrderDetailsView(getMainView());
		
		odv.setOrder((Orders) req.getSession().getAttribute(SESSION_ATTRIBUTE_ORDER));
		odv.addContentView(new ContentView(JSP_ORDER_DETAILS, "Preview Your Order"));
		
		return odv;
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	public OrderDetailsView getOrderDetailsView() {

		OrderDetailsView odv = new OrderDetailsView(getMainView());
		
		Orders order = getOrder();
		odv.setOrder(order);
		
		odv.addContentView(new ContentView(JSP_ORDER_DETAILS, "Order "+order.getId()));
		
		return odv;
	}
	
	
	/**
	 * 
	 * @return
	 */
	public OrderDetailsView submit() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Retrieve payment options from the submitted form
	 * @return
	 */
	public OrderPaymentForm getOrderPaymentRequest() {
		
		OrderPaymentForm opf = new OrderPaymentForm();
		
		CreditCardHandler cch = new CreditCardHandler(req);
		
		
		//TODO Get the card ID from the request
		
		opf.setCard(cch.getUsersCard(0));
		
		opf.setResultView(getOrderDetailsView());
		return opf;
	}

	/**
	 * Retrieve shipping options from the submitted form
	 * @return
	 */
	public OrderShippingForm getOrderShippingRequest() {
		OrderShippingForm osf = new OrderShippingForm();
		
		Visitor visitor = (Visitor) req.getSession().getAttribute(SESSION_ATTRIBUTE_VISITOR);
		
		AddressHandler ah = new AddressHandler(req);
		Address addr = ah.getUserAddress(visitor.getCustomer().getId(), req.getParameter(Constants.Parameters.ADDRESS_1.getId()));
		osf.setAddress(addr);
		
		
		ShippingCodeHandler sch = new ShippingCodeHandler(req);

		ShippingCode shippingCode = sch.getShippingCode(Integer.parseInt(req.getParameter(Constants.Parameters.SHIPPING_CODE.getId())));
		osf.setShippingCode(shippingCode);
		
		return osf;
	}

	/**
	 * Adds the shipping options to the current order.
	 * Builds the new view to display.
	 * 
	 * @param submission
	 * @return
	 */
	public FormSubmission processOrderShipppingRequest() {
		
		l.finer("->");
		OrderShippingForm osf = getOrderShippingRequest();
		
		Orders order = (Orders) req.getSession().getAttribute(SESSION_ATTRIBUTE_ORDER);
		
		order.setShippingCode(osf.getShippingCode());
		order.setAddress(osf.getAddress());

		//FormSubmission fs = new FormSubmission();
		osf.setSuccess(true);
		osf.setResultView(getOrderPaymentView());
		
		l.finer("<-");
		return osf;
	}

	/**
	 * Submits the oder.
	 * @param submission
	 * @return
	 */
	public FormSubmission processOrderConfirmationRequest() {
		
		FormSubmission submission = new FormSubmission();
				
		// TODO Auto-generated method stub
		return submission;
	}

	/**
	 * Adds the payment options to the current order.
	 * @param submission
	 * @return
	 */
	public FormSubmission processOrderPaymentRequest() {
		OrderPaymentForm opf = getOrderPaymentRequest();

		Orders order = (Orders) req.getSession().getAttribute(SESSION_ATTRIBUTE_ORDER);
		
		order.setCreditCard(opf.getCard());
		
		opf.setSuccess(true);
		opf.setResultView(getOrderPreView());
		
		return opf;
	}

	public OrderListView getAllView(boolean admin) {
		
		View main = null;
		
		if (admin) {
			main = getMainAdminView();
		} else {
			main = getMainView();
		}

		OrderListView olv = new OrderListView(main);
		olv.setOrders(service.getAll());
		
		olv.addContentView(new ContentView(JSP_ORDER_LIST, "All Orders"));
		return olv;
	}

	public OrderDetailsView getAdminOrderDetailsView() {
		OrderDetailsView odv = new OrderDetailsView(getMainAdminView());
		
		Orders order = getOrder();
		odv.setOrder(order);
		
		odv.addContentView(new ContentView(JSP_ADMIN_ORDER_DETAILS, "Order "+order.getId()));
		
		return odv;
	}
}
