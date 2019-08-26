<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add New Song</title>
</head>
<body>
	<h1 style="text-align:center;">Add New Song</h1>
	<br/><br/>
	<a href="/dashboard">Dashboard</a>
	<br/><br/><br/>
	<div class="newSong">
		<form:form action="/dashboard" method="post" modelAttribute="song">
			<p>
				<form:label path="title">Title</form:label>
				<form:errors path="title"/>
				<form:input path="title"/>
			</p>
			<p>
				<form:label path="artist">Artist</form:label>
				<form:errors path="artist"/>
				<form:input path="artist"/>
			</p>
			<p>
				<form:label path="rating">Rating</form:label>
				<select id="rating" name="rating">
					<option value="1">1</option>
					<option value="2">2</option>
					<option value="3">3</option>
					<option value="4">4</option>
					<option value="5">5</option>
					<option value="6">6</option>
					<option value="7">7</option>
					<option value="8">8</option>
					<option value="9">9</option>
					<option value="10">10</option>
				</select>
			</p>
			<input type="submit" value="Create Song"/>
		</form:form>
	</div>

</body>
</html>