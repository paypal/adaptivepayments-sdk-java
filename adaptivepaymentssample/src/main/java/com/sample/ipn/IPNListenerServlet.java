package com.sample.ipn;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.paypal.core.LoggingManager;
import com.paypal.ipn.IPNMessage;
import com.sample.adaptivepayments.Configuration;

public class IPNListenerServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/* 
	 * receiver for PayPal ipn call back.
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		// Configuration map containing signature credentials and other required configuration.
		// For a full list of configuration parameters refer at 
		// (https://github.com/paypal/adaptivepayments-sdk-java/wiki/SDK-Configuration-Parameters)
		Map<String,String> configurationMap =  Configuration.getConfig();
		IPNMessage 	ipnlistener = new IPNMessage(request,configurationMap);
		boolean isIpnVerified = ipnlistener.validate();
		String transactionType = ipnlistener.getTransactionType();
		Map<String,String> map = ipnlistener.getIpnMap();
		
		LoggingManager.info(IPNListenerServlet.class, "******* IPN (name:value) pair : "+ map + "  " +
				"######### TransactionType : "+transactionType+"  ======== IPN verified : "+ isIpnVerified);
	}
}
