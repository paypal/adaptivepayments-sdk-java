package com.sample.usecase;

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

import com.paypal.svcs.services.AdaptivePaymentsService;
import com.paypal.svcs.types.ap.PayRequest;
import com.paypal.svcs.types.ap.PayResponse;
import com.paypal.svcs.types.ap.PreapprovalRequest;
import com.paypal.svcs.types.ap.PreapprovalResponse;
import com.paypal.svcs.types.ap.Receiver;
import com.paypal.svcs.types.ap.ReceiverList;
import com.paypal.svcs.types.common.DayOfWeek;
import com.paypal.svcs.types.common.RequestEnvelope;
import com.sample.util.Configuration;

public class PreapprovalPaymentServlet extends HttpServlet {
	private static final long serialVersionUID = 97034234203978L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		if(request.getRequestURI().contains("Preapprove")){
			getServletConfig().getServletContext()
			.getRequestDispatcher("/usecase_jsp/Preapproval.jsp")
			.forward(request, response);
		}
		if(request.getRequestURI().contains("PreapprovalPayment")){
			getServletConfig().getServletContext()
			.getRequestDispatcher("/usecase_jsp/PreapprovalPayment.jsp")
			.forward(request, response);
		}

	}
	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		//*********************************************************************
		//*****  Create a Preapproval agreement between you and sender ********
		//*********************************************************************
		if(request.getRequestURI().contains("Preapprove")){
			// TODO Auto-generated method stub
			HttpSession session = request.getSession();
			session.setAttribute("url", request.getRequestURI());
			RequestEnvelope requestEnvelope = new RequestEnvelope("en_US");
			PreapprovalRequest req = new PreapprovalRequest();
						
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
						session.setAttribute("preapprovalKey", resp.getPreapprovalKey());
						response.sendRedirect("Response.jsp");
					} else {
						session.setAttribute("Error", resp.getError());
						response.sendRedirect("Error.jsp");
					}
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
		
		//**********************************************************
		//*******  Make a Payment using PreapprovalKey *************
		//**********************************************************
		
		if(request.getRequestURI().contains("PreapprovalPayment")){
			PayRequest req = new PayRequest();
			RequestEnvelope requestEnvelope = new RequestEnvelope("en_US");
			req.setRequestEnvelope(requestEnvelope);
			
			List<Receiver> receiver = new ArrayList<Receiver>();
			Receiver rec = new Receiver();
			/** (Required) Amount to be paid to the receiver */
			if (request.getParameter("amount") != "")
				rec.setAmount(Double.parseDouble(request.getParameter("amount")));

			/**
			 * Receiver's email address. This address can be unregistered with
			 * paypal.com. If so, a receiver cannot claim the payment until a PayPal
			 * account is linked to the email address. The PayRequest must pass
			 * either an email address or a phone number. Maximum length: 127
			 * characters
			 */
			if (request.getParameter("mail") != "")
				rec.setEmail(request.getParameter("mail"));

			receiver.add(rec);
			ReceiverList receiverlst = new ReceiverList(receiver);
			req.setReceiverList(receiverlst);
			
			/** Preapproval key for the approval set up between you and the sender */
			if (request.getParameter("preapprovalKey") != "")
				req.setPreapprovalKey(request.getParameter("preapprovalKey"));
			/**
			 * The action for this request. Possible values are: PAY – Use this
			 * option if you are not using the Pay request in combination with
			 * ExecutePayment. CREATE – Use this option to set up the payment
			 * instructions with SetPaymentOptions and then execute the payment at a
			 * later time with the ExecutePayment. PAY_PRIMARY – For chained
			 * payments only, specify this value to delay payments to the secondary
			 * receivers; only the payment to the primary receiver is processed.
			 */
			if (request.getParameter("actionType") != "")
				req.setActionType(request.getParameter("actionType"));
			/**
			 * URL to redirect the sender's browser to after canceling the approval
			 * for a payment; it is always required but only used for payments that
			 * require approval (explicit payments)
			 */
			if (request.getParameter("cancelURL") != "")
				req.setCancelUrl(request.getParameter("cancelURL"));
			/**
			 * The code for the currency in which the payment is made; you can
			 * specify only one currency, regardless of the number of receivers
			 */
			if (request.getParameter("currencyCode") != "")
				req.setCurrencyCode(request.getParameter("currencyCode"));
			/**
			 * URL to redirect the sender's browser to after the sender has logged
			 * into PayPal and approved a payment; it is always required but only
			 * used if a payment requires explicit approval
			 */
			if (request.getParameter("returnURL") != "")
				req.setReturnUrl(request.getParameter("returnURL"));
			
			/**
			 * (Optional) The URL to which you want all IPN messages for this
			 * payment to be sent. Maximum length: 1024 characters
			 */
			if (request.getParameter("ipnNotificationURL") != "")
				req.setIpnNotificationUrl(request
						.getParameter("ipnNotificationURL"));

			// Configuration map containing signature credentials and other required
			// configuration.
			// For a full list of configuration parameters refer at
			// (https://github.com/paypal/sdk-core-java/wiki/SDK-Configuration-Parameters)
			Map<String, String> configurationMap = Configuration.getAcctAndConfig();

			// Creating service wrapper object to make an API call by loading
			// configuration map.
			AdaptivePaymentsService service = new AdaptivePaymentsService(configurationMap);
			
			HttpSession session = request.getSession();
			session.setAttribute("url", request.getRequestURI());
			
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
						 * Correlation identifier. It is a 13-character,
						 * alphanumeric string (for example, db87c705a910e) that is
						 * used only by PayPal Merchant Technical Support. Note: You
						 * must log and store this data for every response you
						 * receive. PayPal Technical Support uses the information to
						 * assist with reported issues.
						 */
						map.put("Correlation ID", resp.getResponseEnvelope()
								.getCorrelationId());

						/**
						 * Date on which the response was sent, for example:
						 * 2012-04-02T22:33:35.774-07:00 Note: You must log and
						 * store this data for every response you receive. PayPal
						 * Technical Support uses the information to assist with
						 * reported issues.
						 */
						map.put("Time Stamp", resp.getResponseEnvelope()
								.getTimestamp());

						/**
						 * The pay key, which is a token you use in other Adaptive
						 * Payment APIs (such as the Refund Method) to identify this
						 * payment. The pay key is valid for 3 hours; the payment
						 * must be approved while the pay key is valid.
						 */
						map.put("Pay Key", resp.getPayKey());

						/**
						 * The status of the payment. Possible values are: CREATED –
						 * The payment request was received; funds will be
						 * transferred once the payment is approved COMPLETED – The
						 * payment was successful INCOMPLETE – Some transfers
						 * succeeded and some failed for a parallel payment or, for
						 * a delayed chained payment, secondary receivers have not
						 * been paid ERROR – The payment failed and all attempted
						 * transfers failed or all completed transfers were
						 * successfully reversed REVERSALERROR – One or more
						 * transfers failed when attempting to reverse a payment
						 * PROCESSING – The payment is in progress PENDING – The
						 * payment is awaiting processing
						 */
						map.put("Payment Execution Status",	resp.getPaymentExecStatus());
						
						if (resp.getDefaultFundingPlan() != null) {
							/** Default funding plan. */
							map.put("Default Funding Plan", resp
									.getDefaultFundingPlan().getFundingPlanId());
						}

						session.setAttribute("map", map);
						response.sendRedirect("Response.jsp");
					} else {
						session.setAttribute("Error", resp.getError());
						response.sendRedirect("Error.jsp");
					}
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
	}
}
