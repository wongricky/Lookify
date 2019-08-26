<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lookify Main Page</title>
</head>
<body>
	<h1 style="text-align:center;">Main Page</h1>
	<div>
		<p style="display:inline-block;"><a href="songs/new">Add New</a></p>
		<p style="display:inline-block;"><a href="#">Top Songs</a></p>
	</div>
	<div class="searchBarForm">
			<form action="/search" method="post">
				<input type="text" name="artist">
				<button type="submit">Search Artists</button>
		</form>
	</div>
	<br/><br/>
	<div class="tableWrapper">
		<table style="margin: 0px auto;" width="600">
			<thead>
				<tr>
					<th>Title</th>
					<th>Rating</th>
					<th>Action</th>
			</thead>
			<tbody>
				<c:forEach items="${songs}" var="song">
				<tr>
					<td style="text-align:center;"><a href="/songs/${song.id}"><c:out value="${song.title}"/></a></td>
					<td style="text-align:center;"><c:out value="${song.rating}"/></td>
					<td style="text-align:center;">
						<form action="/songs/${song.id}" method="post">
							<input type="hidden" name="_method" value="delete">
							<input type="submit" value="delete">
						</form>
					</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>	
</body>
</html>