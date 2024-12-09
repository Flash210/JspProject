<!-- index.jsp -->
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Index Page</title>
</head>
<body>
<h1>Welcome to the Web Application</h1>

<!-- Display message if exists -->
<c:if test="${not empty sessionScope.message}">
    <p>${sessionScope.message}</p>
</c:if>

<a href="login.jsp">Connect</a> |
<a href="detail">Info Session</a>
</body>
</html>
