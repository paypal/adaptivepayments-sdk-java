<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.net.URL"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Adaptive Payments - Chained Pay</title>
<%
	String host = request.getServerName();
	String port = String.valueOf(request.getServerPort());
	URL cancelURL = new URL("http://"+host+":"+port+"/adaptivepaymentssample/DelayedChainedPayment");
	URL returnURL = new URL("http://"+host+":"+port+"/adaptivepaymentssample/ExecutePayment");
%>
</head>
<body>
	<img
		src="https://devtools-paypal.com/image/bdg_payments_by_pp_2line.png"
		alt="PAYMENTS BY PayPal" />
	<div id="wrapper">
		<div id="header">
			<h3>Delayed Chained Payment</h3>
			<div id="apidetails">By default, payments to all receivers in a
				chained payment are immediate. However, you can choose to delay a
				payment to a secondary receiver. For example, as primary receiver,
				you may require secondary receivers to perform some action, such as
				shipping goods or waiting for expiration of a return period, before
				making payment. To complete the payment, you must explicitly execute
				a payment to secondary receivers after the sender pays you. The
				payment must occur within 90 days, after which you cannot complete
				the payment as part of the original chained payment..</div>
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
						<input type="text" name="actionType" value="PAY_PRIMARY" readonly>
					</div>
					<div class="param_name">Cancel URL*</div>
					<div class="param_value">
						<input type="text" name="cancelURL" value="<%=cancelURL%>" />
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
					<div class="param_name">Sender Email (Email other than the API caller)</div>
					<div class="param_value">
						<input type="text" name="senderEmail"
							value="platfo_1255077030_biz@gmail.com" />
					</div>
					<div class="section_header">ReceiverList</div>
					<div class="note">
						<p>Receiver is the party where funds are transferred to. A
							primary receiver receives a payment directly from the sender in a
							chained split payment. A primary receiver should not be specified
							when making a single or parallel split payment. At most one
							receiver can be set as primary receiver.</p>
					</div>
					<table>
						<tr>
							<th class="param_name">Amount*(Double)</th>
							<th class="param_name">E-mail* (Primary receiver should be the API caller)</th>
							<th>Primary Receiver</th>
						</tr>
						<tr>
							<td class="param_value"><input type="text" name="amount"
								value="2.00" /></td>
							<td class="param_value"><input type="text" name="mail"
								value="jb-us-seller@paypal.com" /></td>
							<td><select name="primaryReceiver" id="primaryReceiver_0"
								class="smallfield">
									<option value="true" selected="selected">true</option>
									<option value="false">false</option>
							</select>
							</td>
						</tr>
						<tr>
							<td class="param_value"><input type="text" name="amount"
								value="2.00" /></td>
							<td class="param_value"><input type="text" name="mail"
								value="platfo_1255612361_per@gmail.com" /></td>
							<td><select name="primaryReceiver" id="primaryReceiver_1"
								class="smallfield">
									<option value="true">true</option>
									<option value="false" selected="selected">false</option>
							</select>
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