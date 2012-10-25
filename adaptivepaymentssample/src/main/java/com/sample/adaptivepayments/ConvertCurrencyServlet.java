package com.sample.adaptivepayments;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
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
import com.paypal.svcs.types.ap.ConvertCurrencyRequest;
import com.paypal.svcs.types.ap.ConvertCurrencyResponse;
import com.paypal.svcs.types.ap.CurrencyCodeList;
import com.paypal.svcs.types.ap.CurrencyConversionList;
import com.paypal.svcs.types.ap.CurrencyList;
import com.paypal.svcs.types.common.CurrencyType;
import com.paypal.svcs.types.common.RequestEnvelope;

/**
 * Servlet implementation class ConvertCurrencyServlet
 */
public class ConvertCurrencyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ConvertCurrencyServlet() {
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
				.getRequestDispatcher("/ConvertCurrency.jsp")
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
				"<ul><li><a href='Pay'>Pay</a></li><li><a href='Refund'>Refund</a></li><li><a href='Preapproval'>Preapproval</a></li></ul>");
		RequestEnvelope requestEnvelope = new RequestEnvelope("en_US");
		List<CurrencyType> currency = new ArrayList<CurrencyType>();
		CurrencyType type1 = new CurrencyType();
		if (request.getParameter("amount") != "")
			type1.setAmount(Double.parseDouble(request.getParameter("amount")));
		if (request.getParameter("code") != "")
			type1.setCode(request.getParameter("code"));
		currency.add(type1);
		CurrencyList baseAmountList = new CurrencyList(currency);
		List<String> currencyCode = new ArrayList<String>();
		if (request.getParameter("convertTo") != "")
			currencyCode.add(request.getParameter("convertTo"));
		CurrencyCodeList convertToCurrencyList = new CurrencyCodeList(
				currencyCode);
		ConvertCurrencyRequest req = new ConvertCurrencyRequest(
				requestEnvelope, baseAmountList, convertToCurrencyList);
		if (request.getParameter("conversionType") != "")
			req.setConversionType(request.getParameter("conversionType"));
		if (request.getParameter("countryCode") != "")
			req.setCountryCode(request.getParameter("countryCode"));
		AdaptivePaymentsService service = new AdaptivePaymentsService(this
				.getServletContext().getRealPath("/")
				+ "/WEB-INF/sdk_config.properties");
		response.setContentType("text/html");
		try {

			// if (request.getParameter("ConvertBtn").equals("convert")) {
			ConvertCurrencyResponse resp = service.convertCurrency(req);
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
					Iterator<CurrencyConversionList> iterator = resp
							.getEstimatedAmountTable()
							.getCurrencyConversionList().iterator();
					int index = 1;
					while (iterator.hasNext()) {
						CurrencyConversionList currencyList = iterator.next();
						map.put("Amount to be converted" + index, currencyList.getBaseAmount()
								.getAmount());
						Iterator<CurrencyType> currencyIterator = currencyList
								.getCurrencyList().getCurrency().iterator();
						int innerIndex = 1;
						while (currencyIterator.hasNext()) {
							CurrencyType currencyType = currencyIterator.next();
							map.put("Currency" + innerIndex,
									currencyType.getCode());
							map.put("Converted Amount" + innerIndex,
									currencyType.getAmount());
							innerIndex++;
						}
						index++;
					}
					session.setAttribute("map", map);
					response.sendRedirect("Response.jsp");
				} else {
					session.setAttribute("Error", resp.getError());
					response.sendRedirect("Error.jsp");
				}
			}

			// }
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
