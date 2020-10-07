<%--
  Created by IntelliJ IDEA.
  User: raphael
  Date: 25/09/2020
  Time: 11:10
  To change this template use File | Settings | File Templates.
--%>
<h1>Edit</h1>

<form method="post">
    <input hidden type="number" class="form-control" id="editPackageID" name="editPackageID">
    <input hidden type="number" class="form-control" id="editID" name="editID">
    <div class="form-group">
        <label for="changeName">Name</label>
        <input type="text" class="form-control" id="changeName" name="changeName" placeholder="Enter step name">
    </div>
    <div class="form-group">
        <label for="changeLat">Latitude</label>
        <input type="text" class="form-control" id="changeLat" name="changeLat" placeholder="Enter package value">
    </div>
    <div class="form-group">
        <label for="changeLong">Longitude</label>
        <input type="text" class="form-control" id="changeLong" name="changeLong" placeholder="Enter package value">
    </div>
    <div class="form-group">
        <label for="changeDate">Date</label>
        <input type="text" class="form-control" id="changeDate" name="changeDate" placeholder="Enter date">
    </div>
    <div class="form-group">
        <label for="changeState">State</label>
        <select class="form-control" id="changeState" name="changeState">
            <option>REGISTRATION</option>
            <option>PENDING</option>
            <option>TRANSITING</option>
            <option>BLOCKED</option>
            <option>DELIVERED</option>
        </select>
    </div>
    <button type="submit" class="btn btn-primary">Update</button>
</form>






<%@include file="footer.jsp"%>
