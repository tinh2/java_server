<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Welcome JSP</title>
</head>

<%
String msg = String.valueOf(request.getAttribute("message"));
out.println(msg);
%>
<br>
<center>
	<img src="google.gif"><input type="text" id="query" size="70" /><br>

	<button onclick="google()">Google Search</button>
	<br>
</center>

<script>
function google() {
	var googleURL = "http://www.google.com/search?q=";
	var queryString = document.getElementById("query").value;
    window.location.href(googleURL.concat(queryString));
}
</script>
</body>
</html>