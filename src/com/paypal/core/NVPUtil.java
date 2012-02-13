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

		String[] nmValPairs = nvpString.split("&");

		Map<String, String> response = new HashMap<String, String>();

		// parse the string and load into the object
		for (String nmVal : nmValPairs) {

			String[] field = nmVal.split("=");

			response.put(
					URLDecoder.decode(field[0], Constants.ENCODING_FORMAT),
					(field.length > 1) ? URLDecoder.decode(field[1].trim(),
							Constants.ENCODING_FORMAT) : "");
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
