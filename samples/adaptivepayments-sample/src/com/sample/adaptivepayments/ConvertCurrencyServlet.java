package com.sample.adaptivepayments;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import com.paypal.svcs.types.ap.CurrencyList;
import com.paypal.svcs.types.common.AckCode;
import com.paypal.svcs.types.common.CurrencyType;
import com.paypal.svcs.types.common.ErrorData;
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

		RequestEnvelope requestEnvelope = new RequestEnvelope("en_US");
		List<CurrencyType> currency = new ArrayList<CurrencyType>();
		CurrencyType type1 = new CurrencyType();
		type1.setAmount(Double.parseDouble(request.getParameter("amount")));
		type1.setCode(request.getParameter("code"));
		currency.add(type1);
		CurrencyList baseAmountList = new CurrencyList(currency);
		List<String> currencyCode = new ArrayList<String>();
		currencyCode.add(request.getParameter("convertTo"));
		CurrencyCodeList convertToCurrencyList = new CurrencyCodeList(
				currencyCode);
		ConvertCurrencyRequest req = new ConvertCurrencyRequest(
				requestEnvelope, baseAmountList, convertToCurrencyList);
		AdaptivePaymentsService service = new AdaptivePaymentsService(this
				.getServletContext().getRealPath("/")
				+ "/WEB-INF/sdk_config.properties");
		response.setContentType("text/html");
		try {

			// if (request.getParameter("ConvertBtn").equals("convert")) {
			ConvertCurrencyResponse resp = service.convertCurrency(req);
			response.getWriter().println(
					"Ack:" + resp.getResponseEnvelope().getAck());
			if (resp.getResponseEnvelope().getAck().equals(AckCode.SUCCESS)) {

			} else {
				Iterator iterator = resp.getError().iterator();
				while (iterator.hasNext()) {
					ErrorData error = (ErrorData) iterator.next();
					response.getWriter().println("<br/>" + error.getMessage());
				}
			}

			response.getWriter().println("<a href='index.html'>Home</a>");

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
