package com.paypal.core;

import com.paypal.exception.MissingCredentialException;

/**
 * 
 * Wrapper class for Certificate credentials.
 */
public class CertificateCredential extends ICredential {
	private static final long serialVersionUID = -5489365713654987523L;
	private String certificatePath;
	private String certificateKey;

	public CertificateCredential(String userName, String password,
			String certificate, String certificateKey, String appId)
			throws MissingCredentialException {
		this.certificatePath = certificate;
		this.certificateKey = certificateKey;
		setUserName(userName);
		setPassword(password);
		setApplicationId(appId);
		this.validate();
	}

	public void validate() throws MissingCredentialException {
		if (getUserName() == null || getUserName() == "") {
			throw new MissingCredentialException("username can't be empty");
		}
		if (this.certificatePath == null || this.certificatePath == "") {
			throw new MissingCredentialException("certificatePath can't be empty");
		}
		if (this.certificateKey == null || this.certificateKey == "") {
			throw new MissingCredentialException(
					"certificateKey can't be empty");
		}
		if (getPassword() == null || getPassword() == "") {
			throw new MissingCredentialException("password can't be empty");
		}
		if (getApplicationId() == null || getApplicationId() == "") {
			throw new MissingCredentialException("applicationId can't be empty");
		}
	}

	public String getCertificatePath() {
		return certificatePath;
	}

	public void setCertificatePath(String certificatePath) {
		this.certificatePath = certificatePath;
	}

	public String getCertificateKey() {
		return certificateKey;
	}

	public void setCertificateKey(String certificateKey) {
		this.certificateKey = certificateKey;
	}

}
