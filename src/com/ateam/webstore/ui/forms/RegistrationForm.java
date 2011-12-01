package com.ateam.webstore.ui.forms;


public class RegistrationForm extends FormSubmission {
	String firstName = "";
	String lastName = "";
	String email = "";
	String pw = "";
	String cpw = "";
	String securityQuestionId = ""; 
	String securityAnswer = "";

	public String getSecurityQuestionId() {
		return securityQuestionId;
	}
	
	public Long getSecurityQuestionIdLong() {
		return Long.parseLong(securityQuestionId);
	}

	public void setSecurityQuestionId(String securityQuestionId) {
		this.securityQuestionId = securityQuestionId;
	}

	public String getSecurityAnswer() {
		return securityAnswer;
	}

	public void setSecurityAnswer(String securityAnswer) {
		this.securityAnswer = securityAnswer;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	@Override
	public boolean isValid() {
		
		if (!validString(firstName)) {
			resultMessage = "First Name is required.";
			return false;
		}
		else if (!validString(lastName)) {
			resultMessage = "Last Name is required.";
			return false;
		}
		else if (!validString(email)) {
			resultMessage = "Email is required.";
			return false;
		}
		else if (!validString(pw)) {
			resultMessage = "A password is required.";
			return false;
		}
		else if (!validString(cpw)) {
			resultMessage = "Please confirm your password.";
			return false;
		}
		else if (!pw.equals(cpw)) {
			resultMessage = "Passwords do not match.";
			return false;
		}
		else if (!validLong(securityQuestionId)) {
			resultMessage = "Please select a security question";
			return false;
		}
		else if (!validString(securityAnswer)) {
			resultMessage = "Please answer the security question";
			return false;
		}
		return true;
	}

	public String getCpw() {
		return cpw;
	}

	public void setCpw(String cpw) {
		this.cpw = cpw;
	}


}
