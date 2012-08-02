package com.sample.adaptivepayments.filters;

import java.io.IOException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.paypal.core.LoggingManager;
import com.paypal.core.NVPUtil;
import com.paypal.core.ReflectionUtil;

public class TestFilter implements Filter {

	public void destroy() {

	}

	public void doFilter(ServletRequest servletRequest,
			ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
		filterChain.doFilter(servletRequest, servletResponse);
		HttpSession session = ((HttpServletRequest) servletRequest)
				.getSession();
		Object apiResponseObject = session.getAttribute("RESPONSE_OBJECT");
		String originalResponse = (String) session.getAttribute("lastResp");
		Map<String, String> originalMap = NVPUtil.decode(originalResponse);
		LoggingManager.log(Level.INFO, TestFilter.class, "Original Map: "
				+ originalMap);
		Map<String, String> constructedMap = ReflectionUtil
				.decodeResponseObject(apiResponseObject, "");
		LoggingManager.log(Level.INFO, TestFilter.class, "Constructed Map: "
				+ constructedMap);
		LoggingManager.log(Level.INFO, TestFilter.class,
				"Match:" + originalMap.equals(constructedMap));
		if (!originalMap.equals(constructedMap)) {
			LoggingManager.log(Level.WARNING, TestFilter.class,
					"Difference identified in deserialization of response");
			for (String key : originalMap.keySet()) {
				if (!originalMap.get(key).equals(constructedMap.get(key))) {
					LoggingManager.log(Level.WARNING, TestFilter.class,
							"Original: " + key + " => " + originalMap.get(key)
									+ " : " + "Constructed: " + key + " => "
									+ constructedMap.get(key));
				}
			}
		}
	}

	public void init(FilterConfig filterConfig) throws ServletException {

	}

}
