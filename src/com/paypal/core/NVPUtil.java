package com.paypal.core;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

public class NVPUtil {

	/**
	 * Utility method used to decode the nvp response String
	 * 
	 * @param nvpString
	 * @return Map
	 * @throws UnsupportedEncodingException
	 */
	public static Map<String, String> decode(String nvpString)
			throws UnsupportedEncodingException {

		String decodedResponse = URLDecoder.decode(nvpString,
				Constants.ENCODING_FORMAT);
		Map<String, String> response = new HashMap<String, String>();

		// parse the string and load into the object
		String[] nmValPairs = decodedResponse.split("&");
		for (String nmVal : nmValPairs) {
			String[] field = nmVal.split("=");
			response.put(field[0], (field.length > 1) ? field[1].trim() : "");
		}
		return response;
	}

	/**
	 * Utility method used to encode the value
	 * 
	 * @param value
	 * @return String
	 * @throws UnsupportedEncodingException
	 */
	public static String encodeUrl(String value)
			throws UnsupportedEncodingException {
		return URLEncoder.encode(value, Constants.ENCODING_FORMAT);
	}

}
