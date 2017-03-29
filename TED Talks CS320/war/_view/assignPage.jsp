<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<html>
<head>
<link rel="stylesheet" type="text/css" href="CSS/assignPage.css?<?php echo date('l jS \of F Y h:i:s A'); ?>"/>
</head>

<meta charset="ISO-8859-1">

<title>TTB 0.0.1 Assignments Page</title>

<form action="${pageContext.servletContext.contextPath}/index" method="get">
	<div id="page_border">
		<img id="sign_in_icon" src="resources/Person Icon.png" />
		<input id="sign_in_email" type="text" placeholder="E-Mail/UserID">
		<input id="sign_in_password" type="text" placeholder="Password">
		<input type="image" id="york_logo" src="resources/YCP Logo.png"/>
	</div>
</form>

<body>
	<div id="assign_box">
		<h1>Class Assignments</h1>
		<form action="${pageContext.servletContext.contextPath}/assignPage" method="post">
			<fieldset>
				<legend>Assignments</legend>
				<label>Assignment:</label> <input type="text" id="assign"
					value="${model.assign}" /> <label>Due Date:</label> <input
					type="text" id="date" value="${model.date}" /> <br>
				<button id="addA" type="submit">Add Assignment</button>
			</fieldset>
		</form>
	</div>
</body>

</html>