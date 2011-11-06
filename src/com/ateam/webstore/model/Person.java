package com.ateam.webstore.model;

import java.io.Serializable;

import javax.jdo.annotations.PersistenceCapable;

import com.ateam.webstore.dao.common.BaseModel;

/**
 * @author Hendrix Tavarez
 *
 */
@PersistenceCapable
public class Person extends BaseModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1315549039228014475L;
	
	private Long id;
	
	private String login;
	
	private String password;
	
	private SecurityQuestion securityQuestion;
	
	private String securityAnswer;
	
	@SuppressWarnings("unused")
	private Person() {
	}
	
	public Person(String login, String password, SecurityQuestion securityQuestion, String securityAnswer) {
		super();
		this.login = login;
		this.password = password;
		this.securityQuestion = securityQuestion;
		this.securityAnswer = securityAnswer;
	}

	public Long getId() {
		return id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public SecurityQuestion getSecurityQuestion() {
		return securityQuestion;
	}

	public void setSecurityQuestion(SecurityQuestion securityQuestion) {
		this.securityQuestion = securityQuestion;
	}

	public String getSecurityAnswer() {
		return securityAnswer;
	}

	public void setSecurityAnswer(String securityAnswer) {
		this.securityAnswer = securityAnswer;
	}
	
	

}
