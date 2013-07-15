package com.sample.adaptivepayments;

import java.util.HashMap;
import java.util.Map;

/**
 *  For a full list of configuration parameters refer at [https://github.com/paypal/adaptivepayments-sdk-java/wiki/SDK-Configuration-Parameters] 
 */
public class Configuration {
	
	
	// Creates a configuration map containing signature credentials and other required configuration parameters.
	public static final Map<String,String> getSignatureConfig(){
		Map<String,String> configMap = new HashMap<String,String>();
		
		// Endpoints are varied depending on whether sandbox OR live is chosen for mode
		configMap.put("mode", "sandbox");
		
		// Account Credential
		configMap.put("acct1.UserName", "jb-us-seller_api1.paypal.com");
		configMap.put("acct1.Password", "WX4WTU3S8MY44S7F");
		configMap.put("acct1.Signature", "AFcWxV21C7fd0v3bYYYRCpSSRl31A7yDhhsPUU2XhtMoZXsWHFxu-RWy");
		configMap.put("acct1.AppId", "APP-80W284485P519543T");
		
		return configMap;
	}
	
	//Creates a configuration map containing certificate credentials and other required configuration parameters.
	public static final Map<String,String> getCertificateConfig(){
		Map<String,String> configMap = new HashMap<String,String>();
		
		// Endpoints are varied depending on whether sandbox OR live is chosen for mode
		configMap.put("mode", "sandbox");
		
		//Account Credential
		configMap.put("acct2.UserName", "certuser_biz_api1.paypal.com");
		configMap.put("acct2.Password", "D6JNKKULHN3G5B8A");
		configMap.put("acct2.CertKey", "password");
		configMap.put("acct2.CertPath", "resource/sdk-cert.p12");
		configMap.put("acct2.AppId", "APP-80W284485P519543T");
		
		return configMap;
	}
	
	public static final Map<String,String> getMode(){
		Map<String,String> mode = new HashMap<String,String>();
		// Endpoints are varied depending on whether sandbox OR live is chosen for mode
		mode.put("mode", "sandbox");
		return mode;
	}
}
