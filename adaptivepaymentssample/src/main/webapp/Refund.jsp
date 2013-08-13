<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Adaptive Payments - Refund</title>
</head>
<body>
	<img src="https://devtools-paypal.com/image/bdg_payments_by_pp_2line.png" alt="PAYMENTS BY PayPal" />
	<div id="wrapper">
		<div id="header">
			<h3>Refund</h3>
			<div id="apidetails">Refund API operation is used to refund all
				or part of a payment. You can specify the amount of the refund and
				identify the accounts to receive the refund by the payment key or
				tracking ID, and optionally, by transaction ID or the receivers of
				the original payment.</div>
		</div>
		<form method="POST">
			<div id="request_form">
				<div class="params">
					<div class="note">A refund can be made against the entire
						payKey,or an individual transaction belonging to a payKey,or a
						tracking id, or a specific receiver of a payKey.</div>
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
					<div class="param_name">Currency Code</div>
					<div class="param_value">
						<input type="text" name="currencyCode" value="USD" />
					</div>
					<div class="section_header">ReceiverList</div>
					<div class="note">Receiver is the party where funds are
						transferred to. A primary receiver receives a payment directly
						from the sender in a chained split payment. A primary receiver
						should not be specified when making a single or parallel split
						payment. Must set either mail or phone number</div>
					<table>
						<tr>
							<th class="param_name">Amount*(Double)</th>
							<th class="param_name">E-mail</th>
							<th class="param_name">Primary Receiver</th>
							<th class="param_name">Invoice ID</th>

						</tr>
						<tr>
							<td class="param_value"><input type="text" name="amount"
								value="2.00" /></td>
							<td class="param_value"><input type="text" name="mail"
								value="" /></td>
							<td class="param_value"><select name="setPrimary">
									<option value="">--Select a value--</option>
									<option value="false">Not a Primary Receiver</option>
									<option value="true">Primary Receiver</option>
							</select></td>

							<td class="param_value"><input type="text" name="invoiceID"
								value="" /></td>

						</tr>

					</table>
					<div class="param_name">Receiver Phone</div>
					<div class="param_value">
						Country Code <input type="text" name="countryCode" value="" />Phone
						Number <input type="text" name="phoneNumber" value="" />
						Extension <input type="text" name="extension" value="" />
					</div>
				</div>
				<div class="submit">
					<input type="submit" name="RefundBtn" value="Refund" /><br />
				</div>
				<a href="index.html">Home</a>
			</div>
		</form>

		<div id="relatedcalls">
			See also
			<ul>
				<li><a href='Pay'>Pay</a></li>
				<li><a href='PaymentDetails'>PaymentDetails</a></li>
				<li><a href='GetPaymentOptions'>GetPaymentOptions</a></li>
				<li><a href='ExecutePayment'>ExecutePayment</a></li>
				<li><a href='SetPaymentOptions'>SetPaymentOptions</a></li>
			</ul>
		</div>
	</div>
</body>
</html>