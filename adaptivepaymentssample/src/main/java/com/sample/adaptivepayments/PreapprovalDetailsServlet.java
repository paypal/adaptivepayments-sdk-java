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
import com.paypal.svcs.types.ap.PreapprovalDetailsRequest;
import com.paypal.svcs.types.ap.PreapprovalDetailsResponse;
import com.paypal.svcs.types.common.RequestEnvelope;
import com.sample.util.Configuration;

/**
 * Servlet implementation class PreapprovalDetailsServlet
 */
public class PreapprovalDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PreapprovalDetailsServlet() {
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
				.getRequestDispatcher("/PreapprovalDetails.jsp")
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
		PreapprovalDetailsRequest req = new PreapprovalDetailsRequest();
		req.setRequestEnvelope(requestEnvelope);
		
		/*
		 *  A preapproval key that identifies the preapproval for which you want to retrieve details.
		 *  The preapproval key is returned in the PreapprovalResponse message.
		 */
		if (request.getParameter("preapprovalKey") != "")
			req.setPreapprovalKey(request.getParameter("preapprovalKey"));
		/*
		 *  (Optional) An option that lets you retrieve a list of billing addresses for the sender.
    		true – Includes the billing address in the response
    		false – Omits the billing address from the response (default)
		 */
		if (request.getParameter("getBillingAddress") != "")
			req.setGetBillingAddress(Boolean.parseBoolean(request.getParameter("getBillingAddress")));
		
		// Configuration map containing signature credentials and other required configuration.
		// For a full list of configuration parameters refer in wiki page
		// (https://github.com/paypal/sdk-core-java/wiki/SDK-Configuration-Parameters)
		Map<String,String> configurationMap =  Configuration.getAcctAndConfig();
		
		// Creating service wrapper object to make an API call by loading configuration map. 
		AdaptivePaymentsService service = new AdaptivePaymentsService(configurationMap);
		
		try {
			PreapprovalDetailsResponse resp = service.preapprovalDetails(req);
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
					 * Whether the preapproval request was approved. Possible values are:
					    true – The request was approved
					    false – The request was denied
					 */
					map.put("Approval", resp.getApproved());
					
					/**
					 * The payer of PayPal fees. Allowable values are:
					    SENDER – Sender pays all fees (for personal, implicit simple/parallel payments; do not use for chained or unilateral payments)
					    PRIMARYRECEIVER – Primary receiver pays all fees (chained payments only)
					    EACHRECEIVER – Each receiver pays their own fee (default, personal and unilateral payments)
					    SECONDARYONLY – Secondary receivers pay all fees (use only for chained payments with one secondary receiver)
					 */
					map.put("FeesPayer", resp.getFeesPayer());
					
					/**
					 * The preapproved maximum total amount of all payments.
						Note:
						You must specify a value unless you have specific permission from 
						PayPal to omit this value.
					 */
					map.put("Maximum Total Amount",
							resp.getMaxTotalAmountOfAllPayments());
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
