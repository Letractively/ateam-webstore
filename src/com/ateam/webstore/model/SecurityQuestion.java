package com.ateam.webstore.model;

import java.io.Serializable;

import javax.jdo.annotations.PersistenceCapable;

import com.ateam.webstore.dao.common.BaseModel;

/**
 * @author Hendrix Tavarez
 *
 */
@PersistenceCapable
public class SecurityQuestion extends BaseModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3922940611332251790L;
	
	private Long id;
	
	private String question;
	
	@SuppressWarnings("unused")
	private SecurityQuestion() {
	}

	public SecurityQuestion(Long id, String question) {
		super();
		this.id = id;
		this.question = question;
	}

	public Long getId() {
		return id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

}
