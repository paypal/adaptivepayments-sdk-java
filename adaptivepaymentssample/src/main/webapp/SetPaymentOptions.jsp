<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Adaptive Payments - SetPaymentOptions</title>
</head>
<body>
	<img src="https://devtools-paypal.com/image/bdg_payments_by_pp_2line.png" alt="PAYMENTS BY PayPal" />
	<div id="wrapper">
		<div id="header">
			<h3>SetPaymentOptions</h3>
			<div id="apidetails">SetPaymentOptions API operation is used to
				specify settings for a payment of the actionType CREATE. This
				actionType is specified in the PayRequest message.</div>
		</div>
		<form method="POST">
			<div id="request_form">
				<div class="params">
					<div class="param_name">
						Pay Key*(Get PayKey via <a href="Pay">Pay</a>.Note:In Pay call,
						action type must be "CREATE")
					</div>
					<div class="param_value">
						<input type="text" name="payKey" value="" />
					</div>
				</div>

				<div class="section_header">Receiver Options</div>
				<div class="input_header">Receiver Identifier</div>
				<div class="params">
					<div class="param_name">Receiver Mail</div>
					<div class="param_value">
						<input type="text" name="receiverMail" value="" />
					</div>
				</div>
				<div class="param_name">Receiver Phone</div>
				<div class="param_value">
					Country Code <input type="text" name="receiverCountryCode" value="" />Phone
					Number <input type="text" name="receiverPhoneNumber" value="" />
					Extension <input type="text" name="receiverExtension" value="" />
				</div>
				<div class="params">
					<div class="param_name">Custom ID</div>
					<div class="param_value">
						<input type="text" name="customID" value="" />
					</div>
				</div>
				<div class="params">
					<div class="param_name">Description</div>
					<div class="param_value">
						<input type="text" name="description" value="" />
					</div>
				</div>
				<div class="params">
					<div class="param_name">Referrer Code</div>
					<div class="param_value">
						<input type="text" name="receiverReferrerCode" value="" />
					</div>
				</div>

				<div class="input_header">Invoice Details</div>
				<table class="params">
					<tr>
						<th class="param_name">Invoice Name</th>
						<th class="param_name">Invoice Identifier</th>
						<th class="param_name">Item Count</th>
						<th class="param_name">Item Price(Double)</th>
						<th class="param_name">Total Shipping(Double)</th>
						<th class="param_name">Total Tax(Double)</th>
					</tr>
					<tr>
						<td class="param_value"><input type="text" name="invoiceName"
							value="" /></td>
						<td class="param_value"><input type="text"
							name="invoiceIdentifier" value="" /></td>
						<td class="param_value"><input type="text"
							name="invoiceItemCount" value="" /></td>
						<td class="param_value"><input type="text"
							name="invoiceItemPrice" value="" /></td>
						<td class="param_value"><input type="text"
							name="invoiceTotalShipping" value="" /></td>
						<td class="param_value"><input type="text"
							name="invoiceTotalTax" value="" /></td>
					</tr>
				</table>
				<div class="section_header">Sender Options</div>
				<div class="params">
					<div class="param_name">Require Shipping Address Selection?</div>
					<div class="param_value">
						<select name="requireShippingAddressSelection">
							<option value="">--Select a value--</option>
							<option value="true">True</option>
							<option value="false">False</option>
						</select>
					</div>
				</div>
				<div class="params">
					<div class="param_name">Referrer Code</div>
					<div class="param_value">
						<input type="text" name="senderReferrerCode" value="" />
					</div>
				</div>

				<div class="params">
					<div class="param_name">Shipping Address ID</div>
					<div class="param_value">
						<input type="text" name="shippingAddressID" value="" />
					</div>
				</div>
				<div class="input_header">Initiating Entity</div>
				<table class="params">
					<tr>
						<th class="param_name">ID</th>
						<th class="param_name">First Name</th>
						<th class="param_name">Last Name</th>
						<th class="param_name">Display Name</th>
						<th class="param_name">Mail</th>
						<th class="param_name">Customer ID</th>
						<th class="param_name">Country Code</th>

					</tr>
					<tr>
						<td class="param_value"><input type="text"
							name="institutionId" value="" /></td>
						<td class="param_value"><input type="text" name="firstName"
							value="" /></td>
						<td class="param_value"><input type="text" name="lastName"
							value="" /></td>
						<td class="param_value"><input type="text" name="displayName"
							value="" /></td>
						<td class="param_value"><input type="text"
							name="institutionMail" value="" /></td>
						<td class="param_value"><input type="text"
							name="institutionCustomerId" value="" /></td>
						<td class="param_value"><input type="text" name="countryCode"
							value="" /></td>
					</tr>

				</table>

				<div class="input_header">Display Options</div>
				<table class="params">
					<tr>
						<th class="param_name">Business Name</th>
						<th class="param_name">Header Image URL</th>
						<th class="param_name">Email Header Image URL</th>
						<th class="param_name">Email Header Marketing URL</th>
					</tr>
					<tr>
						<td class="param_value"><input type="text"
							name="businessName" value="" /></td>
						<td class="param_value"><input type="text"
							name="headerImageURL" value="" /></td>
						<td class="param_value"><input type="text"
							name="emailHeaderImageURL" value="" /></td>
						<td class="param_value"><input type="text"
							name="emailHeaderMarketingURL" value="" /></td>
					</tr>
				</table>

				<div class="submit">
					<input type="submit" name="SetPaymentOptionsBtn"
						value="SetPaymentOptions" /><br />
				</div>

			</div>
		</form>
		<div id="relatedcalls">
			See also
			<ul>
				<li><a href='Pay'>Pay</a></li>
				<li><a href='PaymentDetails'>PaymentDetails</a></li>
				<li><a href='Refund'>Refund</a></li>
				<li><a href='GetPaymentOptions'>GetPaymentOptions</a></li>
				<li><a href='ExecutePayment'>ExecutePayment</a></li>
			</ul>
		</div>
	</div>
</body>
</html>