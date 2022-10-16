<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Rest api Project !</title>
</head>
<body>
<h1><%= "Rest api Project !" %>
</h1>
<br/>
<a href="${pageContext.request.contextPath}/api/dvd/getAllDvd">Show all DVDs</a> <br/>
<a href="${pageContext.request.contextPath}/api/dvd/modifyDvd/1">Show DVD with ID 1 </a> <br/>
<a href="${pageContext.request.contextPath}/api/com/dvd/1">Show com DVD with ID 1 </a> <br/>
<br>
<a href="${pageContext.request.contextPath}/api/videogame/getAllVideoGame">Show all VideoGames</a> <br/>
<a href="${pageContext.request.contextPath}/api/videogame/getVideoGame/1">Show VideoGame with ID 1 </a> <br/>
<a href="${pageContext.request.contextPath}/api/com/videogame/1">Show com VideoGame with ID 1 </a> <br/>
<br>
<a href="${pageContext.request.contextPath}/api/book/getAllBook">Show all Books</a> <br/>
<a href="${pageContext.request.contextPath}/api/book/getBook/1">Show Book with ID 1 </a> <br/>
<a href="${pageContext.request.contextPath}/api/com/book/1">Show com Book with ID 1 </a> <br/>


</body>
</html>