<%@ page import="java.sql.Timestamp" %><%--
  Created by IntelliJ IDEA.
  User: raphael
  Date: 24/09/2020
  Time: 16:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<h1>
    <%
        Timestamp timestamp = (Timestamp) request.getAttribute("timestamp");
        out.println(timestamp);
    %>
</h1>
<%@include file="footer.jsp"%>
