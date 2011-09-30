<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Adaptive Payments</title>
</head>
<body>
	<h2>GetShippingAddresses API Test Page</h2>
	<form method="POST">
		<div class="params">
			<div class="param_name">PayKey</div>
			<div class="param_value">
				<input type="text" name="payKey" value="" size="50" maxlength="260" />
			</div>

		</div>
		<input type="submit" name="GetShippingAddressesBtn"
			value="GetShippingAddresses" />
	</form>
	<a href="index.html">Home</a>
</body>
</html>