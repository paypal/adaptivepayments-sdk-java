package com.paypal.svcs.services;
import java.io.*;
import java.util.Map;
import java.util.Properties;
import com.paypal.core.BaseService;
import com.paypal.exception.*;
import com.paypal.core.credential.ICredential;
import com.paypal.core.APICallPreHandler;
import com.paypal.core.NVPUtil;
import com.paypal.core.nvp.PlatformAPICallPreHandler;
import com.paypal.svcs.types.ap.CancelPreapprovalRequest;
import com.paypal.svcs.types.ap.CancelPreapprovalResponse;
import com.paypal.svcs.types.ap.ConfirmPreapprovalRequest;
import com.paypal.svcs.types.ap.ConfirmPreapprovalResponse;
import com.paypal.svcs.types.ap.ConvertCurrencyRequest;
import com.paypal.svcs.types.ap.ConvertCurrencyResponse;
import com.paypal.svcs.types.ap.ExecutePaymentRequest;
import com.paypal.svcs.types.ap.ExecutePaymentResponse;
import com.paypal.svcs.types.ap.GetAllowedFundingSourcesRequest;
import com.paypal.svcs.types.ap.GetAllowedFundingSourcesResponse;
import com.paypal.svcs.types.ap.GetPaymentOptionsRequest;
import com.paypal.svcs.types.ap.GetPaymentOptionsResponse;
import com.paypal.svcs.types.ap.PaymentDetailsRequest;
import com.paypal.svcs.types.ap.PaymentDetailsResponse;
import com.paypal.svcs.types.ap.PayRequest;
import com.paypal.svcs.types.ap.PayResponse;
import com.paypal.svcs.types.ap.PreapprovalDetailsRequest;
import com.paypal.svcs.types.ap.PreapprovalDetailsResponse;
import com.paypal.svcs.types.ap.PreapprovalRequest;
import com.paypal.svcs.types.ap.PreapprovalResponse;
import com.paypal.svcs.types.ap.RefundRequest;
import com.paypal.svcs.types.ap.RefundResponse;
import com.paypal.svcs.types.ap.SetPaymentOptionsRequest;
import com.paypal.svcs.types.ap.SetPaymentOptionsResponse;
import com.paypal.svcs.types.ap.GetFundingPlansRequest;
import com.paypal.svcs.types.ap.GetFundingPlansResponse;
import com.paypal.svcs.types.ap.GetAvailableShippingAddressesRequest;
import com.paypal.svcs.types.ap.GetAvailableShippingAddressesResponse;
import com.paypal.svcs.types.ap.GetShippingAddressesRequest;
import com.paypal.svcs.types.ap.GetShippingAddressesResponse;
import com.paypal.svcs.types.ap.GetUserLimitsRequest;
import com.paypal.svcs.types.ap.GetUserLimitsResponse;
import com.paypal.svcs.types.ap.GetPrePaymentDisclosureRequest;
import com.paypal.svcs.types.ap.GetPrePaymentDisclosureResponse;
import com.paypal.sdk.exceptions.OAuthException;

public class AdaptivePaymentsService extends BaseService {


	// Service Version
	public static final String SERVICE_VERSION = "1.8.6";

	// Service Name
	public static final String SERVICE_NAME = "AdaptivePayments";

	//SDK Name
	private static final String SDK_NAME = "adaptivepayments-java-sdk";
	
	//SDK Version
	private static final String SDK_VERSION = "2.6.110";


	/**
	 * Default <code>AdaptivePaymentsService</code> Constructor.
	 * Initializes the SDK system with the default configuration file named
	 * 'sdk_config.properties' found in the class-path
	 * 
	 */
	public AdaptivePaymentsService() {
		super();
	}
	
	/**
	 * <code>AdaptivePaymentsService</code> that uses the supplied path
	 * to initialize the SDK system. The initialization context is maintained
	 * only for this instance of the class. To initialize the SDK system
	 * globally use the default constructor.
	 * 
	 * @see PayPalAPIInterfaceServiceService
	 * @param configFilePath
	 *            Absolute path to a {@link Properties} file
	 * @throws IOException
	 */
	public AdaptivePaymentsService(String configFilePath) throws IOException {
		this(new File(configFilePath));
	}
	
	/**
	 * <code>AdaptivePaymentsService</code> that uses the supplied
	 * {@link File} object to initialize the SDK system. The initialization
	 * context is maintained only for this instance of the class. To initialize
	 * the SDK system globally use the default constructor
	 * 
	 * @see PayPalAPIInterfaceServiceService
	 * @param configFile
	 *            Configuration file in {@link Properties} format
	 * @throws IOException
	 */
	public AdaptivePaymentsService(File configFile) throws IOException {
		this(new FileInputStream(configFile));
	}		

