<%--
  Created by IntelliJ IDEA.
  User: raphael
  Date: 25/09/2020
  Time: 11:10
  To change this template use File | Settings | File Templates.
--%>
<h1>Edit</h1>
<form method="post" action="EditPackageStatusServlet">
    <input hidden type="number" class="form-control" id="editPackageID" name="packageId" value="${packageId}">
    <input hidden type="number" class="form-control" id="editID" name="packageStatusId" value="${packageStatus.id}">
    <div class="form-group">
        <label for="name">Name</label>
        <input type="text" class="form-control" id="name" name="name" value="${packageStatus.location}">
    </div>
    <div class="form-group">
        <label for="latitude">Latitude</label>
        <input type="text" class="form-control" id="latitude" name="latitude" value="${packageStatus.coordinate.latitude}">
    </div>
    <div class="form-group">
        <label for="longitude">Longitude</label>
        <input type="text" class="form-control" id="longitude" name="longitude" value="${packageStatus.coordinate.longitude}">
    </div>
    <div class="form-group">
        <label for="state">State</label>
        <select class="form-control" id="state" name="state">
            <!-- Select the row according to the package status state -->
            <option <c:if test="${packageStatus.state == 'REGISTRATION'}">selected</c:if>>REGISTRATION</option>
            <option <c:if test="${packageStatus.state == 'PENDING'}">selected</c:if>>PENDING</option>
            <option <c:if test="${packageStatus.state == 'TRANSITING'}">selected</c:if>>TRANSITING</option>
            <option <c:if test="${packageStatus.state == 'BLOCKED'}">selecSted</c:if>>BLOCKED</option>
            <option <c:if test="${packageStatus.state == 'DELIVERED'}">selected</c:if>>DELIVERED</option>
        </select>
    </div>
    <button type="submit" class="btn btn-primary">Update</button>
</form>

<%@include file="footer.jsp"%>
