package com.sample.usecase;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DelayedPayment extends HttpServlet{
	private static final long serialVersionUID = 5798879182722L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		if(request.getRequestURI().contains("CreatePayment")){
			getServletConfig().getServletContext()
			.getRequestDispatcher("/usecase_jsp/CreatePayment.jsp")
			.forward(request, response);
		}
		if(request.getRequestURI().contains("ExecutePayment")){
			getServletConfig().getServletContext()
			.getRequestDispatcher("/usecase_jsp/ExecutePayment.jsp")
			.forward(request, response);
		}

	}
	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
	}
}