	/**
	 * <code>AdaptivePaymentsService</code> that uses the supplied
	 * {@link InputStream} object to initialize the SDK system. The
	 * initialization context is maintained only for this instance of the class.
	 * To initialize the SDK system globally use the default constructor.
	 * 
	 * @see PayPalAPIInterfaceServiceService
	 * @param inputStream
	 *            InputStream of a {@link Properties} file
	 * @throws IOException
	 */
	public AdaptivePaymentsService(InputStream inputStream) throws IOException {
		super(inputStream);
	}

	/**
	 * <code>AdaptivePaymentsService</code> that uses the supplied
	 * {@link Properties} to initialize the SDK system. For values that the
	 * properties should hold consult the sample 'sdk_config.properties' file
	 * bundled with the SDK. The initialization context is maintained only for
	 * this instance of the class. To initialize the SDK system globally use the
	 * default constructor.
	 * 
	 * @see PayPalAPIInterfaceServiceService
	 * @param properties
	 *            {@link Properties} object
	 */	
	public AdaptivePaymentsService(Properties properties) {
		super(properties);
	}
	
	/**
	 * <code>PayPalAPIInterfaceServiceService</code> that uses the supplied
	 * {@link Map} to initialize the SDK system. For values that the map should
	 * hold consult the sample 'sdk_config.properties' file bundled with the
	 * SDK. The initialization context is maintained only for this instance of
	 * the class. To initialize the SDK system globally use the default
	 * constructor.
	 * 
	 * @see PayPalAPIInterfaceServiceService
	 * @param configurationMap
	 *            {@link Map} object
	 */
	public AdaptivePaymentsService(Map<String, String> configurationMap) {
		super(configurationMap);
	}




