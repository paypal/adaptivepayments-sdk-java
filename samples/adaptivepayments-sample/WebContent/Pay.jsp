<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Adaptive Payments</title>
<%
	StringBuilder url = new StringBuilder();
	url.append("http://");
	url.append(request.getServerName());
	url.append(":");
	url.append(request.getServerPort());
	url.append(request.getContextPath());
	String returnURL = url.toString() + "/index.html";
%>
</head>
<body>
	<h2>Pay API Test Page</h2>
	<form method="POST">
		<div class="params">
			<div class="param_name">Code</div>
			<div class="param_value">
				<input type="text" name="currencyCode" value="USD" size="50"
					maxlength="260" />
			</div>
			<div class="param_name">Amount</div>
			<div class="param_value">
				<input type="text" name="amount" value="2.00" size="
					50"
					maxlength="260" />
			</div>
			<div class="param_name">E-mail</div>
			<div class="param_value">
				<input type="text" name="mail" value="enduser_biz@gmail.com"
					size="50" maxlength="260" />
			</div>
			<div class="param_name">ActionType</div>
			<div class="param_value">
				<input type="text" name="actionType" value="PAY" size="50"
					maxlength="260" />
			</div>
			<div class="param_name">CancelURL</div>
			<div class="param_value">
				<input type="text" name="cancelURL" value="<%=returnURL%>" size="50"
					maxlength="260" />
			</div>
			<div class="param_name">ReturnURL</div>
			<div class="param_value">
				<input type="text" name="returnURL" value="<%=returnURL%>" size="50"
					maxlength="260" />
			</div>
		</div>
		<input type="submit" name="PayBtn" value="Pay" />
	</form>
	<a href="index.html">Home</a>
</body>
</html>