package com.paypal.core;

import com.paypal.exception.MissingCredentialException;

public abstract class ICredential {

	private String applicationId;
	private String userName;
	private String password;

	protected abstract void validate() throws MissingCredentialException;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(String applicationId) {
		this.applicationId = applicationId;
	}
}
