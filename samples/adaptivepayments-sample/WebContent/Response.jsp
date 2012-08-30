<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Response Page</title>
</head>
<body>
	<h2>Response Page</h2>
	<div class="section_header">
		<h3>Key values from the response</h3>
	</div>
	<table>
		<%
			Map map = (Map) session.getAttribute("map");
			Iterator iterator = map.entrySet().iterator();
			while (iterator.hasNext()) {
				Map.Entry mapEntry = (Map.Entry) iterator.next();
		%>

		<tr>
			<td><%=mapEntry.getKey()%></td>
			<td>:</td>
			<td><div id="<%=mapEntry.getKey()%>"><%=mapEntry.getValue()%></div></td>
		</tr>

		<%
			}
		%>
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

	<a href="index.html">Home</a>
	<a href="<%=session.getAttribute("url")%>">Back</a>
	<div id="related_calls">
		See also
		<%=session.getAttribute("relatedUrl")%>
	</div>

</body>
</html>