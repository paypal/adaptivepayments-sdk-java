<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>
<%@ page import="java.io.*"%>
<%@ page import="com.paypal.svcs.types.common.ErrorData"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ErrorPage</title>
</head>
<body>
	<img src="https://devtools-paypal.com/image/bdg_payments_by_pp_2line.png" alt="PAYMENTS BY PayPal" />
	<h2>Error Page</h2>
	<%
		Map<String, String> originalMap = (Map) session
				.getAttribute("ORIGINAL_MAP");
		Map<String, String> constructedMap = (Map) session
				.getAttribute("CONSTRUCTED_MAP");
		if ((originalMap != null) && (constructedMap != null)) {
	%>
	<div id="test_result">
		Deserialization test result
		<%=originalMap.equals(constructedMap) ? "<span style='color:GREEN'>SUCCESS</span>"
						: "<span style='color:RED'>FAILURE</span>"%>
		<%
			if (!originalMap.equals(constructedMap)) {
		%>
		<div id="test_failures">
			<ul>
				<%
					for (String key : originalMap.keySet()) {
								if (!originalMap.get(key).equals(
										constructedMap.get(key))) {
				%>
				<li>Key : <%=key%>, Original Value : <%=originalMap.get(key)%>,
					Constructed Value:<%=constructedMap.get(key)%></li>
				<%
					}
							}
				%>
			</ul>
		</div>
		<%
			}
		%>
	</div>
	<%
		}
	%>
	<%
		List<ErrorData> errorList = (List<ErrorData>) session
				.getAttribute("Error");

		for (ErrorData e : errorList) {
	%><table>
		<tr>
			<td>Message:</td>
			<td><%=e.getMessage()%>
		</tr>
	</table>
	<table>
		<tr>
			<td>Request:</td>
		</tr>
		<tr>
			<td><textarea rows="10" cols="100"><%=session.getAttribute("lastReq")%></textarea>
			</td>
		</tr>
		<tr>
			<td>Response:</td>
		</tr>
		<tr>
			<td><textarea rows="10" cols="100"><%=session.getAttribute("lastResp")%></textarea>
			</td>
		</tr>
	</table>


	<%
		}
	%>
	<a href="index.html">Home</a>
	<a href="<%=session.getAttribute("url")%>">Back</a>
	<div id="related_calls">
		See also
		<%=session.getAttribute("relatedUrl")%>
	</div>

</body>
</html>