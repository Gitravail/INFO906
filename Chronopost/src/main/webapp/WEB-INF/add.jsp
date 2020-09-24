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
    ${ id } ${ timestamp }
</h1>

<form method="post">
    <div class="form-group">
        <label for="weight">Weight</label>
        <input type="number" step="0.001" class="form-control" id="weight" placeholder="Enter package weight">
    </div>
    <div class="form-group">
        <label for="value">Value</label>
        <input type="number" step="0.01" class="form-control" id="value" placeholder="Enter package value">
    </div>
    <button type="submit" class="btn btn-primary">Add</button>
</form>
<%@include file="footer.jsp"%>
