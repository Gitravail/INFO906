<%--
  Created by IntelliJ IDEA.
  User: raphael
  Date: 25/09/2020
  Time: 11:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<h1>Progress</h1>
<form method="post">
    <div class="form-group">
        <label for="id">Package's ID</label>
        <input type="number" class="form-control" id="id" placeholder="Enter package ID">
    </div>
    <button type="submit" class="btn btn-primary">Display progress</button>
</form>
<%@include file="footer.jsp"%>
