package com.sample.adaptivepayments;

import java.util.HashMap;
import java.util.Map;

public class Utility {
	
	private static final String MODE_PARAM_KEY = "mode";
	private static final String MODE = "sandbox";
	
	public static final Map<String,String> getSignatureConfig(){
		Map<String,String> configMap = new HashMap<String,String>();
		configMap.put("acct1.UserName", "jb-us-seller_api1.paypal.com");
		configMap.put("acct1.Password", "WX4WTU3S8MY44S7F");
		configMap.put("acct1.Signature", "AFcWxV21C7fd0v3bYYYRCpSSRl31A7yDhhsPUU2XhtMoZXsWHFxu-RWy");
		configMap.put("acct1.AppId", "APP-80W284485P519543T");
		configMap.put(MODE_PARAM_KEY, MODE);
		return configMap;
	}
	
	public static final Map<String,String> getCertificateConfig(){
		Map<String,String> configMap = new HashMap<String,String>();
		configMap.put("acct2.UserName", "certuser_biz_api1.paypal.com");
		configMap.put("acct2.Password", "D6JNKKULHN3G5B8A");
		configMap.put("acct2.CertKey", "password");
		configMap.put("acct2.CertPath", "resource/sdk-cert.p12");
		configMap.put("acct2.AppId", "APP-80W284485P519543T");
		configMap.put(MODE_PARAM_KEY, MODE);
		return configMap;
	}
}
