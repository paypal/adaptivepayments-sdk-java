package com.sample.adaptivepayments;

import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedHashMap;
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
import com.paypal.svcs.types.ap.FundingPlan;
import com.paypal.svcs.types.ap.GetFundingPlansRequest;
import com.paypal.svcs.types.ap.GetFundingPlansResponse;
import com.paypal.svcs.types.common.RequestEnvelope;

/**
 * Servlet implementation class GetFundingPlansServlet
 */
public class GetFundingPlansServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetFundingPlansServlet() {
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
				.getRequestDispatcher("/GetFundingPlans.jsp")
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
				"<ul><li><a href='Pay'>Pay</a></li><li><a href='Refund'>Refund</a></li><li><a href='GetAllowedFundingSources'>GetAllowedFundingSources</a></li></ul>");
		GetFundingPlansRequest req = new GetFundingPlansRequest();
		RequestEnvelope requestEnvelope = new RequestEnvelope("en_US");
		req.setPayKey(request.getParameter("payKey"));
		req.setRequestEnvelope(requestEnvelope);
		AdaptivePaymentsService service = new AdaptivePaymentsService(this
				.getServletContext().getRealPath("/")
				+ "/WEB-INF/sdk_config.properties");
		response.setContentType("text/html");
		try {
			GetFundingPlansResponse resp = service.getFundingPlans(req);
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
					Iterator<FundingPlan> iterator = resp.getFundingPlan()
							.iterator();
					int index = 1;
					while (iterator.hasNext()) {
						FundingPlan fundingPlan = iterator.next();
						map.put("Funding Plan ID" + index,
								fundingPlan.getFundingPlanId());
						index++;
					}
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
