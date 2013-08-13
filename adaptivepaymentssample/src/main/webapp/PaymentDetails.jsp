<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>AdaptivePayments - PaymentDetails</title>
</head>
<body>
	<img src="https://devtools-paypal.com/image/bdg_payments_by_pp_2line.png" alt="PAYMENTS BY PayPal" />
	<div id="wrapper">
		<div id="header">
			<h3>PaymentDetails</h3>
			<div id="apidetails">PaymentDetails API operation is used to
				obtain information about a payment. You can identify the payment by
				your tracking ID, the PayPal transaction ID in an IPN message, or
				the pay key associated with the payment.</div>
		</div>
		<form method="POST">
			<div id="request_form">
				<div class="params">
					<div class="note">Only one is required to identify the
						payment, if more than one is specified, all fields must identify
						the same payment.</div>
					<div class="param_name">
						Pay Key(Get PayKey via <a href='Pay'>Pay</a>)
					</div>
					<div class="param_value">
						<input type="text" name="payKey" value="" />
					</div>
					<div class="param_name">Transaction ID</div>
					<div class="param_value">
						<input type="text" name="transactionID" value="" />
					</div>
					<div class="param_name">Tracking ID</div>
					<div class="param_value">
						<input type="text" name="trackingID" value="" />
					</div>
				</div>
				<div class="submit">
					<input type="submit" name="PayDetailsBtn" value="PaymentDetails" /><br />
				</div>
				<a href="index.html">Home</a>
			</div>
		</form>
		<div id="relatedcalls">
			See also
			<ul>
				<li><a href='Pay'>Pay</a></li>
				<li><a href='Refund'>Refund</a></li>
				<li><a href='GetPaymentOptions'>GetPaymentOptions</a></li>
				<li><a href='ExecutePayment'>ExecutePayment</a></li>
				<li><a href='SetPaymentOptions'>SetPaymentOptions</a></li>
			</ul>
		</div>
	</div>
</body>
</html>