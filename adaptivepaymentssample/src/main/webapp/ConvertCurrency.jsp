<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Adaptive Payments - ConvertCurrency</title>
</head>
<body>
	<img src="https://devtools-paypal.com/image/bdg_payments_by_pp_2line.png" alt="PAYMENTS BY PayPal" />
	<div id="wrapper">
		<div id="header">
			<h3>ConvertCurrency</h3>
			<div id="apidetails">ConvertCurrency API operation is used to
				obtain the estimated current foreign exchange (FX) rate for a
				specific amount and currency. This is an estimated rate, which may
				be different from the FX rate used at the time of the transaction.</div>
		</div>
		<form method="POST">
			<div id="request_form">
				<div class="params">
					<div class="param_name">Code*</div>
					<div class="param_value">
						<input type="text" name="code" value="USD" />
					</div>
				</div>
				<div class="params">
					<div class="param_name">Amount*</div>
					<div class="param_value">
						<input type="text" name="amount" value="2.00" />
					</div>
				</div>
				<div class="params">
					<div class="param_name">ConvertTo*</div>
					<div class="param_value">
						<input type="text" name="convertTo" value="GBP" />
					</div>
				</div>
				<div class="params">
					<div class="param_name">Conversion Type</div>
					<div class="param_value">
						<input type="text" name="conversionType" value="" />
					</div>
				</div>
				<div class="params">
					<div class="param_name">Country Code</div>
					<div class="param_value">
						<input type="text" name="countryCode" value="" />
					</div>
				</div>
				<div class="submit">
					<input type="submit" name="ConvertBtn" value="Convert" /><br />
				</div>
				<a href="index.html">Home</a>
			</div>
		</form>
		<div id="relatedcalls">
			See also
			<ul>
				<li><a href='Pay'>Pay</a></li>
				<li><a href='Refund'>Refund</a></li>
				<li><a href='Preapproval'>Preapproval</a></li>
			</ul>
		</div>
	</div>
</body>
</html>