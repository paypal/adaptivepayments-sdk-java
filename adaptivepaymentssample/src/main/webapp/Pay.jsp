<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.net.URL"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Adaptive Payments - Pay</title>
<%
	URL currentURL = new URL(request.getRequestURL().toString());
	URL returnURL = new URL(currentURL, "index.html");
%>
</head>
<body>
	<img src="https://devtools-paypal.com/image/bdg_payments_by_pp_2line.png" alt="PAYMENTS BY PayPal" />
	<div id="wrapper">
		<div id="header">
			<h3>Pay</h3>
			<div id="apidetails">Pay API operation is used to transfer
				funds from a sender's PayPal account to one or more receivers'
				PayPal accounts. You can use the Pay API operation to make simple
				payments, chained payments, or parallel payments; these payments can
				be explicitly approved, preapproved, or implicitly approved.</div>
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
							<option value="">--Select a value--</option>
							<option value="PAY">Pay</option>
							<option value="CREATE">Create</option>
							<option value="PAY_PRIMARY">Pay Primary</option>
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
					<div class="param_name">IPN Notification URL (For receiving IPN call back from PayPal)</div>
					<div class="param_value">
						<input type="text" name="ipnNotificationURL" value="" />
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
							<th class="param_name">Payment Type</th>
							<th class="param_name">Payment Sub Type</th>
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
							<td class="param_value"><input type="text"
								name="paymentType" value="" /></td>
							<td class="param_value"><input type="text"
								name="paymentSubType" value="" /></td>
							<td class="param_value"><input type="text" name="invoiceID"
								value="" /></td>

						</tr>

					</table>
					<div class="param_name">Receiver Phone</div>
					<div class="param_value">
						Country Code <input type="text" name="countryCode" value=""
							size="5" />Phone Number <input type="text" name="phoneNumber"
							value="" size="10" /> Extension <input type="text"
							name="extension" value="" size="10" />
					</div>

					<div class="note">Set either SenderEmail or Sender Identifier
						Details</div>

					<div class="param_name">Sender Email</div>
					<div class="param_value">
						<input type="text" name="senderEmail" value="" />
					</div>

					<div class="input_header">Sender Identifier Details</div>
					<div class="params">
						<div class="param_name">Sender Identifier Mail</div>
						<div class="param_value">
							<input type="text" name="senderIdentifierEmail" value="" />
						</div>
					</div>
					<div class="param_name">Sender Phone</div>
					<div class="param_value">
						Country Code <input type="text" name="senderCountryCode" value="" />Phone
						Number <input type="text" name="senderPhoneNumber" value="" />
						Extension <input type="text" name="senderExtension" value="" />
					</div>
					<div class="params">
						<div class="param_name">Use Credentials?</div>
						<div class="param_value">
							<select name="useCredentials">
								<option value="">--Select a value--</option>
								<option value="true">True</option>
								<option value="false">False</option>
							</select>
						</div>
					</div>

					<div class="param_name">Fees Payer</div>
					<div class="param_value">
						<select name="feesPayer">
							<option value="">--Select a value--</option>
							<option value="SENDER">Sender</option>
							<option value="PRIMARYRECEIVER">Primary Receiver</option>
							<option value="EACHRECEIVER">Each Receiver</option>
							<option value="SECONDARYONLY">Secondary Receiver only</option>

						</select>
					</div>
					<div class="param_name">Pin</div>
					<div class="param_value">
						<input type="text" name="pin" value="" />
					</div>
					<div class="param_name">Memo</div>
					<div class="param_value">
						<input type="text" name="memo" value="" />
					</div>
					<div class="param_name">Reverse All Payments On Error</div>
					<div class="param_value">
						<select name="reverseAllPaymentsOnError">
							<option value="">--Select a value--</option>
							<option value="true">Yes</option>
							<option value="false">No</option>
						</select>
					</div>
					<div class="param_name">
						PreApproval Key(Get PreApproval Key via <a href="Preapproval">Preapproval</a>)
					</div>
					<div class="param_value">
						<input type="text" name="preapprovalKey" value="" />
					</div>
					<div class="param_name">Tracking ID</div>
					<div class="param_value">
						<input type="text" name="trackingID" value="" />
					</div>


					<div class="input_header">Client Details</div>
					<table>
						<tr>
							<th class="param_name">Device ID</th>
							<th class="param_name">Application ID</th>
							<th class="param_name">Customer ID</th>
							<th class="param_name">Customer Type</th>
							<th class="param_name">IP Address</th>
							<th class="param_name">Geo Location</th>
							<th class="param_name">Partner Name</th>
							<th class="param_name">Model</th>
						</tr>
						<tr>
							<td class="param_value"><input type="text" name="deviceID"
								value="" /></td>
							<td class="param_value"><input type="text"
								name="applicationID" value="" /></td>
							<td class="param_value"><input type="text" name="customerID"
								value="" /></td>
							<td class="param_value"><input type="text"
								name="customerType" value="" /></td>
							<td class="param_value"><input type="text" name="ipAddress"
								value="" /></td>
							<td class="param_value"><input type="text" name="location"
								value="" /></td>
							<td class="param_value"><input type="text"
								name="partnerName" value="" /></td>
							<td class="param_value"><input type="text" name="model"
								value="" /></td>
						</tr>
					</table>
				</div>
				<div class="submit">
					<input type="submit" name="PayBtn" value="Pay" />
				</div>
				<br /> <a href="index.html">Home</a>
			</div>
		</form>
		<div id="relatedcalls">
			See also
			<ul>
				<li><a href='PaymentDetails'>PaymentDetails</a></li>
				<li><a href='Refund'>Refund</a></li>
				<li><a href='GetPaymentOptions'>GetPaymentOptions</a></li>
				<li><a href='ExecutePayment'>ExecutePayment</a></li>
				<li><a href='SetPaymentOptions'>SetPaymentOptions</a></li>
			</ul>
		</div>
	</div>
</body>
</html>