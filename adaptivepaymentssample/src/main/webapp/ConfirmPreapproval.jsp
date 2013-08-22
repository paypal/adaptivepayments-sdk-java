<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Adaptive Payments - Confirm Preapproval</title>
</head>
<body>
	<img src="https://devtools-paypal.com/image/bdg_payments_by_pp_2line.png" alt="PAYMENTS BY PayPal" />
	<div id="wrapper">
		<div id="header">
			<h3>Confirm Preapproval</h3>
			<div id="apidetails">ConfirmPreapproval API operation is used
				to confirm the preapprovals.</div>
		</div>
		<form method="POST">
			<div id="request_form">
				<div class="params">
					<div class="param_name">
						Preapproval Key*(Get Preapproval key via <a href='Preapproval'>Preapproval</a>)
					</div>
					<div class="param_value">
						<input type="text" name="preapprovalKey" value="" />
					</div>
				</div>
				<div class="params">
					<div class="param_name">
						Funding Source ID*(Get Funding Source Id via <a
							href='GetAllowedFundingSources'>GetAllowedFundingSources</a>)
					</div>
					<div class="param_value">
						<input type="text" name="fundingSourceID" value="" />
					</div>
				</div>
				<div class="params">
					<div class="param_name">Pin</div>
					<div class="param_value">
						<input type="text" name="pin" value="" />
					</div>
				</div>
				<div class="submit">
					<input type="submit" name="ConfirmPreapprovalBtn"
						value="ConfirmPreapproval" />
				</div>
				<br /> <a href="index.html">Home</a>
			</div>
		</form>

		<div id="relatedcalls">
			See also
			<ul>
				<li><a href='Preapproval'>Preapproval</a></li>
				<li><a href='PreapprovalDetails'>PreapprovalDetails</a></li>
				<li><a href='CancelPreapproval'>CancelPreapproval</a></li>
			</ul>
		</div>
	</div>
</body>
</html>