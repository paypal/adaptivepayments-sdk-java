<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Adaptive Payments - GetAllowedFundingSources</title>
</head>
<body>
	<img src="https://devtools-paypal.com/image/bdg_payments_by_pp_2line.png" alt="PAYMENTS BY PayPal" />
	<div id="wrapper">
		<div id="header">
			<h3>GetAllowedFundingSources</h3>
			<div id="apidetails">GetAllowedFundingSources API operation is
				used to get the allowed funding sources available for a preapproval.</div>
		</div>
		<form method="POST">
			<div id="request_form">
				<div class="params">
					<div class="param_name">
						Preapproval Key*(Get PreapprovalKey via <a href='Preapproval'>Preapproval</a>)
					</div>
					<div class="param_value">
						<input type="text" name="preapprovalKey" value="" />
					</div>
				</div>
				<div class="submit">
					<input type="submit" name="GetAllowedFundingSourcesBtn"
						value="GetAllowedFundingSources" /><br />
				</div>
				<a href="index.html">Home</a>
			</div>
		</form>
		<div id="relatedcalls">
			See also
			<ul>
				<li><a href='Preapproval'>Preapproval</a></li>
				<li><a href='Refund'>Refund</a></li>
				<li><a href='GetFundingPlans'>GetFundingPlans</a></li>
			</ul>
		</div>
	</div>
</body>
</html>