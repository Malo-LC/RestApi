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


</body>
</html>