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

import com.paypal.core.NVPUtil;
import com.paypal.core.ReflectionUtil;
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
		if (request.getParameter("amount") != "")
			rec.setAmount(Double.parseDouble(request.getParameter("amount")));
		if (request.getParameter("mail") != "")
			rec.setEmail(request.getParameter("mail"));
		if (request.getParameter("invoiceID") != "")
			rec.setInvoiceId(request.getParameter("invoiceID"));
		if (request.getParameter("paymentSubType") != "")
			rec.setPaymentSubType(request.getParameter("paymentSubType"));
		if (request.getParameter("paymentType") != "")
			rec.setPaymentType(request.getParameter("paymentType"));
		if (request.getParameter("phoneNumber") != "") {
			PhoneNumberType phone = new PhoneNumberType(
					request.getParameter("countryCode"),
					request.getParameter("phoneNumber"));
			phone.setExtension(request.getParameter("extension"));
			rec.setPhone(phone);
		}
		if (request.getParameter("setPrimary") != "")
			rec.setPrimary(Boolean.parseBoolean(request
					.getParameter("setPrimary")));
		receiver.add(rec);
		ReceiverList receiverlst = new ReceiverList(receiver);
		req.setReceiverList(receiverlst);
		req.setRequestEnvelope(requestEnvelope);
		ClientDetailsType clientDetails = new ClientDetailsType();
		if (request.getParameter("applicationID") != "")
			clientDetails.setApplicationId(request
					.getParameter("applicationID"));
		if (request.getParameter("customerID") != "")
			clientDetails.setCustomerId(request.getParameter("customerID"));
		if (request.getParameter("customerType") != "")
			clientDetails.setCustomerType(request.getParameter("customerType"));
		if (request.getParameter("deviceID") != "")
			clientDetails.setDeviceId(request.getParameter("deviceID"));
		if (request.getParameter("location") != "")
			clientDetails.setGeoLocation(request.getParameter("location"));
		if (request.getParameter("ipAddress") != "")
			clientDetails.setIpAddress(request.getParameter("ipAddress"));
		if (request.getParameter("model") != "")
			clientDetails.setModel(request.getParameter("model"));
		if (request.getParameter("partnerName") != "")
			clientDetails.setPartnerName(request.getParameter("partnerName"));
		req.setClientDetails(clientDetails);
		if (request.getParameter("ipnNotificationURL") != "")
			req.setIpnNotificationUrl(request
					.getParameter("ipnNotificationURL"));
		if (request.getParameter("memo") != "")
			req.setMemo(request.getParameter("memo"));
		if (request.getParameter("pin") != "")
			req.setPin(request.getParameter("pin"));
		if (request.getParameter("senderEmail") != "")
			req.setSenderEmail(request.getParameter("senderEmail"));
		if (request.getParameter("feesPayer") != "")
			req.setFeesPayer(request.getParameter("feesPayer"));
		FundingConstraint fundingConstraint = new FundingConstraint();
		List<FundingTypeInfo> fundingTypeInfoList = new ArrayList<FundingTypeInfo>();
		if (request.getParameter("fundingType") != "") {
			FundingTypeInfo fundingTypeInfo = new FundingTypeInfo(
					request.getParameter("fundingType"));
			fundingTypeInfoList.add(fundingTypeInfo);
		}
		FundingTypeList fundingTypeList = new FundingTypeList(
				fundingTypeInfoList);
		fundingConstraint.setAllowedFundingType(fundingTypeList);
		req.setFundingConstraint(fundingConstraint);
		if (request.getParameter("preapprovalKey") != "")
			req.setPreapprovalKey(request.getParameter("preapprovalKey"));
		if (request.getParameter("reverseAllPaymentsOnError") != "")
			req.setReverseAllParallelPaymentsOnError(Boolean
					.parseBoolean(request
							.getParameter("reverseAllPaymentsOnError")));

		SenderIdentifier senderIdentifier = new SenderIdentifier();
		if (request.getParameter("senderIdentifierEmail") != "")
			senderIdentifier.setEmail(request
					.getParameter("senderIdentifierEmail"));
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
		if (request.getParameter("useCredentials") != "")
			senderIdentifier.setUseCredentials(Boolean.parseBoolean(request
					.getParameter("useCredentials")));
		req.setSender(senderIdentifier);

		if (request.getParameter("trackingID") != "")
			req.setTrackingId(request.getParameter("trackingID"));
		if (request.getParameter("actionType") != "")
			req.setActionType(request.getParameter("actionType"));
		if (request.getParameter("cancelURL") != "")
			req.setCancelUrl(request.getParameter("cancelURL"));
		if (request.getParameter("currencyCode") != "")
			req.setCurrencyCode(request.getParameter("currencyCode"));
		if (request.getParameter("returnURL") != "")
			req.setReturnUrl(request.getParameter("returnURL"));
		AdaptivePaymentsService service = new AdaptivePaymentsService(this
				.getServletContext().getRealPath("/")
				+ "/WEB-INF/sdk_config.properties");
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
					map.put("Correlation ID", resp.getResponseEnvelope()
							.getCorrelationId());
					map.put("Time Stamp", resp.getResponseEnvelope()
							.getTimestamp());
					map.put("Pay Key", resp.getPayKey());
					map.put("Payment Execution Status",
							resp.getPaymentExecStatus());
					if (resp.getDefaultFundingPlan() != null)
						map.put("Default Funding Plan", resp
								.getDefaultFundingPlan().getFundingPlanId());
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
