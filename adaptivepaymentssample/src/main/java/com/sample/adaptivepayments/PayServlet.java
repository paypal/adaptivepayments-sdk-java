package com.sample.adaptivepayments;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.paypal.exception.ClientActionRequiredException;
import com.paypal.exception.HttpErrorException;
import com.paypal.exception.InvalidCredentialException;
import com.paypal.exception.InvalidResponseDataException;
import com.paypal.exception.MissingCredentialException;
import com.paypal.exception.SSLConfigurationException;
import com.paypal.sdk.exceptions.OAuthException;
import com.paypal.svcs.services.AdaptivePaymentsService;
import com.paypal.svcs.types.ap.FundingConstraint;
import com.paypal.svcs.types.ap.FundingTypeInfo;
import com.paypal.svcs.types.ap.FundingTypeList;
import com.paypal.svcs.types.ap.PayRequest;
import com.paypal.svcs.types.ap.PayResponse;
import com.paypal.svcs.types.ap.Receiver;
import com.paypal.svcs.types.ap.ReceiverList;
import com.paypal.svcs.types.ap.SenderIdentifier;
import com.paypal.svcs.types.common.ClientDetailsType;
import com.paypal.svcs.types.common.PhoneNumberType;
import com.paypal.svcs.types.common.RequestEnvelope;
import com.sample.util.Configuration;

/**
 * Servlet implementation class PayServlet
 */
