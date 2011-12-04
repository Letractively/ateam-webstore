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
		EMPLOGIN("emplogin"),
		EMPPASSWORD("emppassword"),
		EMPCONFIRMPASSWORD("empconfirmpassword"),
		EMPFIRSTNAME("empfirstname"),
		EMPLASTNAME("emplastname"),
		EMPLOYEE("employee"),
		LOGOUT ("logout"),
		FORGOT ("forgot"),
		FORM_ID ("formId"),
		CONTEXT ("context"),
		PASSWORD ("pw"),
		REMEMBER_ME ("remember"),
		CONFIRMPASSWORD ("cpw"),
		CART_ID ("cart"), 
		CART_ACTION ("cartAction"),
		VIEW_CART ("viewCart"),
		CARD_ID ("card"),
		ADDRESS ("address"),
		WISHLIST ("wishList"),
		REGISTER ("register"),
		REMOVE ("remove"),
		CHECKOUT ("checkout"),
		PRODUCTSELECT ("ps"),
		PRODUCT ("product"),
		PRODUCT_ACTION ("productAction"),
		PRODUCT_DESC ("productDesc"),
		PRODUCT_PRICE ("productPrice"),
		PRODUCT_DISCOUNT ("productDiscount"),
		PRODUCT_QUANTITY ("productQty"),
		ON_SALE ("onSale"),
		ACTIVE ("active"),
		ALL_PRODUCTS ("products"),
		FEEDBACK ("customerFeedback"),
		ALL_EMPLOYEES ("employees"),
		ADD_EMPLOYEE ("addEmployee"),
		ALL_ORDERS ("orders"),
		OPEN_ORDERS ("openOrders"),
		ORDER_ID ("order"),
		ORDER_CONFIRM ("orderConfirm"),
		TRACKING_NUMBER ("trackingNumber"),
		CATEGORY_ID ("category"),
		SECURITY_QUESTION ("sq"),
		ROLE ("role"),
		SECURITY_ANSWER ("sa"),
		SHIPPING_CODE ("shippingCode"),
		CARD_NAME ("cardName"),
		CARD_TYPE ("cardType"),
		CARD_ACCOUNT_NUMBER ("cardAcctNum"),
		CARD_EXPIRATION_MONTH ("cardExpMo"),
		CARD_EXPIRATION_YEAR ("cardExpYr"),
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
		ZIP ("zip"),
		REDIRECT ("redirect"),
		SEARCH_QUERY ("query"),
		MY_ACCOUNT ("myAccount"),
		MESSAGE ("message")
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
		SEARCH ("search"),
		EDIT_CART ("editCart"),
		FORGOT_PASSWORD ("forgotPw"),
		ORDER_SHIPPING ("orderShipping"),
		ORDER_PAYMENT ("orderPayment"),
		ORDER_CONFIRM ("orderConfirm"),
		ORDER_UPDATE ("orderUpdate"),
		ORDER_CANCEL ("orderCancel"),
		ADDRESS ("address"),
		CREDIT_CARD ("creditCard"),
		ADD_TO_CART ("addToCart"),
		ADD_TO_WISHLIST ("addToWishList"),
		WISHLIST_TO_CART ("wishListToCart"),
		EDIT_PRODUCT ("editProduct"),
		DELETE_PRODUCT ("deleteProduct"),
		DELETE_EMPLOYEE ("deleteEmployee"),
		CUSTOMER_FEEDBACK ("customerFeedback")
		;
		
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
	public static final String SESSION_ATTRIBUTE_USER_NAME = "userName";
	public static final String SESSION_ATTRIBUTE_VISITOR = "visitor";
	public static final String SESSION_ATTRIBUTE_CART = "cart";
	public static final String SESSION_ATTRIBUTE_ORDER = "order";
	public static final String SESSION_ATTRIBUTE_ORDERED_ITEMS = "orderedItems";
	public static final String SESSION_ATTRIBUTE_PRODUCT_TO_CART = "prodToWishList";
	public static final String SESSION_ATTRIBUTE_PRODUCT_TO_WISHLIST = "prodToWishList";
	
	/**
	 * Request Attributes
	 */
	public static final String REQUEST_ATTRIBUTE_VIEW = "view";
	public static final String REQUEST_ATTRIBUTE_CONTEXT = "context";
	
	/**
	 * JSPs
	 */
	public static final String JSP_MAIN = "/main.jsp";
	public static final String JSP_MESSAGE = "/message.jsp";
	public static final String JSP_ERROR = "/error.jsp";
	public static final String JSP_ADMIN_MAIN = "/adminMain.jsp";
	public static final String JSP_ADMIN_HOME = "/adminHome.jsp";
	public static final String JSP_EMPLOYEE_DETAILS = "/employeeDetails.jsp";
	public static final String JSP_EMPLOYEE_LIST = "/adminEmployeeList.jsp";
	public static final String JSP_LOGIN = "/login.jsp";
	public static final String JSP_REGISTRATION = "/registration.jsp";
	public static final String JSP_HOME = "/home.jsp";
	public static final String JSP_PRODUCT_DETAILS = "/productDetails.jsp";
	public static final String JSP_PRODUCT_LIST = "/productList.jsp";
	public static final String JSP_PRODUCT_LISTING = "/productListing.jsp";
	public static final String JSP_ADMIN_PRODUCT_LIST = "/adminProductList.jsp";
	public static final String JSP_ADMIN_PRODUCT_DETAILS = "/adminProductDetails.jsp";
	public static final String JSP_ORDER_CONFIRMATION = "/orderConfirmation.jsp";
	public static final String JSP_ORDER_DETAILS = "/orderDetails.jsp";
	public static final String JSP_ADMIN_ORDER_DETAILS = "/adminOrderDetails.jsp";
	public static final String JSP_ORDER_PAYMENT = "/orderPayment.jsp";
	public static final String JSP_ORDER_SHIPPING = "/orderShipping.jsp";
	public static final String JSP_ORDER_LIST = "/orderList.jsp";
	public static final String JSP_ADDRESS = "/address.jsp";
	public static final String JSP_CREDIT_CARD = "/creditCard.jsp";
	public static final String JSP_CART = "/cart.jsp";
	public static final String JSP_WISHLIST = "/wishList.jsp";
	public static final String JSP_MY_ACCOUNT = "/myAccount.jsp";
	public static final String JSP_CUSTOMER_FEEDBACK = "/customerFeedback.jsp";
	public static final String JSP_FORGOT_PASSWORD = "/forgotPassword.jsp";

	//Properties
	public static final String PROPERTY_PRODUCT_IMAGE_ROOT =  "com.ateam.webstore.ui.ProductImageRoot";
	
}