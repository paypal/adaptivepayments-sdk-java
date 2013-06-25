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
	
	/* 
	 * receiver for PayPal ipn call back.
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		IPNMessage 	ipnlistener = new IPNMessage(request,Configuration.getIpnConfig());
		boolean isIpnVerified = ipnlistener.validate();
		String transactionType = ipnlistener.getTransactionType();
		Map<String,String> map = ipnlistener.getIpnMap();
		
		LoggingManager.info(IPNListenerServlet.class, "******* IPN (name:value) pair : "+ map + "  " +
				"######### TransactionType : "+transactionType+"  ======== IPN verified : "+ isIpnVerified);
	}
}
