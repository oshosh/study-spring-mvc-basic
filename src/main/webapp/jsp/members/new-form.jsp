<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 2024-03-08
  Time: 오후 10:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="/jsp/members/save.jsp" method="post">
        <div>
            <span>username :</span>
            <input type="text" name="username" />
        </div>
        <div>
            <span>age :</span>
            <input type="text" name="age" />
        </div>
        <button type="submit">전송</button>
    </form>
</body>
</html>
