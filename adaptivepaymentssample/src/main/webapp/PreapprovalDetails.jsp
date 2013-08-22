<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Adaptive Payments - Preapproval Details</title>
</head>
<body>
	<img src="https://devtools-paypal.com/image/bdg_payments_by_pp_2line.png" alt="PAYMENTS BY PayPal" />
	<div id="wrapper">
		<div id="header">
			<h3>Preapproval Details</h3>
			<div id="apidetails">PreapprovalDetails API operation is used
				to obtain information about an agreement between you and a sender
				for making payments on the sender's behalf.</div>
		</div>
		<form method="POST">
			<div id="request_form">
				<div class="params">
					<div class="param_name">
						Preapproval Key*(Get Preapproval key via <a href='Preapproval'>Preapproval</a>)
					</div>
					<div class="param_value">
						<input type="text" name="preapprovalKey" value="" s />
					</div>
				</div>
				<div class="params">
					<div class="param_name">Retrieves the billing address of the
						sender</div>
					<div class="param_value">
						<select name="getBillingAddress">
							<option value="">--Select a value--</option>
							<option value="false">Omits the billing address from the
								response</option>
							<option value="true">Includes the billing address in the
								response</option>
						</select>
					</div>
				</div>
				<div class="submit">
					<input type="submit" name="PreapprovalDetailsBtn"
						value="PreapprovalDetails" /><br />
				</div>
				<a href="index.html">Home</a>
			</div>
		</form>
		<div id="relatedcalls">
			See also
			<ul>
				<li><a href='Preapproval'>Preapproval</a></li>
				<li><a href='ConfirmPreapproval'>ConfirmPreapproval</a></li>
				<li><a href='CancelPreapproval'>CancelPreapproval</a></li>
			</ul>
		</div>
	</div>

</body>
</html>