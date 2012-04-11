/**
 * AdaptivePaymentsService wrapper class
 * Auto generated code
 */
package com.paypal.svcs.services;

import com.paypal.core.BaseService;
import com.paypal.core.NVPUtil;
import com.paypal.exception.ClientActionRequiredException;
import com.paypal.exception.HttpErrorException;
import com.paypal.exception.InvalidCredentialException;
import com.paypal.exception.InvalidResponseDataException;
import com.paypal.exception.MissingCredentialException;
import com.paypal.exception.SSLConfigurationException;
import com.paypal.sdk.exceptions.OAuthException;
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
import com.paypal.svcs.types.ap.GetAvailableShippingAddressesRequest;
import com.paypal.svcs.types.ap.GetAvailableShippingAddressesResponse;
import com.paypal.svcs.types.ap.GetFundingPlansRequest;
import com.paypal.svcs.types.ap.GetFundingPlansResponse;
import com.paypal.svcs.types.ap.GetPaymentOptionsRequest;
import com.paypal.svcs.types.ap.GetPaymentOptionsResponse;
import com.paypal.svcs.types.ap.GetShippingAddressesRequest;
import com.paypal.svcs.types.ap.GetShippingAddressesResponse;
import com.paypal.svcs.types.ap.GetUserLimitsRequest;
import com.paypal.svcs.types.ap.GetUserLimitsResponse;
import com.paypal.svcs.types.ap.PayRequest;
import com.paypal.svcs.types.ap.PayResponse;
import com.paypal.svcs.types.ap.PaymentDetailsRequest;
import com.paypal.svcs.types.ap.PaymentDetailsResponse;
import com.paypal.svcs.types.ap.PreapprovalDetailsRequest;
import com.paypal.svcs.types.ap.PreapprovalDetailsResponse;
import com.paypal.svcs.types.ap.PreapprovalRequest;
import com.paypal.svcs.types.ap.PreapprovalResponse;
import com.paypal.svcs.types.ap.RefundRequest;
import com.paypal.svcs.types.ap.RefundResponse;
import com.paypal.svcs.types.ap.SetPaymentOptionsRequest;
import com.paypal.svcs.types.ap.SetPaymentOptionsResponse;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;


public class AdaptivePaymentsService extends BaseService {

	private static final String SERVICE_VERSION = "1.8.0";
	private static final String SERVICE_NAME = "AdaptivePayments";

	public AdaptivePaymentsService(File configFile) throws IOException, FileNotFoundException {
		super(SERVICE_NAME, SERVICE_VERSION);
		initConfig(configFile);
	}
	public AdaptivePaymentsService(InputStream config) throws IOException, FileNotFoundException {
		super(SERVICE_NAME, SERVICE_VERSION);
		initConfig(config);
	}
	public AdaptivePaymentsService(String configFilePath) throws IOException, FileNotFoundException {
		super(SERVICE_NAME, SERVICE_VERSION);
		initConfig(configFilePath);
		
	}

