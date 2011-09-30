package com.paypal.core;

import com.paypal.exception.MissingCredentialException;

public class SignatureCredential extends ICredential {

	private String signature;

	public SignatureCredential(String userName, String password,
			String signature, String appId) throws MissingCredentialException {
		this.signature = signature;
		setUserName(userName);
		setPassword(password);
		setApplicationId(appId);
		this.validate();
	}

	public void validate() throws MissingCredentialException {
		if (getUserName() == null || getUserName() == "") {
			throw new MissingCredentialException("username can't be empty");
		}
		if (getPassword() == null || getPassword() == "") {
			throw new MissingCredentialException("password can't be empty");
		}
		if (this.signature == null || this.signature == "") {
			throw new MissingCredentialException("signature can't be empty");
		}
		if (getApplicationId() == null || getApplicationId() == "") {
			throw new MissingCredentialException("applicationId can't be empty");
		}
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

}
