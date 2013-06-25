package com.sample.adaptivepayments;

import java.util.HashMap;
import java.util.Map;

public class Configuration {
	
	
	public static final Map<String,String> getSignatureConfig(){
		Map<String,String> configMap = new HashMap<String,String>();
		
		// Account Credential
		configMap.put("acct1.UserName", "jb-us-seller_api1.paypal.com");
		configMap.put("acct1.Password", "WX4WTU3S8MY44S7F");
		configMap.put("acct1.Signature", "AFcWxV21C7fd0v3bYYYRCpSSRl31A7yDhhsPUU2XhtMoZXsWHFxu-RWy");
		configMap.put("acct1.AppId", "APP-80W284485P519543T");
		
		// Endpoints are varied depending on whether sandbox OR live is chosen for mode
		configMap.put("mode", "sandbox");
		
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
		
		return configMap;
	}
	
	public static final Map<String,String> getIpnConfig(){
		Map<String,String> configMap = new HashMap<String,String>();
		//Connection Information
		configMap.put("http.ConnectionTimeOut", "5000");
		configMap.put("http.Retry", "2");
		configMap.put("http.ReadTimeOut", "30000");
		configMap.put("http.MaxConnection", "100");
		
		// Endpoints are varied depending on whether sandbox OR live is chosen for mode
		configMap.put("mode", "sandbox");
		return configMap;
	}
}