	/** 
	 * 
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public CancelPreapprovalResponse cancelPreapproval(CancelPreapprovalRequest cancelPreapprovalRequest) throws SSLConfigurationException, InvalidCredentialException, UnsupportedEncodingException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException {
	 	return cancelPreapproval(cancelPreapprovalRequest, (String) null);
	 }

	/** 
	 * 
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public CancelPreapprovalResponse cancelPreapproval(CancelPreapprovalRequest cancelPreapprovalRequest, ICredential credential) throws SSLConfigurationException, InvalidCredentialException, UnsupportedEncodingException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException {
		APICallPreHandler apiCallPreHandler = new PlatformAPICallPreHandler(cancelPreapprovalRequest.toNVPString(), SERVICE_NAME, "CancelPreapproval", credential, SDK_NAME, SDK_VERSION, "AdaptivePayments", this.configurationMap);
	 	String response = call(apiCallPreHandler);
		return CancelPreapprovalResponse.createInstance(NVPUtil.decode(response), "", -1);
	}
	
	/**	
	 * 
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public CancelPreapprovalResponse cancelPreapproval(CancelPreapprovalRequest cancelPreapprovalRequest, String apiUsername) throws SSLConfigurationException, InvalidCredentialException, UnsupportedEncodingException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException {
		APICallPreHandler apiCallPreHandler = new PlatformAPICallPreHandler(cancelPreapprovalRequest.toNVPString(), SERVICE_NAME, "CancelPreapproval", apiUsername, getAccessToken(), getTokenSecret(), SDK_NAME, SDK_VERSION, "AdaptivePayments", this.configurationMap);
	 	String response = call(apiCallPreHandler);
		return CancelPreapprovalResponse.createInstance(NVPUtil.decode(response), "", -1);
	 }

	/** 
	 * 
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public ConfirmPreapprovalResponse confirmPreapproval(ConfirmPreapprovalRequest confirmPreapprovalRequest) throws SSLConfigurationException, InvalidCredentialException, UnsupportedEncodingException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException {
	 	return confirmPreapproval(confirmPreapprovalRequest, (String) null);
	 }

	/** 
	 * 
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public ConfirmPreapprovalResponse confirmPreapproval(ConfirmPreapprovalRequest confirmPreapprovalRequest, ICredential credential) throws SSLConfigurationException, InvalidCredentialException, UnsupportedEncodingException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException {
		APICallPreHandler apiCallPreHandler = new PlatformAPICallPreHandler(confirmPreapprovalRequest.toNVPString(), SERVICE_NAME, "ConfirmPreapproval", credential, SDK_NAME, SDK_VERSION, "AdaptivePayments", this.configurationMap);
	 	String response = call(apiCallPreHandler);
		return ConfirmPreapprovalResponse.createInstance(NVPUtil.decode(response), "", -1);
	}
	
	/**	
	 * 
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public ConfirmPreapprovalResponse confirmPreapproval(ConfirmPreapprovalRequest confirmPreapprovalRequest, String apiUsername) throws SSLConfigurationException, InvalidCredentialException, UnsupportedEncodingException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException {
		APICallPreHandler apiCallPreHandler = new PlatformAPICallPreHandler(confirmPreapprovalRequest.toNVPString(), SERVICE_NAME, "ConfirmPreapproval", apiUsername, getAccessToken(), getTokenSecret(), SDK_NAME, SDK_VERSION, "AdaptivePayments", this.configurationMap);
	 	String response = call(apiCallPreHandler);
		return ConfirmPreapprovalResponse.createInstance(NVPUtil.decode(response), "", -1);
	 }

	/** 
	 * 
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public ConvertCurrencyResponse convertCurrency(ConvertCurrencyRequest convertCurrencyRequest) throws SSLConfigurationException, InvalidCredentialException, UnsupportedEncodingException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException {
	 	return convertCurrency(convertCurrencyRequest, (String) null);
	 }

	/** 
	 * 
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public ConvertCurrencyResponse convertCurrency(ConvertCurrencyRequest convertCurrencyRequest, ICredential credential) throws SSLConfigurationException, InvalidCredentialException, UnsupportedEncodingException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException {
		APICallPreHandler apiCallPreHandler = new PlatformAPICallPreHandler(convertCurrencyRequest.toNVPString(), SERVICE_NAME, "ConvertCurrency", credential, SDK_NAME, SDK_VERSION, "AdaptivePayments", this.configurationMap);
	 	String response = call(apiCallPreHandler);
		return ConvertCurrencyResponse.createInstance(NVPUtil.decode(response), "", -1);
	}
	
	/**	
	 * 
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public ConvertCurrencyResponse convertCurrency(ConvertCurrencyRequest convertCurrencyRequest, String apiUsername) throws SSLConfigurationException, InvalidCredentialException, UnsupportedEncodingException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException {
		APICallPreHandler apiCallPreHandler = new PlatformAPICallPreHandler(convertCurrencyRequest.toNVPString(), SERVICE_NAME, "ConvertCurrency", apiUsername, getAccessToken(), getTokenSecret(), SDK_NAME, SDK_VERSION, "AdaptivePayments", this.configurationMap);
	 	String response = call(apiCallPreHandler);
		return ConvertCurrencyResponse.createInstance(NVPUtil.decode(response), "", -1);
	 }

	/** 
	 * 
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public ExecutePaymentResponse executePayment(ExecutePaymentRequest executePaymentRequest) throws SSLConfigurationException, InvalidCredentialException, UnsupportedEncodingException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException {
	 	return executePayment(executePaymentRequest, (String) null);
	 }

	/** 
	 * 
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public ExecutePaymentResponse executePayment(ExecutePaymentRequest executePaymentRequest, ICredential credential) throws SSLConfigurationException, InvalidCredentialException, UnsupportedEncodingException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException {
		APICallPreHandler apiCallPreHandler = new PlatformAPICallPreHandler(executePaymentRequest.toNVPString(), SERVICE_NAME, "ExecutePayment", credential, SDK_NAME, SDK_VERSION, "AdaptivePayments", this.configurationMap);
	 	String response = call(apiCallPreHandler);
		return ExecutePaymentResponse.createInstance(NVPUtil.decode(response), "", -1);
	}
	
	/**	
	 * 
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public ExecutePaymentResponse executePayment(ExecutePaymentRequest executePaymentRequest, String apiUsername) throws SSLConfigurationException, InvalidCredentialException, UnsupportedEncodingException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException {
		APICallPreHandler apiCallPreHandler = new PlatformAPICallPreHandler(executePaymentRequest.toNVPString(), SERVICE_NAME, "ExecutePayment", apiUsername, getAccessToken(), getTokenSecret(), SDK_NAME, SDK_VERSION, "AdaptivePayments", this.configurationMap);
	 	String response = call(apiCallPreHandler);
		return ExecutePaymentResponse.createInstance(NVPUtil.decode(response), "", -1);
	 }

	/** 
	 * 
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public GetAllowedFundingSourcesResponse getAllowedFundingSources(GetAllowedFundingSourcesRequest getAllowedFundingSourcesRequest) throws SSLConfigurationException, InvalidCredentialException, UnsupportedEncodingException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException {
	 	return getAllowedFundingSources(getAllowedFundingSourcesRequest, (String) null);
	 }

	/** 
	 * 
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public GetAllowedFundingSourcesResponse getAllowedFundingSources(GetAllowedFundingSourcesRequest getAllowedFundingSourcesRequest, ICredential credential) throws SSLConfigurationException, InvalidCredentialException, UnsupportedEncodingException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException {
		APICallPreHandler apiCallPreHandler = new PlatformAPICallPreHandler(getAllowedFundingSourcesRequest.toNVPString(), SERVICE_NAME, "GetAllowedFundingSources", credential, SDK_NAME, SDK_VERSION, "AdaptivePayments", this.configurationMap);
	 	String response = call(apiCallPreHandler);
		return GetAllowedFundingSourcesResponse.createInstance(NVPUtil.decode(response), "", -1);
	}
	
	/**	
	 * 
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public GetAllowedFundingSourcesResponse getAllowedFundingSources(GetAllowedFundingSourcesRequest getAllowedFundingSourcesRequest, String apiUsername) throws SSLConfigurationException, InvalidCredentialException, UnsupportedEncodingException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException {
		APICallPreHandler apiCallPreHandler = new PlatformAPICallPreHandler(getAllowedFundingSourcesRequest.toNVPString(), SERVICE_NAME, "GetAllowedFundingSources", apiUsername, getAccessToken(), getTokenSecret(), SDK_NAME, SDK_VERSION, "AdaptivePayments", this.configurationMap);
	 	String response = call(apiCallPreHandler);
		return GetAllowedFundingSourcesResponse.createInstance(NVPUtil.decode(response), "", -1);
	 }

	/** 
	 * 
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public GetPaymentOptionsResponse getPaymentOptions(GetPaymentOptionsRequest getPaymentOptionsRequest) throws SSLConfigurationException, InvalidCredentialException, UnsupportedEncodingException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException {
	 	return getPaymentOptions(getPaymentOptionsRequest, (String) null);
	 }

	/** 
	 * 
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public GetPaymentOptionsResponse getPaymentOptions(GetPaymentOptionsRequest getPaymentOptionsRequest, ICredential credential) throws SSLConfigurationException, InvalidCredentialException, UnsupportedEncodingException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException {
		APICallPreHandler apiCallPreHandler = new PlatformAPICallPreHandler(getPaymentOptionsRequest.toNVPString(), SERVICE_NAME, "GetPaymentOptions", credential, SDK_NAME, SDK_VERSION, "AdaptivePayments", this.configurationMap);
	 	String response = call(apiCallPreHandler);
		return GetPaymentOptionsResponse.createInstance(NVPUtil.decode(response), "", -1);
	}
	
	/**	
	 * 
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public GetPaymentOptionsResponse getPaymentOptions(GetPaymentOptionsRequest getPaymentOptionsRequest, String apiUsername) throws SSLConfigurationException, InvalidCredentialException, UnsupportedEncodingException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException {
		APICallPreHandler apiCallPreHandler = new PlatformAPICallPreHandler(getPaymentOptionsRequest.toNVPString(), SERVICE_NAME, "GetPaymentOptions", apiUsername, getAccessToken(), getTokenSecret(), SDK_NAME, SDK_VERSION, "AdaptivePayments", this.configurationMap);
	 	String response = call(apiCallPreHandler);
		return GetPaymentOptionsResponse.createInstance(NVPUtil.decode(response), "", -1);
	 }

	/** 
	 * 
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public PaymentDetailsResponse paymentDetails(PaymentDetailsRequest paymentDetailsRequest) throws SSLConfigurationException, InvalidCredentialException, UnsupportedEncodingException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException {
	 	return paymentDetails(paymentDetailsRequest, (String) null);
	 }

	/** 
	 * 
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public PaymentDetailsResponse paymentDetails(PaymentDetailsRequest paymentDetailsRequest, ICredential credential) throws SSLConfigurationException, InvalidCredentialException, UnsupportedEncodingException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException {
		APICallPreHandler apiCallPreHandler = new PlatformAPICallPreHandler(paymentDetailsRequest.toNVPString(), SERVICE_NAME, "PaymentDetails", credential, SDK_NAME, SDK_VERSION, "AdaptivePayments", this.configurationMap);
	 	String response = call(apiCallPreHandler);
		return PaymentDetailsResponse.createInstance(NVPUtil.decode(response), "", -1);
	}
	
	/**	
	 * 
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public PaymentDetailsResponse paymentDetails(PaymentDetailsRequest paymentDetailsRequest, String apiUsername) throws SSLConfigurationException, InvalidCredentialException, UnsupportedEncodingException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException {
		APICallPreHandler apiCallPreHandler = new PlatformAPICallPreHandler(paymentDetailsRequest.toNVPString(), SERVICE_NAME, "PaymentDetails", apiUsername, getAccessToken(), getTokenSecret(), SDK_NAME, SDK_VERSION, "AdaptivePayments", this.configurationMap);
	 	String response = call(apiCallPreHandler);
		return PaymentDetailsResponse.createInstance(NVPUtil.decode(response), "", -1);
	 }

	/** 
	 * 
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public PayResponse pay(PayRequest payRequest) throws SSLConfigurationException, InvalidCredentialException, UnsupportedEncodingException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException {
	 	return pay(payRequest, (String) null);
	 }

	/** 
	 * 
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public PayResponse pay(PayRequest payRequest, ICredential credential) throws SSLConfigurationException, InvalidCredentialException, UnsupportedEncodingException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException {
		APICallPreHandler apiCallPreHandler = new PlatformAPICallPreHandler(payRequest.toNVPString(), SERVICE_NAME, "Pay", credential, SDK_NAME, SDK_VERSION, "AdaptivePayments", this.configurationMap);
	 	String response = call(apiCallPreHandler);
		return PayResponse.createInstance(NVPUtil.decode(response), "", -1);
	}
	
	/**	
	 * 
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public PayResponse pay(PayRequest payRequest, String apiUsername) throws SSLConfigurationException, InvalidCredentialException, UnsupportedEncodingException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException {
		APICallPreHandler apiCallPreHandler = new PlatformAPICallPreHandler(payRequest.toNVPString(), SERVICE_NAME, "Pay", apiUsername, getAccessToken(), getTokenSecret(), SDK_NAME, SDK_VERSION, "AdaptivePayments", this.configurationMap);
	 	String response = call(apiCallPreHandler);
		return PayResponse.createInstance(NVPUtil.decode(response), "", -1);
	 }

	/** 
	 * 
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public PreapprovalDetailsResponse preapprovalDetails(PreapprovalDetailsRequest preapprovalDetailsRequest) throws SSLConfigurationException, InvalidCredentialException, UnsupportedEncodingException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException {
	 	return preapprovalDetails(preapprovalDetailsRequest, (String) null);
	 }

	/** 
	 * 
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public PreapprovalDetailsResponse preapprovalDetails(PreapprovalDetailsRequest preapprovalDetailsRequest, ICredential credential) throws SSLConfigurationException, InvalidCredentialException, UnsupportedEncodingException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException {
		APICallPreHandler apiCallPreHandler = new PlatformAPICallPreHandler(preapprovalDetailsRequest.toNVPString(), SERVICE_NAME, "PreapprovalDetails", credential, SDK_NAME, SDK_VERSION, "AdaptivePayments", this.configurationMap);
	 	String response = call(apiCallPreHandler);
		return PreapprovalDetailsResponse.createInstance(NVPUtil.decode(response), "", -1);
	}
	
	/**	
	 * 
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public PreapprovalDetailsResponse preapprovalDetails(PreapprovalDetailsRequest preapprovalDetailsRequest, String apiUsername) throws SSLConfigurationException, InvalidCredentialException, UnsupportedEncodingException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException {
		APICallPreHandler apiCallPreHandler = new PlatformAPICallPreHandler(preapprovalDetailsRequest.toNVPString(), SERVICE_NAME, "PreapprovalDetails", apiUsername, getAccessToken(), getTokenSecret(), SDK_NAME, SDK_VERSION, "AdaptivePayments", this.configurationMap);
	 	String response = call(apiCallPreHandler);
		return PreapprovalDetailsResponse.createInstance(NVPUtil.decode(response), "", -1);
	 }

	/** 
	 * 
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public PreapprovalResponse preapproval(PreapprovalRequest preapprovalRequest) throws SSLConfigurationException, InvalidCredentialException, UnsupportedEncodingException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException {
	 	return preapproval(preapprovalRequest, (String) null);
	 }

	/** 
	 * 
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public PreapprovalResponse preapproval(PreapprovalRequest preapprovalRequest, ICredential credential) throws SSLConfigurationException, InvalidCredentialException, UnsupportedEncodingException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException {
		APICallPreHandler apiCallPreHandler = new PlatformAPICallPreHandler(preapprovalRequest.toNVPString(), SERVICE_NAME, "Preapproval", credential, SDK_NAME, SDK_VERSION, "AdaptivePayments", this.configurationMap);
	 	String response = call(apiCallPreHandler);
		return PreapprovalResponse.createInstance(NVPUtil.decode(response), "", -1);
	}
	
	/**	
	 * 
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public PreapprovalResponse preapproval(PreapprovalRequest preapprovalRequest, String apiUsername) throws SSLConfigurationException, InvalidCredentialException, UnsupportedEncodingException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException {
		APICallPreHandler apiCallPreHandler = new PlatformAPICallPreHandler(preapprovalRequest.toNVPString(), SERVICE_NAME, "Preapproval", apiUsername, getAccessToken(), getTokenSecret(), SDK_NAME, SDK_VERSION, "AdaptivePayments", this.configurationMap);
	 	String response = call(apiCallPreHandler);
		return PreapprovalResponse.createInstance(NVPUtil.decode(response), "", -1);
	 }

	/** 
	 * 
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public RefundResponse refund(RefundRequest refundRequest) throws SSLConfigurationException, InvalidCredentialException, UnsupportedEncodingException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException {
	 	return refund(refundRequest, (String) null);
	 }

	/** 
	 * 
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public RefundResponse refund(RefundRequest refundRequest, ICredential credential) throws SSLConfigurationException, InvalidCredentialException, UnsupportedEncodingException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException {
		APICallPreHandler apiCallPreHandler = new PlatformAPICallPreHandler(refundRequest.toNVPString(), SERVICE_NAME, "Refund", credential, SDK_NAME, SDK_VERSION, "AdaptivePayments", this.configurationMap);
	 	String response = call(apiCallPreHandler);
		return RefundResponse.createInstance(NVPUtil.decode(response), "", -1);
	}
	
	/**	
	 * 
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public RefundResponse refund(RefundRequest refundRequest, String apiUsername) throws SSLConfigurationException, InvalidCredentialException, UnsupportedEncodingException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException {
		APICallPreHandler apiCallPreHandler = new PlatformAPICallPreHandler(refundRequest.toNVPString(), SERVICE_NAME, "Refund", apiUsername, getAccessToken(), getTokenSecret(), SDK_NAME, SDK_VERSION, "AdaptivePayments", this.configurationMap);
	 	String response = call(apiCallPreHandler);
		return RefundResponse.createInstance(NVPUtil.decode(response), "", -1);
	 }

	/** 
	 * 
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public SetPaymentOptionsResponse setPaymentOptions(SetPaymentOptionsRequest setPaymentOptionsRequest) throws SSLConfigurationException, InvalidCredentialException, UnsupportedEncodingException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException {
	 	return setPaymentOptions(setPaymentOptionsRequest, (String) null);
	 }

	/** 
	 * 
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public SetPaymentOptionsResponse setPaymentOptions(SetPaymentOptionsRequest setPaymentOptionsRequest, ICredential credential) throws SSLConfigurationException, InvalidCredentialException, UnsupportedEncodingException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException {
		APICallPreHandler apiCallPreHandler = new PlatformAPICallPreHandler(setPaymentOptionsRequest.toNVPString(), SERVICE_NAME, "SetPaymentOptions", credential, SDK_NAME, SDK_VERSION, "AdaptivePayments", this.configurationMap);
	 	String response = call(apiCallPreHandler);
		return SetPaymentOptionsResponse.createInstance(NVPUtil.decode(response), "", -1);
	}
	
	/**	
	 * 
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public SetPaymentOptionsResponse setPaymentOptions(SetPaymentOptionsRequest setPaymentOptionsRequest, String apiUsername) throws SSLConfigurationException, InvalidCredentialException, UnsupportedEncodingException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException {
		APICallPreHandler apiCallPreHandler = new PlatformAPICallPreHandler(setPaymentOptionsRequest.toNVPString(), SERVICE_NAME, "SetPaymentOptions", apiUsername, getAccessToken(), getTokenSecret(), SDK_NAME, SDK_VERSION, "AdaptivePayments", this.configurationMap);
	 	String response = call(apiCallPreHandler);
		return SetPaymentOptionsResponse.createInstance(NVPUtil.decode(response), "", -1);
	 }

	/** 
	 * 
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public GetFundingPlansResponse getFundingPlans(GetFundingPlansRequest getFundingPlansRequest) throws SSLConfigurationException, InvalidCredentialException, UnsupportedEncodingException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException {
	 	return getFundingPlans(getFundingPlansRequest, (String) null);
	 }

	/** 
	 * 
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public GetFundingPlansResponse getFundingPlans(GetFundingPlansRequest getFundingPlansRequest, ICredential credential) throws SSLConfigurationException, InvalidCredentialException, UnsupportedEncodingException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException {
		APICallPreHandler apiCallPreHandler = new PlatformAPICallPreHandler(getFundingPlansRequest.toNVPString(), SERVICE_NAME, "GetFundingPlans", credential, SDK_NAME, SDK_VERSION, "AdaptivePayments", this.configurationMap);
	 	String response = call(apiCallPreHandler);
		return GetFundingPlansResponse.createInstance(NVPUtil.decode(response), "", -1);
	}
	
	/**	
	 * 
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public GetFundingPlansResponse getFundingPlans(GetFundingPlansRequest getFundingPlansRequest, String apiUsername) throws SSLConfigurationException, InvalidCredentialException, UnsupportedEncodingException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException {
		APICallPreHandler apiCallPreHandler = new PlatformAPICallPreHandler(getFundingPlansRequest.toNVPString(), SERVICE_NAME, "GetFundingPlans", apiUsername, getAccessToken(), getTokenSecret(), SDK_NAME, SDK_VERSION, "AdaptivePayments", this.configurationMap);
	 	String response = call(apiCallPreHandler);
		return GetFundingPlansResponse.createInstance(NVPUtil.decode(response), "", -1);
	 }

	/** 
	 * 
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public GetAvailableShippingAddressesResponse getAvailableShippingAddresses(GetAvailableShippingAddressesRequest getAvailableShippingAddressesRequest) throws SSLConfigurationException, InvalidCredentialException, UnsupportedEncodingException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException {
	 	return getAvailableShippingAddresses(getAvailableShippingAddressesRequest, (String) null);
	 }

	/** 
	 * 
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public GetAvailableShippingAddressesResponse getAvailableShippingAddresses(GetAvailableShippingAddressesRequest getAvailableShippingAddressesRequest, ICredential credential) throws SSLConfigurationException, InvalidCredentialException, UnsupportedEncodingException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException {
		APICallPreHandler apiCallPreHandler = new PlatformAPICallPreHandler(getAvailableShippingAddressesRequest.toNVPString(), SERVICE_NAME, "GetAvailableShippingAddresses", credential, SDK_NAME, SDK_VERSION, "AdaptivePayments", this.configurationMap);
	 	String response = call(apiCallPreHandler);
		return GetAvailableShippingAddressesResponse.createInstance(NVPUtil.decode(response), "", -1);
	}
	
	/**	
	 * 
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public GetAvailableShippingAddressesResponse getAvailableShippingAddresses(GetAvailableShippingAddressesRequest getAvailableShippingAddressesRequest, String apiUsername) throws SSLConfigurationException, InvalidCredentialException, UnsupportedEncodingException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException {
		APICallPreHandler apiCallPreHandler = new PlatformAPICallPreHandler(getAvailableShippingAddressesRequest.toNVPString(), SERVICE_NAME, "GetAvailableShippingAddresses", apiUsername, getAccessToken(), getTokenSecret(), SDK_NAME, SDK_VERSION, "AdaptivePayments", this.configurationMap);
	 	String response = call(apiCallPreHandler);
		return GetAvailableShippingAddressesResponse.createInstance(NVPUtil.decode(response), "", -1);
	 }

	/** 
	 * 
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public GetShippingAddressesResponse getShippingAddresses(GetShippingAddressesRequest getShippingAddressesRequest) throws SSLConfigurationException, InvalidCredentialException, UnsupportedEncodingException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException {
	 	return getShippingAddresses(getShippingAddressesRequest, (String) null);
	 }

	/** 
	 * 
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public GetShippingAddressesResponse getShippingAddresses(GetShippingAddressesRequest getShippingAddressesRequest, ICredential credential) throws SSLConfigurationException, InvalidCredentialException, UnsupportedEncodingException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException {
		APICallPreHandler apiCallPreHandler = new PlatformAPICallPreHandler(getShippingAddressesRequest.toNVPString(), SERVICE_NAME, "GetShippingAddresses", credential, SDK_NAME, SDK_VERSION, "AdaptivePayments", this.configurationMap);
	 	String response = call(apiCallPreHandler);
		return GetShippingAddressesResponse.createInstance(NVPUtil.decode(response), "", -1);
	}
	
	/**	
	 * 
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public GetShippingAddressesResponse getShippingAddresses(GetShippingAddressesRequest getShippingAddressesRequest, String apiUsername) throws SSLConfigurationException, InvalidCredentialException, UnsupportedEncodingException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException {
		APICallPreHandler apiCallPreHandler = new PlatformAPICallPreHandler(getShippingAddressesRequest.toNVPString(), SERVICE_NAME, "GetShippingAddresses", apiUsername, getAccessToken(), getTokenSecret(), SDK_NAME, SDK_VERSION, "AdaptivePayments", this.configurationMap);
	 	String response = call(apiCallPreHandler);
		return GetShippingAddressesResponse.createInstance(NVPUtil.decode(response), "", -1);
	 }

	/** 
	 * 
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public GetUserLimitsResponse getUserLimits(GetUserLimitsRequest getUserLimitsRequest) throws SSLConfigurationException, InvalidCredentialException, UnsupportedEncodingException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException {
	 	return getUserLimits(getUserLimitsRequest, (String) null);
	 }

	/** 
	 * 
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public GetUserLimitsResponse getUserLimits(GetUserLimitsRequest getUserLimitsRequest, ICredential credential) throws SSLConfigurationException, InvalidCredentialException, UnsupportedEncodingException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException {
		APICallPreHandler apiCallPreHandler = new PlatformAPICallPreHandler(getUserLimitsRequest.toNVPString(), SERVICE_NAME, "GetUserLimits", credential, SDK_NAME, SDK_VERSION, "AdaptivePayments", this.configurationMap);
	 	String response = call(apiCallPreHandler);
		return GetUserLimitsResponse.createInstance(NVPUtil.decode(response), "", -1);
	}
	
	/**	
	 * 
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public GetUserLimitsResponse getUserLimits(GetUserLimitsRequest getUserLimitsRequest, String apiUsername) throws SSLConfigurationException, InvalidCredentialException, UnsupportedEncodingException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException {
		APICallPreHandler apiCallPreHandler = new PlatformAPICallPreHandler(getUserLimitsRequest.toNVPString(), SERVICE_NAME, "GetUserLimits", apiUsername, getAccessToken(), getTokenSecret(), SDK_NAME, SDK_VERSION, "AdaptivePayments", this.configurationMap);
	 	String response = call(apiCallPreHandler);
		return GetUserLimitsResponse.createInstance(NVPUtil.decode(response), "", -1);
	 }

	/** 
	 * 
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public GetPrePaymentDisclosureResponse getPrePaymentDisclosure(GetPrePaymentDisclosureRequest getPrePaymentDisclosureRequest) throws SSLConfigurationException, InvalidCredentialException, UnsupportedEncodingException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException {
	 	return getPrePaymentDisclosure(getPrePaymentDisclosureRequest, (String) null);
	 }

	/** 
	 * 
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public GetPrePaymentDisclosureResponse getPrePaymentDisclosure(GetPrePaymentDisclosureRequest getPrePaymentDisclosureRequest, ICredential credential) throws SSLConfigurationException, InvalidCredentialException, UnsupportedEncodingException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException {
		APICallPreHandler apiCallPreHandler = new PlatformAPICallPreHandler(getPrePaymentDisclosureRequest.toNVPString(), SERVICE_NAME, "GetPrePaymentDisclosure", credential, SDK_NAME, SDK_VERSION, "AdaptivePayments", this.configurationMap);
	 	String response = call(apiCallPreHandler);
		return GetPrePaymentDisclosureResponse.createInstance(NVPUtil.decode(response), "", -1);
	}
	
	/**	
	 * 
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public GetPrePaymentDisclosureResponse getPrePaymentDisclosure(GetPrePaymentDisclosureRequest getPrePaymentDisclosureRequest, String apiUsername) throws SSLConfigurationException, InvalidCredentialException, UnsupportedEncodingException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException {
		APICallPreHandler apiCallPreHandler = new PlatformAPICallPreHandler(getPrePaymentDisclosureRequest.toNVPString(), SERVICE_NAME, "GetPrePaymentDisclosure", apiUsername, getAccessToken(), getTokenSecret(), SDK_NAME, SDK_VERSION, "AdaptivePayments", this.configurationMap);
	 	String response = call(apiCallPreHandler);
		return GetPrePaymentDisclosureResponse.createInstance(NVPUtil.decode(response), "", -1);
	 }

}