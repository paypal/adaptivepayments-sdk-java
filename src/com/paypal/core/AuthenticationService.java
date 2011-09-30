/**
 * 
 */
package com.paypal.core;

import java.util.HashMap;
import java.util.Map;

import com.paypal.exception.InvalidCredentialException;
import com.paypal.exception.MissingCredentialException;
import com.paypal.exception.SSLConfigurationException;
import com.paypal.sdk.exceptions.OAuthException;
import com.paypal.sdk.util.OAuthSignature;

/**
 * @author lvairamani
 * 
 */
public class AuthenticationService {
	private Map<String, String> headers = new HashMap<String, String>();
	ICredential apiCred = null;
	CredentialManager cred = null;
	private String authString = Constants.EMPTY_STRING;
	ConfigManager config = null;

	/**
	 * @param apiUsername
	 * @param connection
	 * @param accessToken
	 * @param tokenSecret
	 * @param config
	 * @return
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws MissingCredentialException
	 * @throws OAuthException
	 */
	public Map<String, String> getPayPalHeaders(String apiUsername,
			HttpConnection connection, String accessToken, String tokenSecret,
			HttpConfiguration httpConfiguration)
			throws SSLConfigurationException, InvalidCredentialException,
			MissingCredentialException, OAuthException {
		cred = CredentialManager.getInstance();
		apiCred = cred.getCredentialObject(apiUsername);
		config = ConfigManager.getInstance();
		/* Add headers required for service authentication */
		if ((Constants.EMPTY_STRING != accessToken && accessToken != null)
				&& (Constants.EMPTY_STRING != tokenSecret && tokenSecret != null)) {
			authString = generateAuthString(apiCred, accessToken, tokenSecret,
					httpConfiguration.getEndPointUrl());
			headers.put("X-PAYPAL-AUTHORIZATION", authString);
			connection.setDefaultSSL(true);
			connection.setupClientSSL(null, null,
					httpConfiguration.isTrustAll());
		} else if (apiCred instanceof SignatureCredential) {
			headers.put("X-PAYPAL-SECURITY-USERID",
					((SignatureCredential) apiCred).getUserName());
			headers.put("X-PAYPAL-SECURITY-PASSWORD",
					((SignatureCredential) apiCred).getPassword());
			headers.put("X-PAYPAL-SECURITY-SIGNATURE",
					((SignatureCredential) apiCred).getSignature());
			connection.setDefaultSSL(true);
			connection.setupClientSSL(null, null,
					httpConfiguration.isTrustAll());
		} else if (apiCred instanceof CertificateCredential) {
			connection.setDefaultSSL(false);
			headers.put("X-PAYPAL-SECURITY-USERID",
					((CertificateCredential) apiCred).getUserName());
			headers.put("X-PAYPAL-SECURITY-PASSWORD",
					((CertificateCredential) apiCred).getPassword());
			connection.setupClientSSL(
					((CertificateCredential) apiCred).getCertificatePath(),
					((CertificateCredential) apiCred).getCertificateKey(),
					httpConfiguration.isTrustAll());
		}

		/* Add other headers */
		headers.put("X-PAYPAL-APPLICATION-ID", apiCred.getApplicationId());
		headers.put("X-PAYPAL-REQUEST-DATA-FORMAT",
				config.getValue("service.Binding"));
		headers.put("X-PAYPAL-RESPONSE-DATA-FORMAT",
				config.getValue("service.Binding"));
		headers.put("X-PAYPAL-DEVICE-IPADDRESS",
				httpConfiguration.getIpAddress());
		if (httpConfiguration.getEndPointUrl().contains("sandbox")) {
			headers.put("X-PAYPAL-SANDBOX-EMAIL-ADDRESS",
					Constants.SANDBOX_EMAIL_ADDRESS);
		}

		return headers;

	}

	public String appendSoapHeader(String payload, String accessToken,
			String tokenSecret) throws InvalidCredentialException,
			MissingCredentialException {

		StringBuffer soapMsg = new StringBuffer(
				"<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:urn=\"urn:ebay:api:PayPalAPI\" xmlns:ebl=\"urn:ebay:apis:eBLBaseComponents\" xmlns:cc=\"urn:ebay:apis:CoreComponentTypes\" xmlns:ed=\"urn:ebay:apis:EnhancedDataTypes\">");
		if ((Constants.EMPTY_STRING != accessToken && accessToken != null)
				&& (Constants.EMPTY_STRING != tokenSecret && tokenSecret != null)) {
			soapMsg.append("<soapenv:Header>");
			soapMsg.append("<urn:RequesterCredentials/>");
			soapMsg.append("</soapenv:Header>");
		} else if (apiCred instanceof SignatureCredential) {
			soapMsg.append("<soapenv:Header>");
			soapMsg.append("<urn:RequesterCredentials>");
			soapMsg.append("<ebl:Credentials>");
			soapMsg.append("<ebl:Username>"
					+ ((SignatureCredential) apiCred).getUserName()
					+ "</ebl:Username>");
			soapMsg.append("<ebl:Password>"
					+ ((SignatureCredential) apiCred).getPassword()
					+ "</ebl:Password>");
			soapMsg.append("<ebl:Signature>"
					+ ((SignatureCredential) apiCred).getSignature()
					+ "</ebl:Signature>");
			soapMsg.append("</ebl:Credentials>");
			soapMsg.append("</urn:RequesterCredentials>");
			soapMsg.append("</soapenv:Header>");
		} else if (apiCred instanceof CertificateCredential) {
			soapMsg.append("<soapenv:Header>");
			soapMsg.append("<urn:RequesterCredentials>");
			soapMsg.append("<ebl:Credentials>");
			soapMsg.append("<ebl:Username>"
					+ ((CertificateCredential) apiCred).getUserName()
					+ "</ebl:Username>");
			soapMsg.append("<ebl:Password>"
					+ ((CertificateCredential) apiCred).getPassword()
					+ "</ebl:Password>");
			soapMsg.append("</ebl:Credentials>");
			soapMsg.append("</urn:RequesterCredentials>");
			soapMsg.append("</soapenv:Header>");
		}

		soapMsg.append("<soapenv:Body>");
		soapMsg.append(payload);
		soapMsg.append("</soapenv:Body>");
		soapMsg.append("</soapenv:Envelope>");
		LoggingManager.info(AuthenticationService.class, soapMsg.toString());
		return soapMsg.toString();
	}

	private String generateAuthString(ICredential apiCred, String accessToken,
			String tokenSecret, String endPoint) throws OAuthException {

		authString = OAuthSignature.getFullAuthString(apiCred.getUserName(),
				apiCred.getPassword(), accessToken, tokenSecret,
				OAuthSignature.HTTPMethod.POST, endPoint, null);
		return authString;
	}
}
