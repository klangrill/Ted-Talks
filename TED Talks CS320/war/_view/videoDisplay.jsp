<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<html>
<head>
<link rel="stylesheet" type="text/css" href="CSS/videoDisplay.css?<?php echo date('l jS \of F Y h:i:s A'); ?>"/>
</head>

<meta charset="ISO-8859-1">

<title>TTB 0.0.1 Video Display</title>

<body>

	<form action="${pageContext.servletContext.contextPath}/index" method="get">
		<div id="page_border">
			<img id="sign_in_icon" src="resources/Person Icon.png" />
			<input id="sign_in_email" type="text" placeholder="E-Mail/UserID">
			<input id="sign_in_password" type="text" placeholder="Password">
			<input type="image" id="york_logo" src="resources/YCP Logo.png"/>
		</div>
	</form>

	<br>

	<c:if test="${empty video}">
		<form action="${pageContext.servletContext.contextPath}/videoDisplay" method="post">
			<input type="Submit" value="Go to video!">
		</form>
	</c:if>
	<c:if test="${!empty video}">
		<div class="videoTitleWrapper" onclick="goToURL('${video.url}')">
			<h1 class="videoTitle">${video.name}</h1>
		</div>
		<iframe src="${video.embedUrl}" width="640px" height="360px"></iframe>
		<span id="subReviewWrapper">
			<textarea id="reviewComment" placeholder="Leave a review!" cols=32 rows=16></textarea>
			<img id="reviewStars" src="resources/Five Stars Blank.png">
			<input id="reviewSubmit" type="submit" value="Submit..." onclick="submitReview()">
		</span>
		<br>
		<div class="videoTitleWrapper">
			<a><strong>Speaker: </strong>${video.speaker}</a>
		</div>
		<div class="videoTitleWrapper">
			<a><strong>Disciplines: </strong>${video.disciplineLine}</a>
		</div>
		<br>
		<img id="ratingStars" src="resources/Five Stars Large.png" style="${video.ratingClip}" />
	</c:if>
</body>

</html>