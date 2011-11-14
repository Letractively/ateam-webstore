package com.ateam.webstore.ui;


public interface Constants {
	
	
	public static final String LOGGER_NAME = "ateam";
	
	/**
	 * URL Parameters
	 */
	public enum Parameters {
		PRODUCT_ID ("productId"),
		EMAIL ("email"),
		LOGIN ("login"),
		LOGOUT ("logout"),
		FORGOT ("forgot"),
		FORM_ID ("formId"),
		PASSWORD ("pw"),
		REMEMBER_ME ("remember"),
		CONFIRMPASSWORD ("cpw"),
		CART_ID ("cart"), 
		CARD_ID ("card"),
		ADDRESS ("address"),
		WISHLIST ("wishList"),
		REGISTER ("register"),
		CHECKOUT ("checkout"),
		PRODUCTSELECT ("ps"),
		PRODUCT ("product"),
		ALL_PRODUCTS ("products"),
		ORDER_ID ("order"),
		CATEGORY_ID ("category"),
		SECURITY_QUESTION ("sq"),
		SECURITY_ANSWER ("sa"),
		SHIPPING_CODE ("shippingCode"),
		CARD_NAME ("cardName"),
		CARD_TYPE ("cardType"),
		CARD_ACCOUNT_NUMBER ("cardAcctNum"),
		CARD_EXPIRATION ("cardExp"),
		CARD_SECURITY_CODE ("cardCode"),
		USE_SHIPPING ("useShipping"),
		NAME ("name"),
		FIRST_NAME ("firstName"),
		LAST_NAME ("lastName"),
		ADDRESS_1 ("addr1"),
		ADDRESS_2 ("addr2"),
		ACTION("action"),
		CITY ("city"),
		STATE ("state"),
		ZIP ("zip")
		
		;
		
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
		ORDER_SHIPPING ("orderShipping"),
		ORDER_PAYMENT ("orderPayment"),
		ORDER_CONFIRM ("orderConfirm"),
		ADDRESS ("address"),
		CREDIT_CARD ("creditCard"),
		ADD_TO_CART ("addToCart"),
		ADD_TO_WISHLIST ("addToWishList");
		
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
	public static final String JSP_MESSAGE = "/message.jsp";
	public static final String JSP_ERROR = "/error.jsp";
	public static final String JSP_ADMIN_MAIN = "/adminMain.jsp";
	public static final String JSP_LOGIN = "/login.jsp";
	public static final String JSP_REGISTRATION = "/registration.jsp";
	public static final String JSP_HOME = "/home.jsp";
	public static final String JSP_PRODUCT_DETAILS = "/productDetails.jsp";
	public static final String JSP_PRODUCT_LIST = "/productList.jsp";
	public static final String JSP_ORDER_CONFIRMATION = "/orderConfirmation.jsp";
	public static final String JSP_ORDER_DETAILS = "/orderDetails.jsp";
	public static final String JSP_ORDER_PAYMENT = "/orderPayment.jsp";
	public static final String JSP_ORDER_SHIPPING = "/orderShipping.jsp";
	public static final String JSP_ADDRESS = "/address.jsp";
	public static final String JSP_CREDIT_CARD = "/creditCard.jsp";
	public static final String JSP_CART = "/cart.jsp";
	public static final String JSP_WISHLIST = "/wishList.jsp";

	//Properties
	public static final String PROPERTY_PRODUCT_IMAGE_ROOT =  "com.ateam.webstore.ui.ProductImageRoot";
	
}