	/**
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
	public CancelPreapprovalResponse cancelPreapproval (CancelPreapprovalRequest CancelPreapprovalRequest,  String apiUsername) throws SSLConfigurationException, InvalidCredentialException, UnsupportedEncodingException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException {
		String response = call("CancelPreapproval", CancelPreapprovalRequest.toNVPString(), apiUsername);
		return new CancelPreapprovalResponse(NVPUtil.decode(response), "");
	}

	public CancelPreapprovalResponse cancelPreapproval (CancelPreapprovalRequest CancelPreapprovalRequest) throws SSLConfigurationException, InvalidCredentialException, UnsupportedEncodingException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException {
		return cancelPreapproval(CancelPreapprovalRequest, null);
	}

	/**
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
	public ConfirmPreapprovalResponse confirmPreapproval (ConfirmPreapprovalRequest ConfirmPreapprovalRequest,  String apiUsername) throws SSLConfigurationException, InvalidCredentialException, UnsupportedEncodingException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException {
		String response = call("ConfirmPreapproval", ConfirmPreapprovalRequest.toNVPString(), apiUsername);
		return new ConfirmPreapprovalResponse(NVPUtil.decode(response), "");
	}

	public ConfirmPreapprovalResponse confirmPreapproval (ConfirmPreapprovalRequest ConfirmPreapprovalRequest) throws SSLConfigurationException, InvalidCredentialException, UnsupportedEncodingException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException {
		return confirmPreapproval(ConfirmPreapprovalRequest, null);
	}

	/**
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
	public ConvertCurrencyResponse convertCurrency (ConvertCurrencyRequest ConvertCurrencyRequest,  String apiUsername) throws SSLConfigurationException, InvalidCredentialException, UnsupportedEncodingException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException {
		String response = call("ConvertCurrency", ConvertCurrencyRequest.toNVPString(), apiUsername);
		return new ConvertCurrencyResponse(NVPUtil.decode(response), "");
	}

	public ConvertCurrencyResponse convertCurrency (ConvertCurrencyRequest ConvertCurrencyRequest) throws SSLConfigurationException, InvalidCredentialException, UnsupportedEncodingException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException {
		return convertCurrency(ConvertCurrencyRequest, null);
	}

	/**
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
	public ExecutePaymentResponse executePayment (ExecutePaymentRequest ExecutePaymentRequest,  String apiUsername) throws SSLConfigurationException, InvalidCredentialException, UnsupportedEncodingException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException {
		String response = call("ExecutePayment", ExecutePaymentRequest.toNVPString(), apiUsername);
		return new ExecutePaymentResponse(NVPUtil.decode(response), "");
	}

	public ExecutePaymentResponse executePayment (ExecutePaymentRequest ExecutePaymentRequest) throws SSLConfigurationException, InvalidCredentialException, UnsupportedEncodingException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException {
		return executePayment(ExecutePaymentRequest, null);
	}

	/**
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
	public GetAllowedFundingSourcesResponse getAllowedFundingSources (GetAllowedFundingSourcesRequest GetAllowedFundingSourcesRequest,  String apiUsername) throws SSLConfigurationException, InvalidCredentialException, UnsupportedEncodingException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException {
		String response = call("GetAllowedFundingSources", GetAllowedFundingSourcesRequest.toNVPString(), apiUsername);
		return new GetAllowedFundingSourcesResponse(NVPUtil.decode(response), "");
	}

	public GetAllowedFundingSourcesResponse getAllowedFundingSources (GetAllowedFundingSourcesRequest GetAllowedFundingSourcesRequest) throws SSLConfigurationException, InvalidCredentialException, UnsupportedEncodingException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException {
		return getAllowedFundingSources(GetAllowedFundingSourcesRequest, null);
	}

	/**
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
	public GetPaymentOptionsResponse getPaymentOptions (GetPaymentOptionsRequest GetPaymentOptionsRequest,  String apiUsername) throws SSLConfigurationException, InvalidCredentialException, UnsupportedEncodingException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException {
		String response = call("GetPaymentOptions", GetPaymentOptionsRequest.toNVPString(), apiUsername);
		return new GetPaymentOptionsResponse(NVPUtil.decode(response), "");
	}

	public GetPaymentOptionsResponse getPaymentOptions (GetPaymentOptionsRequest GetPaymentOptionsRequest) throws SSLConfigurationException, InvalidCredentialException, UnsupportedEncodingException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException {
		return getPaymentOptions(GetPaymentOptionsRequest, null);
	}

	/**
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
	public PaymentDetailsResponse paymentDetails (PaymentDetailsRequest PaymentDetailsRequest,  String apiUsername) throws SSLConfigurationException, InvalidCredentialException, UnsupportedEncodingException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException {
		String response = call("PaymentDetails", PaymentDetailsRequest.toNVPString(), apiUsername);
		return new PaymentDetailsResponse(NVPUtil.decode(response), "");
	}

	public PaymentDetailsResponse paymentDetails (PaymentDetailsRequest PaymentDetailsRequest) throws SSLConfigurationException, InvalidCredentialException, UnsupportedEncodingException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException {
		return paymentDetails(PaymentDetailsRequest, null);
	}

	/**
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
	public PayResponse pay (PayRequest PayRequest,  String apiUsername) throws SSLConfigurationException, InvalidCredentialException, UnsupportedEncodingException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException {
		String response = call("Pay", PayRequest.toNVPString(), apiUsername);
		return new PayResponse(NVPUtil.decode(response), "");
	}

	public PayResponse pay (PayRequest PayRequest) throws SSLConfigurationException, InvalidCredentialException, UnsupportedEncodingException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException {
		return pay(PayRequest, null);
	}

	/**
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
	public PreapprovalDetailsResponse preapprovalDetails (PreapprovalDetailsRequest PreapprovalDetailsRequest,  String apiUsername) throws SSLConfigurationException, InvalidCredentialException, UnsupportedEncodingException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException {
		String response = call("PreapprovalDetails", PreapprovalDetailsRequest.toNVPString(), apiUsername);
		return new PreapprovalDetailsResponse(NVPUtil.decode(response), "");
	}

	public PreapprovalDetailsResponse preapprovalDetails (PreapprovalDetailsRequest PreapprovalDetailsRequest) throws SSLConfigurationException, InvalidCredentialException, UnsupportedEncodingException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException {
		return preapprovalDetails(PreapprovalDetailsRequest, null);
	}

	/**
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
	public PreapprovalResponse preapproval (PreapprovalRequest PreapprovalRequest,  String apiUsername) throws SSLConfigurationException, InvalidCredentialException, UnsupportedEncodingException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException {
		String response = call("Preapproval", PreapprovalRequest.toNVPString(), apiUsername);
		return new PreapprovalResponse(NVPUtil.decode(response), "");
	}

	public PreapprovalResponse preapproval (PreapprovalRequest PreapprovalRequest) throws SSLConfigurationException, InvalidCredentialException, UnsupportedEncodingException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException {
		return preapproval(PreapprovalRequest, null);
	}

	/**
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
	public RefundResponse refund (RefundRequest RefundRequest,  String apiUsername) throws SSLConfigurationException, InvalidCredentialException, UnsupportedEncodingException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException {
		String response = call("Refund", RefundRequest.toNVPString(), apiUsername);
		return new RefundResponse(NVPUtil.decode(response), "");
	}

	public RefundResponse refund (RefundRequest RefundRequest) throws SSLConfigurationException, InvalidCredentialException, UnsupportedEncodingException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException {
		return refund(RefundRequest, null);
	}

	/**
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
	public SetPaymentOptionsResponse setPaymentOptions (SetPaymentOptionsRequest SetPaymentOptionsRequest,  String apiUsername) throws SSLConfigurationException, InvalidCredentialException, UnsupportedEncodingException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException {
		String response = call("SetPaymentOptions", SetPaymentOptionsRequest.toNVPString(), apiUsername);
		return new SetPaymentOptionsResponse(NVPUtil.decode(response), "");
	}

	public SetPaymentOptionsResponse setPaymentOptions (SetPaymentOptionsRequest SetPaymentOptionsRequest) throws SSLConfigurationException, InvalidCredentialException, UnsupportedEncodingException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException {
		return setPaymentOptions(SetPaymentOptionsRequest, null);
	}

	/**
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
	public GetFundingPlansResponse getFundingPlans (GetFundingPlansRequest GetFundingPlansRequest,  String apiUsername) throws SSLConfigurationException, InvalidCredentialException, UnsupportedEncodingException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException {
		String response = call("GetFundingPlans", GetFundingPlansRequest.toNVPString(), apiUsername);
		return new GetFundingPlansResponse(NVPUtil.decode(response), "");
	}

	public GetFundingPlansResponse getFundingPlans (GetFundingPlansRequest GetFundingPlansRequest) throws SSLConfigurationException, InvalidCredentialException, UnsupportedEncodingException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException {
		return getFundingPlans(GetFundingPlansRequest, null);
	}

	/**
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
	public GetAvailableShippingAddressesResponse getAvailableShippingAddresses (GetAvailableShippingAddressesRequest GetAvailableShippingAddressesRequest,  String apiUsername) throws SSLConfigurationException, InvalidCredentialException, UnsupportedEncodingException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException {
		String response = call("GetAvailableShippingAddresses", GetAvailableShippingAddressesRequest.toNVPString(), apiUsername);
		return new GetAvailableShippingAddressesResponse(NVPUtil.decode(response), "");
	}

	public GetAvailableShippingAddressesResponse getAvailableShippingAddresses (GetAvailableShippingAddressesRequest GetAvailableShippingAddressesRequest) throws SSLConfigurationException, InvalidCredentialException, UnsupportedEncodingException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException {
		return getAvailableShippingAddresses(GetAvailableShippingAddressesRequest, null);
	}

	/**
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
	public GetShippingAddressesResponse getShippingAddresses (GetShippingAddressesRequest GetShippingAddressesRequest,  String apiUsername) throws SSLConfigurationException, InvalidCredentialException, UnsupportedEncodingException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException {
		String response = call("GetShippingAddresses", GetShippingAddressesRequest.toNVPString(), apiUsername);
		return new GetShippingAddressesResponse(NVPUtil.decode(response), "");
	}

	public GetShippingAddressesResponse getShippingAddresses (GetShippingAddressesRequest GetShippingAddressesRequest) throws SSLConfigurationException, InvalidCredentialException, UnsupportedEncodingException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException {
		return getShippingAddresses(GetShippingAddressesRequest, null);
	}

	/**
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
	public GetUserLimitsResponse getUserLimits (GetUserLimitsRequest GetUserLimitsRequest,  String apiUsername) throws SSLConfigurationException, InvalidCredentialException, UnsupportedEncodingException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException {
		String response = call("GetUserLimits", GetUserLimitsRequest.toNVPString(), apiUsername);
		return new GetUserLimitsResponse(NVPUtil.decode(response), "");
	}

	public GetUserLimitsResponse getUserLimits (GetUserLimitsRequest GetUserLimitsRequest) throws SSLConfigurationException, InvalidCredentialException, UnsupportedEncodingException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException {
		return getUserLimits(GetUserLimitsRequest, null);
	}

}
