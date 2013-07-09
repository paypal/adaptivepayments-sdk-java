<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.net.URL"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Adaptive Payments - Embedded Payment</title>
<%
	URL currentURL = new URL(request.getRequestURL().toString());
	URL returnURL = new URL(currentURL, "index.html");
%>
</head>
<body>
	<img src="https://devtools-paypal.com/image/bdg_payments_by_pp_2line.png" alt="PAYMENTS BY PayPal" />
	<div id="wrapper">
		<div id="header">
			<h3>Embedded Payment</h3>
			<div id="apidetails">An embedded payment is a payment that
				initiates a visual presentation of the Adaptive Payments payment
				flow in which the sender appears to never leave your checkout or
				payment page. Embedded payments make it easier for a sender to make
				a payment because PayPal may allow the sender to bypass the PayPal
				login step.</div>
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
						<select name="actionType">
							<option value="PAY">Pay</option>
						</select>
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
					<div class="param_name">Sender Email</div>
					<div class="param_value">
						<input type="text" name="senderEmail"
							value="jb-us-seller@paypal.com" />
					</div>
					<div class="section_header">ReceiverList:</div>
					<div class="note">Receiver is the party where funds are
						transferred to.</div>
					<table>
						<tr>
							<th class="param_name">Amount*(Double)</th>
							<th class="param_name">E-mail</th>

						</tr>
						<tr>
							<td class="param_value"><input type="text" name="amount"
								value="2.00" /></td>
							<td class="param_value"><input type="text" name="mail"
								value="pp15@paypal.com" /></td>
						</tr>

					</table>
					<div class="submit">
						<input type="submit" name="paypal_submit" value="Pay" />
					</div>
					<br /> <a href="index.html">Home</a>
				</div>
			</div>
		</form>

	</div>
<script src='https://www.paypalobjects.com/js/external/dg.js' type='text/javascript'></script>
<script>

	var dg = new PAYPAL.apps.DGFlow(
	{
		trigger: 'paypal_submit',
		expType: 'instant'
		 //PayPal will decide the experience type for the buyer based on his/her 'Remember me on your computer' option.
	});

</script>
</body>
</html>