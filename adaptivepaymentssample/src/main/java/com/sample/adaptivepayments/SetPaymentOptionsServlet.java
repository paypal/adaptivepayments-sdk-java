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
import com.paypal.svcs.types.ap.DisplayOptions;
import com.paypal.svcs.types.ap.InitiatingEntity;
import com.paypal.svcs.types.ap.InstitutionCustomer;
import com.paypal.svcs.types.ap.InvoiceData;
import com.paypal.svcs.types.ap.InvoiceItem;
import com.paypal.svcs.types.ap.ReceiverIdentifier;
import com.paypal.svcs.types.ap.ReceiverOptions;
import com.paypal.svcs.types.ap.SenderOptions;
import com.paypal.svcs.types.ap.SetPaymentOptionsRequest;
import com.paypal.svcs.types.ap.SetPaymentOptionsResponse;
import com.paypal.svcs.types.common.PhoneNumberType;
import com.paypal.svcs.types.common.RequestEnvelope;
import com.sample.util.Configuration;

/**
 * Servlet implementation class SetPaymentOptionsServlet
 */
public class SetPaymentOptionsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SetPaymentOptionsServlet() {
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
		getServletConfig().getServletContext()
				.getRequestDispatcher("/SetPaymentOptions.jsp")
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
				"<ul><li><a href='Pay'>Pay</a></li><li><a href='PaymentDetails'>PaymentDetails</a></li><li><a href='Refund'>Refund</a></li><li><a href='GetPaymentOptions'>GetPaymentOptions</a></li><li><a href='ExecutePayment'>ExecutePayment</a></li></ul>");
		RequestEnvelope requestEnvelope = new RequestEnvelope("en_US");
		SetPaymentOptionsRequest req = new SetPaymentOptionsRequest();
		/**
		 * (Required) The pay key that identifies the payment for which you want to set payment options. 
		 * This is the pay key returned in the PayResponse message.
		 */
		if (request.getParameter("payKey") != "")
			req.setPayKey(request.getParameter("payKey"));
		
		DisplayOptions displayOptions = new DisplayOptions();
		/** (Optional) The business name to display. The name cannot exceed 128 characters. */
		if (request.getParameter("businessName") != "")
			displayOptions
					.setBusinessName(request.getParameter("businessName"));
		/**
		 * (Optional) The URL of the image that displays in the in the header of customer emails.
		 *  The URL cannot exceed 1,024 characters. 
		 *  The image dimensions are 43 pixels high x 240 pixels wide.
		 */
		if (request.getParameter("emailHeaderImageURL") != "")
			displayOptions.setEmailHeaderImageUrl(request
					.getParameter("emailHeaderImageURL"));
		/**
		 * (Optional) The URL of the image that displays in the in customer emails. 
		 * The URL cannot exceed 1,024 characters. 
		 * The image dimensions are 80 pixels high x 530 pixels wide.
		 */
		if (request.getParameter("emailHeaderMarketingURL") != "")
			displayOptions.setEmailMarketingImageUrl(request
					.getParameter("emailHeaderMarketingURL"));
		/**
		 * (Optional) The URL of an image that displays in the header of a payment page.
		 *  If set, it overrides the header image URL specified in your account's Profile.
		 *  The URL cannot exceed 1,024 characters. The image dimensions are 90 pixels high x 750 pixels wide.
		 */
		if (request.getParameter("headerImageURL") != "")
			displayOptions.setHeaderImageUrl(request.getParameter("headerImageURL"));
		
		req.setDisplayOptions(displayOptions);
		
		InitiatingEntity initiatingEntity = new InitiatingEntity();
		/**
		 *  institutionId: (Required) The unique identifier assigned to the institution.
		 *  firstName: (Required) The first name of the consumer as known by the institution.
		 *  lastName: Required) The last name of the consumer as known by the institution.
		 *  displayName: (Required) The full name of the consumer as known by the institution.
		 *  institutionCustomerId: (Required) The unique identifier assigned to the consumer by the institution.
		 *  countryCode: (Required) The two-character country code of the home country of the end consumer
		 *  email: (Optional) The email address of the consumer as known by the institution.
		 */
		if (request.getParameter("institutionId") != ""
				&& request.getParameter("institutionId") != "firstName"
				&& request.getParameter("institutionId") != "lastName"
				&& request.getParameter("institutionId") != "displayName"
				&& request.getParameter("institutionId") != "institutionCustomerId"
				&& request.getParameter("institutionId") != "countryCode") {
			InstitutionCustomer institutionCustomer = new InstitutionCustomer(
					request.getParameter("institutionId"),
					request.getParameter("firstName"),
					request.getParameter("lastName"),
					request.getParameter("displayName"),
					request.getParameter("institutionCustomerId"),
					request.getParameter("countryCode"));
			if (request.getParameter("institutionMail") != "")
				institutionCustomer.setEmail(request
						.getParameter("institutionMail"));

			initiatingEntity.setInstitutionCustomer(institutionCustomer);
		}
		req.setInitiatingEntity(initiatingEntity);
		
		/** (Optional) Sender's shipping address ID. */
		if (request.getParameter("shippingAddressID") != "")
			req.setShippingAddressId(request.getParameter("shippingAddressID"));

		List<ReceiverOptions> receiverOptionsList = new ArrayList<ReceiverOptions>();
		ReceiverIdentifier receiver = new ReceiverIdentifier();
		
		/** (Optional) Receiver's email address. */ 
		if (request.getParameter("receiverMail") != "")
			receiver.setEmail(request.getParameter("receiverMail"));
		
		PhoneNumberType receiverPhone = null;
		/**
		 * (Required) Telephone country code.
		 * (Required) Telephone number. 
		 * (Optional) Telephone extension. 
		 */
		if (request.getParameter("receiverCountryCode") != ""
				&& request.getParameter("receiverPhoneNumber") != "") {
			receiverPhone = new PhoneNumberType(
					request.getParameter("receiverCountryCode"),
					request.getParameter("receiverPhoneNumber"));

			if (request.getParameter("receiverExtension") != "")
				receiverPhone.setExtension(request
						.getParameter("receiverExtension"));
			receiver.setPhone(receiverPhone);
		}
		
		ReceiverOptions receiverOptions = new ReceiverOptions(receiver);
		//(Optional) An external reference or identifier you want to associate with the payment. 
		if (request.getParameter("customID") != "")
			receiverOptions.setCustomId(request.getParameter("customID"));
		/**
		 * (Optional) A description you want to associate with the payment.
		 *  This overrides the value of the memo in Pay API for each receiver.
		 *   If this is not specified the value in the memo will be used.
		 */
		if (request.getParameter("description") != "")
			receiverOptions.setDescription(request.getParameter("description"));

		InvoiceData invoiceData = new InvoiceData();
		List<InvoiceItem> invoiceItemList = new ArrayList<InvoiceItem>();
		InvoiceItem invoiceItem = new InvoiceItem();
		
		/** (Optional) External reference to item or item ID. */
		if (request.getParameter("invoiceIdentifier") != "")
			invoiceItem.setIdentifier(request.getParameter("invoiceIdentifier"));

		Double itemPrice = null;
		Integer itemCount = null;
		/** (Optional) Item quantity. */ 
		if (request.getParameter("invoiceItemCount") != "") {
			itemCount = Integer.parseInt(request.getParameter("invoiceItemCount"));
			invoiceItem.setItemCount(itemCount);
		}
		/** (Optional) Price of an individual item. */
		if (request.getParameter("invoiceItemPrice") != "") {
			itemPrice = Double.parseDouble(request.getParameter("invoiceItemPrice"));
			invoiceItem.setItemPrice(itemPrice);
		}
		
		if (request.getParameter("invoiceItemCount") != ""
				&& request.getParameter("invoiceItemPrice") != "") {
			Double price = itemCount * itemPrice;
			invoiceItem.setPrice(price);
		}
		/** (Optional) Name of item. */ 
		if (request.getParameter("invoiceName") != "")
			invoiceItem.setName(request.getParameter("invoiceName"));
		invoiceItemList.add(invoiceItem);
		invoiceData.setItem(invoiceItemList);
		/** (Optional) Total shipping charge associated with the payment. */ 
		if (request.getParameter("invoiceTotalShipping") != "")
			invoiceData.setTotalShipping(Double.parseDouble(request
					.getParameter("invoiceTotalShipping")));
		/** (Optional) Total tax associated with the payment */
		if (request.getParameter("invoiceTotalTax") != "")
			invoiceData.setTotalTax(Double.parseDouble(request
					.getParameter("invoiceTotalTax")));
		receiverOptions.setInvoiceData(invoiceData);
		/** (Optional) A code that identifies the partner associated with this transaction. */ 
		if (request.getParameter("receiverReferrerCode") != "")
			receiverOptions.setReferrerCode(request.getParameter("receiverReferrerCode"));
		receiverOptionsList.add(receiverOptions);
		req.setReceiverOptions(receiverOptionsList);

		SenderOptions senderOptions = new SenderOptions();
		/**
		 * (Optional) If true, * require the sender to select a shipping address 
		 * during the embedded payment flow; default is false.
		 */
		if (request.getParameter("requireShippingAddressSelection") != "")
			senderOptions.setRequireShippingAddressSelection(Boolean
					.parseBoolean(request
							.getParameter("requireShippingAddressSelection")));
		/** (Optional) A code that identifies the partner associated with this transaction. */ 
		if (request.getParameter("senderReferrerCode") != "")
			senderOptions.setReferrerCode(request.getParameter("senderReferrerCode"));
		req.setSenderOptions(senderOptions);
		req.setRequestEnvelope(requestEnvelope);

		// Configuration map containing signature credentials and other required configuration.
		// For a full list of configuration parameters refer in wiki page
		// (https://github.com/paypal/sdk-core-java/wiki/SDK-Configuration-Parameters)
		Map<String,String> configurationMap =  Configuration.getAcctAndConfig();
		
		// Creating service wrapper object to make an API call by loading configuration map. 
		AdaptivePaymentsService service = new AdaptivePaymentsService(configurationMap);
		
		response.setContentType("text/html");
		try {
			SetPaymentOptionsResponse resp = service.setPaymentOptions(req);
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
