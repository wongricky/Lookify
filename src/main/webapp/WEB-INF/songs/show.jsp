<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><c:out value="${song.title}"/></title>
</head>
<body>
	<a href="/dashboard">Dashboard</a>
	<br/><br/><br/>
	<table>
		<thead>
		</thead>
		<tbody>
			<tr>
				<td>Title</td>
				<td><c:out value="${song.title}"/></td>
			</tr>
			<tr>
				<td>Artist</td>
				<td><c:out value="${song.artist}"/></td>
			</tr>
			<tr>
				<td>Rating (1-10)</td>
				<td><c:out value="${song.rating}"/></td>
			</tr>
		</tbody>	
	</table>
	<br/><br/>
		<form action="/songs/${song.id}" method="post">
			<input type="hidden" name="_method" value="delete">
			<input type="submit" value="delete">
		</form>
</body>
</html>