package com.sample.adaptivepayments;

import java.util.HashMap;
import java.util.Map;

public class Utility {
	
	
	public static final Map<String,String> getSignatureConfig(){
		
		Map<String,String> configMap = new HashMap<String,String>();
		
		// Account Credential
		configMap.put("acct1.UserName", "jb-us-seller_api1.paypal.com");
		configMap.put("acct1.Password", "WX4WTU3S8MY44S7F");
		configMap.put("acct1.Signature", "AFcWxV21C7fd0v3bYYYRCpSSRl31A7yDhhsPUU2XhtMoZXsWHFxu-RWy");
		configMap.put("acct1.AppId", "APP-80W284485P519543T");
		
		// Endpoints are varied depending on whether sandbox OR live is chosen for mode
		configMap.put("mode", "sandbox");
		
		// Sandbox Email Address
		configMap.put("sandbox.EmailAddress", "pp.devtools@gmail.com");
		
		//Connection Information
		configMap.put("http.ConnectionTimeOut", "5000");
		configMap.put("http.Retry", "2");
		configMap.put("http.ReadTimeOut", "30000");
		configMap.put("http.MaxConnection", "100");
		configMap.put("http.IPAddress", "127.0.0.1");
		
		//Set this property to true if you are using the PayPal SDK within a Google App Engine java app
		configMap.put("http.GoogleAppEngine", "false");
		
		// If you are using proxy set http.UseProxy to true and replace the following values with your proxy parameters
		//configMap.put("http.UseProxy", "false");
		//configMap.put("http.ProxyPort", "8080");
		//configMap.put("http.ProxyHost", "127.0.0.1");
		//configMap.put("http.ProxyUserName", null);
		//configMap.put("http.ProxyPassword",null);
		
		return configMap;
	}
	
	public static final Map<String,String> getCertificateConfig(){
		
		Map<String,String> configMap = new HashMap<String,String>();
		
		//Account Credential
		configMap.put("acct2.UserName", "certuser_biz_api1.paypal.com");
		configMap.put("acct2.Password", "D6JNKKULHN3G5B8A");
		configMap.put("acct2.CertKey", "password");
		configMap.put("acct2.CertPath", "resource/sdk-cert.p12");
		configMap.put("acct2.AppId", "APP-80W284485P519543T");
		
		// Endpoints are varied depending on whether sandbox OR live is chosen for mode
		configMap.put("mode", "sandbox");
		
		// Sandbox Email Address
		configMap.put("sandbox.EmailAddress", "pp.devtools@gmail.com");
		
		//Connection Information
		configMap.put("http.ConnectionTimeOut", "5000");
		configMap.put("http.Retry", "2");
		configMap.put("http.ReadTimeOut", "30000");
		configMap.put("http.MaxConnection", "100");
		configMap.put("http.IPAddress", "127.0.0.1");
		
		//Set this property to true if you are using the PayPal SDK within a Google App Engine java app
		configMap.put("http.GoogleAppEngine", "false");
		
		// If you are using proxy set http.UseProxy to true and replace the following values with your proxy parameters
		//configMap.put("http.UseProxy", "false");
		//configMap.put("http.ProxyPort", "8080");
		//configMap.put("http.ProxyHost", "127.0.0.1");
		//configMap.put("http.ProxyUserName", null);
		//configMap.put("http.ProxyPassword",null);
		
		return configMap;
	}
}