public class PayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PayServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		getServletConfig().getServletContext().getRequestDispatcher("/Pay.jsp")
				.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		session.setAttribute("url", request.getRequestURI());
		session.setAttribute(
				"relatedUrl",
				"<ul><li><a href='Pay'>Pay</a></li><li><a href='PaymentDetails'>PaymentDetails</a></li><li><a href='Refund'>Refund</a></li><li><a href='GetPaymentOptions'>GetPaymentOptions</a></li><li><a href='ExecutePayment'>ExecutePayment</a></li><li><a href='SetPaymentOptions'>SetPaymentOptions</a></li></ul>");
		RequestEnvelope requestEnvelope = new RequestEnvelope("en_US");

		PayRequest req = new PayRequest();

		List<Receiver> receiver = new ArrayList<Receiver>();

		Receiver rec = new Receiver();
		/** (Required) Amount to be paid to the receiver */
		if (request.getParameter("amount") != "")
			rec.setAmount(Double.parseDouble(request.getParameter("amount")));
		/**
		 *  Receiver's email address. This address can be unregistered with paypal.com.
		 *  If so, a receiver cannot claim the payment until a PayPal account is linked
		 *  to the email address. The PayRequest must pass either an email address or a phone number. 
		 *  Maximum length: 127 characters 
		 */
		if (request.getParameter("mail") != "")
			rec.setEmail(request.getParameter("mail"));
		/**
		 * (Optional) The invoice number for the payment. 
		 *  This data in this field shows on the Transaction Details report. 
		 *  Maximum length: 127 characters 
		 */
		if (request.getParameter("invoiceID") != "")
			rec.setInvoiceId(request.getParameter("invoiceID"));
		/** (Optional) The transaction subtype for the payment. */ 
		if (request.getParameter("paymentSubType") != "")
			rec.setPaymentSubType(request.getParameter("paymentSubType"));
		/**
		 * (Optional) The transaction type for the payment. Allowable values are:
		    GOODS – This is a payment for non-digital goods
		    SERVICE – This is a payment for services (default)
		    PERSONAL – This is a person-to-person payment
		    CASHADVANCE – This is a person-to-person payment for a cash advance
		    DIGITALGOODS – This is a payment for digital goods
		    BANK_MANAGED_WITHDRAWAL – This is a person-to-person payment for bank withdrawals, available only with special permission.
		 */
		if (request.getParameter("paymentType") != "")
			rec.setPaymentType(request.getParameter("paymentType"));
		/**
		 * A type to specify the receiver's phone number.
		 * The PayRequest must pass either an email address or a phone number as the payment receiver. 
		 */
		if (request.getParameter("phoneNumber") != "") {
			PhoneNumberType phone = new PhoneNumberType(
					request.getParameter("countryCode"),
					request.getParameter("phoneNumber"));
			phone.setExtension(request.getParameter("extension"));
			rec.setPhone(phone);
		}
		/**
		 * (Optional) Whether this receiver is the primary receiver, 
		 * which makes the payment a chained payment.You can specify at most one primary receiver. 
		 *  Omit this field for simple and parallel payments. Allowable values are:
			   true – Primary receiver
			   false – Secondary receiver (default)
		 */
		if (request.getParameter("setPrimary") != "")
			rec.setPrimary(Boolean.parseBoolean(request.getParameter("setPrimary")));
		
		receiver.add(rec);
		
		ReceiverList receiverlst = new ReceiverList(receiver);
		req.setReceiverList(receiverlst);
		req.setRequestEnvelope(requestEnvelope);
		ClientDetailsType clientDetails = new ClientDetailsType();
		/** (Optional) Your application's identification, such as the name of your application */ 
		if (request.getParameter("applicationID") != "")
			clientDetails.setApplicationId(request.getParameter("applicationID"));
		/**  (Optional) Your ID for this sender Maximum length: 127 characters */ 
		if (request.getParameter("customerID") != "")
			clientDetails.setCustomerId(request.getParameter("customerID"));
		/** (Optional) Your identification of the type of customer Maximum length: 127 characters */ 
		if (request.getParameter("customerType") != "")
			clientDetails.setCustomerType(request.getParameter("customerType"));
		/**
		 *  (Optional) Sender's device ID, such as a mobile device's IMEI number or a web browser cookie.
		 *  If a device ID was passed with the PayRequest, use the same ID here. Maximum length: 127 characters
		 */
		if (request.getParameter("deviceID") != "")
			clientDetails.setDeviceId(request.getParameter("deviceID"));
		/** (Optional) Sender's geographic location Maximum length: 127 characters */ 
		if (request.getParameter("location") != "")
			clientDetails.setGeoLocation(request.getParameter("location"));
		/**
		 * (Optional) Sender's IP address.
		 *  If an IP addressed was passed with the PayRequest, use the same ID here. 
		 */
		if (request.getParameter("ipAddress") != "")
			clientDetails.setIpAddress(request.getParameter("ipAddress"));
		/** (Optional) A sub-identification of the application Maximum length: 127 characters */ 
		if (request.getParameter("model") != "")
			clientDetails.setModel(request.getParameter("model"));
		/** (Optional) Your organization's name or ID Maximum length: 127 characters */ 
		if (request.getParameter("partnerName") != "")
			clientDetails.setPartnerName(request.getParameter("partnerName"));
		
		req.setClientDetails(clientDetails);
		/**
		 * (Optional) The URL to which you want all IPN messages for this payment to be sent. 
		 * Maximum length: 1024 characters 
		 */
		if (request.getParameter("ipnNotificationURL") != "")
			req.setIpnNotificationUrl(request.getParameter("ipnNotificationURL"));
		/**
		 * (Optional) A note associated with the payment (text, not HTML). 
		 * Maximum length: 1000 characters, including newline characters 
		 */
		if (request.getParameter("memo") != "")
			req.setMemo(request.getParameter("memo"));
		/**
		 * (Optional) The sender's personal identification number, 
		 * which was specified when the sender signed up for a preapproval. 
		 */
		if (request.getParameter("pin") != "")
			req.setPin(request.getParameter("pin"));
		
		/**  (Optional) Sender's email address. Maximum length: 127 characters */ 
		if (request.getParameter("senderEmail") != "")
			req.setSenderEmail(request.getParameter("senderEmail"));
		/**
		 * (Optional) The payer of PayPal fees. Allowable values are: 
	       SENDER – Sender pays all fees (for personal, implicit simple/parallel payments; do not use for chained or unilateral payments)
		   PRIMARYRECEIVER – Primary receiver pays all fees (chained payments only)
		   EACHRECEIVER – Each receiver pays their own fee (default, personal and unilateral payments)
		   SECONDARYONLY – Secondary receivers pay all fees (use only for chained payments with one secondary receiver)
		 */
		if (request.getParameter("feesPayer") != "")
			req.setFeesPayer(request.getParameter("feesPayer"));
		
		FundingConstraint fundingConstraint = new FundingConstraint();
		List<FundingTypeInfo> fundingTypeInfoList = new ArrayList<FundingTypeInfo>();
		
		/**
		 * (Required) Specifies a list of allowed funding selections for the payment. 
		 * This is a list of funding selections that can be combined in any order to
		 * allow payments to use the indicated funding type. If this field is omitted, 
		 * the payment can be funded by any funding type that is supported for Adaptive Payments.
		 *  Allowable values are:
		    ECHECK – Electronic check
		    BALANCE – PayPal account balance
		    CREDITCARD – Credit card
		 */
		if (request.getParameter("fundingType") != "") {
			FundingTypeInfo fundingTypeInfo = new FundingTypeInfo(
					request.getParameter("fundingType"));
			fundingTypeInfoList.add(fundingTypeInfo);
		}
		FundingTypeList fundingTypeList = new FundingTypeList(
				fundingTypeInfoList);
		fundingConstraint.setAllowedFundingType(fundingTypeList);
		req.setFundingConstraint(fundingConstraint);
		/** Preapproval key for the approval set up between you and the sender */
		if (request.getParameter("preapprovalKey") != "")
			req.setPreapprovalKey(request.getParameter("preapprovalKey"));
		/**
		 * Whether to reverse parallel payments. Possible values are:
			 true – Each parallel payment is reversed if an error occurs
			 false – Each parallel payment is not reversed if an error occurs
		 */
		if (request.getParameter("reverseAllPaymentsOnError") != "")
			req.setReverseAllParallelPaymentsOnError(Boolean
					.parseBoolean(request
							.getParameter("reverseAllPaymentsOnError")));
		
		SenderIdentifier senderIdentifier = new SenderIdentifier();
		if (request.getParameter("senderIdentifierEmail") != "")
			senderIdentifier.setEmail(request.getParameter("senderIdentifierEmail"));
		
		/**
		 *  Telephone country code
		 * Telephone number
		 * Telephone extension
		 */
		if (request.getParameter("senderCountryCode") != ""
				&& request.getParameter("senderPhoneNumber") != "") {
			PhoneNumberType senderPhone = new PhoneNumberType(
					request.getParameter("senderCountryCode"),
					request.getParameter("senderPhoneNumber"));
			if (request.getParameter("senderExtension") != "")
				senderPhone.setExtension(request
						.getParameter("senderExtension"));
			senderIdentifier.setPhone(senderPhone);
		}
		
		/** (Optional) If true, use credentials to identify the sender; default is false. */ 
		if (request.getParameter("useCredentials") != "")
			senderIdentifier.setUseCredentials(Boolean.parseBoolean(request
					.getParameter("useCredentials")));
		
		req.setSender(senderIdentifier);
		/** (Optional) A unique ID that you specify to track the payment. */
		if (request.getParameter("trackingID") != "")
			req.setTrackingId(request.getParameter("trackingID"));
		/**
		 * The action for this request. Possible values are:
		    PAY – Use this option if you are not using the Pay request in combination with ExecutePayment.
		    CREATE – Use this option to set up the payment instructions with SetPaymentOptions and then execute the payment at a later time with the ExecutePayment.
		    PAY_PRIMARY – For chained payments only, specify this value to delay payments to the secondary receivers; only the payment to the primary receiver is processed.
		 */
		if (request.getParameter("actionType") != "")
			req.setActionType(request.getParameter("actionType"));
		/**
		 * URL to redirect the sender's browser to after canceling the approval for a payment;
		 *  it is always required but only used for payments that require approval (explicit payments) 
		 */
		if (request.getParameter("cancelURL") != "")
			req.setCancelUrl(request.getParameter("cancelURL"));
		/**
		 * The code for the currency in which the payment is made;
		 * you can specify only one currency, regardless of the number of receivers
		 */
		if (request.getParameter("currencyCode") != "")
			req.setCurrencyCode(request.getParameter("currencyCode"));
		/**
		 * URL to redirect the sender's browser to after the sender has logged into PayPal and approved a payment; 
		 * it is always required but only used if a payment requires explicit approval 
		 */
		if (request.getParameter("returnURL") != "")
			req.setReturnUrl(request.getParameter("returnURL"));
		
		// Configuration map containing signature credentials and other required configuration.
		// For a full list of configuration parameters refer in wiki page
		// (https://github.com/paypal/sdk-core-java/wiki/SDK-Configuration-Parameters)
		Map<String,String> configurationMap =  Configuration.getAcctAndConfig();
		
		// Creating service wrapper object to make an API call by loading configuration map. 
		AdaptivePaymentsService service = new AdaptivePaymentsService(configurationMap);
		
		try {
			PayResponse resp = service.pay(req);
			response.setContentType("text/html");
			if (resp != null) {
				session.setAttribute("RESPONSE_OBJECT", resp);
				session.setAttribute("lastReq", service.getLastRequest());
				session.setAttribute("lastResp", service.getLastResponse());
				if (resp.getResponseEnvelope().getAck().toString()
						.equalsIgnoreCase("SUCCESS")) {
					Map<Object, Object> map = new LinkedHashMap<Object, Object>();
					map.put("Ack", resp.getResponseEnvelope().getAck());
					
					/**
					 * Correlation identifier. It is a 13-character, alphanumeric string 
					  (for example, db87c705a910e) that is used only by PayPal Merchant Technical Support.
						Note: You must log and store this data for every response you receive. 
						PayPal Technical Support uses the information to assist with reported issues. 
					 */
					map.put("Correlation ID", resp.getResponseEnvelope().getCorrelationId());
					
					/** 
					 * Date on which the response was sent, for example: 2012-04-02T22:33:35.774-07:00
					   Note: You must log and store this data for every response you receive. 
					   PayPal Technical Support uses the information to assist with reported issues. 
					 */
					map.put("Time Stamp", resp.getResponseEnvelope().getTimestamp());
					
					/**
					 * The pay key, which is a token you use in other Adaptive Payment APIs 
					 * (such as the Refund Method) to identify this payment. 
					 * The pay key is valid for 3 hours; the payment must be approved while the 
					 * pay key is valid. 
					 */
					map.put("Pay Key", resp.getPayKey());
					
					/**
					 * The status of the payment. Possible values are:
				    CREATED – The payment request was received; funds will be transferred once the payment is approved
				    COMPLETED – The payment was successful
				    INCOMPLETE – Some transfers succeeded and some failed for a parallel payment or, for a delayed chained payment, secondary receivers have not been paid
				    ERROR – The payment failed and all attempted transfers failed or all completed transfers were successfully reversed
				    REVERSALERROR – One or more transfers failed when attempting to reverse a payment
				    PROCESSING – The payment is in progress
				    PENDING – The payment is awaiting processing
				    */
					map.put("Payment Execution Status",resp.getPaymentExecStatus());
					if (resp.getDefaultFundingPlan() != null){
						/** Default funding plan.  */
						map.put("Default Funding Plan", resp.getDefaultFundingPlan().getFundingPlanId());
					}	
					
					map.put("Redirect URL",
							"<a href=https://www.sandbox.paypal.com/cgi-bin/webscr?cmd=_ap-payment&paykey="
									+ resp.getPayKey()
									+ ">https://www.sandbox.paypal.com/cgi-bin/webscr?cmd=_ap-payment&paykey="
									+ resp.getPayKey() + "</a>");
					session.setAttribute("map", map);
					response.sendRedirect("Response.jsp");
				} else {
					session.setAttribute("Error", resp.getError());
					response.sendRedirect("Error.jsp");
				}
			}
		} catch (SSLConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidCredentialException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (HttpErrorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidResponseDataException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClientActionRequiredException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MissingCredentialException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (OAuthException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
