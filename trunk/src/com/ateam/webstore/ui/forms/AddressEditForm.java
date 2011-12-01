package com.ateam.webstore.ui.forms;

import com.ateam.webstore.model.Address;

public class AddressEditForm extends FormSubmission {

	private String streetAddress1;
	
	private String streetAddress2;
	
	private String city;
	
	private String state;
	
	private String zip;
	
	private String plusFour;
	
	private String phone;

	public String getStreetAddress1() {
		return streetAddress1;
	}

	public void setStreetAddress1(String streetAddress1) {
		this.streetAddress1 = streetAddress1;
	}

	public String getStreetAddress2() {
		return streetAddress2;
	}

	public void setStreetAddress2(String streetAddress2) {
		this.streetAddress2 = streetAddress2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getPlusFour() {
		return plusFour;
	}

	public void setPlusFour(String plusFour) {
		this.plusFour = plusFour;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public boolean isValid() {
		if (!validString(streetAddress1)) {
			resultMessage = "Street address is required";
		}
		else if (!validString(city)) {
			resultMessage = "City is required";
		}
		else if (!validString(state)) {
			resultMessage = "State is required";
		}
		else if (!validString(zip)) {
			resultMessage = "Zip is required";
		}
		
		return true;

	}
	
	
}
