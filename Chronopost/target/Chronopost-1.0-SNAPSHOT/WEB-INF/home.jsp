<%--
  Created by IntelliJ IDEA.
  User: raphael
  Date: 24/09/2020
  Time: 18:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<h1>Homepage</h1>
<br />

<p>
    Hello ${ !empty name ? name : names[rnd]} !
</p>
<%@include file="footer.jsp"%>
