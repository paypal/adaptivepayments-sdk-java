package com.sample.adaptivepayments.filters;

import java.io.IOException;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.paypal.core.NVPUtil;
import com.paypal.core.ReflectionUtil;

public class TestFilter implements Filter {

	public void destroy() {

	}

	public void doFilter(ServletRequest servletRequest,
			ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
		HttpSession session = ((HttpServletRequest) servletRequest)
				.getSession();
		String originalResponse = (String) session.getAttribute("lastResp");
		Map<String, String> originalMap = NVPUtil.decode(originalResponse);
		Object apiResponseObject = session.getAttribute("RESPONSE_OBJECT");
		Map<String, String> constructedMap = ReflectionUtil
				.decodeResponseObject(apiResponseObject, "");
		session.setAttribute("ORIGINAL_MAP", originalMap);
		session.setAttribute("CONSTRUCTED_MAP", constructedMap);
		filterChain.doFilter(servletRequest, servletResponse);
	}

	public void init(FilterConfig filterConfig) throws ServletException {

	}

}
