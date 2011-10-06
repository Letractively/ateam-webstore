package com.ateam.webstore.ui;


public interface Constants {
	
	/**
	 * Form/URL Parameters
	 */
	public enum Parameters {
		PRODUCT_ID ("productId"),
		EMAIL ("email"),
		FORM_ID ("formId"),
		PASSWORD ("pw"),
		CART ("card");
		
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
	 * 
	 * @author bdrew
	 *
	 */
	public enum Forms {
		LOGIN ("login"),
		REQISTER ("register");
		
		String id;
		String handler;
		
		Forms (String id) {
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
	public static final String SESSION_ATTRIBUTE_USER_AUTH = "userAuth";
	public static final String SESSION_ATTRIBUTE_CART = "cart";
	
	/**
	 * Request Attributes
	 */
	public static final String REQUEST_ATTRIBUTE_VIEW = "view";
	
}
