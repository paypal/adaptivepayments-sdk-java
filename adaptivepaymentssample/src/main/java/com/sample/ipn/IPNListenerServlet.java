package com.sample.ipn;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.paypal.core.LoggingManager;
import com.paypal.ipn.IPNMessage;
import com.paypal.svcs.services.AdaptivePaymentsService;

public class IPNListenerServlet extends HttpServlet {
	
	/* 
	 * receiver for PayPal ipn call back.
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		IPNMessage testipnlistener = null;
		IPNMessage ipnlistener=null;
		AdaptivePaymentsService service = new AdaptivePaymentsService(this
				.getClass().getResourceAsStream("/sdk_config.properties"));
		try{
			
			testipnlistener = new IPNMessage(request);
			Map<String,String> testmap = testipnlistener.getIpnParamValueMap();
			ipnlistener = new IPNMessage(testmap);

		}catch(IOException io){
			LoggingManager.debug(IPNListenerServlet.class, io.getMessage());
		}
		
		
		boolean isIpnVerified = ipnlistener.isIpnVerified();
		String transactionType = ipnlistener.getTransactionType();
		Map<String,String> map = ipnlistener.getIpnParamValueMap();
		
		LoggingManager.info(IPNListenerServlet.class, "******* IPN (name:value) pair : "+ map + "  " +
				"######### TransactionType : "+transactionType+"  ======== IPN verified : "+ isIpnVerified);
	}
}
