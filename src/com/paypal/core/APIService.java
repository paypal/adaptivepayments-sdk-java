package com.paypal.core;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;

import com.paypal.exception.ClientActionRequiredException;
import com.paypal.exception.SSLConfigurationException;
import com.paypal.exception.HttpErrorException;
import com.paypal.exception.InvalidCredentialException;
import com.paypal.exception.InvalidResponseDataException;
import com.paypal.exception.MissingCredentialException;
import com.paypal.sdk.exceptions.OAuthException;

/**
 * Wrapper class for api calls
 * 
 */
public class APIService {

	private String serviceName;
	private String endPoint;
	private String serviceBinding;
	private ConfigManager config = null;
	private HttpConfiguration httpConfiguration = new HttpConfiguration();
	private Map<String, String> headers = new HashMap<String, String>();

	/**
	 * Set all the http related parameters from the config file
	 * 
	 * @param serviceName
	 * @throws SSLConfigurationException
	 * @throws NumberFormatException
	 */
	public APIService(String serviceName) throws NumberFormatException {
		this.serviceName = serviceName;
		config = ConfigManager.getInstance();
		endPoint = config.getValue("service.EndPoint");
		serviceBinding = config.getValue("service.Binding");
		httpConfiguration.setTrustAll(Boolean.parseBoolean(config
				.getValue("http.TrustAllConnection")));

		httpConfiguration.setGoogleAppEngine(Boolean.parseBoolean(config.getValue("http.GoogleAppEngine")));
		
		try {
			if (Boolean.parseBoolean(config.getValue("http.UseProxy"))) {
				httpConfiguration.setProxyPort(Integer.parseInt(config
						.getValue("http.ProxyPort")));
				httpConfiguration.setProxyHost(config
						.getValue("http.ProxyHost"));
				httpConfiguration.setProxyUserName(config
						.getValue("http.ProxyUserName"));
				httpConfiguration.setProxyPassword(config
						.getValue("http.ProxyPassword"));
			}
			httpConfiguration.setConnectionTimeout(Integer.parseInt(config
					.getValue("http.ConnectionTimeOut")));
			httpConfiguration.setMaxRetry(Integer.parseInt(config
					.getValue("http.Retry")));
			httpConfiguration.setReadTimeout(Integer.parseInt(config
					.getValue("http.ReadTimeOut")));
			httpConfiguration.setMaxHttpConnection(Integer.parseInt(config
					.getValue("http.MaxConnection")));
		} catch (NumberFormatException nfe) {
			LoggingManager.debug(APIService.class, nfe.getMessage());
			throw nfe;
		}
	}

	/**
	 * makes a request to specified end point.
	 * 
	 * @param apiMethod
	 *            (WSDL API operation name that user wants to call)
	 * @param payload
	 *            (request parameters)
	 * @param apiUsername
	 *            (PayPal account)
	 * @param tokenSecret
	 * @param accessToken
	 * @return response String
	 * @throws HttpErrorException
	 * @throws InterruptedException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws IOException
	 * @throws OAuthException
	 */
	public String makeRequest(String apiMethod, String payload,
			String apiUsername, String accessToken, String tokenSecret)
			throws HttpErrorException, InterruptedException,
			InvalidResponseDataException, ClientActionRequiredException,
			MissingCredentialException, SSLConfigurationException,
			InvalidCredentialException, IOException, OAuthException {

		LoggingManager.info(APIService.class, payload);
		ConnectionManager connectionMgr = ConnectionManager.getInstance();
		HttpConnection connection = connectionMgr.getConnection(httpConfiguration);
		String url = Constants.EMPTY_STRING;

		if (serviceBinding.equalsIgnoreCase(Constants.SOAP)) {
			url = endPoint;
		} else {
			url = endPoint + serviceName + '/' + apiMethod;
		}
		httpConfiguration.setEndPointUrl(url);
		AuthenticationService auth = new AuthenticationService();
		try {

			headers = auth.getPayPalHeaders(apiUsername, connection,
					accessToken, tokenSecret, httpConfiguration);
			connection.CreateAndconfigureHttpConnection(httpConfiguration);

		} catch (SSLConfigurationException ssl) {
			LoggingManager.severe(APIService.class, ssl.getMessage());
			throw ssl;
		} catch (MissingCredentialException mis) {
			LoggingManager.severe(APIService.class, mis.getMessage());
			throw mis;
		} catch (InvalidCredentialException ivl) {
			LoggingManager.severe(APIService.class, ivl.getMessage());
			throw ivl;
		} catch (OAuthException oauth) {
			LoggingManager.severe(APIService.class, oauth.getMessage());
			throw oauth;
		} catch (MalformedURLException me) {
			LoggingManager.severe(APIService.class, me.getMessage());
			throw me;
		} catch (IOException ioe) {
			LoggingManager.severe(APIService.class, ioe.getMessage());
			throw ioe;
		}

		String response = Constants.EMPTY_STRING;
		try {
			if (serviceBinding.equalsIgnoreCase(Constants.SOAP)) {
				String soapPayload = auth.appendSoapHeader(payload,
						accessToken, tokenSecret);
				response = connection.execute(url, soapPayload, headers);

			} else {
				response = connection.execute(url, payload, headers);
			}

		} catch (MissingCredentialException mis) {
			LoggingManager.severe(APIService.class, mis.getMessage());
			throw mis;
		} catch (InvalidCredentialException ivl) {
			LoggingManager.severe(APIService.class, ivl.getMessage());
			throw ivl;
		} catch (ClientActionRequiredException car) {
			LoggingManager.severe(APIService.class, car.getMessage());
			throw car;
		} catch (InterruptedException ie) {
			LoggingManager.severe(APIService.class, ie.getMessage());
			throw ie;
		} catch (InvalidResponseDataException inv) {
			LoggingManager.severe(APIService.class, inv.getMessage());
			throw inv;
		} catch (IOException ioe) {
			LoggingManager.severe(APIService.class, ioe.getMessage());
			throw ioe;
		} catch (HttpErrorException htr) {
			LoggingManager.severe(APIService.class, htr.getMessage());
			throw htr;
		}

		LoggingManager.info(APIService.class, response);
		return response;

	}

	public String getServiceName() {
		return serviceName;
	}

	public String getEndPoint() {
		return endPoint;
	}

}
