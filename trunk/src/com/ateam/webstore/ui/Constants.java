package com.ateam.webstore.ui;


public interface Constants {
	
	/**
	 * URL Parameters
	 */
	public enum Parameters {
		PRODUCT_ID ("productId"),
		EMAIL ("email"),
		LOGIN ("login"),
		FORM_ID ("formId"),
		PASSWORD ("pw"),
		CART ("card"), 
		WISHLIST ("wishList"),
		REGISTER ("register"),
		ORDER ("order"),
		CATEGORY ("category");
		
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
		REGISTER ("register");
		
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
	
}
