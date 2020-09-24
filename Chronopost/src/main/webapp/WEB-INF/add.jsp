<%@ page import="java.sql.Timestamp" %><%--
  Created by IntelliJ IDEA.
  User: raphael
  Date: 24/09/2020
  Time: 16:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add a Package</title>
</head>
<body>
    <h1>
        <%
            Timestamp timestamp = (Timestamp) request.getAttribute("timestamp");
            out.println(timestamp);
        %>
    </h1>
</body>
</html>
