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
import com.paypal.svcs.types.ap.Receiver;
import com.paypal.svcs.types.ap.ReceiverList;
import com.paypal.svcs.types.common.RequestEnvelope;
import com.sample.util.Configuration;

public class DelayedChainedPaymentServlet extends HttpServlet {

	private static final long serialVersionUID = 128820899089722L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		getServletConfig().getServletContext()
				.getRequestDispatcher("/usecase_jsp/DelayedChainedPayment.jsp")
				.forward(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		PayRequest req = new PayRequest();
		RequestEnvelope requestEnvelope = new RequestEnvelope("en_US");
		List<Receiver> receiver = new ArrayList<Receiver>();

		String[] amount = request.getParameterValues("amount");
		String[] email = request.getParameterValues("mail");
		String[] primaryReceiver = request
				.getParameterValues("primaryReceiver");
		for (int i = 0; i < email.length; i++) {
			Receiver rec = new Receiver();

			/**
			 * Receiver's email address. This address can be unregistered with
			 * paypal.com. If so, a receiver cannot claim the payment until a
			 * PayPal account is linked to the email address. The PayRequest
			 * must pass either an email address or a phone number. Maximum
			 * length: 127 characters
			 */
			rec.setEmail(email[i]);

			// (Required) Amount to be paid to the receiver
			rec.setAmount(Double.parseDouble(amount[i]));
			//
			rec.setPrimary(Boolean.parseBoolean(primaryReceiver[i]));
			receiver.add(rec);
		}

		ReceiverList receiverlst = new ReceiverList(receiver);
		req.setReceiverList(receiverlst);

		/**
		 * (Optional) Sender's email address. Maximum length: 127 characters
		 */
		if (request.getParameter("senderEmail") != "")
			req.setSenderEmail(request.getParameter("senderEmail"));
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

		req.setRequestEnvelope(requestEnvelope);

		/**
		 * (Optional) The URL to which you want all IPN messages for this
		 * payment to be sent. Maximum length: 1024 characters
		 */
		if (request.getParameter("ipnNotificationURL") != "")
			req.setIpnNotificationUrl(request
					.getParameter("ipnNotificationURL"));

		// Configuration map containing signature credentials and other
		// required
		// configuration.
		// For a full list of configuration parameters refer at
		// (https://github.com/paypal/sdk-core-java/wiki/SDK-Configuration-Parameters)
		Map<String, String> configurationMap = Configuration.getAcctAndConfig();

		// Creating service wrapper object to make an API call by loading
		// configuration map.
		AdaptivePaymentsService service = new AdaptivePaymentsService(
				configurationMap);

		HttpSession session = request.getSession();
		session.setAttribute("url", request.getRequestURI());
		try {
			PayResponse resp = service.pay(req);
			response.setContentType("text/html");
			if (resp != null) {
				session.setAttribute("lastReq", service.getLastRequest());
				session.setAttribute("lastResp", service.getLastResponse());
				Map<Object, Object> map = new LinkedHashMap<Object, Object>();
				map.put("Ack", resp.getResponseEnvelope().getAck());

				/**
				 * Correlation identifier. It is a 13-character, alphanumeric
				 * string (for example, db87c705a910e) that is used only by
				 * PayPal Merchant Technical Support. Note: You must log and
				 * store this data for every response you receive. PayPal
				 * Technical Support uses the information to assist with
				 * reported issues.
				 */
				map.put("Correlation ID", resp.getResponseEnvelope()
						.getCorrelationId());

				/**
				 * Date on which the response was sent, for example:
				 * 2012-04-02T22:33:35.774-07:00 Note: You must log and store
				 * this data for every response you receive. PayPal Technical
				 * Support uses the information to assist with reported issues.
				 */
				map.put("Time Stamp", resp.getResponseEnvelope().getTimestamp());

				/**
				 * The pay key, which is a token you use in other Adaptive
				 * Payment APIs (such as the Refund Method) to identify this
				 * payment. The pay key is valid for 3 hours; the payment must
				 * be approved while the pay key is valid.
				 */
				map.put("Pay Key", resp.getPayKey());

				/**
				 * The status of the payment. Possible values are: CREATED – The
				 * payment request was received; funds will be transferred once
				 * the payment is approved COMPLETED – The payment was
				 * successful INCOMPLETE – Some transfers succeeded and some
				 * failed for a parallel payment or, for a delayed chained
				 * payment, secondary receivers have not been paid ERROR – The
				 * payment failed and all attempted transfers failed or all
				 * completed transfers were successfully reversed REVERSALERROR
				 * – One or more transfers failed when attempting to reverse a
				 * payment PROCESSING – The payment is in progress PENDING – The
				 * payment is awaiting processing
				 */
				map.put("Payment Execution Status", resp.getPaymentExecStatus());
				/*
				 * if (resp.getDefaultFundingPlan() != null) {
				 *//** Default funding plan. */
				/*
				 * map.put("Default Funding Plan", resp
				 * .getDefaultFundingPlan().getFundingPlanId()); }
				 */
				if (!resp.getPaymentExecStatus().equalsIgnoreCase("Completed")) {
					map.put("Redirect URL",
							"<a href=https://www.sandbox.paypal.com/cgi-bin/webscr?cmd=_ap-payment&paykey="
									+ resp.getPayKey()
									+ ">https://www.sandbox.paypal.com/cgi-bin/webscr?cmd=_ap-payment&paykey="
									+ resp.getPayKey() + "</a>");
				}
				session.setAttribute("map", map);
				response.sendRedirect("Response.jsp");
				session.setAttribute("payKey", resp.getPayKey());
				// response.sendRedirect("https://www.sandbox.paypal.com/cgi-bin/webscr?cmd=_ap-payment&paykey="
				// + resp.getPayKey());
			} else {
				session.setAttribute("Error", resp.getError());
				response.sendRedirect("Error.jsp");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.sendRedirect("Error.jsp");
		}
	}
}
