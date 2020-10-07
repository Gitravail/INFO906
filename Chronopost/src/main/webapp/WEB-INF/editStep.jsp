<%--
  Created by IntelliJ IDEA.
  User: raphael
  Date: 25/09/2020
  Time: 11:10
  To change this template use File | Settings | File Templates.
--%>
<h1>Edit</h1>
${packageId}
${packageStatus}
<form method="post">
    <input hidden type="number" class="form-control" id="editPackageID" name="packageId" value="${packageId}">
    <input hidden type="number" class="form-control" id="editID" name="packageStatusId" value="${packageStatus.id}">
    <div class="form-group">
        <label for="changeName">Name</label>
        <input type="text" class="form-control" id="changeName" name="changeName" value="${packageStatus.location}">
    </div>
    <div class="form-group">
        <label for="changeLat">Latitude</label>
        <input type="text" class="form-control" id="changeLat" name="changeLat" value="${packageStatus.coordinate.latitude}">
    </div>
    <div class="form-group">
        <label for="changeLong">Longitude</label>
        <input type="text" class="form-control" id="changeLong" name="changeLong" value="${packageStatus.coordinate.longitude}">
    </div>
    <div class="form-group">
        <label for="changeDate">Date</label>
        <input type="text" class="form-control" id="changeDate" name="changeDate" value="${packageStatus.date}">
    </div>
    <div class="form-group">
        <label for="changeState">State</label>
        <select class="form-control" id="changeState" name="changeState">
            <option selected="${packageStatus.state == 'REGISTRATION'}">REGISTRATION</option>
            <option selected="${packageStatus.state == 'PENDING'}">PENDING</option>
            <option selected="${packageStatus.state == 'TRANSITING'}">TRANSITING</option>
            <option selected="${packageStatus.state == 'BLOCKED'}">BLOCKED</option>
            <option selected="${packageStatus.state == 'DELIVERED'}">DELIVERED</option>
        </select>
    </div>
    <button type="submit" class="btn btn-primary">Update</button>
</form>

<%@include file="footer.jsp"%>
