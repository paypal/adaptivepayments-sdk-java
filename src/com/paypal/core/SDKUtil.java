package com.paypal.core;

import java.util.regex.Pattern;

/**
 * SDKUtil class holds utility methods for processing data transformation
 * 
 * @author kjayakumar
 * 
 */
public class SDKUtil {

	/**
	 * Pattern for replacing Ampersand '&' character
	 */
	private static final Pattern AMPERSAND_REPLACE = Pattern
			.compile("&(?!([amp;[lt;[gt;[apos;[quot;]]]]]))");

/**
	 * Pattern for replacing Lesser-than '<' character
	 */
	private static final Pattern LESSERTHAN_REPLACE = Pattern.compile("<");

	/**
	 * Pattern for replacing Greater-than '>' character
	 */
	private static final Pattern GREATERTHAN_REPLACE = Pattern.compile(">");

	/**
	 * Pattern for replacing Quote '"' character
	 */
	private static final Pattern QUOT_REPLACE = Pattern.compile("\"");

	/**
	 * Pattern for replacing Apostrophe ''' character
	 */
	private static final Pattern APOSTROPHE_REPLACE = Pattern.compile("'");

	private static final String AMPERSAND = "&amp;";

	private static final String GREATERTHAN = "&lt;";

	private static final String LESSERTHAN = "&gt;";

	private static final String QUOT = "&quot;";

	private static final String APOSTROPHE = "&apos;";

	/**
	 * Method replaces invalid XML entities with proper escapes, this method
	 * does not depend on regular expressions
	 * 
	 * @param textContent
	 *            Original text
	 * @return Replaced text
	 */
	public static String escapeInvalidXmlChars(String textContent) {
		StringBuilder stringBuilder = null;
		String response = null;
		if (textContent != null) {
			stringBuilder = new StringBuilder();
			int contentLength = textContent.toCharArray().length;
			for (int i = 0; i < contentLength; i++) {
				char ch = textContent.charAt(i);
				if (ch == '&') {
					if (i != (contentLength - 1)) {
						if (!(i + 3 > contentLength - 1)
								&& textContent.charAt(i + 3) == ';') {
							stringBuilder.append(ch);
						} else if (!(i + 4 > contentLength - 1)
								&& textContent.charAt(i + 4) == ';') {
							stringBuilder.append(ch);
						} else if (!(i + 5 > contentLength - 1)
								&& textContent.charAt(i + 5) == ';'
								&& textContent.charAt(i + 4) != 't') {
							stringBuilder.append(ch);
						} else {
							stringBuilder.append(AMPERSAND);
						}
					} else {
						stringBuilder.append(AMPERSAND);
					}
				} else if (ch == '<') {
					stringBuilder.append(LESSERTHAN);
				} else if (ch == '>') {
					stringBuilder.append(GREATERTHAN);
				} else if (ch == '"') {
					stringBuilder.append(QUOT);
				} else if (ch == '\'') {
					stringBuilder.append(APOSTROPHE);
				} else {
					stringBuilder.append(ch);
				}
			}
			response = stringBuilder.toString();
		}
		return response;
	}

	/**
	 * Method replaces invalid XML entities with proper escapes, this method
	 * depends on regular expressions
	 * 
	 * @param textContent
	 *            Original text
	 * @return Replaced text
	 */
	public static String escapeInvalidXmlCharsRegex(String textContent) {
		String response = null;
		if (textContent != null && !textContent.isEmpty()) {
			response = APOSTROPHE_REPLACE.matcher(
					QUOT_REPLACE.matcher(
							GREATERTHAN_REPLACE.matcher(
									LESSERTHAN_REPLACE.matcher(
											AMPERSAND_REPLACE.matcher(
													textContent).replaceAll(
													AMPERSAND)).replaceAll(
											LESSERTHAN))
									.replaceAll(GREATERTHAN)).replaceAll(QUOT))
					.replaceAll(APOSTROPHE);
		}
		return response;
	}

	/**
	 * Method replaces invalid XML entities with proper escapes, this method
	 * depends on regular expressions
	 * 
	 * @param intContent
	 *            Integer object
	 * @return Replaced text
	 */
	public static String escapeInvalidXmlCharsRegex(Integer intContent) {
		String response = null;
		String textContent = null;
		if (intContent != null) {
			textContent = intContent.toString();
			response = APOSTROPHE_REPLACE.matcher(
					QUOT_REPLACE.matcher(
							GREATERTHAN_REPLACE.matcher(
									LESSERTHAN_REPLACE.matcher(
											AMPERSAND_REPLACE.matcher(
													textContent).replaceAll(
													AMPERSAND)).replaceAll(
											LESSERTHAN))
									.replaceAll(GREATERTHAN)).replaceAll(QUOT))
					.replaceAll(APOSTROPHE);
		}
		return response;
	}

	/**
	 * Method replaces invalid XML entities with proper escapes, this method
	 * depends on regular expressions
	 * 
	 * @param boolContent
	 *            Boolean object
	 * @return Replaced text
	 */
	public static String escapeInvalidXmlCharsRegex(Boolean boolContent) {
		String response = null;
		String textContent = null;
		if (boolContent != null) {
			textContent = boolContent.toString();
			response = APOSTROPHE_REPLACE.matcher(
					QUOT_REPLACE.matcher(
							GREATERTHAN_REPLACE.matcher(
									LESSERTHAN_REPLACE.matcher(
											AMPERSAND_REPLACE.matcher(
													textContent).replaceAll(
													AMPERSAND)).replaceAll(
											LESSERTHAN))
									.replaceAll(GREATERTHAN)).replaceAll(QUOT))
					.replaceAll(APOSTROPHE);
		}
		return response;
	}

	/**
	 * Method replaces invalid XML entities with proper escapes, this method
	 * depends on regular expressions
	 * 
	 * @param doubleContent
	 *            Double object
	 * @return Replaced text
	 */
	public static String escapeInvalidXmlCharsRegex(Double doubleContent) {
		String response = null;
		String textContent = null;
		if (doubleContent != null) {
			textContent = doubleContent.toString();
			response = APOSTROPHE_REPLACE.matcher(
					QUOT_REPLACE.matcher(
							GREATERTHAN_REPLACE.matcher(
									LESSERTHAN_REPLACE.matcher(
											AMPERSAND_REPLACE.matcher(
													textContent).replaceAll(
													AMPERSAND)).replaceAll(
											LESSERTHAN))
									.replaceAll(GREATERTHAN)).replaceAll(QUOT))
					.replaceAll(APOSTROPHE);
		} else {
			response = textContent;
		}
		return response;
	}

}
