<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Adaptive Payments - GetFundingPlans</title>
</head>
<body>
	<img src="https://devtools-paypal.com/image/bdg_payments_by_pp_2line.png" alt="PAYMENTS BY PayPal" />
	<div id="wrapper">
		<div id="header">
			<h3>GetFundingPlans</h3>
			<div id="apidetails">GetFundingPlans API operation is used to
				determine the funding sources that are available for a specified
				payment, identified by its key, which takes into account the
				preferences and country of the receiver as well as the payment
				amount. You must be both the sender of the payment and the caller of
				this API operation.</div>
		</div>
		<form method="POST">
			<div id="request_form">
				<div class="params">
					<div class="param_name">
						Pay Key*(Get PayKey via <a href='Pay'>Pay</a>)
					</div>
					<div class="param_value">
						<input type="text" name="payKey" value="" />
					</div>
				</div>
				<div class="submit">
					<input type="submit" name="GetFundingPlansBtn"
						value="GetFundingPlans" /><br />
				</div>
				<a href="index.html">Home</a>
			</div>
		</form>
		<div id="relatedcalls">
			See also
			<ul>
				<li><a href='Pay'>Pay</a></li>
				<li><a href='Refund'>Refund</a></li>
				<li><a href='GetAllowedFundingSources'>GetAllowedFundingSources</a></li>
			</ul>
		</div>
	</div>
</body>
</html>