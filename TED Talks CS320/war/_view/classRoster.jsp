<!DOCTYPE html>
<html>

<head>
<link rel="stylesheet" type="text/css" href="CSS/classRoster.css?<?php echo date('l jS \of F Y h:i:s A'); ?>"/>
</head>

<meta charset="ISO-8859-1">

<title>TTB 0.0.1 Class Roster</title>

<form action="${pageContext.servletContext.contextPath}/index"
	method="get">
	<div id="page_border">
		<img id="sign_in_icon" src="resources/Person Icon.png" /> <input
			id="sign_in_email" type="text" placeholder="E-Mail/UserID"> <input
			id="sign_in_password" type="text" placeholder="Password"> <input
			type="image" id="york_logo" src="resources/YCP Logo.png" />
	</div>
</form>
</div>
<div>
	<h3>Add Participants:</h3>
	<form action="${pageContext.servletContext.contextPath}/ClassRoster"
		method="post">
		<table>
			<tr>
				<td class="label">First Name:</td>
				<td><input type="text" name="first" size="12" value="${first}" /></td>
			</tr>
			<tr>
				<td class="label">Last Name:</td>
				<td><input type="text" name="last" size="12" value="${last}" /></td>
			</tr>
			<tr>
				<td class="label">Email:</td>
				<td><input type="text" name="last" size="12" value="${email}" /></td>
			</tr>
		</table>
		<input type="Submit" name="submit" value="Add Participant">
	</form>
	<form>
		<h3>Participants:</h3>
		<table>
			<tr>
				<th>Name:</th>
				<th>Email:</th>
			</tr>
			<tr>
				<td>Joshua DeBose</td>
				<td>jdebose@ycp.edu</td>
			</tr>
			<tr>
				<td>Ezra Moore</td>
				<td>emoore13@ycp.edu</td>
			</tr>
			<tr>
				<td>Robert Van De Mark</td>
				<td>rvandemark@ycp.edu</td>
			</tr>
			<tr>
				<td>Kyle Langrill</td>
				<td>klangrill@ycp.edu</td>
			</tr>
			<tr>
				<td>Joshua DeBose</td>
				<td>jdebose@ycp.edu</td>
			</tr>
			<tr>
				<td>Joshua DeBose</td>
				<td>jdebose@ycp.edu</td>
			</tr>
		</table>
	</form>
</html>