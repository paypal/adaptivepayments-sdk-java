<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.net.URL"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Adaptive Payments - Preapproval</title>
<%
	URL currentURL = new URL(request.getRequestURL().toString());
	URL returnURL = new URL(currentURL, "index.html");
%>
</head>
<body>
	<img src="https://devtools-paypal.com/image/bdg_payments_by_pp_2line.png" alt="PAYMENTS BY PayPal" />
	<div id="wrapper">
		<div id="header">
			<h3>Preapproval</h3>
			<div id="apidetails">Preapproval API operation is used to set
				up an agreement between yourself and a sender for making payments on
				the sender's behalf. You set up a preapprovals for a specific
				maximum amount over a specific period of time and, optionally, by
				any of the following constraints: the number of payments, a maximum
				per-payment amount, a specific day of the week or the month, and
				whether or not a PIN is required for each payment request.</div>
		</div>
		<form method="POST">
			<div id="request_form">
				<div class="params">
					<div class="param_name">Currency Code*</div>
					<div class="param_value">
						<input type="text" name="currencyCode" value="USD" />
					</div>
					<table>
						<tr>
							<th class="param_name">Starting Date*</th>
							<th class="param_name">Ending Date</th>
						</tr>
						<tr>
							<td class="param_value"><input type="text"
								name="startingDate" value="2013-12-18" /></td>

							<td class="param_value"><input type="text" name="endingDate"
								value="" /></td>
						</tr>
					</table>
					<div class="input_header">URLs</div>
					<table>
						<tr>
							<th class="param_name">Cancel URL*</th>
							<th class="param_name">Return URL*</th>
							<th class="param_name">IPN Notification URL (For receiving IPN call back from PayPal)</th>
						</tr>
						<tr>
							<td class="param_value"><input type="text" name="cancelURL"
								value="<%=returnURL%>" /></td>
							<td class="param_value"><input type="text" name="returnURL"
								value="<%=returnURL%>" /></td>
							<td class="param_value"><input type="text"
								name="ipnNotificationURL" value="" /></td>
						</tr>
					</table>
					<div class="param_name">Sender Email</div>
					<div class="param_value">
						<input type="text" name="senderEmail" value="" />
					</div>
					<div class="param_name">Fees Payer</div>
					<div class="param_value">
						<input type="text" name="feesPayer" value="" />
					</div>
					<div class="param_name">Pin Type</div>
					<div class="param_value">
						<input type="text" name="pinType" value="" />
					</div>
					<div class="param_name">Memo</div>
					<div class="param_value">
						<input type="text" name="memo" value="" />
					</div>
					<table>
						<tr>
							<th class="param_name">Date Of Month</th>
							<th class="param_name">Day Of Week</th>
						</tr>
						<tr>
							<td class="param_value"><input type="text"
								name="dateOfMonth" value="" /></td>
							<td class="param_value"><select name="dayOfWeek">
									<option value="">--Select a value--</option>
									<option value="NO_DAY_SPECIFIED">No Day Specified</option>
									<option value="SUNDAY">Sunday</option>
									<option value="MONDAY">Monday</option>
									<option value="TUESDAY">Tuesday</option>
									<option value="WEDNESDAY">Wednesday</option>
									<option value="THURSDAY">Thursday</option>
									<option value="FRIDAY">Friday</option>
									<option value="SATURDAY">Saturday</option>
							</select></td>
						</tr>
					</table>
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
					<div class="input_header">Payment Details</div>
					<table>
						<tr>
							<th class="param_name">Maximum Amount Per Payment</th>
							<th class="param_name">Maximum Number Of Payments</th>
							<th class="param_name">Maximum Number Of Payments Per Period</th>
							<th class="param_name">Total Amount Of All Payments</th>
							<th class="param_name">Payment Period</th>
							<th class="param_name">Display Maximum Total Amount</th>
						</tr>
						<tr>
							<td class="param_value"><input type="text"
								name="maxAmountPerPayment" value="" /></td>
							<td class="param_value"><input type="text"
								name="maxNumberOfPayments" value="" /></td>
							<td class="param_value"><input type="text"
								name="maxNumberOfPaymentsPerPeriod" value="" /></td>
							<td class="param_value"><input type="text"
								name="totalAmountOfAllPayments" value="" /></td>
							<td class="param_value"><input type="text"
								name="paymentPeriod" value="" /></td>
							<td class="param_value"><select name="displayMaxTotalAmount">
									<option value="">--Select a value--</option>
									<option value="true">True</option>
									<option value="false">False</option>
							</select></td>
						</tr>
					</table>
				</div>
				<div class="submit">
					<input type="submit" name="PreapprovalBtn" value="Preapproval" /><br />
				</div>
				<a href="index.html">Home</a>
			</div>
		</form>
		<div id="relatedcalls">
			See also
			<ul>
				<li><a href='PreapprovalDetails'>PreapprovalDetails</a></li>
				<li><a href='ConfirmPreapproval'>ConfirmPreapproval</a></li>
				<li><a href='CancelPreapproval'>CancelPreapproval</a></li>
			</ul>
		</div>
	</div>
</body>
</html>