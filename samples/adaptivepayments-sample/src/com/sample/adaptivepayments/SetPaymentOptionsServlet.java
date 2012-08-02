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
		if (request.getParameter("payKey") != "")
			req.setPayKey(request.getParameter("payKey"));
		DisplayOptions displayOptions = new DisplayOptions();
		if (request.getParameter("businessName") != "")
			displayOptions
					.setBusinessName(request.getParameter("businessName"));
		if (request.getParameter("emailHeaderImageURL") != "")
			displayOptions.setEmailHeaderImageUrl(request
					.getParameter("emailHeaderImageURL"));
		if (request.getParameter("emailHeaderMarketingURL") != "")
			displayOptions.setEmailMarketingImageUrl(request
					.getParameter("emailHeaderMarketingURL"));
		if (request.getParameter("headerImageURL") != "")
			displayOptions.setHeaderImageUrl(request
					.getParameter("headerImageURL"));
		req.setDisplayOptions(displayOptions);
		InitiatingEntity initiatingEntity = new InitiatingEntity();
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
		if (request.getParameter("shippingAddressID") != "")
			req.setShippingAddressId(request.getParameter("shippingAddressID"));

		List<ReceiverOptions> receiverOptionsList = new ArrayList<ReceiverOptions>();
		ReceiverIdentifier receiver = new ReceiverIdentifier();
		if (request.getParameter("receiverMail") != "")
			receiver.setEmail(request.getParameter("receiverMail"));
		PhoneNumberType receiverPhone = null;
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
		if (request.getParameter("customID") != "")
			receiverOptions.setCustomId(request.getParameter("customID"));
		if (request.getParameter("description") != "")
			receiverOptions.setDescription(request.getParameter("description"));

		InvoiceData invoiceData = new InvoiceData();
		List<InvoiceItem> invoiceItemList = new ArrayList<InvoiceItem>();
		InvoiceItem invoiceItem = new InvoiceItem();
		if (request.getParameter("invoiceIdentifier") != "")
			invoiceItem
					.setIdentifier(request.getParameter("invoiceIdentifier"));

		Double itemPrice = null;
		Integer itemCount = null;
		if (request.getParameter("invoiceItemCount") != "") {
			itemCount = Integer.parseInt(request
					.getParameter("invoiceItemCount"));

			invoiceItem.setItemCount(itemCount);
		}
		if (request.getParameter("invoiceItemPrice") != "") {
			itemPrice = Double.parseDouble(request
					.getParameter("invoiceItemPrice"));

			invoiceItem.setItemPrice(itemPrice);
		}
		if (request.getParameter("invoiceItemCount") != ""
				&& request.getParameter("invoiceItemPrice") != "") {
			Double price = itemCount * itemPrice;
			invoiceItem.setPrice(price);
		}
		if (request.getParameter("invoiceName") != "")
			invoiceItem.setName(request.getParameter("invoiceName"));
		invoiceItemList.add(invoiceItem);
		invoiceData.setItem(invoiceItemList);
		if (request.getParameter("invoiceTotalShipping") != "")
			invoiceData.setTotalShipping(Double.parseDouble(request
					.getParameter("invoiceTotalShipping")));
		if (request.getParameter("invoiceTotalTax") != "")
			invoiceData.setTotalTax(Double.parseDouble(request
					.getParameter("invoiceTotalTax")));
		receiverOptions.setInvoiceData(invoiceData);
		if (request.getParameter("receiverReferrerCode") != "")
			receiverOptions.setReferrerCode(request
					.getParameter("receiverReferrerCode"));
		receiverOptionsList.add(receiverOptions);
		req.setReceiverOptions(receiverOptionsList);

		SenderOptions senderOptions = new SenderOptions();
		if (request.getParameter("requireShippingAddressSelection") != "")
			senderOptions.setRequireShippingAddressSelection(Boolean
					.parseBoolean(request
							.getParameter("requireShippingAddressSelection")));
		if (request.getParameter("senderReferrerCode") != "")
			senderOptions.setReferrerCode(request
					.getParameter("senderReferrerCode"));
		req.setSenderOptions(senderOptions);
		req.setRequestEnvelope(requestEnvelope);

		AdaptivePaymentsService service = new AdaptivePaymentsService(this
				.getServletContext().getRealPath("/")
				+ "/WEB-INF/sdk_config.properties");
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
					map.put("Correlation ID", resp.getResponseEnvelope()
							.getCorrelationId());
					map.put("Time Stamp", resp.getResponseEnvelope()
							.getTimestamp());
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
