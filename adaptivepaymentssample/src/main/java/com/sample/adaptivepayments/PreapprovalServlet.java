package com.sample.adaptivepayments;

import java.io.IOException;
import java.util.LinkedHashMap;
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
import com.paypal.svcs.types.ap.PreapprovalRequest;
import com.paypal.svcs.types.ap.PreapprovalResponse;
import com.paypal.svcs.types.common.ClientDetailsType;
import com.paypal.svcs.types.common.DayOfWeek;
import com.paypal.svcs.types.common.RequestEnvelope;
import com.sample.util.Configuration;

/**
 * Servlet implementation class PreapprovalServlet
 */
public class PreapprovalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PreapprovalServlet() {
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
				.getRequestDispatcher("/Preapproval.jsp")
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
				"<ul><li><a href='Preapproval'>Preapproval</a></li><li><a href='PreapprovalDetails'>PreapprovalDetails</a></li><li><a href='ConfirmPreapproval'>ConfirmPreapproval</a></li><li><a href='CancelPreapproval'>CancelPreapproval</a></li></ul>");
		RequestEnvelope requestEnvelope = new RequestEnvelope("en_US");
		PreapprovalRequest req = new PreapprovalRequest();

		ClientDetailsType clientDetails = new ClientDetailsType();

		/** (Optional) Your application's identification, such as the name of your application */ 
		if (request.getParameter("applicationID") != "")
			clientDetails.setApplicationId(request.getParameter("applicationID"));
		/** (Optional) Your ID for this sender Maximum length: 127 characters */ 
		if (request.getParameter("customerID") != "")
			clientDetails.setCustomerId(request.getParameter("customerID"));
		/** (Optional) Your identification of the type of customer Maximum length: 127 characters */ 
		if (request.getParameter("customerType") != "")
			clientDetails.setCustomerType(request.getParameter("customerType"));
		/**
		 * (Optional) Sender's device ID, such as a mobile device's IMEI number or a web browser cookie.
		 *   If a device ID was passed with the PayRequest, use the same ID here. Maximum length: 127 characters 
		 */
		if (request.getParameter("deviceID") != "")
			clientDetails.setDeviceId(request.getParameter("deviceID"));
		/**  (Optional) Sender's geographic location Maximum length: 127 characters */ 
		if (request.getParameter("location") != "")
			clientDetails.setGeoLocation(request.getParameter("location"));
		/**
		 *  (Optional) Sender's IP address. 
		 * If an IP addressed was passed with the PayRequest, use the same ID here.
		 */
		if (request.getParameter("ipAddress") != "")
			clientDetails.setIpAddress(request.getParameter("ipAddress"));
		/**  (Optional) A sub-identification of the application Maximum length: 127 characters */
		if (request.getParameter("model") != "")
			clientDetails.setModel(request.getParameter("model"));
		/** (Optional) Your organization's name or ID Maximum length: 127 characters */
		if (request.getParameter("partnerName") != "")
			clientDetails.setPartnerName(request.getParameter("partnerName"));
		
		req.setClientDetails(clientDetails);
		
		/**
		 * (Optional) The day of the month on which a monthly payment is to be made.
		 *   Allowable values are numbers between 0 and 31.
		 *   A number between 1 and 31 indicates the date of the month.
		 *   Specifying 0 indicates that payment can be made on any day of the month. 
		 */
		if (request.getParameter("dateOfMonth") != "")
			req.setDateOfMonth(Integer.parseInt(request.getParameter("dateOfMonth")));
		/**
		 * (Optional) The day of the week that a weekly payment is to be made. Allowable values are: 
		        NO_DAY_SPECIFIED
			    SUNDAY
			    MONDAY
			    TUESDAY
			    WEDNESDAY
			    THURSDAY
			    FRIDAY
			    SATURDAY
		 */
		if (request.getParameter("dayOfWeek") != "")
			req.setDayOfWeek(DayOfWeek.fromValue(request.getParameter("dayOfWeek")));
		/**
		 * (Optional) Whether to display the maximum total amount of this preapproval. It is one of the following values:
			   TRUE – Display the amount
			   FALSE – Do not display the amount (default)
		 */
		if (request.getParameter("displayMaxTotalAmount") != "")
			req.setDisplayMaxTotalAmount(Boolean.parseBoolean(request.getParameter("displayMaxTotalAmount")));
		/**
		 * (Optional) The payer of PayPal fees. Allowable values are:
		    SENDER – Sender pays all fees (for personal, implicit simple/parallel payments; do not use for chained or unilateral payments)
		    PRIMARYRECEIVER – Primary receiver pays all fees (chained payments only)
		    EACHRECEIVER – Each receiver pays their own fee (default, personal and unilateral payments)
		    SECONDARYONLY – Secondary receivers pay all fees (use only for chained payments with one secondary receiver)
		 */
		if (request.getParameter("feesPayer") != "")
			req.setFeesPayer(request.getParameter("feesPayer"));
		
		/**
		 * (Optional) The URL to which you want all IPN messages for this preapproval to be sent.
		 *  This URL supersedes the IPN notification URL in your profile.
		 *   Maximum length: 1024 characters 
		 */
		if (request.getParameter("ipnNotificationURL") != "")
			req.setIpnNotificationUrl(request.getParameter("ipnNotificationURL"));
		/**
		 * (Optional) The preapproved maximum amount per payment.
		 * It cannot exceed the preapproved maximum total amount of all payments. 
		 */
		if (request.getParameter("maxAmountPerPayment") != "")
			req.setMaxAmountPerPayment(Double.parseDouble(request.getParameter("maxAmountPerPayment")));
		/**
		 * (Optional) The preapproved maximum number of payments.
		 *   It cannot exceed the preapproved maximum total number of all payments. 
		 */
		if (request.getParameter("maxNumberOfPayments") != "")
			req.setMaxNumberOfPayments(Integer.parseInt(request.getParameter("maxNumberOfPayments")));
		/**
		 * (Optional) The preapproved maximum number of all payments per period. 
		 *  You must specify a value unless you have specific permission from PayPal. 
		 */
		if (request.getParameter("maxNumberOfPaymentsPerPeriod") != "")
			req.setMaxNumberOfPaymentsPerPeriod(Integer.parseInt(request.getParameter("maxNumberOfPaymentsPerPeriod")));
		/**
		 * (Optional) The preapproved maximum total amount of all payments.
		 *  It cannot exceed $2,000 USD or its equivalent in other currencies
		 */
		if (request.getParameter("totalAmountOfAllPayments") != "")
			req.setMaxTotalAmountOfAllPayments(Double.parseDouble(request
					.getParameter("totalAmountOfAllPayments")));
		/**
		 * (Optional) A note about the preapproval. 
		 * Maximum length: 1000 characters, including newline characters 
		 */
		if (request.getParameter("memo") != "")
			req.setMemo(request.getParameter("memo"));
		/**
		 * (Optional) The payment period. It is one of the following values:
		    NO_PERIOD_SPECIFIED
		    DAILY – Each day
		    WEEKLY – Each week
		    BIWEEKLY – Every other week
		    SEMIMONTHLY – Twice a month
		    MONTHLY – Each month
		    ANNUALLY – Each year
		 */
		if (request.getParameter("paymentPeriod") != "")
			req.setPaymentPeriod(request.getParameter("paymentPeriod"));
		/**
		 * (Optional) Whether a personal identification number (PIN) is required. It is one of the following values:
		    NOT_REQUIRED – A PIN is not required (default)
		    REQUIRED – A PIN is required; the sender must specify a PIN when setting up the preapproval on PayPal
		 */
		if (request.getParameter("pinType") != "")
			req.setPinType(request.getParameter("pinType"));
		/**
		 * (Optional) Sender's email address. If not specified,
		 *  the email address of the sender who logs in to approve
		 *  the request becomes the email address associated with the preapproval key.
		 *  Maximum length: 127 characters 
		 */
		if (request.getParameter("senderEmail") != "")
			req.setSenderEmail(request.getParameter("senderEmail"));
		//URL to redirect the sender's browser to after canceling the preapproval 
		if (request.getParameter("cancelURL") != "")
			req.setCancelUrl(request.getParameter("cancelURL"));
		/**
		 * The code for the currency in which the payment is made; 
		 * you can specify only one currency, regardless of the number of receivers 
		 */
		if (request.getParameter("currencyCode") != "")
			req.setCurrencyCode(request.getParameter("currencyCode"));
		/**
		 * URL to redirect the sender's browser
		 * to after the sender has logged into PayPal and confirmed the preapproval 
		 */
		if (request.getParameter("returnURL") != "")
			req.setReturnUrl(request.getParameter("returnURL"));
		
		req.setRequestEnvelope(requestEnvelope);
		/**
		 *  First date for which the preapproval is valid. 
		 * It cannot be before today's date or after the ending date. 
		 */
		if (request.getParameter("startingDate") != "")
			req.setStartingDate(request.getParameter("startingDate"));
		/**
		 *  Last date for which the preapproval is valid. 
		 * It cannot be later than one year from the starting date. 
		 * Contact PayPal if you do not want to specify an ending date
		 */
		if (request.getParameter("endingDate") != "")
			req.setEndingDate(request.getParameter("endingDate"));
		
		// Configuration map containing signature credentials and other required configuration.
		// For a full list of configuration parameters refer in wiki page
		// (https://github.com/paypal/sdk-core-java/wiki/SDK-Configuration-Parameters)
		Map<String,String> configurationMap =  Configuration.getAcctAndConfig();
		
		// Creating service wrapper object to make an API call by loading configuration map. 
		AdaptivePaymentsService service = new AdaptivePaymentsService(configurationMap);
		
		try {
			PreapprovalResponse resp = service.preapproval(req);
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
					
					/** A preapproval key that identifies the preapproval requested */
					map.put("Preapproval Key", resp.getPreapprovalKey());
					map.put("Redirect URL",
							"<a href=https://www.sandbox.paypal.com/cgi-bin/webscr?cmd=_ap-preapproval&preapprovalkey="
									+ resp.getPreapprovalKey()
									+ ">Redirect to paypal</a>");
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
