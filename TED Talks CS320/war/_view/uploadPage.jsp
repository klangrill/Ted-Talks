<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<html>

<head>
<link rel="stylesheet" type="text/css" href="CSS/uploadPage.css?<?php echo date('l jS \of F Y h:i:s A'); ?>"/>
</head>

<meta charset="ISO-8859-1">

<title>TTB 0.0.1 Upload Page</title>

<form action="${pageContext.servletContext.contextPath}/index" method="get">
	<div id="page_border">
		<img id="sign_in_icon" src="resources/Person Icon.png" />
		<input id="sign_in_email" type="text" placeholder="E-Mail/UserID">
		<input id="sign_in_password" type="text" placeholder="Password">
		<input type="image" id="york_logo" src="resources/YCP Logo.png"/>
	</div>
</form>

<div>
	<h1 align="center">Upload TED Talk</h1>

	<p align="center">Paste Video URL:</p>
	<p align="center"><input type="text" name="first" size="50" value="" /></p>

	<button>Submit Video</button>
</div>
</html>