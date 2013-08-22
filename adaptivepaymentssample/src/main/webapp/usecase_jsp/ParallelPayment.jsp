<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.net.URL"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Adaptive Payments - Parallel Pay</title>
<%
	URL currentURL = new URL(request.getRequestURL().toString());
	URL returnURL = new URL(currentURL, "../index.html");
%>
</head>
<body>
	<img src="https://devtools-paypal.com/image/bdg_payments_by_pp_2line.png" alt="PAYMENTS BY PayPal" />
	<div id="wrapper">
		<div id="header">
			<h3>Parallel Payment</h3>
			<div id="apidetails">The Pay API operation is used to transfer
				funds from a sender's PayPal account to one or more receivers'
				PayPal accounts. You can use the Pay API operation to make simple
				payments, chained payments, or parallel payments; these payments can
				be explicitly approved, preapproved, or implicitly approved.
				Parallel payments are useful in cases when a buyer intends to make a
				single payment for items from multiple sellers. Examples include the
				following scenarios: a single payment for multiple items from
				different merchants, such as a combination of items in your
				inventory and items that partners drop ship for you. purchases of
				items related to an event, such as a trip that requires airfare, car
				rental, and a hotel booking</div>
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
						<input type="text" name="actionType" value="PAY" readonly>
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
					<div class="param_name">Sender Email (Here, we are showcasing implicit payments, sender email should be same as the API caller. For explicit payments you can skip this parameter or set this to email other than the API caller)</div>
					<div class="param_value">
						<input type="text" name="senderEmail" value="jb-us-seller@paypal.com" />
					</div>
					<div class="section_header">ReceiverList</div>
					<div class="note">Receiver is the party where funds are
						transferred to. Each receiver receives a payment directly
						from the sender in a parallel payment.</div>
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
								value="pp15@paypal.com" />
							</td>
						</tr>
						<tr>
							<td class="param_value"><input type="text" name="amount"
								value="2.00" />
							</td>
							<td class="param_value"><input type="text" name="mail"
								value="pp14@paypal.com" />
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

	</div>
</body>
</html>