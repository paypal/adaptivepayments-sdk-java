package com.paypal.core;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import com.paypal.exception.ClientActionRequiredException;
import com.paypal.exception.SSLConfigurationException;
import com.paypal.exception.HttpErrorException;
import com.paypal.exception.InvalidCredentialException;
import com.paypal.exception.InvalidResponseDataException;
import com.paypal.exception.MissingCredentialException;
import com.paypal.sdk.exceptions.OAuthException;

/**
 * wrapper class for APIService.
 */
public class BaseService {

	private String serviceName;
	private String version;
	protected String accessToken = null;
	protected String tokenSecret = null;
	protected String lastRequest = null;
	protected String lastResponse = null;

	public String getLastRequest() {
		return lastRequest;
	}

	public void setLastRequest(String lastRequest) {
		this.lastRequest = lastRequest;
	}

	public String getLastResponse() {
		return lastResponse;
	}

	public void setLastResponse(String lastResponse) {
		this.lastResponse = lastResponse;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public String getTokenSecret() {
		return tokenSecret;
	}

	public void setTokenSecret(String tokenSecret) {
		this.tokenSecret = tokenSecret;
	}

	public BaseService(String serviceName, String version) {
		this.serviceName = serviceName;
		this.version = version;
	}

	public BaseService(String serviceName) {
		this.serviceName = serviceName;
	}

	/**
	 * overloaded static method used to load the configuration file.
	 * 
	 * @param is
	 */
	public static void initConfig(InputStream is) throws IOException {
		try {
			ConfigManager.getInstance().load(is);
		} catch (IOException ioe) {
			LoggingManager.debug(BaseService.class, ioe.getMessage(), ioe);
			throw ioe;
		}
	}

	/**
	 * overloaded static method used to load the configuration file
	 * 
	 * @param file
	 */
	public static void initConfig(File file) throws IOException {
		try {
			if (!file.exists()) {
				throw new FileNotFoundException("File doesn't exist: "
						+ file.getAbsolutePath());
			}
			FileInputStream fis = new FileInputStream(file);
			initConfig(fis);
		} catch (IOException ioe) {
			LoggingManager.debug(BaseService.class, ioe.getMessage(), ioe);
			throw ioe;
		}
	}

	/**
	 * overloaded static method used to load the configuration file
	 * 
	 * @param filepath
	 */
	public static void initConfig(String filepath) throws IOException {
		try {
			File file = new File(filepath);
			initConfig(file);
		} catch (IOException ioe) {
			LoggingManager.debug(BaseService.class, ioe.getMessage(), ioe);
			throw ioe;
		}
	}

	/**
	 * Wrapper call for APIservice.makeRequest(), used by InvoiceService class.
	 * 
	 * @param method
	 *            (API method)
	 * @param payload
	 *            (request parameters)
	 * @param apiUsername
	 *            (PayPal account)
	 * @param tokenSecret
	 * @param accessToken
	 * @return String response
	 * @throws HttpErrorException
	 * @throws InterruptedException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws OAuthException
	 */
	public String call(String method, String payload, String apiUsername)
			throws HttpErrorException, InterruptedException,
			InvalidResponseDataException, ClientActionRequiredException,
			MissingCredentialException, SSLConfigurationException,
			InvalidCredentialException, IOException, OAuthException {
		if (!ConfigManager.getInstance().isPropertyLoaded()) {
			throw new FileNotFoundException("Property file not loaded");
		}
		APIService apiService = new APIService(serviceName);
		lastRequest = payload;
		String response = apiService.makeRequest(method, payload, apiUsername,
				accessToken, tokenSecret);
		lastResponse = response;
		return response;
	}

	public String getServiceName() {
		return serviceName;
	}

	public String getVersion() {
		return version;
	}

}
