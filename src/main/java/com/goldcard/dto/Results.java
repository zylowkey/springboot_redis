package com.goldcard.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
@JsonRootName("result")
public class Results implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4561391011864450382L;
	@JsonProperty
	private boolean success;
	@JsonProperty
	private String message;

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
