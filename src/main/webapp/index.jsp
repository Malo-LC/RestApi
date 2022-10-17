<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Rest api Project !</title>
    <style type="text/css">
        body{background-color: bisque}
        h1 { color: #111; font-family: 'Helvetica Neue', sans-serif; font-size: 100px; font-weight: bold; letter-spacing: -1px; line-height: 1; text-align: center; }
    </style>
</head>
<style>
    div{
        box-shadow: rgba(0, 0, 0, 0.24) 0px 3px 8px;
        width: 300px;
        margin-bottom: 10px;

    }
    a{
        text-decoration: none;
        color:black;
        margin:10px;

    }
</style>
<body>
<h1><%= "Rest api Project !" %>
</h1>
<br/>
<div>
<a href="${pageContext.request.contextPath}/api/dvd/getAllDvd">Show all DVDs</a> <br/>
<a href="${pageContext.request.contextPath}/api/dvd/modifyDvd/1">Show DVD with ID 1 </a> <br/>
<a href="${pageContext.request.contextPath}/api/com/dvd/1">Show com DVD with ID 1 </a> <br/>
</div>
<br>
<div>
<a href="${pageContext.request.contextPath}/api/videogame/getAllVideoGame">Show all VideoGames</a> <br/>
<a href="${pageContext.request.contextPath}/api/videogame/modifyVideoGame/1">Show VideoGame with ID 1 </a> <br/>
<a href="${pageContext.request.contextPath}/api/com/videogame/1">Show com VideoGame with ID 1 </a> <br/>
</div>
<br>
<div>
<a href="${pageContext.request.contextPath}/api/book/getAllBook">Show all Books</a> <br/>
<a href="${pageContext.request.contextPath}/api/book/modifyBook/1">Show Book with ID 1 </a> <br/>
<a href="${pageContext.request.contextPath}/api/com/book/1">Show com Book with ID 1 </a> <br/>
</div>
<br>
<div>
<a href="${pageContext.request.contextPath}/api/user/getAllUser">See the users</a> <br/>
</div>

</body>
</html>