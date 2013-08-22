<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.net.URL"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Adaptive Payments - Deferred Payment</title>
<%
	URL currentURL = new URL(request.getRequestURL().toString());
	URL returnURL = new URL(currentURL, "../index.html");
%>
</head>
<body>
	<img src="https://devtools-paypal.com/image/bdg_payments_by_pp_2line.png" alt="PAYMENTS BY PayPal" />
	<div id="wrapper">
		<div id="header">
			<h3>Deferred Payment</h3>
			<div id="apidetails"><p> Deferred payment is about  Creating a Payment (Using  Pay api with [actionType:create]) 
			and Executing a Payment later(using ExecutingPayment API) . Here the sender Email should be the email of api caller(whose credential are used for api call),
			 the payment needs to be approved for a deferred payment.</p></div>
		</div>
		<form method="POST">
			<div id="request_form">
				<div class="params">
					<div class="param_name">Currency Code*</div>
					<div class="param_value">
						<input type="text" name="currencyCode" value="USD" />
					</div>

					<div class="param_name">Action Type*</div>
					<div class="param_value">
						<input type="text" name="actionType" value="CREATE" readonly>
					</div>
					<div class="param_name">Cancel URL*</div>
					<div class="param_value">
						<input type="text" name="cancelURL" value="<%=returnURL%>" />
					</div>
					<div class="param_name">Return URL*</div>
					<div class="param_value">
						<input type="text" name="returnURL" value="<%=returnURL%>" />
					</div>
					<div class="param_name">IPN Notification URL (For receiving
						IPN call back from PayPal)</div>
					<div class="param_value">
						<input type="text" name="ipnNotificationURL" value="" />
					</div>
					
					<div class="param_name">Sender Email*</div>
					<div class="param_value">
						<input type="text" name="senderEmail" value="jb-us-seller@paypal.com" />
					</div>
					
					<div class="section_header">ReceiverList</div>
					<div class="note">Receiver is the party where funds are
						transferred to. </div>
					<table>
						<tr>
							<th class="param_name">Amount*(Double)</th>
							<th class="param_name">E-mail*</th>

						</tr>
						<tr>
							<td class="param_value"><input type="text" name="amount"
								value="2.00" />
							</td>
							<td class="param_value"><input type="text" name="mail"
								value="platfo_1255612361_per@gmail.com" />
							</td>
						</tr>

					</table>
					<div class="submit">
						<input type="submit" name="PayBtn" value="Pay" />
					</div>
					<br /> <a href="index.html">Home</a>
				</div>
			</div>
		</form>
		<br/>
		<b>Note:</b>
		<div id="relatedcalls">
			The payment will be created with  <b><i>Pay</i></b> api request,with the request parameter actionType as 'CREATE'. To complete the 
			Payment at a later date , you have to execute the payment using <i><b>ExecutePayment</i></b> api. If  You have to set payment Option, 
			You need to call the optional api <i><b>SetPaymentOptions</i></b> before <i><b>ExecutePayment</i></b>.			
		</div>
	</div>
</body>
</html>