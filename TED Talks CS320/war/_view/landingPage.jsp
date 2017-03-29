<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<html>
<head>
<link rel="stylesheet" type="text/css" href="CSS/landingPage.css?<?php echo date('l jS \of F Y h:i:s A'); ?>"/>
</head>

<meta charset="ISO-8859-1">

<title>TTB 0.0.1 Landing Page</title>

<form action="${pageContext.servletContext.contextPath}/index" method="get">
	<div id="page_border">
		<img id="sign_in_icon" src="resources/Person Icon.png" />
		<input id="sign_in_email" type="text" placeholder="E-Mail/UserID">
		<input id="sign_in_password" type="text" placeholder="Password">
		<input type="image" id="york_logo" src="resources/YCP Logo.png"/>
	</div>
</form>

<div id="overall_container">
	<div class="inputContainer">
		<div>
			<h2>Upload</h2>
		</div>
		<form action="${pageContext.servletContext.contextPath}/uploadPage" method="get">
			<div>
				<input class="linkIcon" type="image"
					src="resources/Upload Icon.png"
					name="saveForm" class="btTxt submit"/>
			</div>
		</form>

	</div>
	<div class="inputContainer">
		<div>
			<h2>Class Videos</h2>
		</div>

		<form action="${pageContext.servletContext.contextPath}/classVideos" method="get">
			<div>
				<input class="linkIcon" type="image"
					src="resources/Class Videos Icon.png"
					name="saveForm" class="btTxt submit"/>
			</div>
		</form>
	</div>
	<div class="inputContainer">
		<div>
			<h2>Assignments</h2>
		</div>

		<form action="${pageContext.servletContext.contextPath}/assignPage" method="get">
			<div>
				<input class="linkIcon" type="image"
					src="resources/Assignments Icon.png"
					name="saveForm" class="btTxt submit"/>
			</div>
		</form>
	</div>
	<div class="inputContainer">
		<div>
			<h2>Class Roster</h2>
		</div>

		<form action="${pageContext.servletContext.contextPath}/classRoster" method="get">
			<div>
				<input class="linkIcon" type="image"
					src="resources/Class Roster Icon.png" name="saveForm"/>
			</div>
		</form>
	</div>
</div>

</html>