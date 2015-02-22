<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Login JSP page</title>
</head>
<body>
	<img src="lock.jpg" alt="locked" height="110" width="110">
	<form name="loginform" action="login" method="post">
		<h2>Hello please log in to see the welcome screen</h2>
		<br>
		Enter username: <input type="text" name="username" /><br>
		Enter password: <input type="password" name="pass" /><br> 
		<input type="submit" value="Submit" />
	</form>
	<h6>You have three tries.</h6>
</body>
</html>