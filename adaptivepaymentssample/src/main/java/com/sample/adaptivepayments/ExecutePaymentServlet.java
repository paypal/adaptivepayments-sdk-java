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
import com.paypal.svcs.types.ap.ExecutePaymentRequest;
import com.paypal.svcs.types.ap.ExecutePaymentResponse;
import com.paypal.svcs.types.common.RequestEnvelope;
import com.sample.util.Configuration;

/**
 * Servlet implementation class ExecutePaymentServlet
 */
public class ExecutePaymentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ExecutePaymentServlet() {
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
				.getRequestDispatcher("/ExecutePayment.jsp")
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
				"<ul><li><a href='Pay'>Pay</a></li><li><a href='PaymentDetails'>PaymentDetails</a></li><li><a href='GetPaymentOptions'>GetPaymentOptions</a></li><li><a href='Refund'>Refund</a></li><li><a href='SetPaymentOptions'>SetPaymentOptions</a></li></ul>");
		RequestEnvelope requestEnvelope = new RequestEnvelope("en_US");
		ExecutePaymentRequest req = new ExecutePaymentRequest();
		/**
		 *  (Optional) The pay key that identifies the payment to be executed. 
		 *  This is the pay key returned in the PayResponse message.
		 */
		req.setPayKey(request.getParameter("payKey"));
		/**
		 *  The ExecutePayment API operation lets you execute a payment set up 
		 * with the Pay API operation with the actionType CREATE
		 * use this option to set up the payment instructions with the Pay request
		 * and then execute the	payment at a later time with the ExecutePayment
		 * request.
		 */
		req.setActionType(request.getParameter("actionType"));
		
		/** (Optional) The ID of the funding plan from which to make this payment. */ 
		req.setFundingPlanId(request.getParameter("fundingPlanID"));
		req.setRequestEnvelope(requestEnvelope);
		
		// Configuration map containing signature credentials and other required configuration.
		// For a full list of configuration parameters refer in wiki page
		// (https://github.com/paypal/sdk-core-java/wiki/SDK-Configuration-Parameters)
		Map<String,String> configurationMap =  Configuration.getAcctAndConfig();
		
		// Creating service wrapper object to make an API call by loading configuration map. 
		AdaptivePaymentsService service = new AdaptivePaymentsService(configurationMap);
		
		response.setContentType("text/html");
		try {
			ExecutePaymentResponse resp = service.executePayment(req);
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
					 * The status of the payment. Possible values are:

					    CREATED – The payment request was received; funds will be transferred once the payment is approved
					    COMPLETED – The payment was successful
					    INCOMPLETE – Some transfers succeeded and some failed for a parallel payment
					    ERROR – The payment failed and all attempted transfers failed or all completed transfers were successfully reversed
					    REVERSALERROR – One or more transfers failed when attempting to reverse a payment
					    
					    Important: You must test the value of paymentExecStatus for an error even 
					    if responseEnvelope.ack is Success. If the PaymentExecStatus is ERROR, 
					    the Pay Key can no longer be used. 
					 */
					map.put("Payment Execution Status",resp.getPaymentExecStatus());
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
