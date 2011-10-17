package com.ateam.webstore.ui;


public interface Constants {
	
	/**
	 * URL Parameters
	 */
	public enum Parameters {
		PRODUCT_ID ("productId"),
		EMAIL ("email"),
		LOGIN ("login"),
		LOGOUT ("logout"),
		FORM_ID ("formId"),
		PASSWORD ("pw"),
		CART_ID ("card"), 
		WISHLIST ("wishList"),
		REGISTER ("register"),
		CHECKOUT ("checkout"),
		ORDER_ID ("order"),
		CATEGORY_ID ("category");
		
		String id;
		Parameters (String id) {
            this.id = id;
		}
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
	}
	
	/**
	 * Form IDs
	 * @author bdrew
	 *
	 */
	public enum FormName {
		LOGIN ("login"),
		REGISTER ("register"),
		EDIT_CART ("editCart"),
		ORDER_SHIPPING ("orderShipper"),
		ORDER_PAYMENT ("orderShipper"),
		ORDER_CONFIRM ("orderShipper");
		
		String id;
		String handler;
		
		FormName (String id) {
            this.id = id;
		}
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
	}

	
	/**
	 * Session Attributes
	 */
	public static final String SESSION_ATTRIBUTE_VISITOR = "visitor";
	public static final String SESSION_ATTRIBUTE_CART = "cart";
	public static final String SESSION_ATTRIBUTE_ORDER = "order";
	
	/**
	 * Request Attributes
	 */
	public static final String REQUEST_ATTRIBUTE_VIEW = "view";
	
	/**
	 * JSPs
	 */
	public static final String JSP_MAIN = "/main.jsp";
	public static final String JSP_LOGIN = "/login.jsp";
	public static final String JSP_HOME = "/home.jsp";
	public static final String JSP_PRODUCT_DETAILS = "/prdouctDetails.jsp";
	public static final String JSP_ORDER_CONFIRMATION = "/orderConfirmation.jsp";
	public static final String JSP_ORDER_DETAILS = "/orderDetails.jsp";
	public static final String JSP_ORDER_PAYMENT = "/orderPayment.jsp";
	public static final String JSP_ORDER_PREVIEW = "/orderPreview.jsp";
	public static final String JSP_ORDER_SHIPPING = "/orderShipping.jsp";
	
}
